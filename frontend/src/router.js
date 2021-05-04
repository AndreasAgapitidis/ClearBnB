import { createRouter, createWebHistory } from 'vue-router'

// import views
import Home from './views/Home.vue'
import SearchByCity from './views/SearchByCity.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/SearchByCity',
      component: SearchByCity
    },
  ]
})