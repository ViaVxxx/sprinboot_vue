<template>
  <el-dialog v-model="dialogFormVisible" title="添加用户" width="500">
    <el-form :model="form">
      <el-form-item label="学号" :label-width="formLabelWidth">
        <el-input v-model="form.number" autocomplete="off" />
      </el-form-item>
      <el-form-item label="姓名" :label-width="formLabelWidth">
        <el-input v-model="form.name" autocomplete="off" />
      </el-form-item>

      <!----下拉选择框---->
      <el-form-item label="性别" :label-width="formLabelWidth">
        <el-select v-model="form.gender" placeholder="请选择性别">
          <el-option label="男" value="男" />
          <el-option label="女" value="女" />
        </el-select>
      </el-form-item>
      <el-form-item label="身份" :label-width="formLabelWidth">
        <el-select v-model="form.role" placeholder="请选择身份">
          <el-option label="学生" value="学生" />
          <el-option label="教师" value="教师" />
          <el-option label="管理员" value="管理员" />
        </el-select>
      </el-form-item>
    </el-form>

    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="submitForm()">添加</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
import request from '@/utils/request'

export default {
  data() {
    return {
      dialogFormVisible: false,
      form: {
        number: '',
        name: '',
        gender: '',
        role: ''
      },
      formLabelWidth: '120px'
    }
  },
  methods: {
    submitForm() {
      request.post('/admin/addUser', this.form)
          .then(response => {
            if (response.code === '0') {
              this.$message.success('添加用户成功');
              this.dialogFormVisible = false;
            } else {
              this.$message.error('添加用户失败');
            }
          });
    }
  }
}


</script>