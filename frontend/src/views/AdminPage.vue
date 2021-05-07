<template>
  <div class="adminContainer">
    <h1>Admin Page</h1>
    <GetAllUsers />
    <SearchUser />
  </div>
</template>

<script>
import GetAllUsers from "../components/adminComponents/GetAllUsers.vue";
import SearchUser from "../components/userComponents/SearchUser.vue";

export default {
  components: {
    GetAllUsers,
    SearchUser,
  },
};
</script>

<style scoped>
.adminContainer {
  width: 100vw;
  position: relative;
  margin: auto;
  margin-top: 200px;
}
h1 {
  margin: auto;
  width: 100vw;
}
</style>