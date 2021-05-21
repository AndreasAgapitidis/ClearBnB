<template>
  <div class="card">
    <h3>{{ city.name }}</h3>
  </div>
  
</template>

<script>

export default {
  props: ["city"],

  methods: {},
};
</script>

<style scoped>
.card {
  max-width: 180px;
  text-align: left;
  margin-left: 10px;
}

h3 {
  letter-spacing: 1px;
  font-size: 20px;
}

.card:hover {
  cursor: pointer;
  transform: scale(1.03);
}
</style>