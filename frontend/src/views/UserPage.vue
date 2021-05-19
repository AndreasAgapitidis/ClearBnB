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
    <ProfileBookings />
    <ProfileHouseApt />
    
 </div>
 
</template>

<script>
import ProfilePic from '../components/userPageComponents/ProfilePic.vue'
import ProfileName from '../components/userPageComponents/ProfileName.vue'
import ProfileInfo from '../components/userPageComponents/ProfileInfo.vue'
import ProfileBookings from '../components/userPageComponents/ProfileBookings.vue'
import ProfileHouseApt from '../components/userPageComponents/ProfileHouseApt.vue'

export default {
  components: {
    ProfilePic,
    ProfileName,
    ProfileInfo,
    ProfileBookings,
    ProfileHouseApt
  }
}
</script>
    

<style scoped>
.profileBanner{
  height: 300px;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  background-image: linear-gradient(90deg ,#b92b27, #1565C0);;
  border-radius: 50%;
}
.profileBody{
  display: flex;
  flex-direction: column;
  width: 90%;
  margin: 0 auto;
  min-height: 100vh;
  
}
.nameContainer{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  top: -5em;
  height: auto;
  width: 100%;
  
}

.infoContainer{
  height: 150px;
  width: 100%;
}




</style>