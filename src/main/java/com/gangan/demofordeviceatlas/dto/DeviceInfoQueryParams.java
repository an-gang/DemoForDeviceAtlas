package com.gangan.demofordeviceatlas.dto;

public class DeviceInfoQueryParams {
    private String keyword;
    private Boolean onlyTablet;
    private Long pageSize;
    private Long offset;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setOnlyTablet(Boolean onlyTablet) {
        this.onlyTablet = onlyTablet;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public String getKeyword() {
        return keyword;
    }

    public Boolean getOnlyTablet() {
        return onlyTablet;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public Long getOffset() {
        return offset;
    }
}
