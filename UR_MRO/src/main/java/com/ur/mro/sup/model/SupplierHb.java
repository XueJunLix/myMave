package com.ur.mro.sup.model;

import com.ur.mro.pic.model.Attachment;

import java.util.ArrayList;
import java.util.List;

/**
 * Parent Supplier
 * Child SupContractInfo
 */
//TODO add Serializable implements
public class SupplierHb {

    private Supplier supplier;

    //合同编号信息
    private List<SupContractInfo> supContractInfoList;

    //银行信息
    private List<SupBankInfo> supBankInfoList;

    //人员情况
    private  List<SupWorkers> supWorkersList;

    //设备情况
    private  List<SupEquipmerts> supEquipmertsList;

    //合作厂商
    private List<SupPartners> supPartnersList;

    //主要客户
    private List<SupCustomers> supCustomersList;

    ////支付数据
    private List<SupPayInfo> supPayInfoList;

    //联系人
    private List<SupContacts> supContactsList;

    //地产权或租赁证明
    List<Attachment> dichanFiles = new ArrayList<Attachment>();

    //营业执照
    List<Attachment> zhizhaoFiles = new ArrayList<Attachment>();

    //其他资格证件
    List<Attachment>qitaFiles = new ArrayList<Attachment>();

    //工厂车间图
    List<Attachment> chejianFiles = new ArrayList<Attachment>();



    public List<Attachment> getChejianFiles() {
        return this.chejianFiles;
    }

    public void setChejianFiles(List<Attachment> chejianFiles) {
        this.chejianFiles = chejianFiles;
    }

    public List<Attachment> getDichanFiles() {
        return this.dichanFiles;
    }

    public void setDichanFiles(List<Attachment> dichanFiles) {
        this.dichanFiles = dichanFiles;
    }

    public List<Attachment> getZhizhaoFiles() {
        return this.zhizhaoFiles;
    }

    public void setZhizhaoFiles(List<Attachment> zhizhaoFiles) {
        this.zhizhaoFiles = zhizhaoFiles;
    }

    public List<Attachment> getQitaFiles() {
        return this.qitaFiles;
    }

    public void setQitaFiles(List<Attachment> qitaFiles) {
        this.qitaFiles = qitaFiles;
    }


    public List<SupContacts> getSupContactsList() {
        return this.supContactsList;
    }

    public void setSupContactsList(List<SupContacts> supContactsList) {
        this.supContactsList = supContactsList;
    }

    public List<SupPayInfo> getSupPayInfoList() {
        return this.supPayInfoList;
    }

    public void setSupPayInfoList(List<SupPayInfo> supPayInfoList) {
        this.supPayInfoList = supPayInfoList;
    }

    public List<SupCustomers> getSupCustomersList() {
        return this.supCustomersList;
    }

    public void setSupCustomersList(List<SupCustomers> supCustomersList) {
        this.supCustomersList = supCustomersList;
    }

    public List<SupPartners> getSupPartnersList() {
        return this.supPartnersList;
    }

    public void setSupPartnersList(List<SupPartners> supPartnersList) {
        this.supPartnersList = supPartnersList;
    }

    public List<SupEquipmerts> getSupEquipmertsList() {
        return this.supEquipmertsList;
    }

    public void setSupEquipmertsList(List<SupEquipmerts> supEquipmertsList) {
        this.supEquipmertsList = supEquipmertsList;
    }

    public List<SupWorkers> getSupWorkersList() {
        return this.supWorkersList;
    }

    public void setSupWorkersList(List<SupWorkers> supWorkersList) {
        this.supWorkersList = supWorkersList;
    }

    public List<SupBankInfo> getSupBankInfoList() {
        return this.supBankInfoList;
    }

    public void setSupBankInfoList(List<SupBankInfo> supBankInfoList) {
        this.supBankInfoList = supBankInfoList;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<SupContractInfo> getSupContractInfoList() {
        return supContractInfoList;
    }

    public void setSupContractInfoList(List<SupContractInfo> supContractInfoList) {
        this.supContractInfoList = supContractInfoList;
    }
}