package com.ur.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ur.common.model.RedisMessageBO;
import com.ur.common.service.RedisMessageBOService;
import com.ur.fw.common.rest.CommonRestResponse;

@Controller
@RequestMapping(value = "")
public class RedisMessageBOController {
	
	@Autowired
	RedisMessageBOService redisMessageBOService;

	 @RequestMapping(value = "RedisMessage/getMsg/{redisKey}", method = RequestMethod.POST)
	 @ResponseBody
	 public CommonRestResponse getRedisMessage(HttpServletRequest httpRequest,@PathVariable String redisKey) {	
		 RedisMessageBO redisMessageBO=redisMessageBOService.getRedisMessageBOFromRedis(redisKey);
		 if(redisMessageBO!=null) {
			 return new CommonRestResponse(CommonRestResponse.SUCCESS_FLAG,"",redisMessageBO);
		 }
		 return new CommonRestResponse(CommonRestResponse.FAILED_FLAG,"查无数据",null);
	 }
}
