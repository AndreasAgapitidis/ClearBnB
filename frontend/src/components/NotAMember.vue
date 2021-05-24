<template>
  <div class="component2">
    <div class="userSignUp">
      <label for="userSignUp">Not a <span>member?</span></label>
    </div>
    <button class="registerBtn" @click="openSignup">Register here</button>
  </div>
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
    openSignup() {
      document.getElementById("signup-overlay").style.display = "flex";
    },
    logout() {
      this.$store.dispatch("logout");
    },
  },
}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');

.component2 {
  font-family: 'Roboto', sans-serif;
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
 height: 250px;
 width: 100%;
}

.userSignUp {
  font-size: 20px;
  font-weight: 200px;
  padding-inline: 2px 2px;
  font-style: italic;
  color: black;
  margin-bottom: 10px;
}

.userSignUp > label > span {
 text-decoration: underline;
 color: rgb(226, 99, 26);
}



.registerBtn {
  font-family: 'Roboto', sans-serif;
  height: 2em;
  letter-spacing: 1px;
  width: 10em;
  border-radius: 50px;
  background-color: rgb(37, 37, 37);
  color: white;
  font-weight: 200;
  font-size: 16px;
  cursor: pointer;
  box-shadow: 3px 3px 3px black;
}

@media screen and (max-width: 320px){
  .component2{
    flex-direction: column;
    justify-content: center;
  }
  .userSignUp{
    margin-bottom: 3rem;
  }
  
}
</style>