package com.ruoyi.device.service.impl;

import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.device.mapper.ComDeviceMapper;
import com.ruoyi.device.domain.ComDevice;
import com.ruoyi.device.service.IComDeviceService;

/**
 * 设备管理Service业务层处理
 *
 * @author Charlie
 * @date 2023-04-09
 */
@Service
public class ComDeviceServiceImpl implements IComDeviceService
{
    @Autowired
    private ComDeviceMapper comDeviceMapper;

    @Override
    public String importData(List<ComDevice> dataManagementList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dataManagementList) || dataManagementList.size() == 0)
        {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<ComDevice> existList = selectComDeviceList(null);
        for (ComDevice importData : dataManagementList)
        {
            try {

                boolean userFlag = false;
                for (ComDevice entry : existList) {
                    if (entry.getId().equals(importData.getId())) {
                        userFlag = true;
                        break;
                    }
                }
                if (!userFlag) {
                    insertComDevice(importData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + importData.getId() + " 导入成功");
                } else if (isUpdateSupport) {
                    updateComDevice(importData);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据 " + importData.getId() + " 更新成功");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、数据 " + importData.getId() + " 已存在");
                }
            }catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + importData.getId() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                //log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new CustomException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }


    /**
     * 查询设备管理
     *
     * @param id 设备管理主键
     * @return 设备管理
     */
    @Override
    public ComDevice selectComDeviceById(String id)
    {
        return comDeviceMapper.selectComDeviceById(id);
    }

    /**
     * 查询设备管理列表
     *
     * @param comDevice 设备管理
     * @return 设备管理
     */
    @Override
    public List<ComDevice> selectComDeviceList(ComDevice comDevice)
    {
        return comDeviceMapper.selectComDeviceList(comDevice);
    }

    /**
     * 新增设备管理
     *
     * @param comDevice 设备管理
     * @return 结果
     */
    @Override
    public int insertComDevice(ComDevice comDevice)
    {
        return comDeviceMapper.insertComDevice(comDevice);
    }

    /**
     * 修改设备管理
     *
     * @param comDevice 设备管理
     * @return 结果
     */
    @Override
    public int updateComDevice(ComDevice comDevice)
    {
        return comDeviceMapper.updateComDevice(comDevice);
    }

    /**
     * 批量删除设备管理
     *
     * @param ids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteComDeviceByIds(String[] ids)
    {
        return comDeviceMapper.deleteComDeviceByIds(ids);
    }

    /**
     * 删除设备管理信息
     *
     * @param id 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteComDeviceById(String id)
    {
        return comDeviceMapper.deleteComDeviceById(id);
    }
}
