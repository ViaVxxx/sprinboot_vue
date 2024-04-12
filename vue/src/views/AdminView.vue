<template>

  <!-----搜索框----->
  <div>
    <el-input v-model="searchinfo" placeholder="输入搜索信息" style="width: 240px" clearable />
    <el-button style="margin-left: 20px" type="primary" @click="searchUser()">搜索</el-button>
    <el-button style="margin-left: 20px" type="warning" @click="OpenUserAddDialog">添加</el-button>
    <el-button style="margin-left: 20px" type="success" @click="searchUser()">刷新</el-button>
  </div>

  <!----添加用户对话框---->
  <user-add-dialog v-model="isDialogVisible" v-on:closeDialog="isDialogVisible = false"></user-add-dialog>

  <!-----用户列表---->
  <div style="margin-top: 30px">
    <el-table :data="tableData" stripe style="width: 80%">
      <el-table-column label="序号" type="index" width="80" />
      <el-table-column label="学号" prop="number" width="180" />
      <el-table-column label="姓名" prop="name" width="180" />
      <el-table-column label="性别" prop="gender" width="180" />
      <el-table-column
          label="身份"
          prop="role"
          width="180"
          :filters="[
              { text: '学生', value: '学生' },
              { text: '教师', value: '教师' },
              { text: '管理员', value: '管理员' },
              ]"
          :filter-method="filterTag"
          filter-placement="bottom-end"
      />

      <el-table-column label="操作" >
        <el-button size="small" type="text">编辑</el-button>
      </el-table-column>

    </el-table>
  </div>

  <!-----分页 ----->
  <div style="margin-top: 30px">
    <el-pagination
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[10, 20, 50, 100]"
        :small="small"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
    />
  </div>
</template>

<script>
// 引入组件
import request from '@/utils/request'
import UserAddDialog from '@/components/UserAddDialog.vue'

export default {
  components: {
    UserAddDialog
  },

  data() {
    return {
      searchinfo: '', // 搜索信息
      tableData: [], // 用户列表

      // 分页数据
      currentPage: 1,
      total: 0,
      pageSize: 10,

      // 是否显示添加用户对话框
      isDialogVisible: false,
      form: {
        number: '',
        name: '',
        role: ''
      },
      formLabelWidth: '120px'
    }

  },

  // 页面加载时做的事情，在created里面
  created() {
    this.loadTableData(); // 加载用户数据表格
  },

  methods: {
    // 加载用户数据
    loadTableData() {
      request.get("/admin/getUserPage", {
        params: {
          page: this.currentPage - 1,
          size: this.pageSize
        }
      }).then(response => {
        if (response.code === '0') {
          this.tableData = response.data.content;
          this.total = response.data.totalElements;
        } else {
          return this.$message.error('获取用户列表失败');
        }
      });
    },

    // 处理页码改变的事件
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
      this.loadTableData();
    },

    // 处理每页数量改变的事件
    handleSizeChange(pageSize) {
      this.pageSize = pageSize;
      this.loadTableData();
    },

    // 搜索用户
    searchUser() {
      let params = {
        name: this.searchinfo,
        number: this.searchinfo,
        gender: this.searchinfo
      };
      request.get("/admin/searchUser", {
        params: params
      }).then(response => {
        if (response.code === '0') {
          this.tableData = response.data;
        } else {
          return this.$message.error('搜索用户失败');
        }
      });
    },

    // 显示添加用户对话框
    OpenUserAddDialog() {
      this.isDialogVisible = true;
    }
  }
}
</script>