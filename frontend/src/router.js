import { createRouter, createWebHistory } from 'vue-router'

// import views
import Home from './views/Home.vue'
import HouseDetails from './views/HouseDetails.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      name: "details",
      path: '/house_details/:id',
      component: HouseDetails
    }
  ]
})