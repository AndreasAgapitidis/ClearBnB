import { createRouter, createWebHistory } from 'vue-router'

// import views
import Home from './views/Home.vue'
import SearchByCity from './views/SearchByCity.vue'
import HouseDetails from './views/HouseDetails.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      name: "SearchByCity",
      path: '/SearchByCity',
      component: SearchByCity,
    },
    {
      path: '/SearchByCity/:id',
      component: SearchByCity,
    },
    {
      name: "details",
      path: '/house_details/:id',
      component: HouseDetails
    },
  ]
})