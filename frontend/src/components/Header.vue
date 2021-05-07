<template>
  <header>
    <nav class="container">
      <ul>
        <li>
          <a href="#">
            <img
              src="../assets/Logo ClearBnB/Company Logo/Logo.png"
              alt=""
              srcset=""
            />
          </a>
        </li>
        <li v-if="!$store.state.user">
          <a class="login-logout" @click="openLogin">Login</a>
        </li>
        <li v-else>
          <a class="login-logout" @click="logout">Logout</a>
        </li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  async beforeCreate() {
    await this.$store.dispatch("whoAmI");
  },

  data() {
    return {};
  },

  methods: {
    openLogin() {
      document.getElementById("login-overlay").style.display = "flex";
    },
    logout() {
      this.$store.dispatch("logout");
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

header {
  background-image: url("../assets/Footer-Header/Header-final.png");
  height: 10em;
  text-align: center;
  color: #fafafa;
  display: flex;
  justify-content: center;
  font-family: "Roboto", sans-serif;
  font-weight: bold;
  width: 100%;
  position: absolute;
  z-index: 1;
  top: 0;
}

.container {
  display: flex;
  width: 100%;
}

ul {
  width: 100%;
  margin: 0;
  height: 100px;
  padding: 5px;
  list-style: none;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
li:nth-child(1) {
  margin-left: 20px;
}
li:nth-child(2) {
  margin-right: 20px;
}
li:nth-child(2) > a {
  text-decoration: none;
  color: #fafafa;
  text-transform: uppercase;
}

img {
  height: 5em;
  width: 5em;
}

.login-logout {
  cursor: pointer;
  font-family: "Roboto", sans-serif;
}
</style>