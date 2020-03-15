package com.ur.bi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name = "t_hdfs_file_info")
@ToString
@NoArgsConstructor
@ApiModel(description = "t_hdfs_file_info 文件信息表")
public class FileInfo implements Serializable {
    @Id
    @Column(name = "id")
    @ApiModelProperty(value = "UUID")
    private String id;

    @Column(name = "uri")
    @ApiModelProperty(value = "文件完整的URI")
    private String uri;

    @Column(name = "path")
    @ApiModelProperty(value = "文件在HDFS上的路径")
    private String path;

    @Column(name = "original_filename")
    @ApiModelProperty(value = "文件的原始文件名")
    private String originalFilename;

    @Column(name = "folder")
    @ApiModelProperty(value = "文件的父级目录，用于区分文件的用途")
    private String folder;

    @Column(name = "data_date")
    @ApiModelProperty(value = "文件的数据日期（yyyyMMDD）")
    private String dataDate;

    @Column(name = "filename")
    @ApiModelProperty(value = "文件的存放在HDFS上的文件名")
    private String filename;

    @Column(name = "size")
    @ApiModelProperty(value = "文件的大小（bytes）")
    private Long size;

    @Column(name = "deleted")
    @ApiModelProperty(value = "1-删除，0-未删除")
    private Boolean deleted;

    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @Column(name = "create_by")
    @ApiModelProperty(value = "创建者（工号）")
    private String createBy;

    @Column(name = "modify_time")
    @ApiModelProperty(value = "修改时间")
    private LocalDateTime modifyTime;

    @Column(name = "modify_by")
    @ApiModelProperty(value = "修改者（工号）")
    private String modifyBy;
}

