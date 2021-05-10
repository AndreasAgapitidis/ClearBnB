<template>
  <div class="inputCityAndDateContainer">
    <h2>Sök stad:</h2>
    <input v-model="userInput" type="text" placeholder="Search city:" />
    <div class="searchResults" v-if="userInput">
      <CityItem
        v-for="city of cities"
        v-bind:key="city.id"
        v-bind:city="city"
        @click="clearTheSearchBox(city)"
      />
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
      userInput: "",
      userSearchedFor: "",
      newListing: [],
    };
  },

  computed: {
    //User input and search for it from a fetched city list
    cities() {
      if (this.userInput) {
        return this.$store.state.cities.filter((city) => {
          let name = city.name.toLowerCase();
          let userSearch = this.userInput.toLowerCase();

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
  methods: {
    clearTheSearchBox(city) {
      this.userSearchedFor = city.name;
      this.userInput = "";
      /* this.$emit("this.userSearchedFor"); */
      this.filterIntoUsersChoice(this.userSearchedFor);
    },

    filterIntoUsersChoice(userSearchedFor) {
      let filteredListings = this.$store.state.listings;

      this.newListing = [];

      filteredListings = this.$store.state.listings.filter((listing) => {
        if (listing.city == userSearchedFor) {
          this.newListing.push(listing);
        }
      });

      this.$parent.filteredListings = this.newListing;
    },
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

.HeroBanner2 {
  height: 200px;
  width: 200px;
  border: 1px solid black;
}
.inputCityAndDateContainer {
  width: 200px;
  margin: auto;
  position: relative;
  top: 10em;
}

.searchResults {
  background: rgb(252, 252, 252);
  border: solid 1px gray;
  max-height: 300px;
  z-index: 10;
  position: absolute;
  top: 86px;
  width: 100%;
}

input {
  width: 200px;
  max-width: 100%;
  font-weight: 200;
  margin: 2em 0;
  height: 2em;
  justify-content: center;
  border: none;
  padding: 10px;
  border-radius: 0 20px 0 20px;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px,
    rgba(0, 0, 0, 0.22) 0px 10px 10px;
}

input:focus {
  outline: none;
}

.cityTitle {
}
</style>