<template>
  <!-- a -->
  <div class="card-Container">
    <RentalItem
      v-for="listing of listings"
      v-bind:key="listing.id"
      v-bind:listing="listing"
      v-on:click="navToBooking(listing)"
    />
  </div>
</template>

<script>
import RentalItem from "../RentalItem.vue";

export default {
  props: ["listings"],

  components: {
    RentalItem,
  },

  methods: {
    navToBooking(listing) {
      this.$router.push("/house_details/" + listing.id);
    },
  },
};
</script>

<style scoped>
.card-Container {
  margin: 3em 0 5em 0;
  overflow: scroll;
  overflow-x: hidden;
}
</style>

