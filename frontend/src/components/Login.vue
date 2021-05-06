<template>
  <div id="login-overlay">
    <a class="close-btn" @click="close">x</a>
    <div class="login-container">
      <form @submit.prevent="login">
        <input v-model="email" type="email" placeholder="email" />
        <input v-model="password" type="password" placeholder="password" />
        <button>Login</button>
      </form>
      <div class="signup-prompt">
        <p>Don't have an account?</p>
        <a @click="signUpPage">Sign-up</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
      password: "",
    };
  },

  methods: {
    async login() {
      let credentials = {
        email: this.email,
        password: this.password,
      };

      await this.$store.dispatch("login", credentials)
      
      // if login was successful, close the login overlay
      if (this.$store.state.user) {
        this.close()
      }
    },
    close() {
      document.getElementById("login-overlay").style.display = "none"
    },
    signUpPage() {
      this.close();
      document.getElementById("signup-overlay").style.display = "flex";
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

#login-overlay {
  position: fixed; /* Sit on top of the page content */
  display: none; /* Hidden by default */
  justify-content: center;
  align-items: center;
  width: 100%; /* Full width (cover the whole page) */
  height: 100%; /* Full height (cover the whole page) */
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.96); /* Black background with opacity */
  z-index: 2; /* Specify a stack order in case you're using a different order for other elements */
  cursor: pointer; /* Add a pointer on hover */
  font-family: "Roboto", sans-serif;
}

.close-btn {
  color: white;
  position: absolute;
  top: 8px;
  right: 16px;
  font-size: 24px;
  font-weight: bold;
}

form {
  display: grid;
}

input {
  margin-bottom: 6px;
}

button {
  margin-bottom: 6px;
}

.signup-prompt {
  color: white;
}

.signup-prompt p {
  margin-top: 10px;
  margin-bottom: 10px;
}

.signup-prompt a {
  font-weight: bold;
  cursor: pointer;
}
</style>