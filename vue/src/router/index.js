import Vue from 'vue'
import Router from 'vue-router'
import Home from '../components/index.vue'
import Insert from '../components/insert.vue'
import Login from '../components/login.vue'
import SignUp from '../components/signUp.vue'
import SearchList from '../components/searchList.vue'

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home
    },
    {
      path: '/Insert',
      name: 'Insert',
      component: Insert
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/SignUp',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/SearchList',
      name: 'SearchList',
      component: SearchList
    }
  ]
});
