package com.ruoyi.price.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 样品价格信息对象 sample_price_info
 * 
 * @author Charlie
 * @date 2023-04-13
 */
public class SamplePriceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 委托编号 */
    @Excel(name = "委托编号")
    private String projectId;

    /** 样品名称 */
    @Excel(name = "样品名称")
    private String sampleName;

    /** 样品价格 */
    @Excel(name = "样品价格")
    private BigDecimal samplePrice;

    /** 编号 */
    private Long id;

    public void setProjectId(String projectId) 
    {
        this.projectId = projectId;
    }

    public String getProjectId() 
    {
        return projectId;
    }
    public void setSampleName(String sampleName) 
    {
        this.sampleName = sampleName;
    }

    public String getSampleName() 
    {
        return sampleName;
    }
    public void setSamplePrice(BigDecimal samplePrice) 
    {
        this.samplePrice = samplePrice;
    }

    public BigDecimal getSamplePrice() 
    {
        return samplePrice;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("sampleName", getSampleName())
            .append("samplePrice", getSamplePrice())
            .append("id", getId())
            .toString();
    }
}
