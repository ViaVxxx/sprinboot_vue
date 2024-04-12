<template>

  <div id="app">
    <el-container>
      <!-----标题----->
      <el-header style="background-color: #026dc5">
        <h1 style="color: #fff;font-size: 20px;font-weight: 600;left: 20px;top: 50%">
          课堂点名系统
        </h1>
      </el-header>
    </el-container>

    <el-container>

      <!-----左侧栏----->
      <el-aside style="overflow: hidden;min-height: 100vh;width: 200px;background-color: #6ea4f3">

        <!-----左侧栏菜单----->
        <el-menu
          active-text-color="#ffd04b"
          background-color="#5484ce"
          class="el-menu-vertical-demo"
          default-active="$route.path"
          router
          text-color="#fff"
          @close="handleClose"
          @open="handleOpen"
        >
          <!-----首页----->
          <el-menu-item index="/">
            <el-icon>
              <icon-menu />
            </el-icon>
            <span>首页</span>
          </el-menu-item>

          <!-----个人信息----->
          <el-menu-item index="Info">
            <el-icon>
              <setting />
            </el-icon>
            <span>个人信息</span>
          </el-menu-item>

          <!-----功能----->
          <el-sub-menu index="3">
            <template #title>
              <el-icon>
                <location />
              </el-icon>
              <span>功能</span>
            </template>
            <el-menu-item index="Course">课程管理</el-menu-item>
            <el-menu-item index="Naming">点名（教师）</el-menu-item>
            <el-menu-item index="Users">用户管理（管理员）</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-aside>

      <!-----主要内容----->
      <el-main>

        <router-view />
      </el-main>
    </el-container>
  </div>
</template>
<script lang="ts">
</script>

<style>
.el-menu {
  border-right: none;
}

</style>