package com.ruoyi.device.service;

import java.util.List;
import com.ruoyi.device.domain.ComDevice;

/**
 * 设备管理Service接口
 *
 * @author Charlie
 * @date 2023-04-09
 */
public interface IComDeviceService
{

    /**
     * 导入用户数据
     *
     * @param comDeviceList 数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importData(List<ComDevice> comDeviceList, Boolean isUpdateSupport, String operName);



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
     * 批量删除设备管理
     *
     * @param ids 需要删除的设备管理主键集合
     * @return 结果
     */
    public int deleteComDeviceByIds(String[] ids);

    /**
     * 删除设备管理信息
     *
     * @param id 设备管理主键
     * @return 结果
     */
    public int deleteComDeviceById(String id);
}
