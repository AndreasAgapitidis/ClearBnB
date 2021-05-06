<template>
  <div v-if="detailprop">
    <div class="Description">
      <h1>Description</h1>
      <p>{{ detailprop.description }}</p>
    </div>

    <div class="Details">
      <p>Price: {{ detailprop.price }}</p>
      <p>Rating: {{ detailprop.rating }}</p>
      <p>City: {{ detailprop.city }}</p>
      <p>Address: {{ detailprop.address }}</p>
      <p>Beds: {{ detailprop.beds }}</p>
      <p>Area: {{ detailprop.area }}</p>
      <p v-if="detailprop.house == true">Building Type: House</p>
      <p v-else-if="detailprop.apartment == true">Building Type: Apartment</p>
      <p>Owner: {{ detailprop.owner }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: ["detailprop"],
};
</script>

<style scoped>
body {
  display: grid;
}
.Description {
  color: blue;
}
</style>