package com.ur.mro.shop.service;

import java.text.SimpleDateFormat;
import java.util.*;


import java.util.stream.Collectors;

import com.ur.admin.user.mappers.SysUserInfoMapper;
import com.ur.admin.user.model.SysUserInfo;
import com.ur.admin.user.service.SysUserInfoService;
import com.ur.common.service.RedisMessageBOService;
import com.ur.mro.dic.service.DictionaryService;

import com.ur.mro.role.mappers.UserRoleInfoMapper;
import com.ur.mro.role.model.UserRoleInfo;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ur.common.model.Shop2OAConfig;
import com.ur.common.service.BaseService;
import com.ur.common.util.HttpClientUtil;
import com.ur.fw.common.page.PageBean;
import com.ur.fw.common.rest.CommonRestResponse;
import com.ur.fw.common.rest.CommonSearchCondition;
import com.ur.fw.common.rest.PagingRestResponse;
import com.ur.mro.contract.model.Contract;
import com.ur.mro.contract.service.ContractService;
import com.ur.mro.shop.mappers.Shop2GCMapper;
import com.ur.mro.shop.model.Shop2GC;
import com.ur.mro.shop.model.Shop2GCDTO;

import net.sf.json.JSONObject;


@Service
public class Shop2GCService extends BaseService {

    private final static  String   ACCESSKEY="accessKey";

    private  final static  String  ACCESSSECRET="accessSecret";

    private final static  int  num = 40;

    @Autowired
    Shop2GCMapper shop2GCMapper;

    @Autowired
    ContractService contractService;

    @Autowired
    Shop2OAConfig  shop2OAConfig;

    @Autowired
    DictionaryService dictionaryService;


    @Autowired
    RedisMessageBOService redisService;

    @Autowired
    SysUserInfoMapper sysUserInfoMapper;

   @Autowired
    UserRoleInfoMapper userRoleInfoMapper;


    public Shop2GC getShop2GCByPK(Integer pkId) {
        return shop2GCMapper.getShop2GCByPK(pkId);
    }

    @Transactional
    public Integer save(Shop2GC shop2GC) {
        
        //TODO handle date columns here
         Integer id=InsertOrUpdateShopInfo(shop2GC,0);
         InsertOrUpdateContactInfo(id,shop2GC.getInfoContactInformationList(),0);

        return id;
    }

    public   int   checkDataMaster(Shop2GC shop2GC){
        if(shop2GC.getId()!=null)
            return 0;
        String code=shop2GC.getCode();
        String name=shop2GC.getName();
        return shop2GCMapper.checkData(code,name);
    }

    public   int   checkDataDetail(List<Contract> contracts) {
        if (contracts == null || contracts.size() == 0)
            return 0;
        Map<String, Object> maps = Maps.newHashMap();
        for (Contract contract : contracts) {
            if (maps.get(contract.getContacts()) == null) {
                maps.put(contract.getContacts().trim(), contract.getPosition().trim());
            } else {
                if (maps.get(contract.getContacts().trim()).toString().equals(contract.getPosition().trim())) {
                    return 1;
                }

            }
        }
            return 0;
    }

    @Transactional
    public void  delete(List<Shop2GC> shop2GCList) {

        //TODO handle date columns here
        for(Shop2GC shop2GC :shop2GCList){
            Integer id=InsertOrUpdateShopInfo(shop2GC,1);
            InsertOrUpdateContactInfo(id,shop2GC.getInfoContactInformationList(),1);
        }

    }


    /**
     * 插入更新主表数据
     * @param shop2GC
     */
    private Integer InsertOrUpdateShopInfo(Shop2GC shop2GC,int deleted){

        if(shop2GC.getId()==null){
            shop2GC.setDeleted(deleted);
            super.setCreateFields(shop2GC);
            super.setUpdateFields(shop2GC);
            shop2GCMapper.insertShop2GC(shop2GC);
        }
        else{
            shop2GC.setDeleted(deleted);
            super.setUpdateFields(shop2GC);
            shop2GCMapper.updateShop2GCByPKSelective(shop2GC);
        }
        return shop2GC.getId();
    }
    /**
     * 更新或者插入细表数据
     * @param lists
     */
    private  void InsertOrUpdateContactInfo(Integer id,List<Contract> lists,int deleted){
        List<Contract> contractLists= Lists.newArrayList();
        List<Contract> updateContractlists= Lists.newArrayList();
       if(lists==null||lists.isEmpty())
            return ;

           for(Contract en :lists){
                 en.setDeleted(deleted);
                 en.setSrmShop2gcInfoId(id);
               if(en.getIsDefaults()!=null)
                   en.setIsDefault(String.valueOf(en.getIsDefaults()));
               else
                   en.setIsDefault("false");
                 super.setUpdateFields(en);
               if(en.getId()==null){
                   super.setCreateFields(en);
                   contractLists.add(en);
               }
               else{
                   updateContractlists.add(en);
                  // contractService.updateContractByPKSelective(en);
               }
           }
           if(contractLists!=null&&contractLists.size()!=0)
               contractService.insertBatchContract(contractLists);
           if(updateContractlists!=null&&updateContractlists.size()>0)
                  contractService.updateBatchContract(updateContractlists);

    }

    @Transactional
    public int updateShop2GCByPKSelective(Shop2GC shop2GC) {
        
        //TODO handle date columns here
        
        int result = shop2GCMapper.updateShop2GCByPKSelective(shop2GC);
        return result;
    }

    public PagingRestResponse searchShop2GC(List<String> selectFields, List<CommonSearchCondition> condList, List<String> orderByList, PageBean pageBean) {
        
        int totalRecordNum = shop2GCMapper.searchShop2GCCount(condList);
        //set totalRecordNum to pageBean to calculate pageCount
        pageBean.init(pageBean.getCurPageNum(), pageBean.getPerPageSize(), totalRecordNum);

        List<Shop2GC> resultList = null;
        if(totalRecordNum>0){
            resultList = shop2GCMapper.searchShop2GC(selectFields, condList, orderByList, pageBean);
        }

        return new PagingRestResponse(CommonRestResponse.SUCCESS_FLAG,CommonRestResponse.SUCCESS_MESSAGE,resultList,pageBean);
    }

     //  同步oa
     @Transactional
      public void  synchroShopInfo(List<Shop2GC> shop2GCList)throws Exception{

          String json = "{\"accessKey\":\""+shop2OAConfig.getAccessKey()+"\",\"accessSecret\":\""+shop2OAConfig.getAccessSecret()+"\"}";

          String   result=null;
          JSONObject jsonObject=null;
           redisService.delRedis("accessToken");
          String accessToken =(String)redisService.getFromRedis("accessToken");
          if(accessToken==null){
                 result= HttpClientUtil.doPost(shop2OAConfig.getTokenUrl(),json);
              if(result==null){
                  throw new Exception("请求失败，请重新操纵!");
              }
               jsonObject=JSONObject.fromObject(result);
              if(!jsonObject.get("errcode").equals("OK")){
                  throw new Exception("请求失败，请重新操纵!");
              }
              accessToken=jsonObject.get("accesstoken").toString();
              redisService.addRedis("accessToken",accessToken,60*2);
          }

         ///   System.out.println("token="+accessToken);
            String  code="";
           if(shop2GCList==null||shop2GCList.size()==0){       // 不勾选的情况为All,更新所有数据
                code="ALL";
           }
           else{     // 勾选的情况
             for(Shop2GC shop2GC:shop2GCList){
                 if(shop2GC.getCode()==null)
                     continue;
                  code=code+shop2GC.getCode()+",";
             }
              if(!code.equals(""))
                    code=code.substring(0,code.length()-1);
           }

            json = "{\"code\":\""+code+"\",\"accessToken\":\""+accessToken+"\"}";
             result= HttpClientUtil.doPost(shop2OAConfig.getStoreInfoUrl(),json);

          if(result==null){
              throw new Exception("请求失败，请重新操纵!");
          }
             jsonObject=JSONObject.fromObject(result);
          if(!jsonObject.get("errcode").equals("OK")){
                  throw new Exception(jsonObject.get("errmsg").toString());
          }

          ObjectMapper  mapper=new ObjectMapper();
          JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Shop2GCDTO.class);
          List<Shop2GCDTO> list =  (List<Shop2GCDTO>)mapper.readValue(jsonObject.get("data").toString(), javaType);


             change(list);

     }

    private  void  change(List<Shop2GCDTO> shop2GCDTOList)throws  Exception{

         List<Contract> insertContractList=Lists.newArrayList();
         List<Contract> updateContractList=Lists.newArrayList();
         List<Shop2GC>  updateShop2GCList=Lists.newArrayList();
         List<SysUserInfo> sysUserList=Lists.newArrayList();
         List<UserRoleInfo> roleInfoList=Lists.newArrayList();

    try{
        List<Shop2GC> shopsList=shop2GCMapper.getMasterIdByNameAndCode(shop2GCDTOList);
        if(shopsList==null)
              shop2GCDTOList=Lists.newArrayList();

        for(Shop2GCDTO shop2GCDTO:shop2GCDTOList){

            Shop2GC  shop2GC= addShopValue(shop2GCDTO);
            Contract  contract=addContractValue(shop2GCDTO);

              List<Integer> shopIds=shopsList.stream().filter(s->s.getCode().equals(shop2GC.getCode()))
                                                      .map(Shop2GC::getId).collect(Collectors.toList());
                if(shopIds!=null&&shopIds.size()>0){

                    this.setUpdateFields(shop2GC);
                    shop2GC.setDeleted(0);
                    for(Integer shopId:shopIds){

                        shop2GC.setId(shopId);
                        super.setUpdateFields(shop2GC);

                      //  updateShop2GCByPKSelective(shop2GC);
                         updateShop2GCList.add(shop2GC);
                        if(contractService.checkData(shop2GCDTO.getStoremanagercode(),shopId)>0){

                            contractService.setUpdateFields(contract);
                            contract.setSrmShop2gcInfoId(shopId);
                            contract.setDeleted(0);

                            updateContractList.add(contract);
                          //  contractService.updateContractByCodeAndShopId(contract);

                        }else{ //  contractService.deleteContractByPKSelective(contract);
                            contractService.setUpdateFields(contract);
                            contractService.setUpdateFields(contract);
                            contract.setSrmShop2gcInfoId(shopId);
                            contract.setDeleted(0);
                            contract.setCreatedBy(contract.getLastUpdatedBy());
                            contract.setCreatedTime(new Date());


                            insertContractList.add(contract);
                        }
                    }

                }
                else{

                    //插入
                    this.setCreateFields(shop2GC);
                    this.setUpdateFields(shop2GC);

                    shop2GC.setCreatedBy(shop2GC.getLastUpdatedBy());
                    shop2GC.setCreatedTime(new Date());

                    shop2GCMapper.insertShop2GC(shop2GC);
                    int id=shop2GC.getId();
                    contractService.setCreateFields(contract);

                    contractService.setUpdateFields(contract);


                    contract.setSrmShop2gcInfoId(id);
                    contract.setCreatedBy(contract.getLastUpdatedBy());
                    contract.setCreatedTime(new Date());

                      insertContractList.add(contract);
                }
                    createShopAcount(shop2GC, roleInfoList);
            }
          if(updateShop2GCList!=null&&updateShop2GCList.size()>0){
              if(updateShop2GCList.size()>num){
                  int sum=updateShop2GCList.size();
                  int size=sum/num+1;
                  for(int i=0;i<size;i++){
                      int total=(i+1)*num>sum?sum:(i+1)*num;
                      List<Shop2GC> list=updateShop2GCList.subList(i*num,total);
                      if(list!=null&&list.size()>0)
                      shop2GCMapper.updateBatchShop2GC(list);
                  }
              }else{
                  shop2GCMapper.updateBatchShop2GC(updateShop2GCList);
              }
          }

          if(insertContractList!=null&&insertContractList.size()>0){
              if(insertContractList.size()>num){
                  int sum=insertContractList.size();
                  int size=sum/num+1;
                  for(int i=0;i<size;i++){
                      int total=(i+1)*num>sum?sum:(i+1)*num;
                      List<Contract> list=insertContractList.subList(i*num,total);
                      if(list!=null&&list.size()>0)
                      contractService.insertBatchContract(list);
                  }
              }else{
                  contractService.insertBatchContract(insertContractList);
              }
          }

          if(updateContractList!=null&&updateContractList.size()>0){
            if(updateContractList.size()>num){
                int sum=insertContractList.size();
                int size=sum/num+1;
                for(int i=0;i<size;i++){
                    int total=(i+1)*num>sum?sum:(i+1)*num;
                    List<Contract> list=insertContractList.subList(i*num,total);
                    if(list!=null&&list.size()>0)
                        contractService.updateBatchContract(list);
                }

            }else{
                contractService.updateBatchContract(updateContractList);
            }
        }

        if(roleInfoList!=null&&roleInfoList.size()>0){
            if(roleInfoList.size()>num){
                int sum=roleInfoList.size();
                int size=sum/num+1;
                for(int i=0;i<size;i++){
                    int total=(i+1)*num>sum?sum:(i+1)*num;
                    List<UserRoleInfo> list=roleInfoList.subList(i*num,total);
                    if(list!=null&&list.size()>0)
                       userRoleInfoMapper.insertBatchUserRoleInfo(list);
                }

            }else{
                userRoleInfoMapper.insertBatchUserRoleInfo(roleInfoList);
            }
        }

        }catch (Exception e){
            throw new Exception("数据出现错误,同步失败!");
        }
    }


    //主表数据赋值
     private   Shop2GC   addShopValue(Shop2GCDTO shop2GCDTO)throws  Exception{

         Map<String,String>  brandType=(Map<String,String>)redisService.getFromRedis("GC_brand");
         Map<String,String> imageType=(Map<String,String>)redisService.getFromRedis("GC_shopImage");
         if(brandType==null){
             brandType=dictionaryService.getMapBySgroup("GC_brand");
                redisService.addRedis("GC_brand",brandType);
         }
         if(imageType==null){
             imageType=dictionaryService.getMapBySgroup("GC_shopImage");
             redisService.addRedis("GC_shopImage",imageType);
         }

         SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

         Shop2GC  shop2GC=new Shop2GC();
         shop2GC.setAddress(shop2GCDTO.getAddress());
         shop2GC.setIsStreetShop(shop2GCDTO.getIsstreetstore());
         shop2GC.setName(shop2GCDTO.getStorename());
         shop2GC.setCode(shop2GCDTO.getStoreid());
         shop2GC.setCity(shop2GCDTO.getCitycode());
         shop2GC.setProvince(shop2GCDTO.getProvincecode());

         shop2GC.setContractArea(shop2GCDTO.getSalesarea());
         shop2GC.setCountry(shop2GCDTO.getConntrycode());

         shop2GC.setRegion(shop2GCDTO.getRegincode());
         shop2GC.setSalesLevel(shop2GCDTO.getCg_storelevel());

         String imgae=shop2GCDTO.getCg_imagelevel();

         if(imgae!=null){
             for(Map.Entry<String,String> entry:imageType.entrySet()){
                 if(imgae.equals(entry.getValue())
                         ||imgae.replaceAll("-","").equals(entry.getValue())){
                     shop2GC.setImageLevel(entry.getKey());
                     break;
                 }

             }
         }


         shop2GC.setIsCrossLayer(shop2GCDTO.getCg_isoverfloor());
         shop2GC.setType(shop2GCDTO.getCg_property());
         shop2GC.setDeleted(0);
         shop2GC.setIsCrossLayer(shop2GCDTO.getCg_isoverfloor());

         String  brand=shop2GCDTO.getBrand();

         if(brand!=null){
             for(Map.Entry<String,String> entry:brandType.entrySet()){
                 if(brand.equals(entry.getValue())){
                     shop2GC.setBrandType(entry.getKey());
                      break;
                 }

             }
         }

         String type=null;
         if("直营".equals(shop2GCDTO.getProperty().trim()))
             type="1";
         else if("加盟".equals(shop2GCDTO.getProperty().trim()))
             type="2";


          shop2GC.setType(type);
          System.out.println("opendate="+shop2GCDTO.getOpendate());

          if(shop2GCDTO.getOpendate()!=null&&shop2GCDTO.getOpendate()!="")
           shop2GC.setExpectedOpenTime(dateFormat.parse(shop2GCDTO.getOpendate()));

          String isStreetStore=null;
          if("是".equals(shop2GCDTO.getIsstreetstore()))
              isStreetStore="1";
          if("否".equals(shop2GCDTO.getIsstreetstore()))
              isStreetStore="2";
          shop2GC.setIsStreetShop(isStreetStore);

          String isoutrant=null;
         if("是".equals(shop2GCDTO.getIsoutrant()))
             isoutrant="1";
         if("否".equals(shop2GCDTO.getIsoutrant())||"无".equals(shop2GCDTO.getIsoutrant()))
             isoutrant="2";

         shop2GC.setOutsideHouse(isoutrant);
         shop2GC.setRegion(shop2GCDTO.getRegincode());
         shop2GC.setArea(shop2GCDTO.getAreacode());
         shop2GC.setInvoiceHead(shop2GCDTO.getTickethead());


         return shop2GC;
     }



     //细表数据赋值
     private Contract  addContractValue(Shop2GCDTO shop2GCDTO){

         Contract contract=new Contract();
         contract.setPosition("1");
         contract.setCode(shop2GCDTO.getStoremanagercode());
         contract.setContacts(shop2GCDTO.getStoremanager());
         contract.setMobilephone(shop2GCDTO.getStoremanagertel());
         contract.setTelephone(shop2GCDTO.getStoretel());
         contract.setZipCode(shop2GCDTO.getStoreemail());
         contract.setDeleted(0);
         contract.setIsDefault("false");

         return  contract;
     }

    private void createShopAcount(Shop2GC info,
                                                 List<UserRoleInfo> roleInfoList) { // 创建店铺账号
        int c=sysUserInfoMapper.findUsername(info.getCode());
        System.out.println("c="+c);
        if (c == 0) {
            SysUserInfo user = new SysUserInfo();
            user.setLoginName(info.getCode());
            user.setJobNumber(info.getCode());
            user.setName(info.getName());
            user.setStatus(0);
            user.setPassword("e10adc3949ba59abbe56e057f20f883e");
            sysUserInfoMapper.insertSysUserInfo(user);
            //  sysUserList.add(user);
              Integer userId =user.getId();

          //  String date = DateFormatUtils.format(new java.util.Date(),"yyyy-MM-dd HH:mm:ss.SSS");
            List<UserRoleInfo> userRoleList = userRoleInfoMapper.findUsername("URCN0123");
            for (int i = 0; i < userRoleList.size(); i++) {
                 UserRoleInfo u=new UserRoleInfo();
                 if(user.getLoginName()==null)
                     continue;
                 u.setUserName(user.getLoginName());
                 u.setRoleId(userRoleList.get(i).getRoleId());
                 u.setCreatedBy("user");
                 u.setCreatedTime(new Date());
                 u.setLastUpdatedBy("user");
                 u.setLastUpdatedTime(new Date());
                 roleInfoList.add(u);
            }
        }
    }

     public  List<Shop2GC> findByStoreId(String code){
              return shop2GCMapper.findByStoreId(code);
    }
}