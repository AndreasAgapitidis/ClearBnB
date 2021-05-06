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

<style>
img {
  max-width: 100%;
}
</style>