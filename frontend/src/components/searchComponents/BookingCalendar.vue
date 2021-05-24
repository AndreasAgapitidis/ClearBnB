<template>
  <v-date-picker
    v-model="range"
    is-range
    :min-date="new Date()"
    @change="filterOnDate"
  >
    <template v-slot="{ inputValue, inputEvents }">
      <div class="wrapper">
        <input
          :value="inputValue.start"
          v-on="inputEvents.start"
          class="border px-2 py-1 w-32 rounded focus:outline-none focus:border-indigo-300"
          id="InputStart"
        />

        <input
          :value="inputValue.end"
          v-on="inputEvents.end"
          class="border px-2 py-1 w-32 rounded focus:outline-none focus:border-indigo-300"
          id="InputEnd"
        />
      </div>
    </template>
  </v-date-picker>
</template>

<script>
export default {
  data() {
    return {
      range: {
        start: this.$store.state.dateRange.start,
        end: this.$store.state.dateRange.end,
      },
    };
  },

  methods: {
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

    goToSearchedByCityPage() {
      this.$router.push("/SearchByCity/" + this.$store.state.usersCity);
    },
  },

  computed: {
    // filter listings based on user inputted dates
    async filterOnDate() {
      if (!this.range.start || !this.range.end) {
        return;
      } else {
        // set hours/minutes/seconds/milliseconds to 0
        this.range.start.setHours(0, 0, 0, 0);
        this.range.end.setHours(0, 0, 0, 0);

        // set dates in store to be access by booking page
        this.$store.dispatch("setBookingDates", this.range);

        this.$parent.$parent.filteredListings = this.$store.state.listings.filter(
          (listing) =>
            listing.city === this.$route.params.id &&
            this.filterDate(listing) &&
            this.$store.state.chosenAmenities.every((element) => {
              return listing.amenities.includes(element);
            })
        );

        this.goToSearchedByCityPage();
      }
    },
  },
};
</script>

<style scoped>
.wrapper {
  font-weight: 200;
  width: 220px;
  margin-top: 20px;
  justify-content: center;
  margin: 0 auto;
  height: 3em;
  display: flex;
  border: none;
  overflow: hidden;
  border-radius: 0 20px 0 20px;
  box-shadow: rgba(0, 0, 0, 0.25) 0px 14px 28px,
    rgba(0, 0, 0, 0.22) 0px 10px 10px;
}
#InputStart {
  width: 100%;
  height: 100%;
  border: none;
  outline: none;
  text-align: center;
}
#InputEnd {
  width: 100%;
  height: 100%;
  border: none;
  outline: none;
  text-align: center;
}

#InputStart,
#InputEnd:focus {
  outline: none;
}

/*#InputStart,
#InputEnd:hover {
  cursor: none;
}*/

.inputCityAndDateContainer > div {
  margin-top: 15px;
}
</style>