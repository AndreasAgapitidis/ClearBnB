<template>
  <h1>Sök stad:</h1>
  <input v-model="userSearchedFor" type="text" placeholder="Search city:" />
  <div v-if="userSearchedFor">
    <CityItem v-for="city of cities" v-bind:key="city.id" v-bind:city="city" />
  </div>
</template>

<script>
import CityItem from "./CityItem.vue";

export default {
  mounted() {
    this.$store.dispatch("fetchCities");
  },

  data() {
    return {
      userSearchedFor: "",
    };
  },

  computed: {
    //User input and search for it from a fetched city list
    cities() {
      if (this.userSearchedFor) {
        return this.$store.state.cities.filter((city) => {
          let name = city.name.toLowerCase();
          let userSearch = this.userSearchedFor.toLowerCase();

          if (name.includes(userSearch)) {
            return city;
          }
        });
      } else {
        return this.$store.state.cities;
      }
    },
  },
  components: {
    CityItem,
  },
};
</script>

<style scoped>
input {
  padding: 10px;
  font-size: 120%;
}
</style>