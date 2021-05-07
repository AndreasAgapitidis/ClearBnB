<template>
  <div class="userCard">
    <img :src="user.profilePicture" alt="" />
    <h1>{{ user.firstName }} {{ user.lastName }}</h1>
  </div>
</template>

<script>
export default {
  props: ["user"],
};
</script>

<style scoped>
.userCard {
  height: 100px;
  background-image: linear-gradient(
    to right,
    rgb(118, 214, 243),
    rgb(253, 253, 253)
  );
  margin: 10px;
  border-radius: 0 40px 0 40px;
  display: grid;
  grid-template-columns: 5vw 50px 50vw;
  align-content: center;
  justify-items: center;
}
h1 {
  font-size: 20px;
  text-align: left;
}

img {
  display: flex;
  grid-column: 2;
  size: 100%;
}
</style>