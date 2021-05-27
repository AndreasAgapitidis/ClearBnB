<template>
  <!-- a -->
  <AmenitiesWhenAddingListing @click="filterAmenities" class="amenity" />

  <PriceSlide @updatePrice="fetchMaxPrice" class="price" />

  <GuestInput @updateMinGuest="fetchMinGuest" class="guest" />
</template>

<script>
import AmenitiesWhenAddingListing from "../userComponents/AmenitiesWhenAddingListing.vue";
import PriceSlide from "./PriceSlide.vue";
import GuestInput from "./GuestInput.vue";

export default {
  data() {
    return {
      chosenAmenities: this.$store.state.chosenAmenities,
      maxPrice: 0,
      minGuestNumber: 1,
    };
  },

  components: {
    AmenitiesWhenAddingListing,
    PriceSlide,
    GuestInput,
  },

  methods: {
    fetchMinGuest(number) {
      this.minGuestNumber = number;
      this.filterAmenities();
    },

    fetchMaxPrice(value) {
      this.maxPrice = value;
      this.filterAmenities();
    },

    filterAmenities() {
      console.log("min " + this.minGuestNumber);
      console.log("max " + this.maxGuestNumber);
      this.$store.dispatch("setChosenAmenities", this.chosenAmenities);
      this.$parent.filteredListings = this.$store.state.listings.filter(
        (listing) =>
          (listing.city === this.$route.params.id || !this.$route.params.id) &&
          this.filterDate(listing) &&
          listing.price * 1.15 < this.maxPrice &&
          listing.beds >= this.minGuestNumber &&
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