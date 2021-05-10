<template>
  <InputCityAndPickDate />
  <!-- <BookingCalendar /> -->
  <ListOfListings v-bind:listings="filteredListings" />
</template>

<script>
import InputCityAndPickDate from "../components/searchComponents/InputCityAndPickDate.vue";
import BookingCalendar from "../components/searchComponents/BookingCalendar.vue";
import ListOfListings from "../components/searchComponents/ListOfListings.vue";

export default {
  data() {
    return {
      filteredListings: [],
    };
  },

  components: {
    InputCityAndPickDate,
    BookingCalendar,
    ListOfListings,
  },

  computed: {
    listings() {
      return this.$store.state.listings;
    },
  },
};
</script>

<style scoped>
</style>