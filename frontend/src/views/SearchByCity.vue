<template>
  <h1>HEEJ</h1>
  <SearchCityAndPickDate />
</template>

<script>
import SearchCityAndPickDate from "../components/SearchCityAndPickDate.vue";

export default {
  created() {
    console.log("SearchByCity created");
    this.$store.dispatch("fetchCities");
  },

  data() {
    return {};
  },

  components: {
    SearchCityAndPickDate,
  },
};
</script>

<style>
</style>