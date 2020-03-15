package com.ur.mro.pic.service;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.pic.mappers.AttachmentMapper;
import com.ur.mro.pic.model.Attachment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;

@Service
public class AttachmentService {
    @Autowired
    AttachmentMapper attachmentMapper;
    @Value("${pic.server.host.image_url}")
    String imageUrl;

    public Attachment getAttachmentByPK(Integer pkId) {
        return attachmentMapper.getAttachmentByPK(pkId);
    }

    @Transactional
    public Integer insertAttachment(Attachment attachment) {
        
        //TODO handle date columns here
        //attachment.setCreatedTime(new Date());
        //attachment.setLastUpdatedTime(new Date());
        
        attachmentMapper.insertAttachment(attachment);
        return attachment.getId();
    }

    @Transactional
    public int updateAttachmentByPKSelective(Attachment attachment) {
        
        //TODO handle date columns here
        //attachment.setCreatedTime(new Date());
        //attachment.setLastUpdatedTime(new Date());
        
        int result = attachmentMapper.updateAttachmentByPKSelective(attachment);
        return result;
    }

    public PagingRestResponse searchAttachment(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = attachmentMapper.searchAttachmentCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<Attachment> resultList = null;
        if(totalRecordNum>0){
            resultList = attachmentMapper.searchAttachment(selectFields, condList, orderByList, pageBean);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

    public List<String> getPicTureByMatId(Integer id){
        List<Attachment> attachmentList = attachmentMapper.getPicByRowId(id);
        List<String> pictureNameList = new ArrayList<String>();
        if(attachmentList.size()>0){
            for(int i = 0;i<attachmentList.size();i++){
                Attachment attachment = attachmentList.get(i);
                pictureNameList.add(imageUrl+attachment.getAbbFileName());
            }
        }else{
                pictureNameList.add(imageUrl+"e4da034a-c98c-4882-b439-e2103e6f5edb");
        }

        return pictureNameList;
    }
    /*public void readImage(String fileName, HttpServletResponse response){
        Attachment attachment = null;
        if(attachment !=null){
            if(attachment.getFileType().equals("pdf"))if(attachment.getFileType().equals("ppt")){
                response.setContentType("appication/powerpoint");
            }
            else{
                response.setContentType("image/" + attachment.getFileType());
            }

        }

        }
    }*/


public List<Attachment> getPicByRowIdAndClassName(@Param("rowId") Integer rowId, @Param("classname") String classname){
        return attachmentMapper.getPicByRowIdAndClassName(rowId,classname);
}


}