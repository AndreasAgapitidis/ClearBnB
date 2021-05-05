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
    this.$store.dispatch("fetchListings");
    this.$$store.dispatch("cities");
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #181818;
  margin-top: 60px;
}
</style>
