<template>
  <div class="carousel">
    <h1>hallo</h1>
  </div>
  <p>DUUUU</p>
</template>

<script>
export default {
  name: "Slider",
  data() {
    return {
      listing: null,
    };
  },
  // create runs before render, mount runs after render
  created() {
    console.log(this.$route.params.id);
    console.log(this.$store.state.listings);

    // loop store listings for matching listing
    for (let listing of this.$store.state.listings) {
      if (listing.id == this.$route.params.id) {
        this.listing = listing;
      }
    }
  },
};
</script>

<style>
</style>