<template>
  {{ cities }}
</template>

<script>
export default {
  computed: {
    cities() {
      return this.$state.cities;
    },
  },
};
</script>

<style>
</style>