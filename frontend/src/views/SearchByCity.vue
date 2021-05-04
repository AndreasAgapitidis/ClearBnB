<template>
  <h1>HEEJ</h1>
  <SearchCityAndPickDate />
</template>

<script>
import SearchCityAndPickDate from "../components/SearchCityAndPickDate.vue";

export default {
  created() {
    this.$store.dispatch("getCities");
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