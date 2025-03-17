package com.gangan.demofordeviceatlas.entity;

public class DeviceInfo {
    private Long id;
    private String primaryHardwareType;
    private String vendor;
    private String model;
    private String osName;
    private String osVersion;
    private String browserName;
    private String browserRenderingEngine;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrimaryHardwareType(String primaryHardwareType) {
        this.primaryHardwareType = primaryHardwareType;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setBrowserRenderingEngine(String browserRenderingEngine) {
        this.browserRenderingEngine = browserRenderingEngine;
    }

    public Long getId() {
        return id;
    }

    public String getPrimaryHardwareType() {
        return primaryHardwareType;
    }

    public String getVendor() {
        return vendor;
    }

    public String getModel() {
        return model;
    }

    public String getOsName() {
        return osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBrowserRenderingEngine() {
        return browserRenderingEngine;
    }

}
