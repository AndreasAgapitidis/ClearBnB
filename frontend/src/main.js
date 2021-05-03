import { createApp } from 'vue'
import App from './App.vue'
import store from './store.js'
import router from './router.js'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

createApp(App)
  .use(store)
  .use(router)
  .use(BootstrapVue)
  .use(IconsPlugin)
  .mount('#app')
