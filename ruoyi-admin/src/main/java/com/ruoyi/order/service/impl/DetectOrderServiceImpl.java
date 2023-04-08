package com.ruoyi.order.service.impl;

import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.DetectOrderMapper;
import com.ruoyi.order.domain.DetectOrder;
import com.ruoyi.order.service.IDetectOrderService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 委托单信息Service业务层处理
 *
 * @author Charlie
 * @date 2023-04-08
 */
@Service
public class DetectOrderServiceImpl implements IDetectOrderService
{
    @Autowired
    private DetectOrderMapper detectOrderMapper;

    /**
     * 查询委托单信息
     *
     * @param sampleId 委托单信息主键
     * @return 委托单信息
     */
    @Override
    public DetectOrder selectDetectOrderBySampleId(String sampleId)
    {
        return detectOrderMapper.selectDetectOrderBySampleId(sampleId);
    }

    /**
     * 查询委托单信息列表
     *
     * @param detectOrder 委托单信息
     * @return 委托单信息
     */
    @Override
    public List<DetectOrder> selectDetectOrderList(DetectOrder detectOrder)
    {
        return detectOrderMapper.selectDetectOrderList(detectOrder);
    }

    /**
     * 新增委托单信息
     *
     * @param detectOrder 委托单信息
     * @return 结果
     */
    @Override
    public int insertDetectOrder(DetectOrder detectOrder)
    {
        return detectOrderMapper.insertDetectOrder(detectOrder);
    }

    /**
     * 修改委托单信息
     *
     * @param detectOrder 委托单信息
     * @return 结果
     */
    @Override
    public int updateDetectOrder(DetectOrder detectOrder)
    {
        return detectOrderMapper.updateDetectOrder(detectOrder);
    }

    /**
     * 批量删除委托单信息
     *
     * @param sampleIds 需要删除的委托单信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectOrderBySampleIds(String[] sampleIds)
    {
        return detectOrderMapper.deleteDetectOrderBySampleIds(sampleIds);
    }

    /**
     * 删除委托单信息信息
     *
     * @param sampleId 委托单信息主键
     * @return 结果
     */
    @Override
    public int deleteDetectOrderBySampleId(String sampleId)
    {
        return detectOrderMapper.deleteDetectOrderBySampleId(sampleId);
    }

    /**
     * 导入用户数据
     * @param detectOrderList 委托单数据
     * @param isUpdateSupport 是否支持更新，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    @Transactional
    public String importData(List<DetectOrder> detectOrderList, Boolean isUpdateSupport, String operName) {

        if (StringUtils.isNull(detectOrderList) || detectOrderList.size() == 0) {
            throw new CustomException("导入数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        List<DetectOrder> existList = selectDetectOrderList(null);
        for (DetectOrder order : detectOrderList) {
            try {
                // 验证是否存在
                boolean userFlag = false;
                for (DetectOrder entry : existList) {
                    if (entry.getSampleId().equals(order.getSampleId())) {
                        userFlag = true;
                        break;
                    }
                }
                if (!userFlag) {
                    insertDetectOrder(order);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据：" + order.getSampleId() + "导入成功！");
                } else if (isUpdateSupport) {
                    updateDetectOrder(order);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、数据：" + order.getSampleId() + "更新成功！");
                } else {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、数据：" + order.getSampleId() + "已存在！");
                }
            }
            catch (Exception e) {
                failureNum++;
                String msg = ("<br/>" + failureNum + "、数据：" + order.getSampleId() + "导入失败！");
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "导入失败，共" + failureNum + "条数据格式不正确，错误如下:");
            throw new CustomException(failureMsg.toString());
        } else {
            successMsg.insert(0, "数据已全部导入成功，共" + successNum + "条，数据如下：");
        }
        return successMsg.toString();
    }
}
