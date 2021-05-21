<template>
  <AmenitiesWhenAddingListing @click="filterAmenities" />
</template>

<script>
import AmenitiesWhenAddingListing from "../userComponents/AmenitiesWhenAddingListing.vue";

export default {
  data() {
    return {
      chosenAmenities: [],
    };
  },

  components: {
    AmenitiesWhenAddingListing,
  },

  methods: {
    filterAmenities() {
      this.$store.dispatch("setChosenAmenities", this.chosenAmenities);
      this.$parent.filteredListings = this.$store.state.listings.filter(
        (listing) =>
          listing.city === this.$route.params.id &&
          this.filterDate(listing) &&
          this.chosenAmenities.every((element) => {
            console.log("element: ", element);
            return listing.amenities.includes(element);
          })
      );
      console.log("Listing: ", this.$parent.filteredListings);
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
  color: rgb(65, 64, 64);
  text-shadow: 1px 1px 2px grey;
  font-family: "Roboto";
  font-size: bolder;
  background: transparent;
  border: 1px solid black;
  border-radius: 20px 20px 20px 20px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
</style>