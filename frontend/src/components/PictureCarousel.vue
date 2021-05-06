<template>
  <div class="slider">
    <p>This is carousel component</p>
    <p>{{ listing.city }}</p>
    <!-- <p>{{ listingprop.beds }}</p> -->
    <!-- {{ listing }} -->

    <span class="btn-left" @click="prevIndex"></span>
    <div
      v-for="(imgUrl, index) in listing.images"
      v-show="index === count"
      :key="index"
      class="slideshow"
    >
      <a href="#">
        <img :src="imgUrl" />
      </a>
    </div>
  </div>
</template>

<script>
export default {
  // name: "Slider",

  props: ["listing"],

  methods: {
    prevIndex() {
      this.count = this.count - 1;
      if (this.count < 0) {
        this.count = 2;
      }
      console.log(this.count);
    },

    data() {
      return {
        listing1: null,
        count: 0,
        img: [], // ['http://i.imgur.com/1.jpg', 'http://i.imgur.com/2.jpg'] ==================================
        // BUT HOW TO DEAL WITH IT when having object arraylist?
        // listing1.img does not work

        // listing.images, through props already fetched all ImageURL, do i still need img:[]?
        // child component, props of props?
      };

      // this.img = listing.images; ??
    },

    async created() {
      // await this.$store.dispatch("fetchListings");
      // for (let listing of this.$store.state.listings) {
      //   if (listing.id == this.$route.params.id) {
      //     this.listing1 = listing;
      //   }
    },
  },
};
</script>

<style>
</style>