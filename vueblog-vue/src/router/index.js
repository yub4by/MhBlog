import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Blogs from '../views/Blogs'
import Detail from '../views/BlogDetail'
import Edit from '../views/BlogEdit'

Vue.use(VueRouter)


//以下route的配置顺序要严格，防止错误匹配
const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: {name: "Blogs"}
  },
  {
    path: '/blogs',
    name: 'Blogs',
    component: Blogs
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/blog/add',
    name: 'Add',
    component: Edit,
    meta: {
      //设置权限，需要登录才能访问，搭配permission.js
      requireAuth: true
    }
  },
  {
    path: '/blog/:blogId',
    name: 'Detail',
    component: Detail
  },
  {
    path: '/blog/:blogId/edit',
    name: 'Edit',
    component: Edit,
    meta: {
      //设置权限，需要登录才能访问
      requireAuth: true
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
