<template>

  <div class="rentalCard">
    <!-- <p>{{ listing.city }}</p> --> 
    <img :src="listing.images[0]" alt="" />
  </div>
  
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
  margin: 1em auto;
  width: 80%;
  height: 100px;
  border-radius: 0 75px 0 75px;
  overflow: hidden;
  position: relative;
  top: 5em;
}

.rentalCard:hover {
  transform: scale(1.02);
  cursor: pointer;
}

img {
  
  width: 100%;
  height: 180px;
  object-fit: cover;
  object-position: center;
  opacity: 70%;
}
</style>