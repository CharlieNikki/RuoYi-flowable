package com.ruoyi.price.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.price.mapper.SamplePriceInfoMapper;
import com.ruoyi.price.domain.SamplePriceInfo;
import com.ruoyi.price.service.ISamplePriceInfoService;

/**
 * 样品价格信息Service业务层处理
 * 
 * @author Charlie
 * @date 2023-04-11
 */
@Service
public class SamplePriceInfoServiceImpl implements ISamplePriceInfoService 
{
    @Autowired
    private SamplePriceInfoMapper samplePriceInfoMapper;

    /**
     * 查询样品价格信息
     * 
     * @param id 样品价格信息主键
     * @return 样品价格信息
     */
    @Override
    public SamplePriceInfo selectSamplePriceInfoById(Long id)
    {
        return samplePriceInfoMapper.selectSamplePriceInfoById(id);
    }

    /**
     * 查询样品价格信息列表
     * 
     * @param samplePriceInfo 样品价格信息
     * @return 样品价格信息
     */
    @Override
    public List<SamplePriceInfo> selectSamplePriceInfoList(SamplePriceInfo samplePriceInfo)
    {
        return samplePriceInfoMapper.selectSamplePriceInfoList(samplePriceInfo);
    }

    /**
     * 新增样品价格信息
     * 
     * @param samplePriceInfo 样品价格信息
     * @return 结果
     */
    @Override
    public int insertSamplePriceInfo(SamplePriceInfo samplePriceInfo)
    {
        return samplePriceInfoMapper.insertSamplePriceInfo(samplePriceInfo);
    }

    /**
     * 修改样品价格信息
     * 
     * @param samplePriceInfo 样品价格信息
     * @return 结果
     */
    @Override
    public int updateSamplePriceInfo(SamplePriceInfo samplePriceInfo)
    {
        return samplePriceInfoMapper.updateSamplePriceInfo(samplePriceInfo);
    }

    /**
     * 批量删除样品价格信息
     * 
     * @param ids 需要删除的样品价格信息主键
     * @return 结果
     */
    @Override
    public int deleteSamplePriceInfoByIds(Long[] ids)
    {
        return samplePriceInfoMapper.deleteSamplePriceInfoByIds(ids);
    }

    /**
     * 删除样品价格信息信息
     * 
     * @param id 样品价格信息主键
     * @return 结果
     */
    @Override
    public int deleteSamplePriceInfoById(Long id)
    {
        return samplePriceInfoMapper.deleteSamplePriceInfoById(id);
    }
}
