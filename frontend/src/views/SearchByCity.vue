<template>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <div class="SearchByCity-Bg">
    <InputCityAndPickDate />

    <h2>Amenities</h2>
    <div class="amenitiesOptions">
      <Amenities />
    </div>
  </div>

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
@media only screen and (min-device-width: 320px) and (max-device-width: 576px) {
  * {
    box-sizing: border-box;
  }
  .SearchByCity-Bg {
    width: 100vw;
    margin: auto;
    position: relative;
    background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
      url("../assets/Banner-Pictures/Malmö-Header.jpg");
    background-repeat: no-repeat;
    background-size: cover;
  }

  h2 {
    color: white;
    text-shadow: 2px 2px 2px black;
    background-color: palegreen;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
    margin-bottom: 2%;
  }
}

@media only screen and (min-device-width: 576px) and (max-device-width: 992px) {
  * {
    box-sizing: border-box;
  }
  .SearchByCity-Bg {
    width: 100vw;
    margin: auto;
    position: relative;
    background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
      url("../assets/Banner-Pictures/Malmö-Header.jpg");
    background-repeat: no-repeat;
    background-size: cover;
  }

  h2 {
    color: white;
    text-shadow: 2px 2px 2px black;
    background-color: orangered;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
    margin-bottom: 2%;
  }
}

@media only screen and (min-device-width: 992px) {
  * {
    box-sizing: border-box;
  }
  .SearchByCity-Bg {
    width: 100vw;
    margin: auto;
    position: relative;
    background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
      url("../assets/Banner-Pictures/Malmö-Header.jpg");
    background-repeat: no-repeat;
    background-size: cover;
  }

  h2 {
    color: white;
    text-shadow: 2px 2px 2px black;
    background-color: orchid;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
    margin-bottom: 2%;
  }
}
</style>