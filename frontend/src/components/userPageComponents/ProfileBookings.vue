<template>
  <div class="reservations-Container">
    <h4>Reservations</h4>
    <div class="divider"></div>
    <ProfileBookingList />
  </div>
</template>

<script>

import ProfileBookingList from '../userPageComponents/ProfileBookingList.vue'

export default {
  
  components: {
    ProfileBookingList
  }
}
</script>

<style scoped>
.reservations-Container{

  margin: 3em auto;
  width: 100%;
  height: 30em;
  overflow: scroll;
}

.divider {
  width: 30%;
  height: 1px;
  background: #929292;
  margin-left: 10px;
}

h4{
  text-align: left;
  margin-left: 10px;
  margin-bottom: 3px;
}
</style>