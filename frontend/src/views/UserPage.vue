<template>
 <div class="profileBanner"></div>
 
 <div class="profileBody">
    <div class="nameContainer">
      <ProfilePic />
      <ProfileName />
    </div>
    <div class="infoContainer">

    </div>
 </div>
 
</template>

<script>
import ProfilePic from '../components/userPageComponents/ProfilePic.vue'
import ProfileName from '../components/userPageComponents/ProfileName.vue'

export default {
  components: {
    ProfilePic,
    ProfileName
  }
}
</script>
    

<style>
.profileBanner{
  position: absolute;
  height: 300px;
  width: 100vw;
  background-image: url('https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/gettyimages-1178015487.jpg?crop=1.00xw:0.752xh;0,0.197xh&resize=1200:*');
  background-size: cover;
  background-repeat: no-repeat;
}
.profileBody{
  position: relative;
  width: 90%;
  margin: 0 auto;
  height: 100vh;
  border: 1px solid black;
}
.nameContainer{
  position: relative;
  top: 15em;
  height: auto;
  width: 100%;
  
}

.infoContainer{
 
  position: relative;
  height: 150px;
  width: 100px;
  border: 1px solid black;
}


</style>