package com.boot.service;

import com.boot.domain.User;
import com.boot.bo.ToClickHouseBo;
import com.github.pagehelper.PageInfo;


public interface TestService {

    String sayHello(String str);

    User findUser();

    ToClickHouseBo findRecord(Integer id);

    int addRecord(ToClickHouseBo bo);

    int deleteById(Integer id);

    PageInfo<ToClickHouseBo> selectByByPage(ToClickHouseBo bo);

}
