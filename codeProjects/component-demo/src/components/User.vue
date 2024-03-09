<template>
    <div>
        <a @click="fun" class="fa fa-star-o fa-1.9x"></a>
        <el-table
        :data="tableData"
        style="width: 100%"
        :row-class-name="tableRowClassName">
        <el-table-column
            prop="id"
            label="编号"
            width="180">
        </el-table-column>
        <el-table-column
            prop="username"
            label="姓名"
            width="180">
        </el-table-column>
        <el-table-column
            prop="phone"
            label="手机">
        </el-table-column>
        </el-table>
    </div>
</template>

<style>
  .el-table .warning-row {
    background: oldlace;
  }

  .el-table .success-row {
    background: #f0f9eb;
  }
</style>

<script>

  export default {
    methods: {
      tableRowClassName({row, rowIndex}) {
        if (rowIndex === 1) {
          return 'warning-row';
        } else if (rowIndex === 3) {
          return 'success-row';
        }
        return '';
      },
      fun() {
            
        }
    },
    data() {
      return {
        tableData: []
      }
    },
    created: function() {
        this.$http.get("/user/getUserList")
        .then((response) =>{
            this.tableData = response.data
            console.log("请求成功", this.tableData)
        })
    }
  }
</script>