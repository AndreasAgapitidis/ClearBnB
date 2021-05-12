import { createApp } from 'vue'
import App from './App.vue'
import store from './store.js'
import router from './router.js'
import VCalendar from 'v-calendar';

createApp(App)
  .use(store)
  .use(router)
  .use(VCalendar, {})
  .mount('#app')