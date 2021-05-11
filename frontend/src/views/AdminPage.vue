<template>
  <div class="adminContainer">
    <h1>Admin Page</h1>
    <div class="buttonsContainer">
      <button @click="whatToRender">All users</button>
      <button @click="whatToRender">Search user</button>
      <button @click="whatToRender">Add listing</button>
    </div>

    <GetAllUsers v-if="printAllUsers" />
    <SearchUser v-if="searchOneUser" />
    <AddListing v-if="addListing" />
  </div>
</template>

<script>
import GetAllUsers from "../components/adminComponents/GetAllUsers.vue";
import SearchUser from "../components/userComponents/SearchUser.vue";
import AddListing from "../components/adminComponents/AddListing.vue";

export default {
  data() {
    return {
      printAllUsers: false,
      searchOneUser: false,
      addListing: false,
    };
  },

  components: {
    GetAllUsers,
    SearchUser,
    AddListing,
  },
  methods: {
    whatToRender(event) {
      this.putAllToFalse();

      switch (event.target.innerText) {
        case "All users":
          this.printAllUsers = true;
          break;
        case "Search user":
          this.searchOneUser = true;
          break;
        case "Add listing":
          this.addListing = true;
          break;
      }
    },
    putAllToFalse() {
      this.printAllUsers = false;
      this.searchOneUser = false;
      this.addListing = false;
    },
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
.buttonsContainer {
  display: flex;
  margin: 10px;
  justify-content: center;
}
button {
  margin-left: 10px;
}
</style>