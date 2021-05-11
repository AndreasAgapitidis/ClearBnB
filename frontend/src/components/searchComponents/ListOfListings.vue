<template>
<div class="card-Container">
  <RentalItem
    v-for="listing of listings"
    v-bind:key="listing.id"
    v-bind:listing="listing"
  />
  </div>
  
</template>

<script>
import RentalItem from "../RentalItem.vue";

export default {
  props: ["listings"],

  components: {
    RentalItem,
  },
};
</script>

<style scoped>
  .card-Container{
    margin: 3em 0 5em 0;
    overflow: scroll;
  }
</style>

