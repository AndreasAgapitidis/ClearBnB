<template>
  <div class="card" @click="goToCityPage">
    <h1>{{ city.name }}</h1>
  </div>
</template>

<script>
export default {
  created() {
    console.log(this.$route);
  },
  props: ["city"],

  methods: {
    goToCityPage() {
      this.$router.push("/SearchByCity/" + this.city.id);
    },
  },
};
</script>

<style scoped>
.card {
  width: 200px;
  background: rgb(216, 216, 216);
}
.card:hover {
  background: rgb(255, 255, 255);
  cursor: pointer;
}
</style>