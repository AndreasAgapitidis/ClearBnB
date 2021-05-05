<template>
  <form @submit.prevent="login">
    <input v-model="firstName" type="text" placeholder="first name" />
    <input v-model="lastName" type="text" placeholder="last name" />
    <input v-model="email" type="text" placeholder="email" />
    <input v-model="password" type="password" placeholder="password" />
    <button>Login</button>
  </form>
  <button @click="register">Register</button>
  <button @click="logout">Logout</button>
</template>

<script>
export default {
  data() {
    return {
      firstName: "",
      lastName: "",
      email: "",
      password: "",
    };
  },

  methods: {
    login() {
      let credentials = {
        email: this.email,
        password: this.password,
      };

      this.$store.dispatch("login", credentials);
    },

    register() {
      let credentials = {
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        password: this.password,
      };

      this.$store.dispatch("register", credentials);
    },

    logout() {
      this.$store.dispatch("logout");
    },
  },
};
</script>

<style scoped>
form {
  max-width: 300px;
  margin: auto;
}

input {
  width: 100%;
  margin-bottom: 10px;
}

button {
  margin-bottom: 10px;
}
</style>