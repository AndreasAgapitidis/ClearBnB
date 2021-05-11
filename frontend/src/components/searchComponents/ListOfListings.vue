<template>
  <RentalItem
    v-for="listing of listings"
    v-bind:key="listing.id"
    v-bind:listing="listing"
    v-on:click="navToBooking(listing)"
  />
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
      this.$router.replace("/house_details/" + listing.id);
    },
  },
};
</script>

<style>
</style>

