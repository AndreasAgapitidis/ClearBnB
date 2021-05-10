<template>
  <Header />
  <Login />
  <Signup />
  <main>
    <router-view />
  </main>
  <Footer />
</template>

<script>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";
import Login from "./components/Login.vue";
import Signup from "./components/Signup.vue";

export default {
  async created() {
    await this.$store.dispatch("fetchListings");
  },
  components: {
    Header,
    Footer,
    Login,
    Signup,
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

body {
  margin: 0px;
}

main {
  min-height: 100vh;
  position: relative;
}

#app {
  font-family: 'Roboto', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #181818;
  margin: 0px;
  box-sizing: border-box;
}
</style>
