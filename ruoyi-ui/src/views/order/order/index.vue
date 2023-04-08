<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="委托编号" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入委托编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工程名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入工程名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="委托单位" prop="projectCompany">
        <el-input
          v-model="queryParams.projectCompany"
          placeholder="请输入委托单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品名称" prop="sampleName">
        <el-input
          v-model="queryParams.sampleName"
          placeholder="请输入样品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="等级" prop="level">
        <el-input
          v-model="queryParams.level"
          placeholder="请输入等级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="规格" prop="specification">
        <el-input
          v-model="queryParams.specification"
          placeholder="请输入规格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="委托人" prop="client">
        <el-input
          v-model="queryParams.client"
          placeholder="请输入委托人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="受理人" prop="recipient">
        <el-input
          v-model="queryParams.recipient"
          placeholder="请输入受理人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="受理日期" prop="acceptanceDate">
        <el-input
          v-model="queryParams.acceptanceDate"
          placeholder="请输入受理日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测项目" prop="testItems">
        <el-input
          v-model="queryParams.testItems"
          placeholder="请输入检测项目"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="养护方式" prop="conservationMethod">
        <el-input
          v-model="queryParams.conservationMethod"
          placeholder="请输入养护方式"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="成型日期" prop="moldingDate">
        <el-input
          v-model="queryParams.moldingDate"
          placeholder="请输入成型日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品价格" prop="price">
        <el-input
          v-model="queryParams.price"
          placeholder="请输入样品价格"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['order:order:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['order:order:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['order:order:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['order:order:export']"
        >导出</el-button>
        <el-button
          type="success"
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
        >导入</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="orderList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="委托编号" align="center" prop="projectId" />
      <el-table-column label="样品编号" align="center" prop="sampleId" />
      <el-table-column label="样品小类" align="center" prop="sampleType" />
      <el-table-column label="工程名称" align="center" prop="projectName" />
      <el-table-column label="委托单位" align="center" prop="projectCompany" />
      <el-table-column label="样品名称" align="center" prop="sampleName" />
      <el-table-column label="等级" align="center" prop="level" />
      <el-table-column label="规格" align="center" prop="specification" />
      <el-table-column label="委托人" align="center" prop="client" />
      <el-table-column label="受理人" align="center" prop="recipient" />
      <el-table-column label="受理日期" align="center" prop="acceptanceDate" />
      <el-table-column label="检测项目" align="center" prop="testItems" />
      <el-table-column label="养护方式" align="center" prop="conservationMethod" />
      <el-table-column label="成型日期" align="center" prop="moldingDate" />
      <el-table-column label="样品价格" align="center" prop="price" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['order:order:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['order:order:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改委托单信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="委托编号" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入委托编号" />
        </el-form-item>
        <el-form-item label="工程名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="委托单位" prop="projectCompany">
          <el-input v-model="form.projectCompany" placeholder="请输入委托单位" />
        </el-form-item>
        <el-form-item label="样品名称" prop="sampleName">
          <el-input v-model="form.sampleName" placeholder="请输入样品名称" />
        </el-form-item>
        <el-form-item label="等级" prop="level">
          <el-input v-model="form.level" placeholder="请输入等级" />
        </el-form-item>
        <el-form-item label="规格" prop="specification">
          <el-input v-model="form.specification" placeholder="请输入规格" />
        </el-form-item>
        <el-form-item label="委托人" prop="client">
          <el-input v-model="form.client" placeholder="请输入委托人" />
        </el-form-item>
        <el-form-item label="受理人" prop="recipient">
          <el-input v-model="form.recipient" placeholder="请输入受理人" />
        </el-form-item>
        <el-form-item label="受理日期" prop="acceptanceDate">
          <el-input v-model="form.acceptanceDate" placeholder="请输入受理日期" />
        </el-form-item>
        <el-form-item label="检测项目" prop="testItems">
          <el-input v-model="form.testItems" placeholder="请输入检测项目" />
        </el-form-item>
        <el-form-item label="养护方式" prop="conservationMethod">
          <el-input v-model="form.conservationMethod" placeholder="请输入养护方式" />
        </el-form-item>
        <el-form-item label="成型日期" prop="moldingDate">
          <el-input v-model="form.moldingDate" placeholder="请输入成型日期" />
        </el-form-item>
        <el-form-item label="样品价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入样品价格" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 用户导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px">
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url + '?updateSupport=' + upload.updateSupport"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div class="el-upload__tip" slot="tip">
          <el-checkbox v-model="upload.updateSupport" />是否更新已经存在的用户数据
          <el-link type="info" style="font-size:12px" @click="importTemplate">下载模板</el-link>
        </div>
        <div class="el-upload__tip" style="color:red" slot="tip">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listOrder, getOrder, delOrder, addOrder, updateOrder } from "@/api/order/order";

import { getToken } from "@/utils/auth"

// 导入模板接口importTemplate
import { importTemplate } from "@/api/system/user";

export default {
  name: "Order",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 委托单信息表格数据
      orderList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        sampleType: null,
        projectName: null,
        projectCompany: null,
        sampleName: null,
        level: null,
        specification: null,
        client: null,
        recipient: null,
        acceptanceDate: null,
        testItems: null,
        conservationMethod: null,
        moldingDate: null,
        price: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 用户导入参数
      upload: {
        // 是否显示弹出层（用户导入）
        open: false,
        // 弹出层标题（用户导入）
        title: "",
        // 是否禁用上传
        isUploading: false,
        // 是否更新已经存在的用户数据
        updateSupport: 0,
        // 设置上传的请求头部
        headers: { Authorization: "Bearer " + getToken() },
        // 上传的地址(需要自己修改)
        url: process.env.VUE_APP_BASE_API + "/order/order/importData"
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询委托单信息列表 */
    getList() {
      this.loading = true;
      listOrder(this.queryParams).then(response => {
        this.orderList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        projectId: null,
        sampleId: null,
        sampleType: null,
        projectName: null,
        projectCompany: null,
        sampleName: null,
        level: null,
        specification: null,
        client: null,
        recipient: null,
        acceptanceDate: null,
        testItems: null,
        conservationMethod: null,
        moldingDate: null,
        price: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.sampleId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加委托单信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const sampleId = row.sampleId || this.ids
      getOrder(sampleId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改委托单信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.sampleId != null) {
            updateOrder(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addOrder(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const sampleIds = row.sampleId || this.ids;
      this.$modal.confirm('是否确认删除委托单信息编号为"' + sampleIds + '"的数据项？').then(function() {
        return delOrder(sampleIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('order/order/export', {
        ...this.queryParams
      }, `order_${new Date().getTime()}.xlsx`)
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = "用户导入";
      this.upload.open = true;
    },
    /** 下载模板操作 */
    importTemplate() {
      importTemplate().then(response => {
        this.download(response.msg);
      });
    },
    // 文件上传中处理
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true;
    },
    // 文件上传成功处理
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false;
      this.upload.isUploading = false;
      this.$refs.upload.clearFiles();
      this.$alert(response.msg, "导入结果", { dangerouslyUseHTMLString: true });
      this.getList();
    },
    // 提交上传文件
    submitFileForm() {
      this.$refs.upload.submit();
    }
  }
};
</script>
