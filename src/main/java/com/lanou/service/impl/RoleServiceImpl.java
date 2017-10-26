package com.lanou.service.impl;

import com.lanou.mapper.RoleInfoMapper;
import com.lanou.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/10/26.
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleInfoMapper roleInfoMapper;
}
