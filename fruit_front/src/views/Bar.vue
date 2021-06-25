<template>
  <div id="myChart" :style="{width:'800px',height:'600px'}"></div>
</template>

<script>
  export default {
    name: 'Echarts',
    data(){

    },
    mounted() {

      let _this = this
      axios.get('http://localhost:8181/fruit/barVO').then(function (resp) {
        let myChart = _this.$echarts.init(document.getElementById('myChart'))
        myChart.setOption({
          xAxis: {
            type: 'category',
            data: resp.data.names
          },
          yAxis: {
            type: 'value'
          },
          series: [{
            data: resp.data.values,
            type: 'bar'
          }]
        })
      })


    }
  }

</script>
