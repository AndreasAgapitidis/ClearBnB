<template>
  <!-- a -->
  <div v-if="isAdmin" class="adminContainer">
    <h1>Admin Page</h1>
    <div class="buttonsContainer">
      <div>
        <button v-if="!summary" @click="whatToRender">Summary</button>
        <button v-else class="isClicked" @click="whatToRender">Summary</button>
      </div>
      <div>
        <button v-if="!printAllUsers" @click="whatToRender">All users</button>
        <button v-else class="isClicked" @click="whatToRender">
          All users
        </button>
      </div>
      <div>
        <button v-if="!searchOneUser" @click="whatToRender">Search user</button>
        <button v-else class="isClicked" @click="whatToRender">
          Search user
        </button>
      </div>
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
    AdminSummary,
    GetAllUsers,
    SearchUser,
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
    isAdmin: async function () {
      if (!this.$store.state.user) {
        await this.$store.dispatch("whoAmI");
      }
      if (
        !this.$store.state.user ||
        !(this.$store.state.user.isAdmin === "true")
      ) {
        this.$router.push("/");
        return false;
      }
      return true;
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
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  margin: auto;
  padding: 20px 1em 20px 1em;
  max-width: 600px;
}

button,
.isClicked {
  width: 100%;
  height: 100%;
  background-color: #262626;
  border-radius: 0 22px 0 22px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  box-shadow: rgb(0 0 0 / 25%) 0px 14px 28px, rgb(0 0 0 / 22%) 0px 10px 10px;
  font-size: 20px;
}

.isClicked {
  background-color: rgb(185, 240, 222);
  color: black;
  box-shadow: none;
}

button:hover {
  background-color: rgb(185, 240, 222);
  color: black;
  cursor: pointer;
}
</style>