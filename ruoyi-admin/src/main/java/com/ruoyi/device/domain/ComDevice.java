package com.ruoyi.device.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备管理对象 com_device
 *
 * @author Charlie
 * @date 2023-04-09
 */
public class ComDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String id;

    /** 设备名 */
    @Excel(name = "设备名")
    private String devName;

    /** 设备数量 */
    @Excel(name = "设备数量")
    private Long devCount;

    /** 设备价格 */
    @Excel(name = "设备价格")
    private BigDecimal devCost;

    /** 设备购入时间 */
    @Excel(name = "设备购入时间")
    private String devPurchaseTime;

    /** 设备购入人员 */
    @Excel(name = "设备购入人员")
    private String devPurchaser;

    /** 设备使用人员 */
    @Excel(name = "设备使用人员")
    private String devUser;

    /** 设备使用日期 */
    @Excel(name = "设备使用日期")
    private String devUseDate;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setDevName(String devName)
    {
        this.devName = devName;
    }

    public String getDevName()
    {
        return devName;
    }
    public void setDevCount(Long devCount)
    {
        this.devCount = devCount;
    }

    public Long getDevCount()
    {
        return devCount;
    }
    public void setDevCost(BigDecimal devCost)
    {
        this.devCost = devCost;
    }

    public BigDecimal getDevCost()
    {
        return devCost;
    }
    public void setDevPurchaseTime(String devPurchaseTime)
    {
        this.devPurchaseTime = devPurchaseTime;
    }

    public String getDevPurchaseTime()
    {
        return devPurchaseTime;
    }
    public void setDevPurchaser(String devPurchaser)
    {
        this.devPurchaser = devPurchaser;
    }

    public String getDevPurchaser()
    {
        return devPurchaser;
    }
    public void setDevUser(String devUser)
    {
        this.devUser = devUser;
    }

    public String getDevUser()
    {
        return devUser;
    }
    public void setDevUseDate(String devUseDate)
    {
        this.devUseDate = devUseDate;
    }

    public String getDevUseDate()
    {
        return devUseDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("devName", getDevName())
            .append("devCount", getDevCount())
            .append("devCost", getDevCost())
            .append("devPurchaseTime", getDevPurchaseTime())
            .append("devPurchaser", getDevPurchaser())
            .append("devUser", getDevUser())
            .append("devUseDate", getDevUseDate())
            .toString();
    }
}
