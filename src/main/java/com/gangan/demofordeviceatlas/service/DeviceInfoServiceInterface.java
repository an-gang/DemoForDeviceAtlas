package com.gangan.demofordeviceatlas.service;

import com.gangan.demofordeviceatlas.framework.AjaxResult;

import java.util.Map;

public interface DeviceInfoServiceInterface {
    void importDeviceInfo(String data);

    void truncateTable();

    AjaxResult selectDeviceInfo(Map<String, String> params);
}
