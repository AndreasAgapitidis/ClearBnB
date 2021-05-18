<template>
  <PictureCarousel v-bind:carouselprop="listing1" />
  <DetailInfo v-bind:detailprop="listing1" v-bind:owner="listingOwner" />
  <BookingSelectables v-bind:detailprop="listing1" />
  <Cheapest />
  <StudentText />
  <ConfirmationTemplate class="ConfirmationTemplate" />
  <!-- <button v-on:click="lista">aa</button> -->
</template>

<script>
import PictureCarousel from "../components/PictureCarousel.vue";
import DetailInfo from "../components/DetailInfo.vue";
import BookingSelectables from "../components/BookingSelectables.vue";
import Cheapest from "../components/Cheapest.vue";
import StudentText from "../components/StudentText.vue";
import ConfirmationTemplate from "../components/confirmationComponents/confirmationTemplate.vue";

export default {
  data() {
    return {
      listing1: null,
      listingOwner: null,
    };
  },

  //This is a special solution from Theodor. // Mac
  async beforeRouteEnter(to, from, next) {
    next((vm) => {
      vm.getListingAndOwner();
    });
  },

  components: {
    PictureCarousel,
    DetailInfo,
    BookingSelectables,
    Cheapest,
    StudentText,
    ConfirmationTemplate,
  },

  methods: {
    /* async getOwner() {
      console.log("getOwner");
      let res = await fetch("/rest/findUserByID/" + this.listing1.owner);
      this.listingOwner = await res.json();
      console.log(this.listingOwner);
    }, */
    async getListingAndOwner() {
      console.log("getListing");
      let res = await fetch("/rest/listings/" + this.$route.params.id);
      this.listing1 = await res.json();
      console.log(this.listing1);

      console.log("getOwner");
      let res2 = await fetch("/rest/findUserByID/" + this.listing1.owner);
      this.listingOwner = await res2.json();
      console.log(this.listingOwner);

      window.scrollTo(0, 0);
    },
  },

  async created() {
    // maybe try to fetch listing with id
    // await this.$store.dispatch("fetchListings");
    // for (let listing of this.$store.state.listings) {
    //   if (listing.id == this.$route.params.id) {
    //     this.listing1 = listing;
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
.ConfirmationTemplate {
  background: brown;
}
</style>