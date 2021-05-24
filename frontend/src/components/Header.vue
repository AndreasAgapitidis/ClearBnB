<template>
  <header>
    <nav class="container">
      <ul>
        <li>
          <a href="#">
            <img
              src="../assets/Logo ClearBnB/Company Logo/Logo.png"
              alt=""
              srcset=""
              @click="goToHomePage"
            />
          </a>
        </li>
        <li v-if="!$store.state.user">
          <a class="login-menu-item" @click="openLogin">Login</a>
        </li>
        <li v-else-if="$store.state.user.isAdmin === 'false'">
          <div class="profile-dropdown">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="28"
              height="28"
              fill="currentColor"
              class="bi bi-person-circle"
              viewBox="0 0 16 16"
            >
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
              <path
                fill-rule="evenodd"
                d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
              />
            </svg>
            <div class="profile-dropdown-content">
              <div></div>
              <div class="profile-menu">
                <div class="profile-menu-item">
                  <a @click="profile">Profile</a>
                </div>
                <div class="profile-menu-last-item">
                  <a @click="logout">Logout</a>
                </div>
              </div>
              <div></div>
            </div>
          </div>
        </li>
        <li v-else>
          <div class="profile-dropdown">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="28"
              height="28"
              fill="currentColor"
              class="bi bi-person-circle"
              viewBox="0 0 16 16"
            >
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
              <path
                fill-rule="evenodd"
                d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"
              />
            </svg>
            <div class="profile-dropdown-content">
              <div></div>
              <div class="profile-menu">
                <div class="profile-menu-item">
                  <a @click="admin">Admin</a>
                </div>
                <div class="profile-menu-last-item">
                  <a @click="logout">Logout</a>
                </div>
              </div>
              <div></div>
            </div>
          </div>
        </li>
      </ul>
    </nav>
  </header>
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
    openLogin() {
      document.getElementById("login-overlay").style.display = "flex";
    },
    logout() {
      this.$store.dispatch("logout");
    },
    goToHomePage() {
      let range = {
        start: "",
        end: "",
      };
      this.$store.dispatch("setBookingDates", range);
      this.$store.dispatch("setUsersCity", "");
      this.$store.dispatch("setChosenAmenities", []);
      this.$router.push("/");
    },
    profile() {
      this.$router.push("/Userpage");
    },
    admin() {
      this.$router.push("/admin");
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

header {
  background-image: url("../assets/Footer-Header/Header-final.png");
  height: 10em;
  text-align: center;
  color: #fafafa;
  display: flex;
  justify-content: center;
  font-family: "Roboto", sans-serif;
  font-weight: bold;
  width: 100vw;
  position: absolute;
  z-index: 1;
  top: 0;
}

.container {
  display: flex;
  width: 100%;
}

ul {
  width: 100%;
  margin: 0;
  height: 100px;
  padding: 5px;
  list-style: none;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
li:nth-child(1) {
  margin-left: 20px;
}
li:nth-child(2) {
  margin-right: 20px;
}
li:nth-child(2) > a {
  text-decoration: none;
  color: #fafafa;
  text-transform: uppercase;
}
header {
  background-image: url("../assets/Footer-Header/Header-final.png");
  height: 10em;
  text-align: center;
  color: #fafafa;
  display: flex;
  justify-content: center;
  font-family: "Roboto", sans-serif;
  font-weight: bold;
  width: 100%;
  position: absolute;
  z-index: 1;
}

img {
  height: 5em;
  width: 5em;
}

.login-menu-item {
  cursor: pointer;
  font-family: "Roboto", sans-serif;
}

.profile-menu {
  text-align: start;
}

.profile-menu-item {
  cursor: pointer;
  font-family: "Roboto", sans-serif;
  margin-bottom: 10px;
}

.profile-menu-last-item {
  cursor: pointer;
  font-family: "Roboto", sans-serif;
}

.profile-dropdown-content {
  display: none;
  position: absolute;
  background-color: #fafafa;
  min-width: 120px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  padding: 12px 16px;
  border-radius: 0 20px 0 20px;
  font-size: 1.1em;
  z-index: 1;
  color: black;
  right: 20px;
  grid-template-columns: auto auto auto;
}

.profile-dropdown:hover .profile-dropdown-content {
  display: grid;
}
</style>