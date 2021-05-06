<template>
  <!-- <p>{{ listing1.beds }}</p> -->
  <p>This is house details page</p>
  <p>This apartment has {{ listing1.beds }} beds</p>
  <p>This apartment is in {{ listing1.city }} city</p>
  <!-- <img :src="listing1.images[0]" alt="" /> -->
  <PictureCarousel v-bind:listing="listing1" />
  <DetailInfo />
  <BookingSelectables />
  <Cheapest />
  <StudentText />
  <!-- <button v-on:click="lista">aa</button> -->
</template>

<script>
import PictureCarousel from "../components/PictureCarousel.vue";
import DetailInfo from "../components/DetailInfo.vue";
import BookingSelectables from "../components/BookingSelectables.vue";
import Cheapest from "../components/Cheapest.vue";
import StudentText from "../components/StudentText.vue";
import Slider from "../components/PictureCarousel.vue";

export default {
  data() {
    return {
      listing1: null,
    };
  },

  components: {
    PictureCarousel,
    DetailInfo,
    BookingSelectables,
    Cheapest,
    StudentText,
    Slider,
  },

  async created() {
    // maybe try to fetch listing with id
    await this.$store.dispatch("fetchListings");
    for (let listing of this.$store.state.listings) {
      if (listing.id == this.$route.params.id) {
        this.listing1 = listing;
        console.log(listing);
        console.log(this.listing1);

        // console.log(this.$store.state.listings);
        // only 1 empty listing?
        // for (let listing of this.$store.state.listings) {
        //   if (listing.id == this.$route.params.id) {
        //     this.listing = listing;
        //   }
        // }
      }
    }
  },

  // mounted() {
  //   for (let listing of this.$store.state.listings) {
  //     if (listing.id == this.$route.params.id) {
  //       this.listing1 = listing;
  //       console.log(listing);
  //       console.log(listing1);

  //       //   await this.$store.dispatch("fetchListings");
  //       //   for (let listing of this.$store.state.listings) {
  //       //     if (listing.id == this.$route.params.id) {
  //       //       this.listing = listing;
  //       //       console.log(listing);
  //       //     }
  //       //    }
  //     }
  //   }
  // },
};
</script>

<style>
</style>