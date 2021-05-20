<template>
  <div class="profileBanner"></div>
  <div class="profileBody">
    <div class="nameContainer">
      <ProfilePic />
      <ProfileName />
    </div>
    <div class="infoContainer">
      <ProfileInfo />
    </div>
    <div class="reserv"><h4>Reservations</h4></div>
    <div class="divider"></div>
    <ProfileBookings />
    <div class="owned">
      <h4>Owned</h4>
      <p>Add new listing <button @click="showPopUp = true">+</button></p>
    </div>
    <div class="divider"></div>
    <ProfileHouseApt />
    <AddListingPopup v-if="showPopUp" />
  </div>
</template>

<script>
import ProfilePic from "../components/userPageComponents/ProfilePic.vue";
import ProfileName from "../components/userPageComponents/ProfileName.vue";
import ProfileInfo from "../components/userPageComponents/ProfileInfo.vue";
import ProfileBookings from "../components/userPageComponents/ProfileBookings.vue";
import ProfileHouseApt from "../components/userPageComponents/ProfileHouseApt.vue";
import AddListingPopup from "../components/userComponents/AddListingPopup.vue";

export default {
  data() {
    return {
      showPopUp: false,
    };
  },

  components: {
    ProfilePic,
    ProfileName,
    ProfileInfo,
    ProfileBookings,
    ProfileHouseApt,
    AddListingPopup,
  },
};
</script>
    

<style scoped>
.profileBanner {
  height: 300px;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  background-image: linear-gradient(90deg, #b92b27, #1565c0);
  border-radius: 50%;
}
.profileBody {
  display: flex;
  flex-direction: column;
  width: 90%;
  margin: 0 auto;
  min-height: 100vh;
}
.nameContainer {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  top: -5em;
  height: auto;
  width: 100%;
}

.infoContainer {
  width: 100%;
}

.divider {
  width: 40%;
  height: 1px;
  background: #929292;
  margin-left: 10px;
}

h4 {
  text-align: left;
 
}

.owned {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.owned > p {
  margin: 0;
}

button {
  width: 50px;
  height: 20px;
  background: rgb(16, 160, 16);
  border-radius: 50px;
  border: 1px solid black;
  cursor: pointer;
  color: #fafafa;
  font-size: 15px;
  font-weight: bold;
}
</style>