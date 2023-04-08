package com.ruoyi.order.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 委托单信息对象 detect_order
 *
 * @author Charlie
 * @date 2023-04-08
 */
public class DetectOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 委托编号 */
    @Excel(name = "委托编号")
    private String projectId;

    /** 样品编号 */
    @Excel(name = "样品编号")
    private String sampleId;

    /** 样品小类 */
    @Excel(name = "样品小类")
    private String sampleType;

    /** 工程名称 */
    @Excel(name = "工程名称")
    private String projectName;

    /** 委托单位 */
    @Excel(name = "委托单位")
    private String projectCompany;

    /** 样品名称 */
    @Excel(name = "样品名称")
    private String sampleName;

    /** 等级 */
    @Excel(name = "等级")
    private String level;

    /** 规格 */
    @Excel(name = "规格")
    private String specification;

    /** 委托人 */
    @Excel(name = "委托人")
    private String client;

    /** 受理人 */
    @Excel(name = "受理人")
    private String recipient;

    /** 受理日期 */
    @Excel(name = "受理日期")
    private String acceptanceDate;

    /** 检测项目 */
    @Excel(name = "检测项目")
    private String testItems;

    /** 养护方式 */
    @Excel(name = "养护方式")
    private String conservationMethod;

    /** 成型日期 */
    @Excel(name = "成型日期")
    private String moldingDate;

    /** 样品价格 */
    @Excel(name = "样品价格")
    private BigDecimal price;

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public String getProjectId()
    {
        return projectId;
    }
    public void setSampleId(String sampleId)
    {
        this.sampleId = sampleId;
    }

    public String getSampleId()
    {
        return sampleId;
    }
    public void setSampleType(String sampleType)
    {
        this.sampleType = sampleType;
    }

    public String getSampleType()
    {
        return sampleType;
    }
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectCompany(String projectCompany)
    {
        this.projectCompany = projectCompany;
    }

    public String getProjectCompany()
    {
        return projectCompany;
    }
    public void setSampleName(String sampleName)
    {
        this.sampleName = sampleName;
    }

    public String getSampleName()
    {
        return sampleName;
    }
    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getLevel()
    {
        return level;
    }
    public void setSpecification(String specification)
    {
        this.specification = specification;
    }

    public String getSpecification()
    {
        return specification;
    }
    public void setClient(String client)
    {
        this.client = client;
    }

    public String getClient()
    {
        return client;
    }
    public void setRecipient(String recipient)
    {
        this.recipient = recipient;
    }

    public String getRecipient()
    {
        return recipient;
    }
    public void setAcceptanceDate(String acceptanceDate)
    {
        this.acceptanceDate = acceptanceDate;
    }

    public String getAcceptanceDate()
    {
        return acceptanceDate;
    }
    public void setTestItems(String testItems)
    {
        this.testItems = testItems;
    }

    public String getTestItems()
    {
        return testItems;
    }
    public void setConservationMethod(String conservationMethod)
    {
        this.conservationMethod = conservationMethod;
    }

    public String getConservationMethod()
    {
        return conservationMethod;
    }
    public void setMoldingDate(String moldingDate)
    {
        this.moldingDate = moldingDate;
    }

    public String getMoldingDate()
    {
        return moldingDate;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("sampleId", getSampleId())
            .append("sampleType", getSampleType())
            .append("projectName", getProjectName())
            .append("projectCompany", getProjectCompany())
            .append("sampleName", getSampleName())
            .append("level", getLevel())
            .append("specification", getSpecification())
            .append("client", getClient())
            .append("recipient", getRecipient())
            .append("acceptanceDate", getAcceptanceDate())
            .append("testItems", getTestItems())
            .append("conservationMethod", getConservationMethod())
            .append("moldingDate", getMoldingDate())
            .append("price", getPrice())
            .toString();
    }
}
