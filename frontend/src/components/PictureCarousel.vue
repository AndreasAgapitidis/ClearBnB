<template>
  <div class="slideshow">
    <img
      v-if="carouselprop"
      :src="carouselprop.images[count]"
      alt="photo of the listing"
    />
  </div>
  <button class="btn-left" @click="prevIndex">Prev</button>
  <button class="btn-right" @click="nextIndex">Next</button>
  <!-- <div class="slider"> -->
  <!-- <div
      v-for="(imgUrl, index) in carouselprop.images"
      v-show="index === count"
      :key="index"
      class="slideshow"
    >
      <a href="#">
        <img :src="imgUrl" />
      </a>
    </div> -->
  <!-- </div> -->
</template>

<script>
export default {
  // name: "Slider",

  props: ["carouselprop"],

  methods: {
    prevIndex() {
      this.count = this.count - 1;
      if (this.count < 0) {
        this.count = 2;
      }
      console.log(this.count);
    },

    nextIndex() {
      this.count = this.count + 1;
      if (this.count > 2) {
        this.count = 0;
      }
    },
  },

  data() {
    return {
      count: 0,
      img: [], // ['http://i.imgur.com/1.jpg', 'http://i.imgur.com/2.jpg'] ==================================
      // BUT HOW TO DEAL WITH IT when having object arraylist?
      // listing1.img does not work

      // listing.images, through props already fetched all ImageURL, do i still need img:[]?
      // child component, props of props?
    };

    // this.img = listing.images; ??
  },

  // async created() {
  // await this.$store.dispatch("fetchListings");
  // for (let listing of this.$store.state.listings) {
  //   if (listing.id == this.$route.params.id) {
  //     this.listing1 = listing;
  //   }
  // },
};
</script>

<style scoped>
img {
  height: 300px;
  width: 100vw;
  object-fit: cover;
  position: absolute;
  top: 0;
  left: 0;
  border: 1px red solid;
  z-index: 3;
}

button {
  padding: 5px;
  margin: 10px 10px 10px 10px;
  border-radius: 10%;
  border-style: none;
  border: 2px solid gray;
}
</style>