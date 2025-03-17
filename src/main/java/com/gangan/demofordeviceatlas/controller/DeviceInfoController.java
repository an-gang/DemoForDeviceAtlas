package com.gangan.demofordeviceatlas.controller;

import com.gangan.demofordeviceatlas.framework.AjaxResult;
import com.gangan.demofordeviceatlas.service.DeviceInfoServiceInterface;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Resource
    private DeviceInfoServiceInterface service;

    @PostMapping("/import")
    public AjaxResult importDeviceInfo(String data) {
        service.importDeviceInfo(data);

        return AjaxResult.success();
    }

    @DeleteMapping("/truncate")
    public AjaxResult truncateTable() {
        service.truncateTable();
        return AjaxResult.success();
    }


    // params: onlyTablet, keyword, pageSize, page
    @GetMapping("/list")
    public AjaxResult selectDeviceInfo(@RequestParam Map<String, String> params) {
        return service.selectDeviceInfo(params);
    }


}
