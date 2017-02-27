package com.ssm.service.impl;

import com.ssm.dao.ProvincesMapper;
import com.ssm.pojo.Provinces;
import com.ssm.service.ProvincesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huangcr02 on 2017/1/13 013.
 */
@Service("provincesService")
public class ProvincesServiceImpl implements ProvincesService {
    @Resource
    private ProvincesMapper provincesMapper;

    @Override
    public Provinces getProvincesById(String id) {
        return this.provincesMapper.selectByPrimaryKey(id);
    }
}
