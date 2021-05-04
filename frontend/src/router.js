import { createRouter, createWebHistory } from 'vue-router'

// import views
import Home from './views/Home.vue'
import Auth from './components/Auth.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/auth',
      component: Auth
    }
  ]
})