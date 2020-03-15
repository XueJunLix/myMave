package com.ur.mro.SHtest.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="SHtest",method = RequestMethod.GET)

public class SHcontroller {

    @RequestMapping(value="SH1",method = RequestMethod.GET)
    @ApiOperation(value = "货源主数据列表", notes = "货源主数据列表")
    public String SH1(){
        return "mro/SH/SH1";
    }

    @RequestMapping(value="SH2",method = RequestMethod.GET)
    @ApiOperation(value = "货源主数据列表", notes = "货源主数据列表")
    public String SH2(){

        return "mro/SH/SH2";
    }

    @RequestMapping(value="SH3",method = RequestMethod.GET)
    @ApiOperation(value = "货源主数据列表", notes = "货源主数据列表")
    public String SH3(){

        return "mro/SH/SH3";
    }


    @RequestMapping(value="SH0",method = RequestMethod.GET)
    @ApiOperation(value = "货源主数据列表", notes = "货源主数据列表")
    public String SH0(){
        return "mro/SH/SHyishou";
    }

    @RequestMapping(value="SH00",method = RequestMethod.GET)
    @ApiOperation(value = "货源主数据列表", notes = "货源主数据列表")
    public String SH00(){
        return "mro/SH/SHdaishou";
    }

}
