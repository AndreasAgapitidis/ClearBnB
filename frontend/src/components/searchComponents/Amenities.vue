<template>
  <div>
    <input
      type="checkbox"
      id="Wi-Fi"
      @change="filterAmenities('Wi-Fi')"
      value="Wi-Fi"
      v-model="chosenAmenities"
    />
    <label for="Wi-Fi">Wi-Fi</label>

    <input
      type="checkbox"
      id="Pool"
      @change="filterAmenities('Pool')"
      value="Pool"
      v-model="chosenAmenities"
    />
    <label for="Pool">Pool</label>

    <input
      type="checkbox"
      id="Balcony"
      @change="filterAmenities('Balcony')"
      value="Balcony"
      v-model="chosenAmenities"
    />
    <label for="Balcony">Balcony</label>

    <input
      type="checkbox"
      id="Kitchen"
      @change="filterAmenities('Kitchen')"
      value="Kitchen"
      v-model="chosenAmenities"
    />
    <label for="Kitchen">Kitchen</label>
    <input
      type="checkbox"
      id="Freezer"
      @change="filterAmenities('Freezer')"
      value="Freezer"
      v-model="chosenAmenities"
    />
    <label for="Freezer">Freezer</label>
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
          listing.amenities.includes(value)
      );
      console.log(value);
      console.log(this.chosenAmenities);
    },
  },
};
</script>

<style>
</style>