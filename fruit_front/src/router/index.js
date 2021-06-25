import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Pie from "../views/Pie";
import Table from "../views/Table";
import Edit from "../views/Edit";
import Add from "../views/Add";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/bar',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/Bar.vue')
  },
  {
    path: '/pie',
    component: Pie
  },
  {
    path: '/table',
    component: Table
  },
  {
    path: '/edit',
    component: Edit
  },
  {
    path: '/add',
    component: Add
  }
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
