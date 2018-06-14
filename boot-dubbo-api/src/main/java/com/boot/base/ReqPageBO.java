package com.boot.base;

import lombok.Data;

@Data
public class ReqPageBO {

    /**  */
    private static final long serialVersionUID = -7485827693286591127L;

    /**
     * 第几页
     */
    private int pageNo = 0;
    /**
     * 每页的数量
     */
    private int pageSize = 10;

    private String sortName;
    private String sortOrder;
}
