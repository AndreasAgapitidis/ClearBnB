<template>
  <div v-if="isUser" class="profileBanner"></div>
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
      <p>Add new listing <button @click="openModal">+</button></p>
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

  methods: {
    openModal() {
      this.showPopUp = true;
      document.body.classList.add("modal-open");
    },
  },

  components: {
    ProfilePic,
    ProfileName,
    ProfileInfo,
    ProfileBookings,
    ProfileHouseApt,
    AddListingPopup,
  },
  computed: {
    isUser: async function() {
      if (!this.$store.state.user) {
        await this.$store.dispatch("whoAmI");
      }
      if (!this.$store.state.user || !(this.$store.state.user.isAdmin === 'false')) {
        this.$router.push('/')
        return false
      }
      return true
    }
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
  width: 85%;
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

@media only screen and (min-width: 320px){
  .divider{
    width: 85%;
    margin: 0 auto;
  }
  .reserv,
  .owned{
    width: 85%;
    margin: 0 auto;
    }

    .owned > p {
      font-size: 0.8rem;
    }
 
}
@media only screen and (min-width: 576px){
   .profileBanner{
    border-radius: 0px;
  }
  .nameContainer{
     width: 85%;
    margin: 0 auto;
    align-items: flex-start;
  }

  .reserv,
  .owned{
    width: 85%;
    margin: 0 auto;
    }

    .divider{
    width: 85%;
    margin: 0 auto;
  }
  .infoContainer{
    width: 85%;
    margin: 0 auto;
  }

  
    .owned > p {
      font-size: 1rem;
    }

}
@media only screen and (min-width: 992px){
  .profileBanner{
    border-radius: 0px;
  }

  .nameContainer{
    width: 85%;
    margin: 0 auto;
    align-items: flex-start;
  }

  .divider{
    width: 85%;
    margin: 0 auto;
  }

  .reserv,
  .owned{
    width: 85%;
    margin: 0 auto;
  }
  .infoContainer{
    width: 85%;
    margin: 0 auto;
  }
}

@media only screen and (min-width: 1200px){

  .profileBody{
    max-width: 1090px;
  }

}

</style>