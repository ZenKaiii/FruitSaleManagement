<template>
  <el-table
      :data="tableData"
      border
      style="width: 100%">
    <el-table-column
        fixed
        prop="id"
        label="水果ID"
        width="150">
    </el-table-column>
    <el-table-column
        prop="name"
        label="水果名称"
        width="160">
    </el-table-column>
    <el-table-column
        prop="sale"
        label="水果销量"
        width="160">
    </el-table-column>
    <el-table-column
        prop="icon"
        label="图片"
        width="160">
      <template slot-scope="scope">
        <img :src="scope.row.icon" style="height: 70px">
      </template>
    </el-table-column>

    <el-table-column

        label="操作"
        width="100">
      <template slot-scope="scope">
        <el-button @click="fruitDelete(scope.row)" type="text" size="small">删除</el-button>
        <el-button @click="findFruit(scope.row)" type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  methods: {
    findFruit(row){
      this.$router.push('/edit?id='+row.id)
    },
    fruitDelete(row){

      let _this = this

      this.$confirm('是否确定删除'+row.name, '删除数据', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {

        axios.delete('http://localhost:8181/fruit/delete/'+row.id).then(function (response){
          if (response.data){
            _this.$alert(row.name+'删除成功', '删除数据', {
              confirmButtonText: '确定',
              callback: action => {
                location.reload()
              }
            })
          }
        })


      }).catch(() => {

      });


    }
  },
  created() {
    let _this = this
    axios.get('http://localhost:8181/fruit/list').then(function (reponse) {
      _this.tableData = reponse.data
    })
  },
  data() {
    return {
      tableData: null
    }
  }
}
</script>