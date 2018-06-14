package com.boot.bo;

import lombok.Data;

@Data
public class ToClickHouseWithBLOBs extends ToClickHouseBo {
    private byte[] tinyblobColumn;

    private byte[] blobColumn;

    private byte[] mediumblobColumn;

    private byte[] longblobColumn;

    private String textColumn;

    private String mediumtextColumn;

    private String longtextColumn;


}