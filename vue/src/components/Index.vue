<template>
  <div class="index_img">
    <div>
      <span v-for="(item,i) in info" v-bind:key="i">
      <router-link to="/category"><img src="../assets/picture/1.png"></router-link>
      </span>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        info: null
      }
    },
    //https://api.coindesk.com/v1/bpi/currentprice.json
    //    /main/categories
    mounted() {
      this.$http.get('https://api.coindesk.com/v1/bpi/currentprice.json')
        .then(ex => this.info = ex)
    }
  }
</script>
