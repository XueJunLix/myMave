package com.ur.mro.pic.mappers;

import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.mro.pic.model.Attachment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Mapper
public interface AttachmentMapper {
    Attachment getAttachmentByPK(Integer pkId);

    int insertAttachment(Attachment Attachment);
    int insertBatchAttachment(@Param("list")List<Attachment> attachmentList);
    int updateAttachmentByPKSelective(Attachment Attachment);

    List<Attachment> searchAttachment(@Param("selectFields") List<String> selectFields, @Param("condList") List<CommonSearchCondition> condList, @Param("orderByList") List<String> orderByList, @Param("pageBean") PageBean pageBean);

    int searchAttachmentCount(@Param("condList") List<CommonSearchCondition> condList);

    Attachment saveAttachment(CommonsMultipartFile file);

    List<Attachment> getPicByRowId(Integer rowId);

    List<Attachment> getPicByRowIdAndClassName(@Param("rowId") Integer rowId,@Param("classname") String classname);


}