package com.ur.mro.oa.controller;

import com.ur.mro.oa.service.OAMaterialService;
import io.swagger.annotations.Api;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "")
@Api(description = "MaterialController的注释")
public class OAMaterialController {

    @Autowired
    OAMaterialService oAMaterialService;
    @RequestMapping(value = "/mat/getMatDataByCode/code={code}/lastUpdatedTime={lastUpdatedTime}", method = RequestMethod.GET, produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String getMatDataByCode(@PathVariable("code") String code,@PathVariable("lastUpdatedTime") String lastUpdatedTime){

        JSONArray jsonArray = oAMaterialService.getMaterialByCode(code,lastUpdatedTime);

        return jsonArray.toString();


    }
}
