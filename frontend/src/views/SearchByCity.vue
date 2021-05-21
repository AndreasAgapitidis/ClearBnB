<template>

  <div class="SearchByCity-Bg">
    <InputCityAndPickDate />

     <div><h2>Amenities</h2></div>
      <Amenities />
    
  </div>
  <!-- <InputCityAndPickDate /> -->
  <!-- <BookingCalendar /> -->
  <ListOfListings v-bind:listings="filteredListings" />
 
</template>

<script>
import InputCityAndPickDate from "../components/searchComponents/InputCityAndPickDate.vue";
import BookingCalendar from "../components/searchComponents/BookingCalendar.vue";
import ListOfListings from "../components/searchComponents/ListOfListings.vue";
import Amenities from "../components/searchComponents/Amenities.vue";

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
    Amenities,
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

h2 {
  color: rgb(65, 64, 64);
  text-shadow: 2px 2px 2px white;
}
</style>