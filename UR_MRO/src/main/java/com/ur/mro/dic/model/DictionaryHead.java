package com.ur.mro.dic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DictionaryHead {

    private String sgroup;

    private String groupDesciption;

    private String sgroupName;

    List<DictionaryItem> dictionaryItemList = new ArrayList<DictionaryItem>();

    public List<DictionaryItem> getDictionaryItemList() {
        return this.dictionaryItemList;
    }

    public void setDictionaryItemList(List<DictionaryItem> dictionaryItemList) {
        this.dictionaryItemList = dictionaryItemList;
    }

    public String getSgroup() {
        return this.sgroup;
    }

    public void setSgroup(String sgroup) {
        this.sgroup = sgroup;
    }

    public String getGroupDesciption() {
        return this.groupDesciption;
    }

    public void setGroupDesciption(String groupDesciption) {
        this.groupDesciption = groupDesciption;
    }

    public String getSgroupName() {
        return this.sgroupName;
    }

    public void setSgroupName(String sgroupName) {
        this.sgroupName = sgroupName;
    }
}