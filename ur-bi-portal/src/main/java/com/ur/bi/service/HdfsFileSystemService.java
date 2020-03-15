package com.ur.bi.service;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HdfsFileSystemService {

    /**
     *
     * @param sourcePath
     * @param outputStream
     * @throws URISyntaxException
     * @throws IOException
     */
    public void copyFromHdfsToStream(URI hdfsUri, Path sourcePath, OutputStream outputStream) throws IOException {
        FileSystem fileSystem = null;
        FSDataInputStream fsDataInputStream = null;
        try {
            fileSystem = FileSystem.get(hdfsUri, new Configuration());
            fsDataInputStream = fileSystem.open(sourcePath);
            IOUtils.copyBytes(fsDataInputStream, outputStream, new Configuration());
        } finally {
            IOUtils.closeStream(outputStream);
            if (fsDataInputStream != null) {
                IOUtils.closeStream(fsDataInputStream);
            }
            if (fileSystem != null) {
                fileSystem.close();
            }
        }
    }

    /**
     *
     * @param inputStream
     * @param hdfsPath
     * @throws URISyntaxException
     * @throws IOException
     */
    public void saveStreamToHdfs(InputStream inputStream, URI hdfsUri, Path hdfsPath) throws IOException {
        FileSystem fileSystem = null;
        FSDataOutputStream fsDataOutputStream = null;
        try {
            fileSystem = FileSystem.get(hdfsUri, new Configuration());
            fsDataOutputStream = fileSystem.create(hdfsPath);
            IOUtils.copyBytes(inputStream, fsDataOutputStream, new Configuration());
        } finally {
            IOUtils.closeStream(inputStream);
            if (fsDataOutputStream != null) {
                IOUtils.closeStream(fsDataOutputStream);
            }
            if (fileSystem != null) {
                fileSystem.close();
            }
        }
    }

    public boolean deleteFromHdfs(URI hdfsUri, Path hdfsPath) throws IOException {
        FileSystem fileSystem = FileSystem.get(hdfsUri, new Configuration());
        return fileSystem.delete(hdfsPath, false);
    }
}
