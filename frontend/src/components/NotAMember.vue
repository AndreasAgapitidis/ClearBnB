<template>
  <div class="component2">
    <div class="userSignUp">
      <label for="userSignUp">Not a member?</label>
    </div>
    <button class="registerBtn">Register here</button>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

.component2 {
  font-family: Roboto, sans-serif;
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 10%;
  margin-left: 10%;
  margin-right: 10%;
  margin-top: 10%;
}

.userSignUp {
  font-size: 24px;
  font-weight: 200px;
  padding-inline: 2px 2px;
  font-style: italic;
  color: black;
  margin-bottom: 10px;
}

.registerBtn {
  height: 50px;
  width: 180px;
  border-radius: 50px;
  background-color: rgb(37, 37, 37);
  color: white;
  font-weight: 100;
  font-size: 16px;
  cursor: pointer;
}
</style>