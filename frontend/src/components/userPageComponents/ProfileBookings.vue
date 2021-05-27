<template>

  <div class="reservations-Container">
    <ProfileBookingList />
  </div>
</template>

<script>
import ProfileBookingList from "../userPageComponents/ProfileBookingList.vue";

export default {
  components: {
    ProfileBookingList,
  },
};
</script>

<style scoped>
.reservations-Container {
  margin: 0em auto 3em auto;
  width: 100%;
  height: 20em;
  overflow: scroll;
  overflow-x: hidden;
}
</style>