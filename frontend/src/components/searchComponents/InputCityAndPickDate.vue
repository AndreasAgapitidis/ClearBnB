<template>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <div class="inputCityAndDateContainer">
    <div class="InputContainer">
      <div
        class="autofill"
        @mouseenter="toggleShowAutoFill"
        @mouseleave="toggleShowAutoFill"
      >
        <h2>City</h2>
        <input
          v-model="userInput"
          type="text"
          placeholder="Search city:"
          @keyup.enter="goToCityPage"
        />
        <div class="searchResults" v-if="showAutoFill && userInput">
          <CityItem
            v-for="city of cities"
            v-bind:key="city.id"
            v-bind:city="city"
            @click="autofill(city), goToCityPage()"
          />
        </div>
      </div>
      <div class="CheckInContainer">
        <h2>Check-in/out</h2>
        <Calendar />
      </div>
    </div>
  </div>
</template>

<script>
import CityItem from "./CityItem.vue";
import Calendar from "./BookingCalendar.vue";

export default {
  async created() {
    await this.$store.dispatch("fetchCities");
    await this.$store.dispatch("fetchListings");
    this.filterIntoUsersChoice(this.$route.params.id);
  },

  data() {
    return {
      userInput: this.$store.state.usersCity,
      userSearchedFor: this.$store.state.usersCity,
      newListing: [],
      showAutoFill: false,
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
      this.$store.commit("setUsersCity", userSearchedFor);

      this.$parent.filteredListings = this.$store.state.listings.filter(
        (listing) =>
          (listing.city === this.$route.params.id || !this.$route.params.id) &&
          this.filterDate(listing) &&
          this.$store.state.chosenAmenities.every((element) => {
            return listing.amenities.includes(element);
          })
      );
    },

    autofill(city) {
      this.userSearchedFor = city.name;
      this.$store.commit("setUsersCity", this.userSearchedFor);
      this.userInput = city.name;
      this.filterIntoUsersChoice(this.userSearchedFor);
      this.showAutoFill = false;
    },

    goToCityPage() {
      if (this.inputIsCity(this.userInput) || this.userInput === "") {
        this.userInput = this.properCase(this.userInput);
        this.showAutoFill = false;
        this.$store.commit("setUsersCity", this.userInput);
        this.$router.push("/SearchByCity/" + this.userInput);
      } else {
        this.userInput = "";
        this.$parent.filteredListings = [];
      }
    },

    inputIsCity(input) {
      for (let i = 0; i < this.$store.state.cities.length; i++) {
        if (
          input.toLowerCase() === this.$store.state.cities[i].name.toLowerCase()
        ) {
          return true;
        }
      }

      return false;
    },

    properCase(name) {
      let proper = name.charAt(0).toUpperCase();
      for (let i = 1; i < name.length; i++) {
        proper += name.charAt(i).toLowerCase();
      }
      return proper;
    },

    toggleShowAutoFill() {
      this.showAutoFill = !this.showAutoFill;
    },

    filterDate(listing) {
      for (let i = 0; i < listing.unavailableDates.length; i++) {
        let date = new Date(listing.unavailableDates[i] * 1000);
        if (
          date >= this.$store.state.dateRange.start &&
          date <= this.$store.state.dateRange.end - 86400000
        ) {
          return false;
        }
      }

      return true;
    },
  },

  watch: {
    "$route.params.id": function () {
      this.filterIntoUsersChoice(this.$route.params.id);
    },
  },
};
</script>

<style scoped>
@media only screen and (min-device-width: 320px) and (max-device-width: 576px) {
  * {
    box-sizing: border-box;
  }

  .inputCityAndDateContainer {
    width: 100vw;
    top: 4em;
    position: relative;
    height: 30em;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    /*   background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
    url("https://www.sgbc.se/app/uploads/2020/05/V%C3%A4stra-Hamnen-Malm%C3%B6-Foto-Ossian-K-Olsson-1200x0-c-default.jpg");
  background-repeat: no-repeat;
  background-size: cover; */
  }

  h2 {
    color: white;
    text-shadow: 2px 2px 2px black;
  }

  .InputContainer {
    height: 200px;
    width: auto;
    display: flex;
    flex-direction: column;
    justify-content: space-around;

    margin-bottom: 2em;
  }

  .searchResults {
    position: absolute;
    background: rgba(252, 252, 252, 1);
    max-height: 300px;
    z-index: 10;
    width: 220px;
    border-radius: 0 0 20px 20px;
    font-size: 10px;
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
}
@media only screen and (min-device-width: 576px) and (max-device-width: 992px) {
  * {
    box-sizing: border-box;
  }

  .inputCityAndDateContainer {
    width: 100vw;
    top: 4em;
    position: relative;
    height: 30em;
    display: flex;
    flex-direction: column;
    /* @media only screen and (min-width: 320px) {
  .inputCityAndDateContainer {
    align-items: center;
    justify-content: center; */

    /*   background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
    url("https://www.sgbc.se/app/uploads/2020/05/V%C3%A4stra-Hamnen-Malm%C3%B6-Foto-Ossian-K-Olsson-1200x0-c-default.jpg");
  background-repeat: no-repeat;
  background-size: cover; */
  }

  h2 {
    color: white;
    text-shadow: 2px 2px 2px black;
  }

  .InputContainer {
    height: 200px;
    width: auto;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    margin-bottom: 2em;
  }

  .searchResults {
    position: absolute;
    background: rgba(252, 252, 252, 1);
    max-height: 300px;
    z-index: 10;
    width: 220px;
    border-radius: 0 0 20px 20px;
    font-size: 10px;
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
    /* .InputContainer {
    margin-right: 0;
  }
}

@media only screen and (min-width: 576px) {
  .inputCityAndDateContainer {
    align-items: center;
  }
  .InputContainer {
    margin-right: 0; */
  }
}
@media only screen and (min-device-width: 992px) {
  * {
    box-sizing: border-box;
  }

  .inputCityAndDateContainer {
    width: 100vw;
    top: 4em;
    position: relative;
    height: 35em;
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    justify-content: center;
    margin: 0 auto;
    /*   background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)),
    url("https://www.sgbc.se/app/uploads/2020/05/V%C3%A4stra-Hamnen-Malm%C3%B6-Foto-Ossian-K-Olsson-1200x0-c-default.jpg");
  background-repeat: no-repeat;
  background-size: cover; */
  }

  h2 {
    color: white;
    text-shadow: 2px 2px 2px black;
  }

  .InputContainer {
    height: 200px;
    width: auto;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    margin-bottom: 2em;
  }

  .searchResults {
    position: absolute;
    background: rgba(252, 252, 252, 1);
    max-height: 300px;
    z-index: 10;
    width: 220px;
    border-radius: 0 0 20px 20px;
    font-size: 10px;
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
}

@media only screen and (max-width: 320px) {
  .inputCityAndDateContainer {
    align-items: center;
  }
  .InputContainer {
    margin-right: 0;
  }
}

@media only screen and (min-width: 992px) {
  .inputCityAndDateContainer {
    align-items: center;
  }

  /* @media only screen and (min-width: 992px) {
  .inputCityAndDateContainer {
    align-items: center;
  } */

  .InputContainer {
    margin: 0;
    background-color: rgba(0, 0, 0, 0.7);
    width: 60%;
    height: 50%;
    flex-direction: row;
    align-items: center;
    justify-content: space-around;
    border-radius: 50px;
  }
}

@media only screen and (min-width: 1200px) {
  .InputContainer {
    max-width: 720px;
  }
}
</style>