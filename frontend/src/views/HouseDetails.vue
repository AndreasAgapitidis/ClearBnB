<template>
  <!-- a1 -->
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
    async getListingAndOwner() {
      let res = await fetch("/rest/listings/" + this.$route.params.id);
      this.listing1 = await res.json();

      let res2 = await fetch("/rest/findUserByID/" + this.listing1.owner);
      this.listingOwner = await res2.json();

      window.scrollTo(0, 0);
    },
  },
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