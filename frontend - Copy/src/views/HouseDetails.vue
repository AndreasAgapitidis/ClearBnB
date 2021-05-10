<template>
  <PictureCarousel />
  <DetailInfo />
  <BookingSelectables />
  <Cheapest />
  <StudentText />
</template>

<script>
import PictureCarousel from "../components/PictureCarousel.vue";
import DetailInfo from "../components/DetailInfo.vue";
import BookingSelectables from "../components/BookingSelectables.vue";
import Cheapest from "../components/Cheapest.vue";
import StudentText from "../components/StudentText.vue";

export default {
  async created() {
    // this.$store.dispatch("getListingInfo");
    console.log("attached");
  },

  components: {
    PictureCarousel,
    DetailInfo,
    BookingSelectables,
    Cheapest,
    StudentText,
  },
};
</script>

<style>
</style>