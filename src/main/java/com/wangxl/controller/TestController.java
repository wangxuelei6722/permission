package com.wangxl.controller;

import com.wangxl.common.JsonData;
import com.wangxl.exception.PermissionException;
import com.wangxl.param.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @ResponseBody
    @RequestMapping("/hello.json")
    public JsonData hello(){

        log.info("hello");
        throw new PermissionException("test exception");
       // return JsonData.success("hello ,permisson");
    }
    @ResponseBody
    @RequestMapping("/validate.json")
    public JsonData valate(TestVO vo){
        log.info("hello");
        return JsonData.success("validate");
    }
}
