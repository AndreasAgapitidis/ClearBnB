<template>
  <div class="SearchByCity-Bg">
    <InputCityAndPickDate />
    
  </div>
  <!-- <InputCityAndPickDate /> -->
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
};
</script>

<style scoped>
.SearchByCity-Bg {
  width: 100vw;
  margin: auto;
  position: relative;
  background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)), url('../assets/Banner-Pictures/Malmö-Header.jpg');
}
</style>