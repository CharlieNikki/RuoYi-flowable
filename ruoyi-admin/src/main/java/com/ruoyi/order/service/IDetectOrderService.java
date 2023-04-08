package com.ruoyi.order.service;

import java.util.List;
import com.ruoyi.order.domain.DetectOrder;

/**
 * 委托单信息Service接口
 *
 * @author Charlie
 * @date 2023-04-08
 */
public interface IDetectOrderService
{
    /**
     * 查询委托单信息
     *
     * @param sampleId 委托单信息主键
     * @return 委托单信息
     */
    public DetectOrder selectDetectOrderBySampleId(String sampleId);

    /**
     * 查询委托单信息列表
     *
     * @param detectOrder 委托单信息
     * @return 委托单信息集合
     */
    public List<DetectOrder> selectDetectOrderList(DetectOrder detectOrder);

    /**
     * 新增委托单信息
     *
     * @param detectOrder 委托单信息
     * @return 结果
     */
    public int insertDetectOrder(DetectOrder detectOrder);

    /**
     * 修改委托单信息
     *
     * @param detectOrder 委托单信息
     * @return 结果
     */
    public int updateDetectOrder(DetectOrder detectOrder);

    /**
     * 批量删除委托单信息
     *
     * @param sampleIds 需要删除的委托单信息主键集合
     * @return 结果
     */
    public int deleteDetectOrderBySampleIds(String[] sampleIds);

    /**
     * 删除委托单信息信息
     *
     * @param sampleId 委托单信息主键
     * @return 结果
     */
    public int deleteDetectOrderBySampleId(String sampleId);

    /**
     * 导入委托单信息
     */
    public String importData(List<DetectOrder> detectOrderList, Boolean isUpdateSupport, String operName);
}
