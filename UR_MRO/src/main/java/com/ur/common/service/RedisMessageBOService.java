package com.ur.common.service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ur.common.model.RedisMessageBO;

@Service
public class RedisMessageBOService {

	public static final String STATUS_BEGIN="begin"; //开始
	public static final String STATUS_DOING="doing"; //进行中
	public static final String STATUS_END="end"; //结束	
	
	public static final String PROGRESS_STATUS_SUCCESS="success";
	public static final String PROGRESS_STATUS_EXCEPTION="exception";

	
	  @Value("${spring.redis.redisKeyPrefix}")
	  private String redisKeyPrefix;
	  
	  @Autowired
	  private RedisTemplate<String,Object> redisTemplate;
	  
	  public void addRedis(String redisKey,Object value,long time) {
		  redisTemplate.opsForValue().set(redisKeyPrefix+"_"+redisKey, value,time,TimeUnit.SECONDS);
	  }
	  
	  public void addRedis(String redisKey,Object value) {
		  redisTemplate.opsForValue().set(redisKeyPrefix+"_"+redisKey, value,3600,TimeUnit.SECONDS);
	  }
	  
	  public boolean delRedis(String redisKey) {
		  boolean isDel = false;
		  try {
			  isDel = redisTemplate.delete(redisKeyPrefix+"_"+redisKey);
		  } catch (Exception e) {
			//System.err.println("====redis del "+redisKeyPrefix+"_"+redisKey+" error=:");
			e.printStackTrace();
		  }
		  
		  //System.err.println("======remove "+redisKeyPrefix+"_"+redisKey+" ==:" + isDel);
		  return isDel;
	  }
	  
	  public Object getFromRedis(String redisKey) {
		  return redisTemplate.opsForValue().get(redisKeyPrefix+"_"+redisKey);
	  }
	  
	  public void removeRedisCache() {
		  Set<String> keys = redisTemplate.keys("*SYS*");
		  
		  if(keys != null && keys.size() > 0) {
			  redisTemplate.delete(keys);
		  }
	  }
	  
	  public RedisMessageBO getRedisMessageBOFromRedis(String redisKey) {
		  return (RedisMessageBO)redisTemplate.opsForValue().get(redisKeyPrefix+"_"+redisKey);
	  }
	  
	  public void addRedisMsgBO(String redisKey,String status,String message,Integer percentage) {
		  RedisMessageBO redisMsgBO=new RedisMessageBO();
		  redisMsgBO.setStatus(status);
		  redisMsgBO.setMessage(message);
		  redisMsgBO.setPercentage(percentage);
		  this.addRedis(redisKey, redisMsgBO);		  
	  }
	  
	  public void addRedisMsgBO(String redisKey,String status,String message,Integer percentage,String progressStatus) {
		  RedisMessageBO redisMsgBO=new RedisMessageBO();
		  redisMsgBO.setStatus(status);
		  redisMsgBO.setMessage(message);
		  redisMsgBO.setPercentage(percentage);
		  redisMsgBO.setProgressStatus(progressStatus);
		  this.addRedis(redisKey, redisMsgBO);		  
	  }
	  
	  public void addBeginRedisMsgBO(String redisKey,String message,Integer percentage) {
		  RedisMessageBO redisMsgBO=new RedisMessageBO();
		  redisMsgBO.setStatus(STATUS_BEGIN);
		  redisMsgBO.setMessage(message);
		  redisMsgBO.setPercentage(percentage);
		  this.addRedis(redisKey, redisMsgBO);		  
	  }
	  
	  public void addDoingRedisMsgBO(String redisKey,String message,Integer percentage) {
		  RedisMessageBO redisMsgBO=new RedisMessageBO();
		  redisMsgBO.setStatus(STATUS_DOING);
		  redisMsgBO.setMessage(message);
		  redisMsgBO.setPercentage(percentage);
		  this.addRedis(redisKey, redisMsgBO);		  
	  }
	  
	  public void addEndRedisMsgBOBySuccess(String redisKey,String message) {
		  RedisMessageBO redisMsgBO=new RedisMessageBO();
		  redisMsgBO.setStatus(STATUS_END);
		  redisMsgBO.setMessage(message);
		  redisMsgBO.setPercentage(100);
		  redisMsgBO.setProgressStatus(PROGRESS_STATUS_SUCCESS);
		  this.addRedis(redisKey, redisMsgBO);		  
	  }
	  
	  public void addEndRedisMsgBOByException(String redisKey,String message) {
		  RedisMessageBO redisMsgBO=new RedisMessageBO();
		  redisMsgBO.setStatus(STATUS_END);
		  redisMsgBO.setMessage(message);
		  redisMsgBO.setPercentage(100);
		  redisMsgBO.setProgressStatus(PROGRESS_STATUS_EXCEPTION);
		  this.addRedis(redisKey, redisMsgBO);		  
	  }
	  
	  public boolean checkExistsAsync(String redisKey) {
		  boolean result=false;
		  RedisMessageBO redisMsgBO=this.getRedisMessageBOFromRedis(redisKey);
		  //存在未结束的进程
		  if(redisMsgBO!=null && !STATUS_END.equals(redisMsgBO.getStatus())) {			  
			  result=true;
		  }
		  return result;
	  }
	  
	  public String getRedisKey(String redisKeyPrefix,Integer year,Integer month,String serial) {
			return redisKeyPrefix+"_"+year+"_"+month+"_"+serial;
	  }
	  
	  public String getRedisKey(String redisKeyPrefix,Integer year,String season,Integer month,String serial) {
			return redisKeyPrefix+"_"+year+"_"+season+"_"+month+"_"+serial;
	  }
}
