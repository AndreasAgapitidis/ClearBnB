<template>
  <div class="card" @click="goToCityPage">
    <h3>{{ city.name }}</h3>
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
  max-width: 180px;
  text-align: left;
  margin-left: 10px;
}

.card:hover {
  cursor: pointer;
  transform: scale(1.03);
}
</style>