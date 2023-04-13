package com.ruoyi.price.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.ruoyi.order.mapper.DetectOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.price.mapper.SamplePriceInfoMapper;
import com.ruoyi.price.domain.SamplePriceInfo;
import com.ruoyi.price.service.ISamplePriceInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 样品价格信息Service业务层处理
 *
 * @author Charlie
 * @date 2023-04-13
 */
@Service
public class SamplePriceInfoServiceImpl implements ISamplePriceInfoService
{
    @Autowired
    private SamplePriceInfoMapper samplePriceInfoMapper;

    @Autowired
    private DetectOrderMapper detectOrderMapper;

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
     * 新增样品价格信息的同时，在DetectOrder表中进行价格的更新，判断更新的条件是：匹配projectId和样品名称
     * @param samplePriceInfo 样品价格信息
     * @return 结果
     */
    @Override
    @Transactional
    public int insertSamplePriceInfo(SamplePriceInfo samplePriceInfo)
    {
        System.out.println("samplePriceInfo:" + samplePriceInfo);
        int insertResult = samplePriceInfoMapper.insertSamplePriceInfo(samplePriceInfo);
        String projectId = samplePriceInfo.getProjectId();
        String sampleName = samplePriceInfo.getSampleName();
        BigDecimal price = samplePriceInfo.getSamplePrice();

        int updateResult = detectOrderMapper.updateOrderPriceByProjectIdAndSampleName(projectId, sampleName, price);
        return insertResult + updateResult;
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
