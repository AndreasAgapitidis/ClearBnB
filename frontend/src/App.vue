<template>
  <header></header>

  <main>
    <router-view />
  </main>

  <footer></footer>
</template>

<script>
export default {
  async created() {
    let res = await fetch('/rest/hello')
    let message = await res.json()
    console.log(message);
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
