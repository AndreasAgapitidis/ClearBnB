import { createRouter, createWebHistory } from 'vue-router'

// import views
import Home from './views/Home.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home
    }
  ]
})