import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/Index.vue'
import Insert from '../components/Insert.vue'
import Login from '../components/Login.vue'
import SignUp from '../components/SignUp.vue'
import SearchList from '../components/SearchList.vue'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/home',
      name: 'home',
      component: Home
    },
    {
      path: '/insert',
      name: 'insert',
      component: Insert
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/member/signUp',
      name: '/member/signUp',
      component: SignUp
    },
    {
      path: '/searchList',
      name: 'searchList',
      component: SearchList
    }
  ]
});
