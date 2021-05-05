<template>
 <Header />
  <main>
    <router-view />
  </main>
 
<Footer />

 
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'



export default {
  async created() {
    let res = await fetch('/rest/hello')
    let message = await res.json()
    console.log(message);
  },
  components: {
    Header,
    Footer
  }
}
</script>

<style>

body{
  margin: 0px;
}

main{
  height: 100vh;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #181818;
  margin: 0px;
  box-sizing: border-box;
}
</style>
