package com.ruoyi.device.controller;

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
import com.ruoyi.device.domain.ComDevice;
import com.ruoyi.device.service.IComDeviceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 设备管理Controller
 *
 * @author Charlie
 * @date 2023-04-09
 */
@RestController
@RequestMapping("/device/device")
public class ComDeviceController extends BaseController
{
    @Autowired
    private IComDeviceService comDeviceService;

    @Autowired
    private TokenService tokenService;

    /**
     * 导入数据管理列表
     */
    @Log(title = "数据管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<ComDevice> util = new ExcelUtil<>(ComDevice.class);
        List<ComDevice> dataManagementList = util.importExcel(file.getInputStream());
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        String operName = loginUser.getUsername();
        String message = comDeviceService.importData(dataManagementList, updateSupport, operName);
        return AjaxResult.success(message);
    }
    @GetMapping("/importTemplate")
    public AjaxResult importTemplate()
    {
        ExcelUtil<ComDevice> util = new ExcelUtil<>(ComDevice.class);
        return util.importTemplateExcel("案卷数据");
    }



    /**
     * 查询设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('device:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(ComDevice comDevice)
    {
        startPage();
        List<ComDevice> list = comDeviceService.selectComDeviceList(comDevice);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('device:device:export')")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ComDevice comDevice)
    {
        List<ComDevice> list = comDeviceService.selectComDeviceList(comDevice);
        ExcelUtil<ComDevice> util = new ExcelUtil<ComDevice>(ComDevice.class);
        util.exportExcel(response, list, "设备管理数据");
    }

    /**
     * 获取设备管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('device:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(comDeviceService.selectComDeviceById(id));
    }

    /**
     * 新增设备管理
     */
    @PreAuthorize("@ss.hasPermi('device:device:add')")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ComDevice comDevice)
    {
        return toAjax(comDeviceService.insertComDevice(comDevice));
    }

    /**
     * 修改设备管理
     */
    @PreAuthorize("@ss.hasPermi('device:device:edit')")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ComDevice comDevice)
    {
        return toAjax(comDeviceService.updateComDevice(comDevice));
    }

    /**
     * 删除设备管理
     */
    @PreAuthorize("@ss.hasPermi('device:device:remove')")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(comDeviceService.deleteComDeviceByIds(ids));
    }
}
