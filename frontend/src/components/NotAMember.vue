<template>
  <div class="component2">
    <div class="userWrapper">
      <div class="userSignUp">
      <label for="userSignUp">Not a <span class="memberText">member?</span> <br>
      <span class="userText">With our lightningfast registration, you'll be a part of this amazing community in no time!</span>
      </label>
    </div>
    <button class="registerBtn" @click="openSignup">Register here</button>
    </div>
    <div class="picture"></div>
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

<style scoped>
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
  
  padding-inline: 2px 2px;
  font-style: italic;
  color: black;
  margin-bottom: 10px;
 
}

.memberText {
 text-decoration: underline;
 color: rgb(226, 99, 26);
}

.userText {
  font-weight: 200;
  font-size: 15px;
  
}
.userText{
    display: none;
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

@media only screen and (max-width: 320px){

   .component2{
     width: 100%;
     height: 250px;
    justify-content: center;
    align-items: center;
  }
  
  .userSignUp{
    margin-bottom: 3rem;
  }

  .userWrapper{
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  }
  
}

@media only screen and (min-width: 320px){
    .component2{
     width: 100%;
     height: 250px;
    justify-content: center;
    align-items: center;
  }

  .userWrapper{
    margin: 0 auto;
    height: 100%;
    display: flex;
    flex-flow: column;
    justify-content: space-evenly;
    align-items: center;
  }
}


@media only screen and (min-width: 576px){
 .userWrapper{
    margin: 0 auto;
    width: 90%;
    display: flex;
    flex-flow: row;
    justify-content: space-around;
    align-items: center;
  }

  .userSignUp{
    width: 50%;
    margin: 0;
    
  }

  .userText{
    display:initial;
  }
  
}


@media only screen and (min-width: 992px){

  .component2{
    width: 85%;
    margin: 0 auto;
  }

   .picture{
    background-image: url('https://www.leeds.ac.uk/images/students_1_1.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    height: 100%;
    width: 100%;
    flex: 1;
  }

  .userWrapper{
    height: 100%;
    flex-flow: column;
    justify-content: space-around;
    flex: 1;
  }
}
@media screen and (min-width: 992px){}

</style>