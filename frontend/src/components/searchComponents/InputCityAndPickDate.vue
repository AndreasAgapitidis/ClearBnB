<template>
  <div class="inputCityAndDateContainer">
    <h2>Sök stad:</h2>
    <input v-model="userSearchedFor" type="text" placeholder="Search city:" />
    <div class="searchResults" v-if="userSearchedFor">
      <CityItem
        v-for="city of cities"
        v-bind:key="city.id"
        v-bind:city="city"
      />
    </div>
    <div>
      <p>Incheckning</p>
      <input type="date" name="Arrival date" id="" />
      <p>Utcheckning</p>
      <input type="date" name="Arrival date" id="" />
    </div>
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
* {
  box-sizing: border-box;
}

.inputCityAndDateContainer {
  width: 200px;
  margin: auto;
}

.searchResults {
  background: rgb(252, 252, 252);
  border: solid 1px gray;
  max-height: 300px;
  z-index: 10;
}

input {
  width: 200px;
  max-width: 100%;
  padding: 10px;
}
</style>