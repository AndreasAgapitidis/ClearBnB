<template>
  <div class="rentalCard"><img :src="listing.images[0]" alt="" /></div>
</template>

<script>
export default {
  props: ["listing"],

  data() {
    return {};
  },
};
</script>

<style scoped>
.rentalCard {
  margin: 20px auto;
  width: 80%;
  height: 180px;
  border-radius: 0 75px 0 75px;
  overflow: hidden;
}

img {
  width: 100%;
  height: 180px;
  object-fit: cover;
  object-position: center;
  opacity: 50%;
}
</style>