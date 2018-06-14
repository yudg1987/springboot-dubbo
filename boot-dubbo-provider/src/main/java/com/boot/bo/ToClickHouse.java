package com.boot.bo;

import lombok.Data;

import java.util.Date;

@Data
public class ToClickHouse {
    private Integer idColumn;

    private Byte tinyintColumn;

    private Byte tinyintUnsignedColumn;

    private Short smallintColumn;

    private Short smallintUnsignedColumn;

    private Integer mediumintColumn;

    private Integer mediumintUnsignedColumn;

    private Integer intColumn;

    private Integer intUnsignedColumn;

    private Long bigintColumn;

    private Long bigintUnsignedColumn;

    private Double doubleColumn;

    private Double doubleUnsignedColumn;

    private Float floatColumn;

    private Float floatUnsignedColumn;

    private Long decimalColumn;

    private Long decimalUnsignedColumn;

    private String charColumn;

    private String varcharColumn;

    private Date dateColumn;

    private Date timeColumn;

    private Date yearColumn;

    private Date timestampColumn;

    private Date datetimeColumn;

    private String tinytextColumn;

    private String enumColumn;

    private Boolean bitColumn;


}