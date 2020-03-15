package com.ur.mro.sup.service;

import com.ur.common.service.BaseService;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.pic.service.AttachmentService;
import com.ur.mro.sup.mappers.SupContractInfoMapper;
import com.ur.mro.sup.mappers.SupplierHbMapper;
import com.ur.mro.sup.mappers.SupplierMapper;
import com.ur.mro.sup.model.*;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierHbService extends BaseService {
    @Autowired
    SupplierHbMapper supplierHbMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @Autowired
    SupContractInfoMapper supContractInfoMapper;

    @Autowired
    SupBankInfoService supBankInfoService;

    @Autowired
    SupWorkersService supWorkersService;

    @Autowired
    SupEquipmertsService supEquipmertsService;

    @Autowired
    SupPartnersService supPartnersService;

    @Autowired
    SupCustomersService supCustomersService;

    @Autowired
    SupPayInfoService supPayInfoService;

    @Autowired
    SupContactsService supContactsService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    SupContractInfoService supContractInfoService;

    @Autowired
    AttachmentService attachmentService;

    public SupplierHb getSupplierHb(String id){
        SupplierHb supplierHb = new SupplierHb();

        if(id!=null && !id.equals("")){
            Integer pid = Integer.valueOf(id);
            Supplier supplier = supplierService.getSupplierByPK(Integer.valueOf(id));
            supplierHb.setSupplier(supplier);

            List<SupContractInfo> supContractInfoList = supContractInfoService.getSupContractInfoListBysupId(pid);
            if(supContractInfoList.size()>0){
                supplierHb.setSupContractInfoList(supContractInfoList);
            }else{
                supContractInfoList = new ArrayList<SupContractInfo>();
                supplierHb.setSupContractInfoList(supContractInfoList);
            }

            List<SupBankInfo> supBankInfoList = supBankInfoService.getSupBankInfoListBysupId(pid);
            if(supBankInfoList.size()>0){

                for(int i = 0;i<supBankInfoList.size();i++){
                    //开户许可证
                    SupBankInfo supBankInfo = supBankInfoList.get(i);
                    Integer supBankInfoId = supBankInfo.getId();
                    List<Attachment> attachmentList = super.getAttachmentList(supBankInfoId,SupBankInfo.class.getName());//com.ur.srm.supplier.domain.Supplier
                    supBankInfo.setKaihuFiles(attachmentList);
                }
                supplierHb.setSupBankInfoList(supBankInfoList);
            }else{
                SupBankInfo supBankInfo = new SupBankInfo();
                supBankInfo.setDeleted(0);
                supBankInfoList.add(supBankInfo);
                supplierHb.setSupBankInfoList(supBankInfoList);
            }


            List<SupWorkers> supWorkersList= supWorkersService.getSupWorkersBySupplierId(pid);
            if(supWorkersList.size()>0){
                supplierHb.setSupWorkersList(supWorkersList);
            }else{
                SupWorkers supWorkers = new SupWorkers();
                supWorkers.setDeleted(0);
                supWorkersList.add(supWorkers);
                supplierHb.setSupWorkersList(supWorkersList);
            }


            List<SupEquipmerts> supEquipmertsList = supEquipmertsService.getSupEquipmertsListBySupplierId(pid);
            if(supEquipmertsList.size()>0){
                for(int i = 0;i<supEquipmertsList.size();i++){
                    SupEquipmerts supEquipmerts = supEquipmertsList.get(i);
                    Integer supEquipmertsId = supEquipmerts.getId();
                    List<Attachment> attachmentList = super.getAttachmentList(supEquipmertsId,SupEquipmerts.class.getName());
                    supEquipmerts.setShebeiFiles(attachmentList);
                }
                supplierHb.setSupEquipmertsList(supEquipmertsList);
            }else{
                SupEquipmerts supEquipmerts = new SupEquipmerts();
                supEquipmerts.setDeleted(0);
                supEquipmertsList.add(supEquipmerts);
                supplierHb.setSupEquipmertsList(supEquipmertsList);
            }

            List<SupPartners> supPartnersList = supPartnersService.getSupPartnersListBySupplierId(pid);
            if(supPartnersList.size()>0){
                for(int i = 0;i<supPartnersList.size();i++){
                    SupPartners supPartners =   supPartnersList.get(i);
                    Integer supPartnersId = supPartners.getId();
                    List<Attachment> attachmentList = super.getAttachmentList(supPartnersId,SupPartners.class.getName());
                    supPartners.setChangshangFiles(attachmentList);
                }
                supplierHb.setSupPartnersList(supPartnersList);
            }else{
                SupPartners supPartners = new SupPartners();
                supPartners.setDeleted(0);
                supPartnersList.add(supPartners);
                supplierHb.setSupPartnersList(supPartnersList);
            }

            List<SupCustomers> supCustomersList =  supCustomersService.getSupCustomersListBySupplierId(pid);
            if(supCustomersList.size()>0){

                for(int i = 0;i<supCustomersList.size();i++){
                    SupCustomers supCustomers = supCustomersList.get(i);
                    Integer supCustomersId = supCustomers.getId();
                    List<Attachment> attachmentList = super.getAttachmentList(supCustomersId,SupCustomers.class.getName());
                    supCustomers.setKehuFiles(attachmentList);
                }
                supplierHb.setSupCustomersList(supCustomersList);
            }else{
                SupCustomers supCustomers = new SupCustomers();
                supCustomers.setDeleted(0);
                supCustomersList.add(supCustomers);
                supplierHb.setSupCustomersList(supCustomersList);
            }

            List<SupPayInfo> supPayInfoList = supPayInfoService.getSupPayInfoListBySupplierId(pid);
            if(supPayInfoList.size()>0){
                supplierHb.setSupPayInfoList(supPayInfoList);
            }else{
                SupPayInfo supPayInfo = new SupPayInfo();
                supPayInfo.setDeleted(0);
                supPayInfoList.add(supPayInfo);
                supplierHb.setSupPayInfoList(supPayInfoList);
            }

            List<SupContacts> supContactsList = supContactsService.getSupContactsListBySupplierId(pid);
            if(supContactsList.size()>0){
                supplierHb.setSupContactsList(supContactsList);
            }else{
                SupContacts supContacts = new SupContacts();
                supContacts.setDeleted(0);
                supContactsList.add(supContacts);
                supplierHb.setSupContactsList(supContactsList);
            }

            List<Attachment> attachmentList = super.getAttachmentList(Integer.valueOf(id),Supplier.class.getName());//com.ur.srm.supplier.domain.Supplier
            if(attachmentList.size()>0){
                //地产权或租赁证明
                List<Attachment> dichanFiles = new ArrayList<Attachment>();

                //营业执照
                List<Attachment> zhizhaoFiles = new ArrayList<Attachment>();

                //其他资格证件
                List<Attachment>qitaFiles = new ArrayList<Attachment>();


                //客户
                List<Attachment>chejianFiles = new ArrayList<Attachment>();

               /* //厂商
                List<Attachment>changshangFiles = new ArrayList<Attachment>();*/


                    for(int i = 0;i<attachmentList.size();i++){
                        Attachment attachment = attachmentList.get(i);
                        String com1 = attachment.getCom1();

                        if(com1!=null){
                                if(com1.equals("dichan")){
                                    dichanFiles.add(attachment);
                                }
                                if(com1.equals("zhizhao")){
                                    zhizhaoFiles.add(attachment);
                                }
                                if(com1.equals("qita")){
                                    qitaFiles.add(attachment);
                                }
                                if(com1.equals("chejian")){
                                chejianFiles.add(attachment);
                                }

                        }

                    }

                List<Attachment> oldAttachmentList = super.getAttachmentList(Integer.valueOf(id),"com.ur.srm.supplier.domain.Supplier");
                    if(oldAttachmentList.size()>0){
                        for(int i = 0;i<oldAttachmentList.size();i++){
                            Attachment oldAttachment = oldAttachmentList.get(i);
                            qitaFiles.add(oldAttachment);
                        }
                    }
                    supplierHb.setDichanFiles(dichanFiles);
                    supplierHb.setZhizhaoFiles(zhizhaoFiles);
                    supplierHb.setQitaFiles(qitaFiles);
                    supplierHb.setChejianFiles(chejianFiles);



            }







        }else{

            Supplier supplier = new Supplier();
            supplier.setDeleted(0);
            supplier.setCoordination("0");
            supplier.setSupType("1");
            supplier.setSupCooperationWay("1");
            supplier.setSupCalStatus("1");
            supplierHb.setSupplier(supplier);

            List<SupContractInfo> supContractInfoList = new ArrayList<SupContractInfo>();
            supplierHb.setSupContractInfoList(supContractInfoList);

            List<SupBankInfo> supBankInfoList = new ArrayList<SupBankInfo>();
            SupBankInfo supBankInfo = new SupBankInfo();
            supBankInfo.setDeleted(0);
            supBankInfoList.add(supBankInfo);
            supplierHb.setSupBankInfoList(supBankInfoList);

            List<SupWorkers> supWorkersList = new ArrayList<SupWorkers>();
            SupWorkers supWorkers = new SupWorkers();
            supWorkers.setDeleted(0);
            supWorkersList.add(supWorkers);
            supplierHb.setSupWorkersList(supWorkersList);

            List<SupPartners> supPartnersList = new ArrayList<SupPartners>();
            SupPartners supPartners = new SupPartners();
            supPartners.setDeleted(0);
            supPartnersList.add(supPartners);
            supplierHb.setSupPartnersList(supPartnersList);

            List<SupCustomers> supCustomersList = new ArrayList<SupCustomers>();
            SupCustomers supCustomers = new SupCustomers();
            supCustomers.setDeleted(0);
            supCustomersList.add(supCustomers);
            supplierHb.setSupCustomersList(supCustomersList);

            List<SupPayInfo> supPayInfoList = new ArrayList<SupPayInfo>();
            SupPayInfo supPayInfo = new SupPayInfo();
            supPayInfo.setDeleted(0);
            supPayInfoList.add(supPayInfo);
            supplierHb.setSupPayInfoList(supPayInfoList);

            List<SupContacts> supContactsList = new ArrayList<SupContacts>();
            SupContacts supContacts = new SupContacts();
            supContacts.setDeleted(0);
            /*supContacts.setMrLxr(true);
            supContacts.setMrCwLxr(true);
            supContacts.setMrShLxr(true);*/
            supContactsList.add(supContacts);
            supplierHb.setSupContactsList(supContactsList);

            List<SupEquipmerts> supEquipmertsList = new ArrayList<SupEquipmerts>();
            SupEquipmerts supEquipmerts = new SupEquipmerts();
            supEquipmerts.setDeleted(0);
            supEquipmertsList.add(supEquipmerts);
            supplierHb.setSupEquipmertsList(supEquipmertsList);

        }


        return supplierHb;
    }


    public SupplierHb getSupplierHbByPK(Integer pkId) {
        return supplierHbMapper.getSupplierHbByPK(pkId);
    }

    //流水号规则
    public String getCreateSupplierNum(String supType){

        String perCode = "";
        if ("1".equals(supType)) {
            perCode = "ZD";
        } else if ("2".equals(supType)) {
            perCode = "WL";
        } else if ("3".equals(supType)) {
            perCode = "ZX";
        } else if ("4".equals(supType)) {
            perCode = "XF";
        } else if ("5".equals(supType)) {
            perCode = "KT";
        }

        String numbCode = supplierHbMapper.getSupCodeNum(supType);
        if(numbCode!=null){
            String str = "";
            int numb = Integer.parseInt(numbCode);
            numb++;
            if (numb < 10) {
                str = perCode + "000" + numb;
            } else if (9 < numb && numb < 100) {
                str = perCode + "00" + numb;
            } else if (99 < numb && numb < 1000) {
                str = perCode + "0" + numb;
            } else {
                str = perCode + numb;
            }
            perCode = str;
        }else{
            perCode = perCode + "0001";
        }

        return perCode;
    }
    /**
     * 保存供应商主数据
     * @param supplierHb
     * @return
     */
    @Transactional
    public Integer saveSupplierHb(SupplierHb supplierHb) {
        Supplier supplier = supplierHb.getSupplier();
        List<SupContractInfo> supContractInfoList = supplierHb.getSupContractInfoList();
        List<SupBankInfo> supBankInfoList = supplierHb.getSupBankInfoList();
        List<SupContacts> supContactsList = supplierHb.getSupContactsList();
        List<SupCustomers> supCustomersList = supplierHb.getSupCustomersList();
        List<SupEquipmerts> supEquipmertsList = supplierHb.getSupEquipmertsList();
        List<SupPartners> supPartnersList = supplierHb.getSupPartnersList();
        List<SupPayInfo> supPayInfoList = supplierHb.getSupPayInfoList();
        List<SupWorkers> supWorkersList = supplierHb.getSupWorkersList();
        List<Attachment> dichanFiles = supplierHb.getDichanFiles();
        List<Attachment> zhizhaoFiles = supplierHb.getZhizhaoFiles();
        List<Attachment> qitaFiles = supplierHb.getQitaFiles();
        List<Attachment> chejianFiles = supplierHb.getChejianFiles();
        Integer id = supplier.getId();
        if(id!=null){
            //编辑
            supplierMapper.updateSupplierByPKSelective(supplier);

            //合同明细模块
            if(supContractInfoList.size()>0){
                for(int i = 0;i<supContractInfoList.size();i++){
                    SupContractInfo supContractInfo = supContractInfoList.get(i);
                    //如果明细ID为空就把抬头ID塞进去，然后保存。如果明细ID不为空就直接更新
                    if(supContractInfo.getId()==null){
                        supContractInfo.setSupId(id);
                        super.setCreateFields(supContractInfo);
                        supContractInfoService.insertSupContractInfo(supContractInfo);
                    }else{
                        supContractInfoService.updateSupContractInfoByPKSelective(supContractInfo);
                    }
                }
            }

            if(supBankInfoList.size()>0){
                for(int i = 0;i<supBankInfoList.size();i++){
                    SupBankInfo supBankInfo = supBankInfoList.get(i);
                    if(supBankInfo.getId()==null){
                        supBankInfo.setSupplierId(id);
                        super.setCreateFields(supBankInfo);
                        int bankInfoId = supBankInfoService.insertSupBankInfo(supBankInfo);

                        List<Attachment> kaihuFiles = supBankInfo.getKaihuFiles();
                        if(kaihuFiles.size()>0){
                            for (int b = 0;b<kaihuFiles.size();b++){
                                Attachment attachment =  kaihuFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment kaihuAttachment = attachmentService.getAttachmentByPK(fileId);
                                kaihuAttachment.setRowId(bankInfoId);
                                kaihuAttachment.setClassname(SupBankInfo.class.getName());
                                super.setUpdateFields(kaihuAttachment);
                                attachmentService.updateAttachmentByPKSelective(kaihuAttachment);
                            }
                        }


                    }else{
                        super.setUpdateFields(supBankInfo);
                        supBankInfoService.updateSupBankInfoByPKSelective(supBankInfo);

                        List<Attachment> kaihuFiles = supBankInfo.getKaihuFiles();
                        if(kaihuFiles.size()>0){
                            for (int b = 0;b<kaihuFiles.size();b++){
                                Attachment attachment =  kaihuFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment kaihuAttachment = attachmentService.getAttachmentByPK(fileId);
                                if(kaihuAttachment.getRowId()==0){
                                    kaihuAttachment.setRowId(supBankInfo.getId());
                                    //kaihuAttachment.setCom1("dichan");
                                    kaihuAttachment.setClassname(SupBankInfo.class.getName());
                                    super.setUpdateFields(kaihuAttachment);
                                    attachmentService.updateAttachmentByPKSelective(kaihuAttachment);
                                }

                            }
                        }
                    }

                }
            }


            if(supContactsList.size()>0){
                for(int i = 0;i<supContactsList.size();i++){
                    SupContacts supContacts = supContactsList.get(i);
                    if(supContacts.getId()==null){
                        supContacts.setSupplierId(id);
                        super.setCreateFields(supContacts);
                        supContactsService.insertSupContacts(supContacts);
                    }else{
                        super.setUpdateFields(supContacts);
                        supContactsService.updateSupContactsByPKSelective(supContacts);
                    }
                }
            }

            if(supCustomersList.size()>0) {
                for (int i = 0; i < supCustomersList.size(); i++) {
                    SupCustomers supCustomers = supCustomersList.get(i);
                    if(supCustomers.getId()==null){
                        supCustomers.setSupplierId(id);
                        super.setCreateFields(supCustomers);
                        int supCustomersId = supCustomersService.insertSupCustomers(supCustomers);

                        List<Attachment> KehuFiles = supCustomers.getKehuFiles();
                        if(KehuFiles.size()>0){
                            for(int b = 0;b<KehuFiles.size();b++){
                                Attachment attachment = KehuFiles.get(b);
                                Integer fileId = attachment.getId();

                                Attachment KehuAttachment = attachmentService.getAttachmentByPK(fileId);
                                KehuAttachment.setRowId(supCustomersId);
                                //kaihuAttachment.setCom1("dichan");
                                KehuAttachment.setClassname(SupCustomers.class.getName());
                                super.setUpdateFields(KehuAttachment);
                                attachmentService.updateAttachmentByPKSelective(KehuAttachment);
                            }
                        }
                    }else{
                        super.setUpdateFields(supCustomers);
                        supCustomersService.updateSupCustomersByPKSelective(supCustomers);

                        List<Attachment> KehuFiles = supCustomers.getKehuFiles();
                        if(KehuFiles.size()>0){
                            for(int b = 0;b<KehuFiles.size();b++){
                                Attachment attachment = KehuFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment KehuAttachment = attachmentService.getAttachmentByPK(fileId);
                                if(KehuAttachment.getRowId()==0){
                                    KehuAttachment.setRowId(supCustomers.getId());
                                    //kaihuAttachment.setCom1("dichan");
                                    KehuAttachment.setClassname(SupCustomers.class.getName());
                                    super.setUpdateFields(KehuAttachment);
                                    attachmentService.updateAttachmentByPKSelective(KehuAttachment);
                                }

                            }
                        }
                    }

                }
            }

            if(supEquipmertsList.size()>0) {
                for (int i = 0; i < supEquipmertsList.size(); i++) {
                    SupEquipmerts supEquipmerts = supEquipmertsList.get(i);
                    if(supEquipmerts.getId()==null){
                        supEquipmerts.setSupplierId(id);
                        super.setCreateFields(supEquipmerts);
                        int supEquipmertId = supEquipmertsService.insertSupEquipmerts(supEquipmerts);

                        List<Attachment> shebeiFiles = supEquipmerts.getShebeiFiles();
                        if(shebeiFiles.size()>0){
                            for (int b = 0;b<shebeiFiles.size();b++){
                                Attachment attachment =  shebeiFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment shebeiAttachment = attachmentService.getAttachmentByPK(fileId);
                                shebeiAttachment.setRowId(supEquipmertId);
                                shebeiAttachment.setClassname(SupEquipmerts.class.getName());
                                super.setUpdateFields(shebeiAttachment);
                                attachmentService.updateAttachmentByPKSelective(shebeiAttachment);
                            }
                        }
                    }else{
                        super.setUpdateFields(supEquipmerts);
                        supEquipmertsService.updateSupEquipmertsByPKSelective(supEquipmerts);

                        List<Attachment> shebeiFiles = supEquipmerts.getShebeiFiles();
                        if(shebeiFiles.size()>0){
                            for (int b = 0;b<shebeiFiles.size();b++){
                                Attachment attachment =  shebeiFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment shebeiAttachment = attachmentService.getAttachmentByPK(fileId);
                                if(shebeiAttachment.getRowId()==0){
                                    shebeiAttachment.setRowId(supEquipmerts.getId());
                                    shebeiAttachment.setClassname(SupEquipmerts.class.getName());
                                    super.setUpdateFields(shebeiAttachment);
                                    attachmentService.updateAttachmentByPKSelective(shebeiAttachment);
                                }

                            }
                        }
                    }

                }
            }

            if(supPartnersList.size()>0){
                for(int i = 0;i<supPartnersList.size();i++){
                    SupPartners supPartners = supPartnersList.get(i);
                    if(supPartners.getId()==null){
                        supPartners.setSupplierId(id);
                        super.setCreateFields(supPartners);
                        int supPartnersId = supPartnersService.insertSupPartners(supPartners);

                        List<Attachment> changshangFiles = supPartners.getChangshangFiles();
                        if(changshangFiles.size()>0){
                            for (int b = 0;b<changshangFiles.size();b++){
                                Attachment attachment =  changshangFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment changshangAttachment = attachmentService.getAttachmentByPK(fileId);
                                changshangAttachment.setRowId(supPartnersId);
                                changshangAttachment.setClassname(SupPartners.class.getName());
                                super.setUpdateFields(changshangAttachment);
                                attachmentService.updateAttachmentByPKSelective(changshangAttachment);
                            }
                        }


                    }else{
                        super.setUpdateFields(supPartners);
                        supPartnersService.updateSupPartnersByPKSelective(supPartners);

                        List<Attachment> changshangFiles = supPartners.getChangshangFiles();
                        if(changshangFiles.size()>0){
                            for (int b = 0;b<changshangFiles.size();b++){
                                Attachment attachment =  changshangFiles.get(b);
                                Integer fileId = attachment.getId();
                                Attachment changshangAttachment = attachmentService.getAttachmentByPK(fileId);
                                if(changshangAttachment.getRowId()==0){
                                    changshangAttachment.setRowId(supPartners.getId());
                                    changshangAttachment.setClassname(SupPartners.class.getName());
                                    super.setUpdateFields(changshangAttachment);
                                    attachmentService.updateAttachmentByPKSelective(changshangAttachment);
                                }

                            }
                        }
                    }

                }
            }

            if(supPayInfoList.size()>0){
                for(int i = 0;i<supPayInfoList.size();i++){
                    SupPayInfo supPayInfo = supPayInfoList.get(i);
                    if(supPayInfo.getId()==null){
                        supPayInfo.setSupplierId(id);
                        super.setCreateFields(supPayInfo);
                        supPayInfoService.insertSupPayInfo(supPayInfo);
                    }else{
                        super.setUpdateFields(supPayInfo);
                        supPayInfoService.updateSupPayInfoByPKSelective(supPayInfo);
                    }

                }
            }

            if(supWorkersList.size()>0){
                for(int i = 0;i<supWorkersList.size();i++){
                    SupWorkers supWorkers = supWorkersList.get(i);
                    if(supWorkers.getId()==null){
                        supWorkers.setSupplierId(id);
                        super.setCreateFields(supWorkers);
                        supWorkersService.insertSupWorkers(supWorkers);
                    }else{
                        super.setUpdateFields(supWorkers);
                        supWorkersService.updateSupWorkersByPKSelective(supWorkers);
                    }

                }
            }

            if(dichanFiles.size()>0){
                for(int i = 0;i<dichanFiles.size();i++){
                    Attachment attachment = dichanFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment dichanAttachment = attachmentService.getAttachmentByPK(fileId);
                    if(dichanAttachment.getRowId()==0){
                        dichanAttachment.setRowId(id);
                        dichanAttachment.setCom1("dichan");
                        dichanAttachment.setClassname(Supplier.class.getName());
                        super.setUpdateFields(dichanAttachment);
                        attachmentService.updateAttachmentByPKSelective(dichanAttachment);
                    }

                }
            }

            if(zhizhaoFiles.size()>0){
                for(int i = 0;i<zhizhaoFiles.size();i++){
                    Attachment attachment = zhizhaoFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment zhizhaoAttachment = attachmentService.getAttachmentByPK(fileId);
                    if(zhizhaoAttachment.getRowId()==0){
                        zhizhaoAttachment.setRowId(id);
                        zhizhaoAttachment.setCom1("zhizhao");
                        zhizhaoAttachment.setClassname(Supplier.class.getName());
                        super.setUpdateFields(zhizhaoAttachment);
                        attachmentService.updateAttachmentByPKSelective(zhizhaoAttachment);
                    }

                }
            }


            if(qitaFiles.size()>0){
                for(int i = 0;i<qitaFiles.size();i++){
                    Attachment attachment = qitaFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment qitaAttachment = attachmentService.getAttachmentByPK(fileId);
                    if(qitaAttachment.getRowId()==0){
                        qitaAttachment.setRowId(id);
                        qitaAttachment.setCom1("qita");
                        qitaAttachment.setClassname(Supplier.class.getName());
                        super.setUpdateFields(qitaAttachment);
                        attachmentService.updateAttachmentByPKSelective(qitaAttachment);
                    }

                }
            }

            if(chejianFiles.size()>0){
                for(int i = 0;i<chejianFiles.size();i++){
                    Attachment attachment = chejianFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment chejianAttachment = attachmentService.getAttachmentByPK(fileId);
                    if(chejianAttachment.getRowId()==0){
                        chejianAttachment.setRowId(id);
                        chejianAttachment.setCom1("chejian");
                        chejianAttachment.setClassname(Supplier.class.getName());
                        super.setUpdateFields(chejianAttachment);
                        attachmentService.updateAttachmentByPKSelective(chejianAttachment);
                    }

                }
            }
/*
            if(kehuFiles.size()>0){
                for(int i = 0;i<kehuFiles.size();i++){
                    Attachment attachment = kehuFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment kehuAttachment = attachmentService.getAttachmentByPK(fileId);
                    if(kehuAttachment.getRowId()==null){
                        kehuAttachment.setRowId(id);
                        kehuAttachment.setCom1("kehu");
                        kehuAttachment.setClassname("com.ur.srm.supplier.domain.Supplier");
                        super.setUpdateFields(kehuAttachment);
                        attachmentService.updateAttachmentByPKSelective(kehuAttachment);
                    }

                }
            }

            if(changshangFiles.size()>0){
                for(int i = 0;i<changshangFiles.size();i++){
                    Attachment attachment = changshangFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment changshangAttachment = attachmentService.getAttachmentByPK(fileId);
                    if(changshangAttachment.getRowId()==null){
                        changshangAttachment.setRowId(id);
                        changshangAttachment.setCom1("changshang");
                        changshangAttachment.setClassname("com.ur.srm.supplier.domain.Supplier");
                        super.setUpdateFields(changshangAttachment);
                        attachmentService.updateAttachmentByPKSelective(changshangAttachment);
                    }

                }
            }
*/


        }else{
            //新增
            supplier.setCode(this.getCreateSupplierNum(supplier.getSupType()));
            id = supplierService.insertSupplier(supplier);

            //合同明细模块
            if(supContractInfoList.size()>0){
                for(int i = 0;i<supContractInfoList.size();i++){
                    SupContractInfo supContractInfo = supContractInfoList.get(i);
                    supContractInfo.setSupId(id);
                    super.setCreateFields(supContractInfo);
                    supContractInfoService.insertSupContractInfo(supContractInfo);
                }
            }

            if(supBankInfoList.size()>0){
                for(int i = 0;i<supBankInfoList.size();i++){
                    SupBankInfo supBankInfo = supBankInfoList.get(i);
                    supBankInfo.setSupplierId(id);
                    super.setCreateFields(supBankInfo);
                    int bankInfoId = supBankInfoService.insertSupBankInfo(supBankInfo);

                    List<Attachment> kaihuFiles = supBankInfo.getKaihuFiles();
                    if(kaihuFiles.size()>0){
                        for (int b = 0;b<kaihuFiles.size();b++){
                            Attachment attachment =  kaihuFiles.get(b);
                            Integer fileId = attachment.getId();
                            Attachment kaihuAttachment = attachmentService.getAttachmentByPK(fileId);
                            kaihuAttachment.setRowId(bankInfoId);
                            //kaihuAttachment.setCom1("dichan");
                            kaihuAttachment.setClassname(SupBankInfo.class.getName());
                            super.setUpdateFields(kaihuAttachment);
                            attachmentService.updateAttachmentByPKSelective(kaihuAttachment);
                        }
                    }
                }
            }

            if(supContactsList.size()>0){
                for(int i = 0;i<supContactsList.size();i++){
                    SupContacts supContacts = supContactsList.get(i);
                    supContacts.setSupplierId(id);
                    super.setCreateFields(supContacts);
                    supContactsService.insertSupContacts(supContacts);
                }
            }

            if(supCustomersList.size()>0) {
                for (int i = 0; i < supCustomersList.size(); i++) {
                    SupCustomers supCustomers = supCustomersList.get(i);
                    supCustomers.setSupplierId(id);
                    super.setCreateFields(supCustomers);
                    supCustomersService.insertSupCustomers(supCustomers);
                }
            }

            if(supEquipmertsList.size()>0) {
                for (int i = 0; i < supEquipmertsList.size(); i++) {
                    SupEquipmerts supEquipmerts = supEquipmertsList.get(i);
                    supEquipmerts.setSupplierId(id);
                    super.setCreateFields(supEquipmerts);

                    int supEquipmertId = supEquipmertsService.insertSupEquipmerts(supEquipmerts);

                    List<Attachment> shebeiFiles = supEquipmerts.getShebeiFiles();
                    if(shebeiFiles.size()>0){
                        for (int b = 0;b<shebeiFiles.size();b++){
                            Attachment attachment =  shebeiFiles.get(b);
                            Integer fileId = attachment.getId();
                            Attachment shebeiAttachment = attachmentService.getAttachmentByPK(fileId);
                            shebeiAttachment.setRowId(supEquipmertId);
                            shebeiAttachment.setClassname(SupEquipmerts.class.getName());
                            super.setUpdateFields(shebeiAttachment);
                            attachmentService.updateAttachmentByPKSelective(shebeiAttachment);
                        }
                    }
                }
            }

            if(supPartnersList.size()>0){
                for(int i = 0;i<supPartnersList.size();i++){
                    SupPartners supPartners = supPartnersList.get(i);
                    supPartners.setSupplierId(id);
                    super.setCreateFields(supPartners);
                    supPartnersService.insertSupPartners(supPartners);
                }
            }

            if(supPayInfoList.size()>0){
                for(int i = 0;i<supPayInfoList.size();i++){
                    SupPayInfo supPayInfo = supPayInfoList.get(i);
                    supPayInfo.setSupplierId(id);
                    super.setCreateFields(supPayInfo);
                    supPayInfoService.insertSupPayInfo(supPayInfo);
                }
            }

            if(supWorkersList.size()>0){
                for(int i = 0;i<supWorkersList.size();i++){
                    SupWorkers supWorkers = supWorkersList.get(i);
                    supWorkers.setSupplierId(id);
                    super.setCreateFields(supWorkers);
                    supWorkersService.insertSupWorkers(supWorkers);
                }
            }

            if(dichanFiles.size()>0){
                for(int i = 0;i<dichanFiles.size();i++){
                    Attachment attachment = dichanFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment dichanAttachment = attachmentService.getAttachmentByPK(fileId);
                    dichanAttachment.setRowId(id);
                    dichanAttachment.setCom1("dichan");
                    dichanAttachment.setClassname(Supplier.class.getName());
                    super.setUpdateFields(dichanAttachment);
                    attachmentService.updateAttachmentByPKSelective(dichanAttachment);
                }
            }

            if(zhizhaoFiles.size()>0){
                for(int i = 0;i<zhizhaoFiles.size();i++){
                    Attachment attachment = zhizhaoFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment zhizhaoAttachment = attachmentService.getAttachmentByPK(fileId);
                    zhizhaoAttachment.setRowId(id);
                    zhizhaoAttachment.setCom1("zhizhao");
                    zhizhaoAttachment.setClassname(Supplier.class.getName());
                    super.setUpdateFields(zhizhaoAttachment);
                    attachmentService.updateAttachmentByPKSelective(zhizhaoAttachment);
                }
            }

            if(qitaFiles.size()>0){
                for(int i = 0;i<qitaFiles.size();i++){
                    Attachment attachment = qitaFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment qitaAttachment = attachmentService.getAttachmentByPK(fileId);
                    qitaAttachment.setRowId(id);
                    qitaAttachment.setCom1("qita");
                    qitaAttachment.setClassname(Supplier.class.getName());
                    super.setUpdateFields(qitaAttachment);
                    attachmentService.updateAttachmentByPKSelective(qitaAttachment);
                }
            }

            if(chejianFiles.size()>0){
                for(int i = 0;i<chejianFiles.size();i++){
                    Attachment attachment = chejianFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment chejianAttachment = attachmentService.getAttachmentByPK(fileId);
                    chejianAttachment.setRowId(id);
                    chejianAttachment.setCom1("chejian");
                    chejianAttachment.setClassname(Supplier.class.getName());
                    super.setUpdateFields(chejianAttachment);
                    attachmentService.updateAttachmentByPKSelective(chejianAttachment);
                }
            }
            /*
            if(kehuFiles.size()>0){
                for(int i = 0;i<kehuFiles.size();i++){
                    Attachment attachment = kehuFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment kehuAttachment = attachmentService.getAttachmentByPK(fileId);
                    kehuAttachment.setRowId(id);
                    kehuAttachment.setCom1("kehu");
                    kehuAttachment.setClassname("com.ur.srm.supplier.domain.Supplier");
                    super.setUpdateFields(kehuAttachment);
                    attachmentService.updateAttachmentByPKSelective(kehuAttachment);
                }
            }

            if(changshangFiles.size()>0){
                for(int i = 0;i<changshangFiles.size();i++){
                    Attachment attachment = changshangFiles.get(i);
                    Integer fileId = attachment.getId();
                    Attachment changshangAttachment = attachmentService.getAttachmentByPK(fileId);
                    changshangAttachment.setRowId(id);
                    changshangAttachment.setCom1("changshang");
                    changshangAttachment.setClassname("com.ur.srm.supplier.domain.Supplier");
                    super.setUpdateFields(changshangAttachment);
                    attachmentService.updateAttachmentByPKSelective(changshangAttachment);
                }
            }*/

            }




        return supplier.getId();
    }

    @Transactional
    public int deleteSupplierHb(SupplierHb supplierHb){
        Supplier supplier = supplierHb.getSupplier();
        Integer id = supplier.getId();
        supplierService.deleteSupplier(id);
        supBankInfoService.deleteSupBankInfo(id);
        supContactsService.deleteSupContacts(id);
        supContractInfoService.deleteSupContractInfo(id);
        supCustomersService.deleteSupCustomers(id);
        supEquipmertsService.deleteSupEquipmerts(id);
        supPartnersService.deleteSupPartners(id);
        supPayInfoService.deleteSupSupPayInfo(id);
        supWorkersService.deleteSupSupPayInfo(id);


        return 0;
    }


    public PagingRestResponse searchSupplierHb(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = supplierHbMapper.searchSupplierHbCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<SupplierHb> resultList = null;
        if(totalRecordNum>0){
            resultList = supplierHbMapper.searchSupplierHb(selectFields, condList, orderByList, pageBean);
        }
        for(int i = 0;i<resultList.size();i++){
            SupplierHb supplierHb = resultList.get(i);
            Supplier supplier = supplierHb.getSupplier();
            String coor = supplier.getCoordination();
            supplier.setCoordination(super.getDicSvalue("coordination",coor));
            String supcalStatus = supplier.getSupCalStatus();
            supplier.setSupCalStatus(super.getDicSvalue("GC_SUP_STATUS",supcalStatus));
            List<SupContractInfo> supContractInfoList = supplierHb.getSupContractInfoList();
            if(supContractInfoList.size()==0){
                List<SupContractInfo> supContractInfoList2 = new ArrayList<SupContractInfo>();
                SupContractInfo supContractInfo= new SupContractInfo();
                supContractInfoList2.add(supContractInfo);
                supplierHb.setSupContractInfoList(supContractInfoList2);
            }

        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }
}