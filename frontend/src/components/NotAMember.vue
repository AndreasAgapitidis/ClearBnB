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
.component2 {
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
  font-weight: bold;
  padding-inline: 2px 2px;
  text-shadow: 3px 3px 3px grey;
  color: black;
  margin-bottom: 10px;
}

.registerBtn {
  height: 50px;
  width: 180px;
  border-radius: 20px;
  background-color: rgb(37, 37, 37);
  color: white;
  font-weight: bold;
  font-size: 16px;
  cursor: grab;
}
</style>