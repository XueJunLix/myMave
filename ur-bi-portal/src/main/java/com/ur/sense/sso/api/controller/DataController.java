package com.ur.sense.sso.api.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ur.sense.sso.api.service.UrCommonService;
import com.ur.sense.sso.common.bean.MenuBean;
import com.ur.sense.sso.common.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
@Slf4j
public class DataController {

	@Autowired
    UrCommonService urCommonService;

	/**
	 * 微信端通过userid获取菜单列表
	 * @param request
	 * @return
	 */
	@CrossOrigin
	@RequestMapping("/WeiXin/getMenuList")
	public Object menuList(HttpServletRequest request, Model model) {

		log.info("getMenuList from WeiXin Page");
		// 返回的菜单列表结果
		List<MenuBean> MENU_LIST = new ArrayList<MenuBean>();
		try {
			String userId = request.getParameter("userId");
			log.info("userId -->" + userId);
			if ("".equals(userId) || null == userId) {
				log.info("userId is null return null");
				return null;
			}

			String rootCode = PropertiesUtil.getProperty("URRootCode");
			String jsonStr = urCommonService.getMenuByLoginIdAndRootCode(userId, rootCode);
			JSONObject jobj = JSONObject.parseObject(jsonStr);
			analysisJson(MENU_LIST, jobj.get("data"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return MENU_LIST;
	}

	/**
	 * 递归解析json
	 * @param MENU_LIST
	 * @param objJson
	 */
	public void analysisJson(List<MenuBean> MENU_LIST, Object objJson) {
		JSONObject dataJson = (JSONObject) objJson;
		MenuBean mb = null;
		if (null != dataJson) {
			Object tmp1Json = dataJson.get("children");
			if (tmp1Json instanceof JSONArray) {
				JSONArray objArray = (JSONArray) tmp1Json;
				if (objArray.size() > 0) {
					for (int i = 0; i < objArray.size(); i++) {
						analysisJson(MENU_LIST, objArray.get(i));
					}
				}
				String menuType = dataJson.getString("menuType");
				String displayType = dataJson.getString("displayType");
				// 判断是否为菜单链接 (可以增加判断,是否为菜单或者是否为手机端独享菜单列表)
				if ("2".equals(menuType) && "MOBILE".equals(displayType)) {
					mb = new MenuBean();
					mb.setName(dataJson.getString("menuName"));
					mb.setUrl(dataJson.getString("menuUrl"));
					mb.setEnName(dataJson.getString("menuEnglishName"));
					MENU_LIST.add(mb);
				}
			}
		}
	}
    

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getMenuByRootCode")
	public String getMenuByRootCode(@RequestParam String auth) {
		String jsonStr = "";
		if (!"".equals(auth) && null != auth && auth.equals(PropertiesUtil.getProperty("RANDOMCODE"))) {
			String rootCode = PropertiesUtil.getProperty("URRootCode");
			jsonStr = urCommonService.getMenuByRootCode("", rootCode);
		}
		return jsonStr;
	}
}
