package com.gangan.demofordeviceatlas.dto;

import com.gangan.demofordeviceatlas.entity.DeviceInfo;

public class DeviceAtlasResponse {
    private DeviceInfo properties;

    public void setProperties(DeviceInfo properties) {
        this.properties = properties;
    }

    public DeviceInfo getProperties() {
        return properties;
    }

}
