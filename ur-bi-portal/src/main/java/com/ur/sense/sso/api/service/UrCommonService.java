package com.ur.sense.sso.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UrCommonService {

    @Autowired
    RestTemplate restTemplate;

    public String getUserInfoByLoginId(String loginId) {
        return restTemplate.getForObject("http://UR-INTERNAL-INTERFACE/eureka/admin/getUserInfoByLoginId?loginId="+loginId,String.class);
    }

    public String getMenuByLoginId(String loginId) {
        return restTemplate.getForObject("http://UR-COMMON/eureka/admin/getMenuByLoginId?loginId="+loginId,String.class);
    }

    public String getMenuByLoginIdAndRootCode(String loginId,String rootCode) {
        return restTemplate.getForObject("http://UR-COMMON/eureka/admin/getMenuByLoginIdAndRootCode?loginId="+loginId+"&rootCode="+rootCode,String.class);
    }

    public String getMenuByRootCode(String loginId,String rootCode) {
        return restTemplate.getForObject("http://UR-COMMON/eureka/admin/getMenuByRootCode?loginId="+loginId+"&rootCode="+rootCode,String.class);
    }
    public String getAllUserInfoMapByPose(String pose) {
        return restTemplate.getForObject("http://UR-COMMON/eureka/admin/getAllUserInfoMapByPose?pose="+pose,String.class);
    }
}