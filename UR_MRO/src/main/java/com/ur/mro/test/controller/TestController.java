package com.ur.mro.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "test")
@Api(description = "MaterialController的注释")
public class TestController {
    @RequestMapping(value="Material",method = RequestMethod.GET)
    @ApiOperation(value = "Material默认页面模板", notes = "Material默认页面模板")
    public String MaterialTemplate() {
        return "mro/mat/WLguanli";
    }
}
