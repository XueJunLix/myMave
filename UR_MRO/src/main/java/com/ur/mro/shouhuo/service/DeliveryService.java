package com.ur.mro.shouhuo.service;

import com.ur.admin.service.AdminUserInfoService;
import com.ur.common.model.Mat2SAPConfig;
import com.ur.common.service.BaseService;
import com.ur.common.service.SysSerivalNumberService;
import com.ur.common.util.DateTools;
import com.ur.common.util.NumberUtils;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ur.mro.mat.mappers.MaterialMapper;
import com.ur.mro.mat.model.Material;
import com.ur.mro.order.mappers.OrderInfoMapper;
import com.ur.mro.order.model.OrderInfo;
import com.ur.mro.purchaseorder.model.PurchaseOrder;
import com.ur.mro.purchaseorder.service.PurchaseOrderService;
import com.ur.mro.purpurchase.mappers.PurPurchaseMapper;

import com.ur.mro.sap.service.SapInterfaceDataLog2Service;
import com.ur.mro.shop.model.Shop2GC;
import com.ur.mro.shop.service.Shop2GCService;
import com.ur.mro.shouhuo.mappers.DeliveryItemMapper;
import com.ur.mro.shouhuo.mappers.DeliveryMapper;
import com.ur.mro.shouhuo.mappers.GcshItemMapper;
import com.ur.mro.shouhuo.model.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
public class DeliveryService extends BaseService {
    @Autowired
    DeliveryMapper deliveryMapper;
    @Autowired
    AdminUserInfoService adminUserInfoService;

    @Autowired
    GCshHdeadService gCshHdeadService;

    @Autowired
    GcshItemMapper  gcshItemMapper;

    @Autowired
    DeliveryItemMapper deliveryItemMapper;


    @Autowired
    PurchaseOrderService purchaseOrderService;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    PurPurchaseMapper purPurchaseMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    Mat2SAPConfig mat2SAPConfig;

    @Autowired
    WlShopMatinvService wlShopMatinvService;


    @Autowired
    Shop2GCService shop2GCService;

    @Autowired
    SapInterfaceDataLog2Service sapInterfaceDataLogService;

    @Autowired
    SysSerivalNumberService sysSerivalNumberService;



    public Delivery getDeliveryByPK(Integer pkId) {
        return deliveryMapper.getDeliveryByPK(pkId);
    }

    @Transactional
    public Integer insertDelivery(Delivery delivery) {

        //TODO handle date columns here
        //delivery.setCreatedTime(new Date());
        //delivery.setLastUpdatedTime(new Date());
        //delivery.setGoodsSignDate(new Date());

        deliveryMapper.insertDelivery(delivery);
        return delivery.getId();
    }

    @Transactional
    public int updateDeliveryByPKSelective(Delivery delivery) {

        //TODO handle date columns here
        //delivery.setCreatedTime(new Date());
        //delivery.setLastUpdatedTime(new Date());
        //delivery.setGoodsSignDate(new Date());

        int result = deliveryMapper.updateDeliveryByPKSelective(delivery);
        return result;
    }

    public PagingRestResponse searchDelivery(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {

        int totalRecordNum = deliveryMapper.searchDeliveryCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);

        List<Delivery> resultList = null;
        if(totalRecordNum>0){
            resultList = deliveryMapper.searchDelivery(selectFields, condList, orderByList, pageBean);
        }

        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }


 @Transactional
    public void saveDelivery(DeliveryVO deliveryVO) throws Exception{


         GCshHdead gcshhead = gCshHdeadService.findGCshHeadByShno(deliveryVO.getShNo());
        String receivier = gcshhead.getShopNo();//收货方

        String shNo = deliveryVO.getShNo();
        String dlNo = null;

        Integer headId = deliveryVO.getId();


        Delivery delivery = null;

        if (headId != null) {
             delivery = getDeliveryByPK(headId);
        } else {


            if (StringUtils.isEmpty(delivery)){
                delivery = new Delivery();
            } else {
                dlNo = delivery.getDeliveryNo();
            }
        }
        try {
            BeanUtils.copyProperties(delivery, deliveryVO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(delivery.getDeliveryNo())){
            delivery.setDeliveryNo(dlNo);
        }

       /* for(DeliveryItem deliveryitemVO:DeliveryitemVOList ){

            if(gcshhead.getShType().equals("supToWL")){
                receivier = deliveryitemVO.getShopNo();
            }
            //签收数量
            Double deliveryCount = this.getDeliveryTotalCount(deliveryitemVO.getPoNo(),deliveryitemVO.getPrNo() ,deliveryitemVO.getMatCode(), deliveryitemVO.getMatName(), deliveryitemVO.getMatSpec(), receivier);
            if(headId == null){
                deliveryCount =NumberUtils.add(deliveryCount, Double.valueOf(deliveryitemVO.getQcShQut()));
            }
            if(!StringUtils.isEmpty(deliveryitemVO.getPoNo())){
                //订单数
                Double purchaseActualCount = this.getPurchaseActualCount(deliveryitemVO.getPoNo(),deliveryitemVO.getPrNo(), deliveryitemVO.getMatCode(), deliveryitemVO.getMatName(), deliveryitemVO.getMatSpec(), deliveryitemVO.getShopNo());
                if(deliveryCount>purchaseActualCount){
                    throw new Exception(deliveryitemVO.getMatName()+deliveryitemVO.getMatCode()+"总的签收数"+deliveryCount+"大于申购数"+purchaseActualCount+"！！");
                }
            }
        }*/

        List<DeliveryItem> deliveryitems=deliveryVO.getDeliveryitemVOs();

        for (DeliveryItem deliveryitem : deliveryitems) {
            String poNo = deliveryitem.getPoNo();

            if (!StringUtils.isEmpty(poNo)){
                Delivery deliveryPo = deliveryMapper.getDeliveryByShNo(poNo);
                if (deliveryPo != null && deliveryPo.getShopNo().equals(deliveryVO.getShopNo())) {
                    throw new Exception(deliveryPo.getShNo() + "该单已在《据采购订单收货》中存在，无法创建！！");
                }

            }
            if("shopToWC".equals(gcshhead.getShType())){
                //店到外仓
                deliveryitem.setShopNo(delivery.getSenderNo());
                deliveryitem.setShopName(delivery.getSenderName());
            }
            deliveryitem.setDelivery(delivery);
        }
        delivery.setDeliveryitems(deliveryitems);
        if (delivery.getId() == null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
            String dateStr = sdf.format(new Date());
            String perCode = "DL";
            dlNo = perCode + sysSerivalNumberService
                    .curSerialNumberFullYYMMDD(perCode + delivery.getClass().getSimpleName() + dateStr, 4);
            delivery.setDeliveryNo(dlNo);
        }

        boolean isUndefined = false;// 采购结果是否存在 请选择/未处理
        boolean isUnDeal = false;// 采购结果是否存在 处理中
        boolean isFinish = false;// 采购结果是否存在 处理完成

        //int unfinishCount = 0;// 是否收货完成

        //Gcshhead gcshhead = (Gcshhead) this.getObjectByField(Gcshhead.class, deliveryDto.getShNo(), "shNo");
        //List<Gcshitem> gcshItems = gcshhead.getGcshitems();

        for (DeliveryItem item : delivery.getDeliveryitems()) {
            if (item.getDeleted()==1) {
                continue;
            }
            if (item.getDealResult() == null || "1".equals(item.getDealResult())) {// 请选择/未处理
                isUndefined = true;
            } else if ("2".equals(item.getDealResult())) {// 处理中
                isUnDeal = true;
            } else {// 处理完成
                isFinish = true;
            }

            // 设置YSQUT
			/*for (int i = 0; i < gcshItems.size(); i++) {
				if (item.getMatCode().equals(gcshItems.get(i).getMatCode())) {
					gcshItems.get(i).setYsQut(NumberUtils.add(gcshItems.get(i).getYsQut(), item.getQcShQut()));
					gcshItems.get(i).setSignDate(DateTools.getCurrentDateAndTime(DateTools.defaultFormat));
					if (!gcshItems.get(i).getYsQut().equals(gcshItems.get(i).getShQut())) {
						unfinishCount++;
					}
				}
			}*/
            super.setCreateFields(item);
            super.setUpdateFields(item);
        }
		/*if (unfinishCount == 0) {
			gcshhead.setGcShStatus("06");// 送货完成

		}*/
        //gcshhead.setGcshitems(gcshItems);
        //gcShHeadService.saveGcshhead(gcshhead);

        if (!isFinish && !isUnDeal) {// 不存在处理完成 和 处理中,证明全部没处理
            delivery.setDelDiffStatus("1");// 未处理
        }
        if (!isUnDeal && !isUndefined) {// 不存在未处理 和 处理中,证明全部处理完成
            delivery.setDelDiffStatus("3");// 处理完成
        }
        if (!((!isFinish && !isUnDeal) || (!isUnDeal && !isUndefined))) {// 上面2个并集的补集，就是处理中
            delivery.setDelDiffStatus("2");// 处理中
        }


        delivery.setGoodsSignDate(new Date());
        delivery.setCreatedBy(adminUserInfoService.getCurrentLoginName());
        delivery.setCreatedTime(new Date());

        super.setCreateFields(delivery);
        super.setUpdateFields(delivery);

        if(delivery.getId()==null){
            insertDelivery(delivery);
             deliveryItemMapper.insertBatchDeliveryItem(deliveryitems);
        }

        else{
            updateDeliveryByPKSelective(delivery);
            deliveryItemMapper.updateBathcDeliveryItemByPKSelective(deliveryitems);
            /*if(delivery.getLastModifiedBy().equals("ANONYMOUS") && delivery.getCreatedBy().equals("ANONYMOUS")){
            deliveryRepository.updateCreateAndUpdateName(deliveryDto.getCreatedBy(), deliveryDto.getLastModifiedBy(), devId);
            deliveryRepository.updateItemCreateAndUpdateName(deliveryDto.getCreatedBy(), deliveryDto.getLastModifiedBy(), devId);
        }
        super.saveFj(deliveryDto.getFiles(), delivery);//保存附件*/
        }
          saveFj(delivery.getFiles(), delivery.getClass().getName(),delivery.getId());//保存附件
          submitDelById(delivery);
    }
        /**
         * 获取收货方所有的签收数
         * @param poNo
         * @param matCode
         * @param matName
         * @param matSpec
         * @param shopNo
         * @return
         */
        private Double getDeliveryTotalCount (String poNo, String prNo, String matCode, String matName, String matSpec, String shopNo){
            List<Map<String, Object>> result = deliveryMapper.getDeliveryTotalCount(poNo, prNo, matCode, matName, matSpec, shopNo);

            Double count = 0.0;

            if (result != null && !result.isEmpty()) {
                for (int i = 0; i < result.size(); i++) {
                    Map<String, Object> entry = result.get(i);
                    if (entry.get("QC_SH_QUT") != null) {
                        String qcShQut = entry.get("QC_SH_QUT").toString();
                        count = Double.parseDouble(qcShQut);
                        return count;
                    }
                }
            }
            return count;
        }

        private Double getPurchaseActualCount (String po, String prNo, String matCode, String matName, String matSpec, String shopNo){
            if (po.startsWith("PO")) {
                return this.getPurchasePOActualCount(po, prNo, matCode, matName, matSpec, shopNo);
            } else if (po.startsWith("PR")) {
                return this.getPurchaseSHActualCount(po, prNo, matCode, matName, matSpec, shopNo);
            }
            return null;
        }

        /**
         * po汇总数量
         * @param poNo
         * @param matCode
         * @param matName
         * @param matSpec
         * @param shopNo
         * @return
         */
        private Double getPurchasePOActualCount (String poNo, String prNo, String matCode, String matName, String matSpec, String shopNo){
            List<Map<String, Object>> result = deliveryMapper.getPurchasePOActualCount(poNo, prNo, matCode, matName, matSpec, shopNo);
            Double count = 0.0;
            if (result != null && !result.isEmpty()) {
                for (int i = 0; i < result.size(); i++) {
                    Map<String, Object> entry = result.get(i);
                    if (entry.get("PURCHASE_ACTUAL_COUNT") != null) {
                        String qcShQut = entry.get("PURCHASE_ACTUAL_COUNT").toString();
                        count = Double.parseDouble(qcShQut);
                        return count;
                    }
                }
            }

            return count;
        }


        /**
         * po汇总数量
         * @param poNo
         * @param matCode
         * @param matName
         * @param matSpec
         * @param shopNo
         * @return
         */
        private Double getPurchaseSHActualCount(String poNo, String prNo, String matCode, String matName, String matSpec, String shopNo){

            List<Map<String, Object>> result = deliveryMapper.getPurchaseSHActualCount(poNo, prNo, matCode, matName, matSpec, shopNo);
            Double count = 0.0;
            if (result != null && !result.isEmpty()) {
                for (int i = 0; i < result.size(); i++) {
                    Map<String, Object> entry = result.get(i);
                    if (entry.get("PURCHASE_ACTUAL_COUNT") != null) {
                        String qcShQut = entry.get("PURCHASE_ACTUAL_COUNT").toString();
                        count = Double.parseDouble(qcShQut);
                        return count;
                    }
                }
            }
            return count;
        }


    public void setGcdeliveryPoFinish(Delivery delivery) {
        if (delivery == null) {
            return;
        }
        // 判断采购订单是否送货完成，如果完成，设置为true
        List<DeliveryItem> deliveryIitemList = delivery.getDeliveryitems();
        if (deliveryIitemList != null) {
            String poNo = "";
            for (DeliveryItem deliveryItem : deliveryIitemList) {
                if (deliveryItem.getDeleted()==1) {
                    continue;
                }
                poNo = deliveryItem.getPoNo();
                PurchaseOrder purchaseOrder=purchaseOrderService.getPurchaseOrderDtoByOrderNo(poNo,"GC");
                purchaseOrder.setOrderInfos(orderInfoMapper.getOrderInfoByOrderId(purchaseOrder.getId()));
                if (purchaseOrder != null) {

                    for (int i = 0; i < purchaseOrder.getOrderInfos().size(); i++) {// 设置采购订单
                        // 的明细
                        // 是否完成送货
                        OrderInfo o = purchaseOrder.getOrderInfos().get(i);
                        if (o.getDeleted()==1) {
                            continue;
                        }
                        String matCode = o.getMatCode();// 物料编号
                        String matName = o.getMatName();// 物料编号
                        String shopNo = o.getShopNo();// 店铺编码
                        if("WL0001".equals(delivery.getShopNo())||"ZD0098".equals(delivery.getShopNo())){
                            shopNo = delivery.getShopNo();
                        }
                        // 检查该物料是否已经送货完成
                        Double purchaseCount = o.getPurchaseActualCount() == null ? Double.valueOf(o.getPurchaseCount()==null?"0.00":o.getPurchaseCount())
                                : Double.valueOf(o.getPurchaseActualCount());// 订单数

                        // 转店累加
                        Double qcShQut=0.00;
                        String sqcshOut=deliveryMapper.getQCHOUT(poNo,matCode,matName,shopNo);
                        if(qcShQut!=null)
                            qcShQut=Double.valueOf(sqcshOut);

                        if (purchaseCount <= qcShQut) {
                            o.setIsGcdeliveryFinish(1);
                        } else {
                            o.setIsGcdeliveryFinish(0);
                        }
                        o.setDeliveryCount(String.valueOf(qcShQut));
                        orderInfoMapper.updateOrderInfoByPKSelective(o);
                    }
                    // }

                    boolean allGcDeliveryFinish = true;
                    for (int i = 0; i < purchaseOrder.getOrderInfos().size(); i++) {
                        OrderInfo o = purchaseOrder.getOrderInfos().get(i);
                        if (o.getDeleted()==1) {
                            continue;
                        }
                        if (o.getIsGcdeliveryFinish() != null) {
                            if (o.getIsGcdeliveryFinish()==0) {
                                allGcDeliveryFinish = false;
                            }
                        } else {
                            allGcDeliveryFinish = false;
                        }

                    }
                    if (allGcDeliveryFinish) {// 设置一整张采购订单是否完成收貨
                        purchaseOrder.setIsGcshheadFinish(1);
                        purchaseOrder.setDzIsSend("S");
                    } else {
                        purchaseOrder.setIsGcshheadFinish(0);
                    }
                     purchaseOrderService.updatePurchaseOrderByPKSelective(purchaseOrder);
                }
            }

        }

    }


    public Double getSHKCCount(String poNo,String prNo, String matCode,String matName,String matSpec, String shopNo){
        Double poCount  = this.getPurchaseSHActualCount(poNo, prNo, matCode, matName, matSpec, shopNo);
        Double dlCount = this.getDeliveryTotalCount(poNo, prNo, matCode, matName, matSpec, shopNo);
        return NumberUtils.subtract(poCount, dlCount);
    }


    //传sap 提交收货单
    public void  submitDelById(Delivery delivery) throws Exception{
        if (delivery != null) {
            try {
                DeliveryVO deliveryDto2=new DeliveryVO();
                BeanUtils.copyProperties(deliveryDto2,delivery);

                GCshHdead gcshhead = gCshHdeadService.findGCshHeadByShno(delivery.getShNo());
                gcshhead.setIsSend(null);// 关闭邮件提醒
                gCshHdeadService.insertGCshHdead(gcshhead);
                wlShopMatinvService.writeMatinv(gcshhead, delivery);
                delivery.setGcWlStatus("02");
                delivery.setGoodsSignDate(DateTools.getCurrentDateAndTime(DateTools.defaultFormat));
                updateDeliveryByPKSelective(delivery);
                setGcdeliveryPoFinish(delivery);

                // 供应商外仓的签收转送货单
                if (gcshhead.getOuterWarehouseNo() != null && gcshhead.getOuterWarehouseNo().equals("Z997")) {
                    GCshHdead gcShHeadDto = gCshHdeadService.getGCshHdeadByPK(gcshhead.getId());
                    String supNo = gcShHeadDto.getSupNo();
                    String wc = gcShHeadDto.getOuterWarehouseNo();
                    gcShHeadDto.setSupNo(wc);// 发送方
                    gcShHeadDto.setOuterWarehouseNo(supNo);// 供应商
                    gCshHdeadService.gcShHeadCrAsySapWs(gcShHeadDto, gcshhead.getCreatedTime());
                    gCshHdeadService.setGcShHeadFinish(gcshhead, deliveryDto2);
                    return ;
                }

                // ======================================================传SAP
                // start
                gCshHdeadService.setGcShHeadFinish(gcshhead, deliveryDto2);// 判断是否收货
                String poNo = delivery.getDeliveryitems().get(0).getPoNo();
                PurchaseOrder purchaseOrderDto = purchaseOrderService.getPurchaseOrderDtoByOrderNo(poNo,null);
                if (!purchaseOrderDto.getOrderType().equals("9") && !purchaseOrderDto.getOrderType().equals("11")
                        && !gcshhead.getSupNo().equals("ZD0098") && !gcshhead.getSupNo().equals("ZD0086")) { // 工厂领用单不传SAP,工厂到店，店铺收货
                    // --------------------暂时关闭传SAP2018/4/3
                    deliveryCrAsySapWs(deliveryDto2, false);
                }
                // ======================================================传SAP
                // end

            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception(e.getMessage());
            }
        }
    }


    /**
     * 发送收货信息到SAP接口 保存
     *
     * @param deliveryDto
     *            modified by siyang.gu 14/11/2017
     */
    public void deliveryCrAsySapWs(DeliveryVO deliveryDto,boolean flag) {
        if (deliveryDto.getDeliveryitemVOs() != null && deliveryDto.getDeliveryitemVOs().size() > 0) {
            String shopNo = deliveryDto.getShopNo();
            SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
            Date splitDate = null;
            try {
                splitDate = format.parse("2018-01-01");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (DeliveryItem deliveryitemVO : deliveryDto.getDeliveryitemVOs()) {
                PurchaseOrder purchaseOrder = purchaseOrderService.getPurchaseOrderDtoByOrderNo(deliveryitemVO.getPoNo(),null);
                Date createdDate = purchaseOrder.getCreatedTime();
                String taskType = purchaseOrder.getTaskType();
                if(!flag){ //判断是否手动，false自动
                    //1月1日以后开业的新店订单及1月1日以后下单的订单
                    if (splitDate.compareTo(createdDate) < 0) {//2018-01-01创建的单
                        flag= true;
                    }

                    if ("2".equals(taskType)){
                        if(shopNo!=null){
                            Shop2GC shopInfo = shop2GCService.findByStoreId(shopNo).get(0);
                            Date openTime = shopInfo.getExpectedOpenTime();
                            if(openTime!=null){
                                if (splitDate.compareTo(openTime) < 0) {//开业日期
                                    flag= true;
                                }
                            }
                        }
                    }
                    if(!flag){
                        return;
                    }
                }
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(new Date());
//		System.out.println(dateString);
        String interfaceCode = "INT_MRO_004";
        String demandCode = "FS-MM-003";
        StringBuffer sb = new StringBuffer();

        String dataId = deliveryDto.getId() + "";// 收货信息id
        String dataCode = deliveryDto.getDeliveryNo() == null ? "" : deliveryDto.getDeliveryNo(); //收货单号  写入中间表

        String  dateString2 = dateString.substring(0,8); //记账日期
        String shNo = "";
        if(deliveryDto.getShNo()!=null){

            if(deliveryDto.getShNo().startsWith("SH")){
                shNo = deliveryDto.getShNo();
            }

        }

        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:ur.cn:SLM:ERP:BusinessData\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <urn:SLM_GOODSMVT>\n" +
                "         <MSG_HDR>\n" +
                "            <INTNO>"+interfaceCode+"</INTNO>\n" +
                "            <!--Optional:-->\n" +
                "            <MSG_GUID></MSG_GUID>\n" +
                "            <PIGUID></PIGUID>\n" +
                "            <SENDER>MRO</SENDER>\n" +
                "            <RECEIVER>SAP</RECEIVER>\n" +
                "            <BUSTYPE>"+demandCode+"</BUSTYPE>\n" +
                "            <!--Optional:-->\n" +
                "            <DATT>"+dateString+"</DATT>\n" +
                "            <!--Optional:-->\n" +
                "            <RES1></RES1>\n" +
                "            <!--Optional:-->\n" +
                "            <RES2></RES2>\n" +
                "            <!--Optional:-->\n" +
                "            <RES3></RES3>\n" +
                "         </MSG_HDR>\n" +
                "         <MSG_BODY>\n" +
                "            <BU_HDR>\n" +
                "               <!--Optional:-->\n" +
                "               <GMCODE></GMCODE>\n" +
                "               <MOVE_TYPE>101</MOVE_TYPE>\n" +
                "				<ZDELIV>"+shNo+"</ZDELIV>"+//送货单号
                "               <!--Optional:-->\n" +
                //"               <PSTNG_DATE>"+(deliveryDto.getGoodsSignDate() == null ? dateString2: formatter.format(deliveryDto.getGoodsSignDate()))+"</PSTNG_DATE>\n" + // 收货日期
                "               <PSTNG_DATE>"+(dateString2)+"</PSTNG_DATE>\n" + // 收货日期
                "               <!--Optional:-->\n" +
                "               <DOC_DATE></DOC_DATE>\n" +
                "               <!--Optional:-->\n" +
                "               <ZREF_DOC_NO>"+(deliveryDto.getDeliveryNo() == null ? "" : deliveryDto.getDeliveryNo())+"</ZREF_DOC_NO>\n" + // 收货单号
                "               <!--Optional:-->\n" +
                "               <BILL_OF_LADING></BILL_OF_LADING>\n" +
                "               <!--Optional:-->\n" +
                "               <GR_GI_SLIP_NO></GR_GI_SLIP_NO>\n" +
                "               <!--Optional:-->\n" +
                "               <HEADER_TXT></HEADER_TXT>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES1></ZRES1>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES2></ZRES2>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES3></ZRES3>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES4></ZRES4>\n" +
                "               <!--Optional:-->\n" +
                "               <ZRES5></ZRES5>\n" +
                "            </BU_HDR>\n");

        //拼接Items部分的xml
        getSAPXMLItems(deliveryDto,sb);

        sb.append("         </MSG_BODY>\n" +
                "      </urn:SLM_GOODSMVT>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>");


//		System.out.println(sb.toString());

          String sapUrl = mat2SAPConfig.getUrl2();
        sapInterfaceDataLogService.sapsend(sapUrl, sb.toString(), demandCode, interfaceCode, "", "", dataId,dataCode);
    }

    /**
     * 拼接传SAP Items部分的xml
     * Created by siyang.gu 14/11/2017
     * @param deliveryDto
     * @param sb
     */
    private void getSAPXMLItems(DeliveryVO deliveryDto,StringBuffer sb){
        String shopNo = deliveryDto.getShopNo() == null ? "ZD0098" : deliveryDto.getShopNo();//  收货仓库

        if(shopNo.equals("URCNA0005")){//长春欧亚商都店（ACC）
            shopNo="URCN0214";
        }

        if (deliveryDto.getDeliveryitemVOs() != null && deliveryDto.getDeliveryitemVOs().size() > 0) {
            for (DeliveryItem deliveryitemVO : deliveryDto.getDeliveryitemVOs()) {

                if (deliveryitemVO.getQcShQut() == null||deliveryitemVO.getQcShQut().equals(new Double("0"))) {
                    continue;
                }

                String rowId = deliveryitemVO.getPoItemRowNo()==null?"":deliveryitemVO.getPoItemRowNo();
                String poNoStr = deliveryitemVO.getPoNo() == null ? "" : deliveryitemVO.getPoNo();// 采购订单编号
                String matCodeStr = deliveryitemVO.getMatCode()==null?"":deliveryitemVO.getMatCode();// 商品
                String matNameStr = deliveryitemVO.getMatName()==null?"":deliveryitemVO.getMatName();// 商品
                String matSpecStr = deliveryitemVO.getMatSpec()==null?"":deliveryitemVO.getMatSpec();// 商品
                String matShopNo = deliveryitemVO.getShopNo()==null?"ZD0098":deliveryitemVO.getShopNo();
                String matPrNo = deliveryitemVO.getPrNo()==null?"":deliveryitemVO.getPrNo();// 商品
                Material material=materialMapper.getMatOrderByNo( deliveryitemVO.getMatCode(),"GC");

                PurchaseOrder purchaseOrderDto = purchaseOrderService.getPurchaseOrderDtoByOrderNo(poNoStr,null);
                purchaseOrderDto.setOrderInfos(orderInfoMapper.getOrderInfoByOrderId(purchaseOrderDto.getId()));

                if(purchaseOrderDto != null && purchaseOrderDto.getOrderInfos().size() > 0) {
                    for (OrderInfo orderInfoVO : purchaseOrderDto.getOrderInfos()) {
                        String oiShopNoStr = orderInfoVO.getShopNo()==null?"ZD0098":orderInfoVO.getShopNo();
                        String oiMatCodeStr = orderInfoVO.getMatCode()==null?"":orderInfoVO.getMatCode();
                        String oiMatNameStr = orderInfoVO.getMatName()==null?"":orderInfoVO.getMatName();
                        String oiMatSpecStr = orderInfoVO.getMatSpec()==null?"":orderInfoVO.getMatSpec();
                        String oiPrNo = orderInfoVO.getApplyOrderNo()==null?"":orderInfoVO.getApplyOrderNo();

                        if(rowId.equals("")){
                            if (shopNo.equals(oiShopNoStr) && matCodeStr.equals(oiMatCodeStr)&& matNameStr.equals(oiMatNameStr)&& matSpecStr.equals(oiMatSpecStr)&&oiPrNo.equals(matPrNo)) { // 对比商店号，物料编码，来取rowId

                                rowId = orderInfoVO.getRowId() ==null ? orderInfoVO.getId()+"":orderInfoVO.getRowId()+"";

                                if(!(orderInfoVO.getPurchaseUnit()==null?orderInfoVO.getBaseUnit():orderInfoVO.getPurchaseUnit()).equals(deliveryitemVO.getUnit())){
                                    deliveryitemVO.setUnit(orderInfoVO.getPurchaseUnit());
                                }

                            }else if(matShopNo.equals(oiShopNoStr)&&matCodeStr.equals(oiMatCodeStr)&& matNameStr.equals(oiMatNameStr)&& matSpecStr.equals(oiMatSpecStr)){ //当po明细中shopNo为空，直接对比物料编码

                                rowId = orderInfoVO.getRowId() ==null ? orderInfoVO.getId()+"":orderInfoVO.getRowId()+"";

                                if(!orderInfoVO.getPurchaseUnit().equals(deliveryitemVO.getUnit())){
                                    deliveryitemVO.setUnit(orderInfoVO.getPurchaseUnit());
                                }

                            }/*else if(matShopNo.equals(oiShopNoStr)&&matCodeStr.equals(oiMatCodeStr)){

								rowId = orderInfoVO.getRowId() ==null ? orderInfoVO.getId()+"":orderInfoVO.getRowId()+"";

								if(!orderInfoVO.getPurchaseUnit().equals(deliveryitemVO.getUnit())){
									deliveryitemVO.setUnit(orderInfoVO.getPurchaseUnit());
								}

							}*/
                        }

						/*else if("ZD0098".equals(shopNo)&&matCodeStr.equals(oiMatCodeStr)&& matNameStr.equals(oiMatNameStr)&& matSpecStr.equals(oiMatSpecStr)){ //ZD0098工厂物流  直接对比物料编码
							rowId = orderInfoVO.getRowId() ==null ? orderInfoVO.getId()+"":orderInfoVO.getRowId()+"";
						}*//*else if("WL0001".equals(shopNo)&&matCodeStr.equals(oiMatCodeStr)&& matNameStr.equals(oiMatNameStr)&& matSpecStr.equals(oiMatSpecStr)){ //WL0001物流供应商  直接对比物料编码
							rowId = orderInfoVO.getRowId() ==null ? orderInfoVO.getId()+"":orderInfoVO.getRowId()+"";
						}*/

						/*if("01FDBBA0001".equals(matCodeStr)){//通用物料
							if (shopNo.equals(oiShopNoStr) && matCodeStr.equals(oiMatCodeStr)&& matNameStr.equals(oiMatNameStr)&& matSpecStr.equals(oiMatSpecStr)) { // 对比商店号，物料编码，来取rowId
								rowId = orderInfoVO.getRowId() ==null ? orderInfoVO.getId()+"":orderInfoVO.getRowId()+"";
							}
						}*/



                        if(material.getCode().equals("01FDBBA0001")){
                            if (shopNo.equals(oiShopNoStr) && matCodeStr.equals(oiMatCodeStr)&& matNameStr.equals(oiMatNameStr)&& matSpecStr.equals(oiMatSpecStr)) { // 对比商店号，物料编码，来取rowId
                                if(orderInfoVO.getPurchaseUnit()!=null){
                                    if(!orderInfoVO.getPurchaseUnit().equals(deliveryitemVO.getUnit())){
                                        deliveryitemVO.setUnit(orderInfoVO.getPurchaseUnit());
                                    }
                                }
                            }
                        }

                    }
                    //费协同供应商编码不传
					/*Supplier supplier = (Supplier) supplierManagerService.getObjectByField(Supplier.class, purchaseOrderDto.getSupplierCode(), "code");
					String coo = supplier.getCoordination();
					if("0".equals(coo)){
						matCodeStr="";
					}*/
                    String orderType = purchaseOrderDto.getOrderType();
                    if("30".equals(orderType)){
                        matCodeStr="";
                    }

					/*if(material!=null&&!material.getCode().equals("01FDBBA0001")){//不是通用物料
						if(!material.getUnit().equals(deliveryitemVO.getUnit())){
							deliveryitemVO.setUnit(material.getUnit());
						}
					}*/
                }


                sb.append("            <BU_ITEM>\n" +
                        "               <MATERIAL>"+matCodeStr+"</MATERIAL>\n" + // 商品
                        "               <!--Optional:-->\n" +
                        "               <ZSJH></ZSJH>\n" +
                        "               <!--Optional:-->\n" +
                        "               <PLANT></PLANT>\n" +
                        "               <!--Optional:-->\n" +
                        "               <STGE_LOC>"+shopNo+"</STGE_LOC>\n" + // 收货仓库
                        "               <!--Optional:-->\n" +
                        "               <ZREF_DOC_IT>"+(deliveryitemVO.getRowNo() == null ? "" : deliveryitemVO.getRowNo())+"</ZREF_DOC_IT>\n" +// 收货单行号
                        "               <ENTRY_QNT>"+(deliveryitemVO.getQcShQut() == null ? "" : deliveryitemVO.getQcShQut())+"</ENTRY_QNT>\n" +// 收货数量
                        "               <ENTRY_UOM>"+(deliveryitemVO.getUnit() == null ? material.getUnit() : deliveryitemVO.getUnit())+"</ENTRY_UOM>\n" +// 收货单位
                        "               <!--Optional:-->\n" +
                        "               <ZPO_NUMBER>"+poNoStr+"</ZPO_NUMBER>\n" +// 采购订单编号
                        "               <!--Optional:-->\n" +
                        "               <ZPO_ITEM>"+rowId+ "</ZPO_ITEM>\n" +// 采购订单行号  ROW_ID 在SRM_PUR_ORDER_INFO中， 不在SRM_PUR_PURCHASE_ORDER 中   循环比对取值？
                        "               <!--Optional:-->\n" +
                        "               <MVT_IND></MVT_IND>\n" +
                        "               <!--Optional:-->\n" +
                        "               <COSTCENTER></COSTCENTER>\n" +
                        "               <!--Optional:-->\n" +
                        "               <BATCH></BATCH>\n" +
                        "               <!--Optional:-->\n" +
                        "               <SPEC_STOCK></SPEC_STOCK>\n" +
                        "               <!--Optional:-->\n" +
                        "               <VENDOR></VENDOR>\n" +
                        "               <!--Optional:-->\n" +
                        "               <CUSTOMER></CUSTOMER>\n" +
                        "               <!--Optional:-->\n" +
                        "               <MOVE_PLANT></MOVE_PLANT>\n" +
                        "               <!--Optional:-->\n" +
                        "               <MOVE_STLOC></MOVE_STLOC>\n" +
                        "               <!--Optional:-->\n" +
                        "               <MOVE_REAS></MOVE_REAS>\n" +
                        "               <!--Optional:-->\n" +
                        "               <GR_RCPT></GR_RCPT>\n" +
                        "               <!--Optional:-->\n" +
                        "               <RESERV_NO></RESERV_NO>\n" +
                        "               <!--Optional:-->\n" +
                        "               <RES_ITEM></RES_ITEM>\n" +
                        "               <!--Optional:-->\n" +
                        "               <WITHDRAWN></WITHDRAWN>\n" +
                        "               <!--Optional:-->\n" +
                        "               <DELIV_NUMB></DELIV_NUMB>\n" +
                        "               <!--Optional:-->\n" +
                        "               <DELIV_ITEM></DELIV_ITEM>\n" +
                        "               <!--Optional:-->\n" +
                        "               <MOVE_BATCH></MOVE_BATCH>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ORDERID></ORDERID>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ITEM_TEXT></ITEM_TEXT>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ZRES1></ZRES1>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ZRES2></ZRES2>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ZRES3></ZRES3>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ZRES4></ZRES4>\n" +
                        "               <!--Optional:-->\n" +
                        "               <ZRES5></ZRES5>\n" +
                        "            </BU_ITEM>\n");
            }
        }
    }
}