<template>
  <RentalItem
    v-for="listing of listings"
    v-bind:key="listing.id"
    v-bind:listing="listing"
  />
</template>

<script>
import RentalItem from "../RentalItem.vue";

export default {
  props: ["listings"],

  components: {
    RentalItem,
  },
};
</script>

<style>
</style>