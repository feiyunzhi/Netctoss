package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Account;
import com.lanou.service.AccountService;
import com.lanou.utils.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/**
 * Created by dllo on 17/10/23.
 */
@Controller
public class AccountController {

    @Resource
    private AccountService accountService;
    @Resource
    private HttpServletRequest request;

    //到财务页面
    @RequestMapping(value = "account/account_list")
    public String account_list() {
        return "account/account_list";
    }

    //到个人信息页面
    @RequestMapping(value = "/account_detail")
    public String account_detail() {
        return "account/account_detail";
    }

    //到修改页面
    @RequestMapping(value = "/account_modi")
    public String account_modi() {
        return "account/account_modi";
    }

    //到增加页面
    @RequestMapping(value = "/account_add")
    public String account_add() {
        return "account/account_add";
    }

    //查询全部-account
    @ResponseBody
    @RequestMapping(value = "/findAllAccount", method = RequestMethod.POST)
    public AjaxResult findAllAccount(@Param("pageNo") Integer pageNo,
                                     @Param("pageSize") Integer pageSize) {
        PageInfo<Account> allAccount = accountService.findAllAccount(pageNo, pageSize);
        return new AjaxResult(allAccount);
    }

    //更改状态
    @ResponseBody
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public AjaxResult updateStatus(@Param("account") Account account) {
        Account byId = accountService.updateStatuById(account);
        return new AjaxResult(byId);
    }

    //查询当前用户信息
    @ResponseBody
    @RequestMapping(value = "/findInfo", method = RequestMethod.POST)
    public Account findInfo(@Param("accountId") Integer accountId) {
        Account byId = accountService.findInfoById(accountId);
        return byId;
    }

    //修改信息

    //查询职业 去重
//    @ResponseBody
//    @RequestMapping(value = "")
//    public List<Account> findOccDistinct(){
//        return accountService.findOccDistinct();
//    }

    //查询职业,去重
    @ResponseBody
    @RequestMapping(value = "/removeDuplicate", method = RequestMethod.POST)
    public List<String> findOccDistinct() {
        List<Account> allAccount = accountService.findAllAccount();

        List<String> strings = new ArrayList<String>();
        for (Account account : allAccount) {
            strings.add(account.getOccupation());
        }

        HashSet hashSet = new HashSet(strings);
        strings.clear();
        strings.addAll(hashSet);

        return strings;
    }

    //修改
    @ResponseBody
    @RequestMapping(value = "/subUpdateAcc", method = RequestMethod.POST)
    public boolean subUpdate(@Param("account") Account account) {
        return accountService.updateAcc(account);
    }

    //添加Acc
    @ResponseBody
    @RequestMapping(value = "/addAcc", method = RequestMethod.POST)
    public Integer addAcc(@Param("account") Account account) {
        return accountService.addAcc(account);
    }

    //删除Acc
    @ResponseBody
    @RequestMapping(value = "/delAcc", method = RequestMethod.POST)
    public boolean delAcc(@Param("account") Account account) {
        return accountService.delAccById(account);
    }

    //模糊查询
    @ResponseBody
    @RequestMapping(value = "/fuzzySearch", method = RequestMethod.POST)
    public AjaxResult fuzzySearch(@Param("account") Account account,
                                  @Param("pageNo")Integer pageNo,
                                  @Param("pageSize")Integer pageSize) {
        System.out.println(account);
        PageInfo<Account> accounts = accountService.fuzzySearch(account,pageNo,pageSize);
        return new AjaxResult(accounts);
    }

    //通过身份证查询Acc
    @ResponseBody
    @RequestMapping(value = "/findByIdCard",method = RequestMethod.POST)
    public Account findByIdCard(@Param("idcardNo")String idcaedNo){
        return accountService.findByIdCard(idcaedNo);
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
