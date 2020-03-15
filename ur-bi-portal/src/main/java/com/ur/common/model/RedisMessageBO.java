package com.ur.common.model;

import lombok.Data;

@Data
public class RedisMessageBO {
	
    private String status;
	
	private String message;
	
	private Integer percentage;
	
	private String progressStatus="";
}
