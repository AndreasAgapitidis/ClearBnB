import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/rest': 'http://localhost:4000', // same port as Java Express
      '/api': 'http://localhost:4000',
      'SearchByCity': 'http://localhost:4000',
    }
  }
})
