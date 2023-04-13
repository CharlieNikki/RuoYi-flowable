package com.ruoyi.order.mapper;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.order.domain.DetectOrder;
import org.apache.ibatis.annotations.Param;

/**
 * 委托单信息Mapper接口
 *
 * @author Charlie
 * @date 2023-04-08
 */
public interface DetectOrderMapper
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
     * 删除委托单信息
     *
     * @param sampleId 委托单信息主键
     * @return 结果
     */
    public int deleteDetectOrderBySampleId(String sampleId);

    /**
     * 批量删除委托单信息
     *
     * @param sampleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetectOrderBySampleIds(String[] sampleIds);

    /**
     * 根据project_id和sample_name，更新委托的价格信息
     */
    public int updateOrderPriceByProjectIdAndSampleName(@Param("projectId") String projectId,
                                                        @Param("sampleName") String sampleName,
                                                        @Param("price") BigDecimal price);
}
