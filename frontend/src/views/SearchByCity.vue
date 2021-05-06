<template>
  <InputCityAndPickDate />
  <RentalItem
    v-for="listing of listings"
    v-bind:key="listing.id"
    v-bind:listing="listing"
  />
</template>

<script>
import InputCityAndPickDate from "../components/searchComponents/InputCityAndPickDate.vue";
import RentalItem from "../components/RentalItem.vue";

export default {
  data() {
    return {
      listings: {},
    };
  },

  components: {
    InputCityAndPickDate,
    RentalItem,
  },

  async created() {
    await this.$store.dispatch("fetchListings");
    this.listings = this.$store.state.listings;
  },
};
</script>

<style>
</style>