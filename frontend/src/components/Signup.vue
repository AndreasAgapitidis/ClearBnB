<template>
  <div id="signup-overlay">
    <a class="close-btn" @click="close">x</a>
    <div class="signup-container">
      <form @submit.prevent="register">
        <p id="signup-error-text">Email already has account</p>
        <input v-model="firstName" type="text" placeholder="first name" />
        <input v-model="lastName" type="text" placeholder="last name" />
        <input v-model="email" type="email" placeholder="email" />
        <input v-model="password" type="password" placeholder="password" />
        <button>Register</button>
      </form>
      <div class="login-prompt">
        <p>Already have an account?</p>
        <a @click="loginPage">Login</a>
      </div>
    </div>
  </div>
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
    async register() {
      let credentials = {
        firstName: this.firstName,
        lastName: this.lastName,
        email: this.email,
        password: this.password,
      };

      await this.$store.dispatch("register", credentials);

      // if login was successful, close the sign-up overlay
      if (this.$store.state.user) {
        this.close();
      } else {
        this.showErrorText();
      }
    },
    close() {
      this.hideErrorText();
      document.getElementById("signup-overlay").style.display = "none";
    },
    showErrorText() {
      document.getElementById("signup-error-text").style.display = "block";
    },
    hideErrorText() {
      document.getElementById("signup-error-text").style.display = "none";
    },
    loginPage() {
      this.close();
      document.getElementById("login-overlay").style.display = "flex";
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

#signup-overlay {
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

#signup-error-text {
  display: none;
  color: red;
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
  min-width: 214px;
}

input {
  margin-bottom: 6px;
}

button {
  margin-bottom: 6px;
}

.login-prompt {
  color: white;
}

.login-prompt p {
  margin-top: 10px;
  margin-bottom: 10px;
}

.login-prompt a {
  font-weight: bold;
  cursor: pointer;
}
</style>