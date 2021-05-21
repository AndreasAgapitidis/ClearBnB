<template>
  <div class="amenityBoxes">
    <label for="Wi-Fi">Wi-Fi</label>
    <input
      type="checkbox"
      id="Wi-Fi"
      @change="filterAmenities('Wi-Fi')"
      value="Wi-Fi"
      v-model="chosenAmenities"
    />

    <label for="Pool">Pool</label>
    <input
      type="checkbox"
      id="Pool"
      @change="filterAmenities('Pool')"
      value="Pool"
      v-model="chosenAmenities"
    />

    <label for="Balcony">Balcony</label>
    <input
      type="checkbox"
      id="Balcony"
      @change="filterAmenities('Balcony')"
      value="Balcony"
      v-model="chosenAmenities"
    />

    <label for="Family">Family</label>
    <input
      type="checkbox"
      id="Family"
      @change="filterAmenities('Family')"
      value="Family"
      v-model="chosenAmenities"
    />
    <label for="Handicap-accessible">Handicap-accessible</label>
    <input
      type="checkbox"
      id="Handicap-accessible"
      @change="filterAmenities('Handicap-accessible')"
      value="Handicap-accessible"
      v-model="chosenAmenities"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      chosenAmenities: [],
    };
  },

  methods: {
    filterAmenities(value) {
      this.$parent.$parent.filteredListings = this.$store.state.listings.filter(
        (listing) =>
          listing.city === this.$route.params.id &&
          this.filterDate(listing) &&
          this.chosenAmenities.every((element) =>
            listing.amenities.includes(element)
          )
      );

      console.log(value);
      console.log(this.chosenAmenities);
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
};
</script>

<style scoped>
.amenityBoxes {
  color: rgb(0, 0, 0);
  text-shadow: 1px 1px 2px black;
  font-family: "Roboto";
  font-size: bolder;
  background: transparent;
  border: 1px solid black;
  border-radius: 20px 20px 20px 20px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}

.reloadBtn {
  color: rgb(0, 0, 0);
  text-shadow: 1px 1px 2px black;
  font-family: "Roboto";
  font-size: bolder;
  background: transparent;
  border: 1px solid black;
  border-radius: 20px 20px 20px 20px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
</style>