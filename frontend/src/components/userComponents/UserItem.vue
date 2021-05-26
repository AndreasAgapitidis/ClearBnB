<template>
  <div class="userCard">
    <img :src="user.profilePicture" alt="" />
    <ul>
      <li><b>name:</b> {{ user.firstName }} {{ user.lastName }}</li>
      <li><b>userId:</b> {{ user.id }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  props: ["user"],

  mounted() {},

  methods: {},
};
</script>

<style scoped>
.userCard {
  height: 100px;
  max-width: 600px;
  background-image: linear-gradient(
    to right,
    rgb(118, 214, 243),
    rgb(253, 253, 253)
  );
  margin: 10px auto;
  border-radius: 0 40px 0 40px;
  display: flex;
  align-items: center;
}

ul {
  list-style-type: none;
}

li {
  text-align: left;
}

img {
  display: flex;
  grid-column: 2;
  size: 100%;
  max-width: 50px;
  max-height: 50px;
  display: none;
  margin: 0 20px 0 40px;
  width: 50px;
  height: 50px;
}

@media (min-width: 576px) {
  li {
    font-size: 20px;
  }
  img {
    display: block;
  }
}
</style>