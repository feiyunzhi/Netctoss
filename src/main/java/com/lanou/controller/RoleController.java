package com.lanou.controller;

import com.lanou.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/26.
 */
@Controller
public class RoleController {
    @Resource
    private RoleService roleService;


    //到角色管理界面
    @RequestMapping(value = "role/role_list")
    public String role_list(){
        return "role/role_list";
    }

}
