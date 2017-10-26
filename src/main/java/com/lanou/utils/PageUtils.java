package com.lanou.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by dllo on 17/10/20.
 */
public class PageUtils<T> {
//    private Class<T> beanClass;
//
//    public PageUtils(){
//
//        ParameterizedType paramType = (ParameterizedType) this.getClass().getGenericSuperclass();
//
//        beanClass = (Class<T>) paramType.getActualTypeArguments()[0];
//    }

    public PageInfo<T> getPageInfo(Integer pageNo,Integer pageSize){
        return queryAllByPage(pageNo,pageSize);
    }

    public PageInfo<T> queryAllByPage(Integer pageNo,Integer pageSize){
        //判断参数的合法性
        pageNo = pageNo == null?1 : pageNo;
        pageSize = pageSize == null? 3 : pageSize;

        PageHelper.startPage(pageNo,pageSize);

        //获取全部的T信息
//        beanClass.findAll();

        return null;
    }

}
