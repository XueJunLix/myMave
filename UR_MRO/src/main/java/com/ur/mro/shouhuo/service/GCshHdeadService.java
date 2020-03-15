package com.ur.mro.shouhuo.service;

import com.google.common.collect.Lists;
import com.ur.admin.service.AdminUserInfoService;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.common.model.Mat2SAPConfig;
import com.ur.common.service.BaseService;
import com.ur.common.util.NumberUtils;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import com.ur.mro.contract.model.Contract;
import com.ur.mro.contract.service.ContractService;
import com.ur.mro.mat.mappers.MaterialMapper;
import com.ur.mro.mat.model.Material;
import com.ur.mro.order.mappers.OrderInfoMapper;
import com.ur.mro.pic.model.Attachment;
import com.ur.mro.pic.service.AttachmentService;
import com.ur.mro.purchaseorder.mappers.PurchaseOrderMapper;
import com.ur.mro.purchaseorder.model.PurchaseOrder;
import com.ur.mro.purpurchase.mappers.PurPurchaseMapper;
import com.ur.mro.purpurchase.model.PurPurchase;
import com.ur.mro.sap.service.SapInterfaceDataLog2Service;
import com.ur.mro.shop.model.Shop2GC;
import com.ur.mro.shop.service.Shop2GCService;
import com.ur.mro.shouhuo.mappers.DeliveryItemMapper;
import com.ur.mro.shouhuo.mappers.GCshHdeadMapper;
import com.ur.mro.shouhuo.mappers.GcshItemMapper;
import com.ur.mro.shouhuo.model.*;
import com.ur.mro.sup.model.Supplier;
import com.ur.mro.sup.service.SupplierService;
import io.swagger.models.auth.In;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GCshHdeadService extends BaseService {

    @Autowired
    GCshHdeadMapper gCshHdeadMapper;

    @Autowired
    GcshItemMapper gcshItemMapper;

    @Autowired
    AdminUserInfoService adminUserInfoService;
    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    PurPurchaseMapper purPurchaseMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    Mat2SAPConfig mat2SAPConfig;

    @Autowired
    DeliveryItemMapper deliveryItemMapper;

    @Autowired
    DeliveryService deliveryService;

    @Autowired
    private SapInterfaceDataLog2Service sapInterfaceDataLogService;

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    Shop2GCService shop2GCService;

    @Value("${pic.server.host.image_url}")
    private String picUrl;

    @Autowired
    ContractService contractService;


    public GCshHdead getGCshHdeadByPK(Integer pkId) {
        return gCshHdeadMapper.getGCshHdeadByPK(pkId);
    }

    @Transactional
    public Integer insertGCshHdead(GCshHdead gCshHdead) {
        
        //TODO handle date columns here
        //gCshHdead.setCreatedTime(new Date());
        //gCshHdead.setLastUpdatedTime(new Date());
        //gCshHdead.setRequiredArrivalDate(new Date());
        //gCshHdead.setSupplierDeliverDate(new Date());
        
        gCshHdeadMapper.insertGCshHdead(gCshHdead);
        return gCshHdead.getId();
    }

    @Transactional
    public int updateGCshHdeadByPKSelective(GCshHdead gCshHdead) {
        
        //TODO handle date columns here
        //gCshHdead.setCreatedTime(new Date());
        //gCshHdead.setLastUpdatedTime(new Date());
        //gCshHdead.setRequiredArrivalDate(new Date());
        //gCshHdead.setSupplierDeliverDate(new Date());
        
        int result = gCshHdeadMapper.updateGCshHdeadByPKSelective(gCshHdead);
        return result;
    }

    public PagingRestResponse searchGCshHdead(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {

        for(CommonSearchCondition c:condList){
            if("CREATED_TIME".equals(c.getColumnName())&&!Objects.isNull(c.getValue()))
                   c.setValue(c.getValue().substring(0,10));
        }
        int totalRecordNum = gCshHdeadMapper.searchGCshHdeadCount(condList,"L00001");
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);
        
        List<GCshHdead> resultList = null;
        List<DeliveryDTO> deliveryDTOList=null;
        if(totalRecordNum>0){
            resultList = gCshHdeadMapper.searchGCshHdead(selectFields, condList, orderByList, pageBean,"L00001");
             deliveryDTOList=covertGCshHhead(resultList);
        }
        
        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,deliveryDTOList,pageBean);
    }


    private  List<DeliveryDTO> covertGCshHhead(List<GCshHdead> gCshHdeadList){

          List<DeliveryDTO> lists= Lists.newArrayList();
          Set<String> set=gCshHdeadList.stream().map(GCshHdead::getShNo).collect(Collectors.toSet());

          for(String no :set){
               DeliveryDTO en=new DeliveryDTO();
               List<GCshHdead> products=Lists.newArrayList();
               en.setDelivery_note(no);
               for(GCshHdead gc:gCshHdeadList){
                   Double shout2=0.00;
                   if(gc.getPoQut()!=null&&gc.getSjShQut()!=null)
                    shout2=NumberUtils.subtract(Double.valueOf(gc.getPoQut()),Double.valueOf(gc.getSjShQut()));
                    gc.setQcShQut(String.valueOf(shout2));
                   if(gc.getShouHchayi()==null)
                       gc.setCyQut("0");
                   if(gc.getPrice()==null)
                       gc.setPrice("0");
                   String abbfileName=gc.getAbbfileName();
                   if(abbfileName!=null&&!abbfileName.contains("http:"))
                       abbfileName=this.picUrl+abbfileName;
                   gc.setAbbfileName(abbfileName);
                   if(gc.getShNo().equals(no)){
                       products.add(gc);
                   }
               }
                   en.setProducts(products);
                 lists.add(en);
          }
          return lists;
    }

    public  GCshHdead findGCshHeadByShno(String shNo){
        return  gCshHdeadMapper.findGCshHeadByShno(shNo);
    }

    /**
     * 发送送货信息到SAP接口
     *
     * @param gcShHeadDto
     * @param createdDate GcShHead 基类的createdDate 属性，传送给SAP
     *                    modified by siyang.gu 13/11/2017
     */
    public void gcShHeadCrAsySapWs(GCshHdead gcShHeadDto, Date createdDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(new Date());
        System.out.println(dateString);
        String interfaceCode = "INT_MRO_005";
        String demandCode = "FS-MM-092";
        StringBuffer sb = new StringBuffer();


        String dataId = gcShHeadDto.getId() + "";//送货信息id
        String dataCode = gcShHeadDto.getShNo() + "";//送货单号  写入中间表

        if (gcShHeadDto.getShopNo().equals("URCNA0005")) {//长春欧亚商都店（ACC）
            gcShHeadDto.setShopNo("URCN0214");
        }

        String taskType = "";

        gcShHeadDto.setGcshitemVOs(gcshItemMapper.getListGcshItemByShId(gcShHeadDto.getId()));
        String poNo = gcShHeadDto.getGcshitemVOs().get(0) == null ? "" : gcShHeadDto.getGcshitemVOs().get(0).getPoNo();
        if (poNo.startsWith("PO")) {
            PurchaseOrder purchaseOrder=purchaseOrderMapper.getPurchaseOrderByNo(poNo,"GC");
            if (purchaseOrder != null) {
                taskType = purchaseOrder.getTaskType();
            }

            if (purchaseOrder.getSupplierCode().equals("ZD0086")) {//怡和不传
                return;
            }

        } else {
            PurPurchase purPurchase=purPurchaseMapper.getPurchaseOrderByNo(poNo,"GC");
            if (purPurchase != null) {
                taskType = purPurchase.getTaskType();
            }
        }

        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:ur.cn:SLM:ERP:BusinessData\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <urn:SLM_RESERV>\n" +
                "         <MSG_HDR>\n" +
                "            <INTNO>" + interfaceCode + "</INTNO>\n" +
                "            <!--Optional:-->\n" +
                "            <MSG_GUID></MSG_GUID>\n" +
                "            <PIGUID></PIGUID>\n" +
                "            <SENDER>MRO</SENDER>\n" +
                "            <RECEIVER>SAP</RECEIVER>\n" +
                "            <BUSTYPE>" + demandCode + "</BUSTYPE>\n" +
                "            <!--Optional:-->\n" +
                "            <DATT>" + dateString + "</DATT>\n" +
                "            <RES1></RES1>\n" +
                "            <RES2></RES2>\n" +
                "            <RES3></RES3>\n" +
                "         </MSG_HDR>\n" +
                "         <MSG_BODY>\n" +
                "            <BU_HDR>\n" +
                "               <ZORDNUM>" + (gcShHeadDto.getShNo() == null ? "" : gcShHeadDto.getShNo()) + "</ZORDNUM>\n" +//发货指令号
                "               <ZDATE>" + formatter.format(createdDate) + "</ZDATE>\n" +//指令日期
                "               <PLANT>" + gcShHeadDto.getCompanyCode() + "</PLANT>\n" +//公司代码
                "               <STLOC>" + (gcShHeadDto.getSupNo() == null ? "" : gcShHeadDto.getSupNo()) + "</STLOC>\n" +//发货仓库
                "               <STLOC_IN>" + (gcShHeadDto.getShopNo() == null ? "" : gcShHeadDto.getShopNo()) + "</STLOC_IN>\n" +//收货仓库
                "               <ZTYPE></ZTYPE>\n" +
                "               <ZSJH></ZSJH>\n" +
                "               <ZSJHIN></ZSJHIN>\n" +
                "               <COSTCENTER></COSTCENTER>\n" +
                "               <ZBZ>" + (gcShHeadDto.getComments() == null ? "" : gcShHeadDto.getComments()) + "</ZBZ>\n" + //备注
                "               <TASK_TYPE>" + taskType + "</TASK_TYPE>\n" + //任务类型  默认第一个订单
                "               <ZRES1></ZRES1>\n" +
                "               <ZRES2>" + (gcShHeadDto.getOuterWarehouseNo() == null ? "" : gcShHeadDto.getOuterWarehouseNo()) + "</ZRES2>\n" +
                "               <ZRES3></ZRES3>\n" +
                "               <ZRES4></ZRES4>\n" +
                "               <ZRES5></ZRES5>\n" +
                "            </BU_HDR>\n");

        if (gcShHeadDto != null && gcShHeadDto.getGcshitemVOs().size() > 0) {
            for (GcshItem gcshitemVO : gcShHeadDto.getGcshitemVOs()) {

                if (gcshitemVO.getShQut() == null || gcshitemVO.getShQut().equals(new Double("0"))) {
                    continue;
                }

                Material material=materialMapper.getMatOrderByNo(gcshitemVO.getMatCode(),"GC");
                if (material.getStatus().equals("0")) {//去掉禁用物料
                    continue;
                }
                if (!material.getUnit().equals(gcshitemVO.getUnit())) {
                    gcshitemVO.setUnit(material.getUnit());
                }

                sb.append("            <BU_ITEM>\n" +
                        "               <ZORDNUM>" + (gcShHeadDto.getShNo() == null ? "" : gcShHeadDto.getShNo()) + "</ZORDNUM>\n" +//发货指令号
                        "               <ZORDLINE>" + (gcshitemVO.getRowNo() == null ? "" : gcshitemVO.getRowNo()) + "</ZORDLINE>\n" +//发货指令行号
                        "               <MATNR>" + (gcshitemVO.getMatCode() == null ? "" : gcshitemVO.getMatCode()) + "</MATNR>\n" +//商品
                        "               <ENTRY_QNT>" + (gcshitemVO.getShQut()) + "</ENTRY_QNT>\n" +//送货数量
                        "               <ENTRY_UOM>" + (gcshitemVO.getUnit() == null ? material.getUnit() : gcshitemVO.getUnit()) + "</ENTRY_UOM>\n" +//送货单位
                        "               <ZWBDH>" + (gcshitemVO.getPoNo()) + "</ZWBDH>\n" +//订单单号
                        "               <ITEM_TEXT></ITEM_TEXT>\n" +
                        "               <ZRES1></ZRES1>\n" +
                        "               <ZRES2></ZRES2>\n" +
                        "               <ZRES3></ZRES3>\n" +
                        "               <ZRES4></ZRES4>\n" +
                        "               <ZRES5></ZRES5>\n" +
                        "            </BU_ITEM>\n");
            }
        }


        sb.append("         </MSG_BODY>\n" +
                "      </urn:SLM_RESERV>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>");

        System.out.println(sb.toString());

        String sapUrl = mat2SAPConfig.getUrl2();
        sapInterfaceDataLogService.sapsend(sapUrl, sb.toString(), demandCode, interfaceCode, "", "", dataId, dataCode);

    }


    public void setGcShHeadFinish(GCshHdead gcshhead, DeliveryVO deliveryDto) {
        int unfinishCount = 0;//是否收货完成
        for (DeliveryItem itemVO : deliveryDto.getDeliveryitemVOs()) {
            if (itemVO.getDeleted()==1) {
                continue;
            }
            /*Double qcQut = itemVO.getShQut();
    		Double sjQut = itemVO.getQcShQut();

    		if(qcQut>gcshItems.get(i).getPoQut()){
    			throw new BaseException("第"+(i+1)+"行物料收货数大于订单数", new Object[]{});
    		}

    		if(gcshItems.get(i).getSjShQut()>(qcQut)){
    			unfinishCount++;
    		}

    		if(sjQut>(qcQut)){
    			unfinishCount++;
    		}*/


            double ksqut =deliveryService.getSHKCCount(itemVO.getPoNo(), itemVO.getPrNo(), itemVO.getMatCode(), itemVO.getMatName(), itemVO.getMatSpec(), deliveryDto.getShopNo());
            if (ksqut > 0) {
                unfinishCount++;
            }

           /* String shopNo = itemVO.getShopNo()==null?"":itemVO.getShopNo();
            //设置YSQUT
            for(int i=0;i<gcshItems.size();i++){
            	if(itemVO.getMatCode().equals(gcshItems.get(i).getMatCode())&&itemVO.getPoNo().equals(gcshItems.get(i).getPoNo())&&shopNo.equals(gcshItems.get(i).getShopNo())){
            		//gcshItems.get(i).setYsQut(NumberUtils.add(gcshItems.get(i).getYsQut(),itemVO.getQcShQut()));
            		//gcshItems.get(i).setSignDate(DateTools.getCurrentDateAndTime(DateTools.defaultFormat));
            		//获取收货数
            		//Double qcQut = deliveryService.getDeliveryCountByShNo(gcshhead.getShNo(), gcshItems.get(i).getPoNo(), gcshItems.get(i).getMatCode(), gcshItems.get(i).getShopNo());

            	}
            }*/

        }
        if (unfinishCount == 0) {
            gcshhead.setGcShStatus("06");//送货完成
            gcshhead.setIsSend(null);//  关闭邮件提醒
        }
          insertGCshHdead(gcshhead);
    }


    public DeliveryVO get(Integer id) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GCshHdead gcshhead = getGCshHdeadByPK(id);
        List<GcshItem> gcshItemList=gcshItemMapper.getListGcshItemByShId(id);
        gcshhead.setGcshitemVOs(gcshItemList);
        GcShHeadDto gcShHeadDto = new GcShHeadDto();

        if (gcshhead != null) {
            gcShHeadDto = new GcShHeadDto();
            try {
                BeanUtils.copyProperties(gcShHeadDto, gcshhead);
                //附件
                List<Attachment> attachmentList=getAttachmentList( gcshhead.getId(),GCshHdead.class.getName());

                gcShHeadDto.setFiles(attachmentList);

                gcShHeadDto.setGcshitemVOs(gcshItemList);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            if (gcShHeadDto.getRequiredArrivalDate() != null) {
                  gcShHeadDto.setRequiredArrivalDate1(sdf.format(gcShHeadDto.getRequiredArrivalDate()));
            }


            String supno = gcShHeadDto.getSupNo();
            gcShHeadDto.setSupAddress("");
            if (null != supno) {
                Supplier supplier =supplierService.getSupplierByNo(supno,"GC");
                if (supplier != null) {
                    gcShHeadDto.setSupAddress(supplier.getAddress());
                }
            }
            List<GcshItem> voList = gcShHeadDto.getGcshitemVOs();
            if (voList != null) {
                for (GcshItem vo : voList) {
                    if (vo.getShQut() != null) {
                        vo.setShQut1(String.valueOf(vo.getSjShQut()));
                    } else {
                        vo.setShQut1("0");
                    }
                    if ("WLtoShop".equals(gcShHeadDto.getShType())) {
                        vo.setShopName(gcShHeadDto.getShopName());
                        vo.setSjShQut(vo.getShQut());
                    }
                    //小类
                    if (vo.getsType() == null) {
                        List<Material> materialList=materialMapper.getMaterialByCode(vo.getMatCode());
                        if (materialList != null &&!materialList.isEmpty()) {
                            Material material=materialList.get(0);
                            if(material.getCategoryC() != null){
                                vo.setsType(material.getCategoryC());
                            }

                        }
                    }
                }

            }
        }

        //找固话
        //gcShHeadDto.getShopNo();
         List<Shop2GC> shop2GCList=shop2GCService.findByStoreId(gcShHeadDto.getShopNo());
             if(shop2GCList != null&&!shop2GCList.isEmpty()){
                 Shop2GC info=shop2GCList.get(0);
                 info.setInfoContactInformationList(contractService.getContractByShopId(info.getId()));
                 if(info != null &&info.getInfoContactInformationList()!=null){
                     for (int i = 0; i < info.getInfoContactInformationList().size(); i++) {
                         Contract infoContactInformation = info.getInfoContactInformationList().get(i);
                         if ("1".equals(infoContactInformation.getPosition()) && infoContactInformation.getTelephone() != null && !infoContactInformation.getTelephone().equals(infoContactInformation.getMobilephone())) {
                             if (infoContactInformation.getContacts().equals(gcShHeadDto.getContacts())) {
                                 gcShHeadDto.setTel(infoContactInformation.getTelephone() + "/" + infoContactInformation.getMobilephone());
                             }

                         }
                     }
                 }
             }

        DeliveryVO deliveryDto = new DeliveryVO();

        if (gcShHeadDto != null) {
            deliveryDto.setShNo(gcShHeadDto.getShNo());
            deliveryDto.setShopNo(gcShHeadDto.getShopNo());
            deliveryDto.setShopName(gcShHeadDto.getShopName());
            deliveryDto.setBrandType(gcShHeadDto.getBrandType());
            List<DeliveryItem> deliveryitemVOs = new ArrayList<DeliveryItem>();

            for (int i = 0; i < gcShHeadDto.getGcshitemVOs().size(); i++) {
                GcshItem gcshItemVO = gcShHeadDto.getGcshitemVOs().get(i);
                DeliveryItem deliveryItemVO = new DeliveryItem();
                deliveryItemVO.setPoNo(gcshItemVO.getPoNo());
                deliveryItemVO.setMatCode(gcshItemVO.getMatCode());
                deliveryItemVO.setMatName(gcshItemVO.getMatName());
                deliveryItemVO.setMatSpec(gcshItemVO.getMatSpec());
                deliveryItemVO.setShopNo(gcshItemVO.getShopNo());
                deliveryItemVO.setShopName(gcshItemVO.getShopName());
                deliveryItemVO.setMakeIe(gcshItemVO.getMakeIe());
                deliveryItemVO.setUnit(gcshItemVO.getUnit());
                deliveryItemVO.setShQut(String.valueOf(gcshItemVO.getSjShQut()));
                //      deliveryItemVO.setKsQut(deliveryService.getSHKCCount(gcshItemVO.getPoNo(), gcshItemVO.getPrNo(), gcshItemVO.getMatCode(), gcshItemVO.getMatName(), gcshItemVO.getMatSpec(), gcshItemVO.getShopNo()));
                deliveryItemVO.setQcShQut(deliveryItemVO.getKsQut());
                deliveryItemVO.setPrNo(gcshItemVO.getPrNo());
                //   deliveryItemVO.setSType(gcshItemVO.getsType());
                // deliveryItemVO.setMType(gcshItemVO.getmType());
                // deliveryItemVO.setBType(gcshItemVO.getbType());
                deliveryItemVO.setShItemId(gcshItemVO.getRowNo());
                deliveryitemVOs.add(deliveryItemVO);
            }
            deliveryDto.setDeliveryitemVOs(deliveryitemVOs);
        }
        return deliveryDto;
    }

}