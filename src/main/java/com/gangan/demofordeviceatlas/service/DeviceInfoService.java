package com.gangan.demofordeviceatlas.service;

import com.gangan.demofordeviceatlas.dto.DeviceInfoQueryParams;
import com.gangan.demofordeviceatlas.entity.DeviceInfo;
import com.gangan.demofordeviceatlas.framework.AjaxResult;
import com.gangan.demofordeviceatlas.mapper.DeviceInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DeviceInfoService implements DeviceInfoServiceInterface {

    @Resource
    private DeviceAtlasService deviceAtlasService;

    @Resource
    private DeviceInfoMapper mapper;

    @Override
    public void importDeviceInfo(String data) {
        String[] userAgents = data.trim().split("\n");
        for (String userAgent : userAgents) {
            userAgent = userAgent.trim();
            if (userAgent.equals("")) {
                continue;
            }
            DeviceInfo deviceInfo = deviceAtlasService.detectUserAgent(userAgent);
            mapper.insertDeviceInfo(deviceInfo);
        }
    }

    @Override
    public void truncateTable() {
        mapper.truncateTable();
    }

    @Override
    public AjaxResult selectDeviceInfo(Map<String, String> params) {
        long pageSize = Long.parseLong(params.get("pageSize"));
        long page = Long.parseLong(params.get("page"));
        Long offset = (page - 1) * pageSize;
        DeviceInfoQueryParams queryParams = new DeviceInfoQueryParams();
        queryParams.setKeyword(params.get("keyword"));
        queryParams.setOnlyTablet(Boolean.valueOf(params.get("onlyTablet")));
        queryParams.setPageSize(pageSize);
        queryParams.setOffset(offset);
        AjaxResult rtn = AjaxResult.success();
        rtn.put("total", mapper.selectCount(queryParams));
        rtn.put("data", mapper.selectDeviceInfo(queryParams));
        return rtn;
    }
}
