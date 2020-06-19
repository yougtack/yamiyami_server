<template>
  <div id="app">
    <Header></Header>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
  import Header from "./components/Header.vue";
  import Footer from "./components/Footer.vue";
  import Insert from "./components/Insert.vue";
  import Login from "./components/Login.vue";
  import Index from "./components/Index.vue";
  import SignUp from "./components/SignUp.vue";
  import SearchList from './components/SearchList.vue';

  export default {
    components: {
      Header: Header,
      Footer: Footer,
      Insert: Insert,
      Login: Login,
      Index: Index,
      SignUp: SignUp,
      SearchList: SearchList
    }
  };
</script>
<style>
  @import "./assets/css.css";
</style>
