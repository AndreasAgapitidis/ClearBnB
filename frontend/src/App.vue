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
  components: {
    Header,
    Footer,
    Login,
    Signup,
  },
};
</script>

<style>
body {
  margin: 0px;
}

main{
  min-height: 100vh;
  position: relative;
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
