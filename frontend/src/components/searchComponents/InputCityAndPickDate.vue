<template>
  <div class="inputCityAndDateContainer">
    <div class="InputContainer">
      <h2>City</h2>
      <input v-model="userInput" type="text" placeholder="Search city:" />
      <h2>Check-in/out</h2>
      <Calendar />
    </div>

    <div class="searchResults" v-if="userInput">
      <CityItem
        v-for="city of cities"
        v-bind:key="city.id"
        v-bind:city="city"
        @click="autofill(city)"
      />
    </div>
  </div>
</template>

<script>
import CityItem from "./CityItem.vue";
import Calendar from "./BookingCalendar.vue";
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
    //Search for what the user inputed, from a fetched city list
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
    Calendar,
  },
  methods: {
    filterIntoUsersChoice(userSearchedFor) {
      this.newListing = [];

      this.$store.state.listings.filter((listing) => {
        if (listing.city == userSearchedFor) {
          this.newListing.push(listing);
        }
      });

      this.$parent.filteredListings = this.newListing;
    },

    autofill(city) {
      this.userSearchedFor = city.name;
      this.userInput = city.name;
      this.filterIntoUsersChoice(this.userSearchedFor);
    },

    /* clearTheSearchBox(city) {
      this.userSearchedFor = city.name;
      this.userInput = "";
      this.$emit("this.userSearchedFor"); 
      this.filterIntoUsersChoice(this.userSearchedFor);
    }, */
  },
};
</script>

<style scoped>
* {
  box-sizing: border-box;
}

.inputCityAndDateContainer {
  width: 100%;
  top: 4em;
  position: relative;
  height: 35em;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  justify-content: center;
  margin: 0 auto;
  background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
    url("https://www.sgbc.se/app/uploads/2020/05/V%C3%A4stra-Hamnen-Malm%C3%B6-Foto-Ossian-K-Olsson-1200x0-c-default.jpg");
  background-repeat: no-repeat;
  background-size: cover;
}

h2 {
  color: white;
}

.InputContainer {
  height: 300px;
  width: auto;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  margin-right: 1em;
  margin-bottom: 2em;
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
  width: 220px;
  height: 4em;
  font-weight: 200;
  justify-content: center;
  border: none;
  padding-left: 1em;
  border-radius: 0 20px 0 20px;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px,
    rgba(0, 0, 0, 0.22) 0px 10px 10px;
}

input:focus {
  outline: none;
}
</style>