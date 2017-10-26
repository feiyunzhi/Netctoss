package com.lanou.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/10/22.
 */
@Controller
public class BaseController {

    //错误页面返回
    @RequestMapping(value = "login")
    public String error(){
        return "login";
    }

    //到错误页面
    @RequestMapping(value = "/error")
    public String addError(){
        return "error";
    }

}
