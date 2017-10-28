package com.lanou.mapper;

import com.lanou.bean.AdminInfo;

import java.util.List;

public interface AdminInfoMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(AdminInfo record);

    int insertSelective(AdminInfo record);

    AdminInfo selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(AdminInfo record);

    int updateByPrimaryKey(AdminInfo record);

    List<AdminInfo> findAllAdmin();

    void deleteForA_RByAId(Integer adminId);
}