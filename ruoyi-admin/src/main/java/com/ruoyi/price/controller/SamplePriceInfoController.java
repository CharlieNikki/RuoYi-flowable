package com.ruoyi.price.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.price.domain.SamplePriceInfo;
import com.ruoyi.price.service.ISamplePriceInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 样品价格信息Controller
 * 
 * @author Charlie
 * @date 2023-04-11
 */
@RestController
@RequestMapping("/price/priceInfo")
public class SamplePriceInfoController extends BaseController
{
    @Autowired
    private ISamplePriceInfoService samplePriceInfoService;

    /**
     * 查询样品价格信息列表
     */
    @PreAuthorize("@ss.hasPermi('price:priceInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SamplePriceInfo samplePriceInfo)
    {
        startPage();
        List<SamplePriceInfo> list = samplePriceInfoService.selectSamplePriceInfoList(samplePriceInfo);
        return getDataTable(list);
    }

    /**
     * 导出样品价格信息列表
     */
    @PreAuthorize("@ss.hasPermi('price:priceInfo:export')")
    @Log(title = "样品价格信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SamplePriceInfo samplePriceInfo)
    {
        List<SamplePriceInfo> list = samplePriceInfoService.selectSamplePriceInfoList(samplePriceInfo);
        ExcelUtil<SamplePriceInfo> util = new ExcelUtil<SamplePriceInfo>(SamplePriceInfo.class);
        util.exportExcel(response, list, "样品价格信息数据");
    }

    /**
     * 获取样品价格信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('price:priceInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(samplePriceInfoService.selectSamplePriceInfoById(id));
    }

    /**
     * 新增样品价格信息
     */
    @PreAuthorize("@ss.hasPermi('price:priceInfo:add')")
    @Log(title = "样品价格信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SamplePriceInfo samplePriceInfo)
    {
        return toAjax(samplePriceInfoService.insertSamplePriceInfo(samplePriceInfo));
    }

    /**
     * 修改样品价格信息
     */
    @PreAuthorize("@ss.hasPermi('price:priceInfo:edit')")
    @Log(title = "样品价格信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SamplePriceInfo samplePriceInfo)
    {
        return toAjax(samplePriceInfoService.updateSamplePriceInfo(samplePriceInfo));
    }

    /**
     * 删除样品价格信息
     */
    @PreAuthorize("@ss.hasPermi('price:priceInfo:remove')")
    @Log(title = "样品价格信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(samplePriceInfoService.deleteSamplePriceInfoByIds(ids));
    }
}
