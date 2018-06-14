package com.boot.mapper;


import com.boot.bo.ToClickHouseBo;
import com.boot.bo.ToClickHouseWithBLOBs;

import java.util.List;

public interface ToClickHouseMapper {

    int deleteByPrimaryKey(Integer idColumn);

    int insert(ToClickHouseWithBLOBs record);

    int insertSelective(ToClickHouseWithBLOBs record);

    ToClickHouseWithBLOBs selectByPrimaryKey(Integer idColumn);

    int updateByPrimaryKeySelective(ToClickHouseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ToClickHouseWithBLOBs record);

    int updateByPrimaryKey(ToClickHouseBo record);

    List<ToClickHouseWithBLOBs> selectByListByPage(ToClickHouseWithBLOBs toClickHouseWithBLOBs);
}