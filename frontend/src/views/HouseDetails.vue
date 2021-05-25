<template>
  <PictureCarousel v-bind:carouselprop="listing1" />
  <DetailInfo v-bind:detailprop="listing1" v-bind:owner="listingOwner" />
  <BookingSelectables
    v-bind:detailprop="listing1"
    v-bind:owner="listingOwner"
  />
</template>

<script>
import PictureCarousel from "../components/PictureCarousel.vue";
import DetailInfo from "../components/DetailInfo.vue";
import BookingSelectables from "../components/BookingSelectables.vue";

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
  },

  methods: {
    /* async getOwner() {
      console.log("getOwner");
      let res = await fetch("/rest/findUserByID/" + this.listing1.owner);
      this.listingOwner = await res.json();
      console.log(this.listingOwner);
    }, */
    async getListingAndOwner() {
      let res = await fetch("/rest/listings/" + this.$route.params.id);
      this.listing1 = await res.json();

      let res2 = await fetch("/rest/findUserByID/" + this.listing1.owner);
      this.listingOwner = await res2.json();

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

body.modal-open {
  height: 100vh;
  overflow: hidden;
}
</style>