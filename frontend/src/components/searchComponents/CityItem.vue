<template>
  <div class="card">
    <img :src="city.images[0]" alt="" />
  </div>
</template>

<script>
export default {
  props: ["city"],
};
</script>

<style>
</style>