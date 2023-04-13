package com.ruoyi.price.service;

import java.util.List;
import com.ruoyi.price.domain.SamplePriceInfo;

/**
 * 样品价格信息Service接口
 * 
 * @author Charlie
 * @date 2023-04-11
 */
public interface ISamplePriceInfoService 
{
    /**
     * 查询样品价格信息
     * 
     * @param id 样品价格信息主键
     * @return 样品价格信息
     */
    public SamplePriceInfo selectSamplePriceInfoById(Long id);

    /**
     * 查询样品价格信息列表
     * 
     * @param samplePriceInfo 样品价格信息
     * @return 样品价格信息集合
     */
    public List<SamplePriceInfo> selectSamplePriceInfoList(SamplePriceInfo samplePriceInfo);

    /**
     * 新增样品价格信息
     * 
     * @param samplePriceInfo 样品价格信息
     * @return 结果
     */
    public int insertSamplePriceInfo(SamplePriceInfo samplePriceInfo);

    /**
     * 修改样品价格信息
     * 
     * @param samplePriceInfo 样品价格信息
     * @return 结果
     */
    public int updateSamplePriceInfo(SamplePriceInfo samplePriceInfo);

    /**
     * 批量删除样品价格信息
     * 
     * @param ids 需要删除的样品价格信息主键集合
     * @return 结果
     */
    public int deleteSamplePriceInfoByIds(Long[] ids);

    /**
     * 删除样品价格信息信息
     * 
     * @param id 样品价格信息主键
     * @return 结果
     */
    public int deleteSamplePriceInfoById(Long id);
}
