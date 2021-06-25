<template>
  <el-form ref="form" :rules="rules" :model="fruit" label-width="80px">
    <el-form-item label="水果ID">
      <el-input v-model="fruit.id" ></el-input>
    </el-form-item>
    <el-form-item label="名称" prop="name">
      <el-input v-model="fruit.name" ></el-input>
    </el-form-item>
    <el-form-item label="销量" prop="sale">
      <el-input v-model.number="fruit.sale" ></el-input>
    </el-form-item>
    <el-form-item label="图片" prop="icon">
      <el-input v-model="fruit.icon" ></el-input>
    </el-form-item>


    <el-form-item>
      <el-button type="primary" @click="onSubmit">立即添加</el-button>
      <el-button>取消</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "Edit",
  data(){
    return {
      fruit: {
        name:'',
        sale:'',
        icon:''
      },
      rules: {
        name: [
          {required:true, message:'请输入水果名称', trigger:'blur'}
        ],
        sale: [
          {required:true, message:'请输入销量', trigger:'blur'},
          {type:'number',message: '销量必须为数字'}
        ],
        icon: [
          {required:true, message:'请输入图片链接', trigger:'blur'},
        ]
      }
    }
  },
  created(){

  },
  methods: {
    onSubmit(formName){
      let _this = this
      axios.post('http://localhost:8181/fruit/add', this.fruit).then(function (response) {
        if (response.data){
          _this.$alert(_this.fruit.name+'添加成功','添加数据',{
            confirmButtonText: '确定',
            callback: action => {
              _this.$router.push('/table')
            }
          })
        }
      })
    }
  }
}
</script>

<style scoped>

</style>