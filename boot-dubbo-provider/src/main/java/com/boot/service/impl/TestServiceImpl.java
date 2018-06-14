package com.boot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.boot.domain.User;
import com.boot.mapper.ToClickHouseMapper;
import com.boot.bo.ToClickHouseBo;
import com.boot.bo.ToClickHouseWithBLOBs;
import com.boot.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service(version = "1.0")
@Transactional
public class TestServiceImpl implements TestService {
    @Autowired
    private ToClickHouseMapper toClickHouseMapper;

    @Override
    public String sayHello(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()) + ": " + str;
    }

    @Override
    public int addRecord(ToClickHouseBo bo) {
        this.toClickHouseMapper.deleteByPrimaryKey(5);
        ToClickHouseWithBLOBs toClickHouseWithBLOBs = new ToClickHouseWithBLOBs();
        BeanUtils.copyProperties(bo, toClickHouseWithBLOBs);
        toClickHouseMapper.insert(toClickHouseWithBLOBs);
        /*boolean flag = true;
        if (flag) {
            throw new RuntimeException();
        }*/
        return 0;
    }

    @Override
    public User findUser() {
        User user = new User();
        user.setId(1001);
        user.setUsername("scott");
        user.setPassword("tiger");
        user.setAge(20);
        user.setGender(0);
        return user;
    }

    @Override
    public ToClickHouseBo findRecord(Integer id) {
        ToClickHouseBo bo = new ToClickHouseBo();
        ToClickHouseWithBLOBs toClickHouseWithBLOBs = toClickHouseMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(toClickHouseWithBLOBs, bo);
        return bo;
    }

    @Override
    public int deleteById(Integer id) {
        this.toClickHouseMapper.deleteByPrimaryKey(id);
        return 0;
    }

    @Override
    public PageInfo selectByByPage(ToClickHouseBo bo) {
        ToClickHouseWithBLOBs toClickHouseWithBLOBs = new ToClickHouseWithBLOBs();
        BeanUtils.copyProperties(bo, toClickHouseWithBLOBs);
        PageHelper.startPage(bo.getPageNo(), bo.getPageSize());
        List<ToClickHouseWithBLOBs> list=this.toClickHouseMapper.selectByListByPage(toClickHouseWithBLOBs);
        return new PageInfo(list);
    }
}
