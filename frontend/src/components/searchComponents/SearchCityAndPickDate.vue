<template>
  <h1>Sök stad:</h1>
  <input type="text" placeholder="Search city:" />
  <div>{{ cities }}</div>
</template>

<script>
import CityItem from "./CityItem.vue";

export default {
  mounted() {
    this.$store.dispatch("fetchCities");
  },

  computed: {
    cities() {
      return this.$store.state.cities;
    },
  },
  components: {
    CityItem,
  },
};
</script>

<style>
</style>