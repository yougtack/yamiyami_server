<template>
  <div id="app">
    <Header></Header>
    <router-view></router-view>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "./components/header.vue";
import Footer from "./components/footer.vue";
import Insert from "./components/insert.vue";
import Login from "./components/login.vue";
import Index from "./components/index.vue";
import SignUp from "./components/signUp.vue";
import SearchList from './components/searchList.vue'

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
