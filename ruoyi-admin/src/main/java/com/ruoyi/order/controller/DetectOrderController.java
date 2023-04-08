package com.ruoyi.order.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
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
import com.ruoyi.order.domain.DetectOrder;
import com.ruoyi.order.service.IDetectOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 委托单信息Controller
 *
 * @author Charlie
 * @date 2023-04-08
 */
@RestController
@RequestMapping("/order/order")
public class DetectOrderController extends BaseController
{
    @Autowired
    private IDetectOrderService detectOrderService;

    @Autowired
    private TokenService tokenService;

    /**
     * 查询委托单信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(DetectOrder detectOrder)
    {
        startPage();
        List<DetectOrder> list = detectOrderService.selectDetectOrderList(detectOrder);
        return getDataTable(list);
    }

    /**
     * 导出委托单信息列表
     */
    @PreAuthorize("@ss.hasPermi('order:order:export')")
    @Log(title = "委托单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DetectOrder detectOrder)
    {
        List<DetectOrder> list = detectOrderService.selectDetectOrderList(detectOrder);
        ExcelUtil<DetectOrder> util = new ExcelUtil<DetectOrder>(DetectOrder.class);
        util.exportExcel(response, list, "委托单信息数据");
    }

    /**
     * 导入委托单信息列表
     */
    @Log(title = "委托单信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {

        ExcelUtil<DetectOrder> util = new ExcelUtil<>(DetectOrder.class);
        List<DetectOrder> list = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = detectOrderService.importData(list, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @GetMapping("/importTemplate")
    public AjaxResult importTemplate() {
        ExcelUtil<DetectOrder> util = new ExcelUtil<>(DetectOrder.class);
        return util.importTemplateExcel("案卷数据");
    }

    /**
     * 获取委托单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('order:order:query')")
    @GetMapping(value = "/{sampleId}")
    public AjaxResult getInfo(@PathVariable("sampleId") String sampleId)
    {
        return success(detectOrderService.selectDetectOrderBySampleId(sampleId));
    }

    /**
     * 新增委托单信息
     */
    @PreAuthorize("@ss.hasPermi('order:order:add')")
    @Log(title = "委托单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DetectOrder detectOrder)
    {
        return toAjax(detectOrderService.insertDetectOrder(detectOrder));
    }

    /**
     * 修改委托单信息
     */
    @PreAuthorize("@ss.hasPermi('order:order:edit')")
    @Log(title = "委托单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DetectOrder detectOrder)
    {
        return toAjax(detectOrderService.updateDetectOrder(detectOrder));
    }

    /**
     * 删除委托单信息
     */
    @PreAuthorize("@ss.hasPermi('order:order:remove')")
    @Log(title = "委托单信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sampleIds}")
    public AjaxResult remove(@PathVariable String[] sampleIds)
    {
        return toAjax(detectOrderService.deleteDetectOrderBySampleIds(sampleIds));
    }
}
