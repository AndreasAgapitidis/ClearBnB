<template>
  <v-date-picker v-model="range" is-range @change="filterOnDate">
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
        start: null,
        end: null,
      },
    };
  },

  methods: {
    filterHelper(array) {
      let newArray = [];
      for (let i = 0; i < array.length; i++) {
        let conflict = false;
        for (let j = 0; j < array[i].unavailableDates.length; j++) {
          // compare to UNIX time stored in Java (which is the UNIX time divided by 1000)
          if (
            array[i].unavailableDates[j] >= this.range.start.getTime() / 1000 &&
            array[i].unavailableDates[j] <=
              this.range.end.getTime() / 1000 - 86400
          ) {
            conflict = true;
            break;
          }
        }
        if (!conflict) {
          newArray.push(array[i]);
        }
      }
      return newArray;
    },
  },

  computed: {
    // filter listings based on user inputted dates
    async filterOnDate() {
      if (!this.range.start || !this.range.end) {
        return;
      } else {
        // set hours/minutes/seconds/milliseconds to 0 on UNIX date-time
        this.range.start.setHours(0, 0, 0, 0);
        this.range.end.setHours(0, 0, 0, 0);

        let updatedListings = [];

        if (!this.$route.params.id) {
          updatedListings = this.filterHelper(this.$store.state.listings);
        } else {
          let res = await fetch("/rest/listings/city/" + this.$route.params.id);
          let listings = await res.json();
          updatedListings = this.filterHelper(listings);
        }

        this.$parent.filteredListings = updatedListings;
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
  text-align: left;
}
#InputEnd {
  width: 100%;
  height: 100%;
  border: none;
  outline: none;
  text-align: right;
}

#InputStart,
#InputEnd:focus {
  outline: none;
}

#InputStart,
#InputEnd:hover {
  pointer: none;
}

.inputCityAndDateContainer > div {
  margin-top: 15px;
}
</style>