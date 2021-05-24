<template>
  <div v-if="isAdmin" class="adminContainer">
    <h1>Admin Page</h1>
    <div class="buttonsContainer">
      <button @click="whatToRender">Summary</button>
      <button @click="whatToRender">All users</button>
      <button @click="whatToRender">Search user</button>
      <button @click="whatToRender">Add listing</button>
      <button @click="whatToRender">Show pop up</button>
    </div>

    <AdminSummary v-if="summary" />
    <GetAllUsers v-if="printAllUsers" />
    <SearchUser v-if="searchOneUser" />
    <AddListing v-if="addListing" />
    <AddListingPopup v-if="showPopUp" />
  </div>
</template>

<script>
import GetAllUsers from "../components/adminComponents/GetAllUsers.vue";
import SearchUser from "../components/userComponents/SearchUser.vue";
import AddListing from "../components/adminComponents/AddListing.vue";
import AddListingPopup from "../components/userComponents/AddListingPopup.vue";
import AdminSummary from "../components/adminComponents/AdminSummary.vue";

export default {
  data() {
    return {
      summary: true,
      printAllUsers: false,
      searchOneUser: false,
      addListing: false,
      showPopUp: false,
    };
  },

  components: {
    GetAllUsers,
    SearchUser,
    AddListingPopup,
    AddListing,
    AdminSummary,
  },
  methods: {
    whatToRender(event) {
      this.putAllToFalse();

      switch (event.target.innerText) {
        case "Summary":
          this.summary = true;
          break;
        case "All users":
          this.printAllUsers = true;
          break;
        case "Search user":
          this.searchOneUser = true;
          break;
        case "Add listing":
          this.addListing = true;
          break;
        case "Show pop up":
          this.showPopUp = true;
          document.body.classList.add("modal-open");
          break;
      }
    },
    putAllToFalse() {
      this.summary = false;
      this.printAllUsers = false;
      this.searchOneUser = false;
      this.addListing = false;
      this.showPopUp = false;
    },
  },
  computed: {
    isAdmin: async function() {
      if (!this.$store.state.user) {
        await this.$store.dispatch("whoAmI");
      }
      if (!this.$store.state.user || !(this.$store.state.user.isAdmin === 'true')) {
        this.$router.push('/')
        return false
      }
      return true
    }
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