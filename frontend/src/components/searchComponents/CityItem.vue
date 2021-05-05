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
  padding: 12px;
}
</style>