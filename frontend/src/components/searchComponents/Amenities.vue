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
            return listing.amenities.includes(element);
          })
      );
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


 
</style>