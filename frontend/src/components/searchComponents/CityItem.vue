<template>
  <div class="card">
    <h1>{{ city.name }} {{ city.id }}</h1>
  </div>
</template>

<script>
export default {
  created() {
    console.log(this.$route);
  },
  props: ["city"],
};
</script>

<style>
</style>