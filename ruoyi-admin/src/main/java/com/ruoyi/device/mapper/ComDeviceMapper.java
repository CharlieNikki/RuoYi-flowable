package com.ruoyi.device.mapper;

import java.util.List;
import com.ruoyi.device.domain.ComDevice;

/**
 * 设备管理Mapper接口
 * 
 * @author Charlie
 * @date 2023-04-09
 */
public interface ComDeviceMapper 
{
    /**
     * 查询设备管理
     * 
     * @param id 设备管理主键
     * @return 设备管理
     */
    public ComDevice selectComDeviceById(String id);

    /**
     * 查询设备管理列表
     * 
     * @param comDevice 设备管理
     * @return 设备管理集合
     */
    public List<ComDevice> selectComDeviceList(ComDevice comDevice);

    /**
     * 新增设备管理
     * 
     * @param comDevice 设备管理
     * @return 结果
     */
    public int insertComDevice(ComDevice comDevice);

    /**
     * 修改设备管理
     * 
     * @param comDevice 设备管理
     * @return 结果
     */
    public int updateComDevice(ComDevice comDevice);

    /**
     * 删除设备管理
     * 
     * @param id 设备管理主键
     * @return 结果
     */
    public int deleteComDeviceById(String id);

    /**
     * 批量删除设备管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteComDeviceByIds(String[] ids);
}
