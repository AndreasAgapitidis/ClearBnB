<template>
  <InputCityAndPickDate />
  <ListOfListings v-bind:listings="listings" />
</template>

<script>
import InputCityAndPickDate from "../components/searchComponents/InputCityAndPickDate.vue";
import ListOfListings from "../components/searchComponents/ListOfListings.vue";

export default {
  components: {
    InputCityAndPickDate,
    ListOfListings,
  },

  computed: {
    listings() {
      return this.$store.state.listings;
    },
  },
};
</script>

<style>
</style>