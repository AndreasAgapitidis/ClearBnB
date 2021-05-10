<template>
  <PictureCarousel v-bind:carouselprop="listing1" />
  <DetailInfo v-bind:detailprop="listing1" />
  <BookingSelectables v-bind:detailprop="listing1" />
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
    // await this.$store.dispatch("fetchListings");
    // for (let listing of this.$store.state.listings) {
    //   if (listing.id == this.$route.params.id) {
    //     this.listing1 = listing;

    let res = await fetch("/rest/listings/" + this.$route.params.id);
    this.listing1 = await res.json();

    // console.log(this.$store.state.listings);
    // only 1 empty listing?
    // for (let listing of this.$store.state.listings) {
    //   if (listing.id == this.$route.params.id) {
    //     this.listing = listing;
    //   }
    // }
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