package com.gangan.demofordeviceatlas.mapper;

import com.gangan.demofordeviceatlas.dto.DeviceInfoQueryParams;
import com.gangan.demofordeviceatlas.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DeviceInfoMapper {

    void insertDeviceInfo(DeviceInfo deviceInfo);

    void truncateTable();

    List<DeviceInfo> selectDeviceInfo(DeviceInfoQueryParams params);

    long selectCount(DeviceInfoQueryParams params);
}
