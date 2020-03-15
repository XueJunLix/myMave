package com.ur.eureka.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import com.alibaba.druid.util.StringUtils;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.ur.common.service.UserInfoService;
import com.ur.eureka.model.AdminUserInfoBO;
import com.ur.eureka.model.SCMDictionaryBO;
import com.ur.fw.common.rest.CommonSearchCondition;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class EurekaDiscoveryService {
	private static final Logger logger = LoggerFactory.getLogger(EurekaDiscoveryService.class);

	@Autowired
    RestTemplate restTemplate;
	@Autowired
	UserInfoService userInfoService;
	
	private String getUserInfoByLoginIdUri="http://UR-COMMON/eureka/admin/getUserInfoByLoginId?loginId={loginId}";
	
	public AdminUserInfoBO getUserInfoByLoginId(String loginId) {
		AdminUserInfoBO adminUserInfoBO = null;
		if(StringUtils.isEmpty(loginId)) {
			return null;
		}
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("loginId", loginId);
		String resultData= restTemplate.getForObject(this.getUserInfoByLoginIdUri,String.class,paramMap);
		logger.debug("=============getUserInfoByLoginId:"+resultData);
		JSONObject obj = JSONObject.fromObject(resultData);
		if("success".equals(obj.get("message"))) {
			JSONObject dataObj = JSONObject.fromObject(obj.get("data"));
			adminUserInfoBO=new AdminUserInfoBO(); 
			adminUserInfoBO.setUserId(dataObj.getInt("userId"));
			adminUserInfoBO.setLoginId(dataObj.getString("loginId"));
			adminUserInfoBO.setLoginPassword(dataObj.getString("loginPassword"));
			adminUserInfoBO.setAdminUserName(dataObj.getString("adminUserName"));
			adminUserInfoBO.setAdminUserType(dataObj.getInt("adminUserType"));
			adminUserInfoBO.setAdminUserPose(dataObj.getString("adminUserPose"));
			adminUserInfoBO.setAdminUserDepartment(dataObj.getString("adminUserDepartment"));
			adminUserInfoBO.setAdminUserCompany(dataObj.getString("adminUserCompany"));
			adminUserInfoBO.setAdminUserTelephone(dataObj.getString("adminUserTelephone"));
			adminUserInfoBO.setAdminUserMobile(dataObj.getString("adminUserMobile"));
			adminUserInfoBO.setAdminUserEmail(dataObj.getString("adminUserEmail"));
			adminUserInfoBO.setStatus(dataObj.getInt("status"));
			adminUserInfoBO.setMemo(dataObj.getString("memo"));
			adminUserInfoBO.setAdminUserCode(dataObj.getString("adminUserCode"));
			adminUserInfoBO.setAdminShopCode(dataObj.getString("adminShopCode"));
			//return (AdminUserInfoBO)JSONObject.toBean(dataObj,AdminUserInfoBO.class);			
		}
		return adminUserInfoBO;
	}
	
	public Map<String, String> getAllUserMap() {
		long startTime = System.currentTimeMillis();
		Map<String, String> resultMap = new HashMap<>();
		String url="http://UR-COMMON/eureka/admin/getAllUserInfoMapByStatus?status=all";
		String resultData= restTemplate.getForObject(url,String.class);
		//logger.debug("=============getAllUserInfoMap:"+resultData);
		JSONObject obj = JSONObject.fromObject(resultData);
		if("success".equals(obj.get("message"))) {
			JSONObject dataObj = JSONObject.fromObject(obj.get("data"));
			resultMap = JSONObject.fromObject(dataObj);
		}
		logger.debug("getAllUserInfoMap user time:"+(System.currentTimeMillis()-startTime));
		return resultMap;
	}
	
	public Map<String, String> getYearAndWeekMap(){
		long startTime = System.currentTimeMillis();
		Map<String, String> resultMap = new HashMap<>();
		String url="http://UR-COMMON/eureka/impalaCommon/getYearAndWeek";
		String resultData= restTemplate.getForObject(url,String.class);
		logger.debug("=============getYearAndWeekMap:"+resultData);
		JSONObject obj = JSONObject.fromObject(resultData);
		if("success".equals(obj.get("message"))) {
			JSONObject dataObj = JSONObject.fromObject(obj.get("data"));
			resultMap = JSONObject.fromObject(dataObj);
		}
		logger.debug("getYearAndWeekMap user time:"+(System.currentTimeMillis()-startTime));
		return resultMap;
	}
	/**
	 * 根据字典组获取SCM字典表的key/value值map(启用的、默认中文)
	 * @param sgroup
	 * @return
	 */
	public Map<String, String> getActiveSCMDictionaryKeyValueMap(String sgroup) {
		return this.getActiveSCMDictionaryKeyValueMap(sgroup, null);
	}
	/**
	 * 根据字典组、语言（1：中文、2：英文、3：泰文）获取SCM字典表的key/value值map(启用的、中文)
	 * @param sgroup
	 * @return
	 */
	public Map<String, String> getActiveSCMDictionaryKeyValueMap(String sgroup, String language) {
		long startTime = System.currentTimeMillis();
		String url="http://UR-COMMON/eureka/Dictionary/getActiveMapBySgroup?sgroup={sgroup}&language={language}";
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("sgroup", sgroup);
		paramMap.put("language", language);
		String  dictionaryInto= restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(dictionaryInto);
        if("success".equals(obj.get("message"))) {
        	JSONObject dataObj = new JSONObject().fromObject(obj.get("data"));
        	resultMap = JSONObject.fromObject(dataObj);
        }
		logger.debug("getSCMDictionaryKeyValueMap["+sgroup+"] user time:"+(System.currentTimeMillis()-startTime));
        return resultMap;
	}
	
	/**
	 * 根据字典组获取SCM字典表的value-key值map(启用的、默认中文)
	 * @param sgroup
	 * @return
	 */
	public Map<String, String> getActiveSCMDictionaryValueKeyMap(String sgroup) {
		Map<String, String> keyValueMap = this.getActiveSCMDictionaryKeyValueMap(sgroup, null);
		Map<String, String> valueKeyMap = new HashMap<String, String>();
		for(Map.Entry<String, String> map:keyValueMap.entrySet()) {
			valueKeyMap.put(map.getValue(), map.getKey());
		}
		return valueKeyMap;
	}
	
	/**
	 * 根据字典组获取SCM字典表列表(启用的、默认中文)
	 * @param sgroup
	 * @return
	 */
	public List<SCMDictionaryBO> getActiveSCMDictionaryBOs(String sgroup) {
		return this.getSCMDictionaryBOs(sgroup, "1");
	}
	
	/**
	 * 根据字典组、语言（1：中文、2：英文、3：泰文）获取SCM字典表列表(启用的)
	 * @param sgroup
	 * @param language
	 * @return
	 */
	public List<SCMDictionaryBO> getSCMDictionaryBOs(String sgroup, String language) {
		long startTime = System.currentTimeMillis();
		String url="http://UR-COMMON/eureka/Dictionary/getActiveSCMDictionarysBySgroup?sgroup={sgroup}&language={language}";
		List<SCMDictionaryBO> resultList = new ArrayList<>();
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("sgroup", sgroup);
		paramMap.put("language", language);
		String  dictionaryInto= restTemplate.getForObject(url,String.class,paramMap);
		
		JSONObject obj = new JSONObject().fromObject(dictionaryInto);
        if("success".equals(obj.get("message"))) {
        	JSONArray jsonArray = obj.getJSONArray("data");
        	for(int i=0; i<jsonArray.size(); i++){
        		String itemStr = jsonArray.get(i).toString();
        		JSONObject itemObject = JSONObject.fromObject(itemStr);
        		SCMDictionaryBO dictionaryBO = (SCMDictionaryBO)JSONObject.toBean(itemObject,SCMDictionaryBO.class);
        		resultList.add(dictionaryBO);
        	}
        }
		logger.debug("getSCMDictionaryBOs["+sgroup+"] user time:"+(System.currentTimeMillis()-startTime));
        return resultList;
   	}
	
	public Map<String,String> searchLanguagesByCode(String code){
		String language="1";
		long startTime = System.currentTimeMillis();
		String url="http://UR-COMMON/eureka/Dictionary/searchLanguagesByCode?code={code}&language={language}";
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("code", code);
		paramMap.put("language",language);
		String  dictionaryInto= restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(dictionaryInto);
        if("success".equals(obj.get("message"))) {
        	JSONObject dataObj = new JSONObject().fromObject(obj.get("data"));
        	resultMap = JSONObject.fromObject(dataObj);
        }
		logger.debug("getSCMDictionaryKeyValueMap["+code+"] user time:"+(System.currentTimeMillis()-startTime));
        return resultMap;
	}

	//查询是否有按钮操作权限
	public String checkUserPrivilege(String loginId, String privilegeCode) {
		long startTime = System.currentTimeMillis();
		String url="http://UR-COMMON/eureka/admin/checkUserPrivilege?loginId={loginId}&privilegeCode={privilegeCode}";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("loginId", loginId);
		paramMap.put("privilegeCode", privilegeCode);
		String data = restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(data);
		logger.debug("checkUserPrivilege["+loginId+"_"+privilegeCode+"] user time:"+(System.currentTimeMillis()-startTime));
        if("success".equals(obj.get("message"))) {
        	String result = (String) obj.get("data");
        	logger.debug(result);
        	return result;
        }
        return null;
	}
	//查询是否有按钮操作权限,放到model中
	public void putButtonPrivilegeToModel(Model model, String attributeName, String privilegeCode) {
		String loginId = userInfoService.getCurrentLoginUserName();
		String result = this.checkUserPrivilege(loginId, privilegeCode);
		if(Objects.equal(result, "1")) {
        	model.addAttribute(attributeName, true);
    	}else {
        	model.addAttribute(attributeName, false);
    	}
	}
	//查询是否有按钮操作权限,放到model中
	public void putButtonPrivilegeToModel(Model model, List<String> attributeNames, List<String> privilegeCodes) {
		String loginId = userInfoService.getCurrentLoginUserName();
		String result = this.checkUserPrivilege(loginId, String.join(",", privilegeCodes));
		if(StringUtils.isEmpty(result)) {
			for(int i=0;i<attributeNames.size();i++) {
	        	model.addAttribute(attributeNames.get(i), false);
			}
		}else {
			List<String> resultArr = Arrays.asList(result.split(","));
			for(int i=0;i<attributeNames.size();i++) {
				if(Objects.equal(resultArr.get(i), "1")) {
		        	model.addAttribute(attributeNames.get(i), true);
		    	}else {
		        	model.addAttribute(attributeNames.get(i), false);
		    	}
			}
		}
	}
	
	

	/**
	 * 根据字典组获取SCM字典表Map(启用的、默认中文) 父级key_子级value_子级key（例：由于获取风格/中品类信息）
	 * @param sgroup
	 * @return
	 */
	public Map<String, Map<String, String>> getParentKeyDictValueKey(String sgroup){
		List<SCMDictionaryBO> list = this.getActiveSCMDictionaryBOs(sgroup);
		Map<String, Map<String, String>> parentKeyMap = new HashMap<>();
		for(SCMDictionaryBO bean:list) {
			String parentKey = bean.getParentKey();
			if(!StringUtils.isEmpty(parentKey)) {
				if(parentKeyMap.containsKey(parentKey)) {
					Map<String, String> map = parentKeyMap.get(parentKey);
					map.put(bean.getSvalue(), bean.getSkey());
				}else {
					Map<String, String> map = new HashMap<>();
					map.put(bean.getSvalue(), bean.getSkey());
					parentKeyMap.put(parentKey, map);
				}
			}
		}
		return parentKeyMap;
	}
	
	
	public Map<Integer,String> getAllRoleInfoMapByStatus(String status){
		Map<Integer,String> resultMap=new HashMap<>();
		String url="http://UR-COMMON/eureka/admin/getAllRoleInfoMapByStatus?status={status}";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("status", status);
		String data = restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(data);
        if("success".equals(obj.get("message"))) {
        	JSONObject dataObj = new JSONObject().fromObject(obj.get("data"));
        	resultMap = JSONObject.fromObject(dataObj);
        }
		return resultMap;
	}
	
	public HashSet<Integer> getRoleSetByUserId(String loginId){
		HashSet<Integer> resultSet=new HashSet<>();
		String url="http://UR-COMMON/eureka/admin/getRoleSetByUserId?loginId={loginId}";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("loginId", loginId);
		String data = restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(data);
        if("success".equals(obj.get("message"))) {
        	JSONArray jsonArray = obj.getJSONArray("data");
        	for(int i=0; i<jsonArray.size(); i++){
        		resultSet.add(new Integer(jsonArray.get(i).toString()));
        	}
        }
        return resultSet;
	}
	
	public Map<String,String> searchLanguagesByCode(String code,String language){
		long startTime = System.currentTimeMillis();
		String url="http://UR-COMMON/eureka/Dictionary/searchLanguagesByCode?code={code}&language={language}";
		Map<String, String> resultMap = new HashMap<>();
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("code", code);
		paramMap.put("language",language);
		String  dictionaryInto= restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(dictionaryInto);
        if("success".equals(obj.get("message"))) {
        	JSONObject dataObj = new JSONObject().fromObject(obj.get("data"));
        	resultMap = JSONObject.fromObject(dataObj);
        }
		logger.debug("getSCMDictionaryKeyValueMap["+code+"] user time:"+(System.currentTimeMillis()-startTime));
        return resultMap;
	}
	
	/**
	 * 通过用户名获取用户loginId(多个)
	 * @param userName
	 * @return
	 */
	public List<String> getLoginIdByLoginName(String userName){
		List<String> resultList=new ArrayList<>();
		String url="http://UR-COMMON/eureka/admin/getLoginIdListByLoginUserName?userName={userName}";
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("userName", userName);
		String data = restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = new JSONObject().fromObject(data);
        if("success".equals(obj.get("message"))) {
        	JSONArray jsonArray = obj.getJSONArray("data");
        	for(int i=0; i<jsonArray.size(); i++){
        		resultList.add(jsonArray.get(i).toString());
        	}
        }
        return resultList;
	}
	
	/**
	 * 填充用户名loginId查询条件（界面传的是用户名）
	 * @param condition
	 * @return
	 */
	public void paddingLoginId(CommonSearchCondition condition) {
		String userName = condition.getValue();
		if(!StringUtils.isEmpty(userName)) {
			List<String> loginIds = this.getLoginIdByLoginName(userName);
			if(loginIds!=null) {
				if(loginIds.size()==1) {
					condition.setOperator("eq");
					condition.setValue(loginIds.get(0));
				}else {
					condition.setOperator("in");
					condition.setValue(Joiner.on(",").join(loginIds));
				}
			}
		}
	}

	public Map<String,String> getUserNameMapByLoginIds(List<String> loginIds){
		Map<String, String> resultMap = new HashMap<>();
		String url="http://UR-INTERNAL-INTERFACE/eureka//admin/getAdminUserNameMapByLoginIds";
		Map<String, String> paramMap = new HashMap<>();
		if(loginIds!=null && loginIds.size()>0){
			paramMap.put("loginIds",String.join(",",loginIds));
		}
		String resultData= restTemplate.getForObject(url,String.class,paramMap);
		JSONObject obj = JSONObject.fromObject(resultData);
		if("success".equals(obj.get("message"))) {
			JSONObject dataObj = JSONObject.fromObject(obj.get("data"));
			resultMap = JSONObject.fromObject(dataObj);
		}
		return resultMap;
	}
	
}
