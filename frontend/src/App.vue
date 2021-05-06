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
    await this.$store.dispatch("fetchListings");
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
