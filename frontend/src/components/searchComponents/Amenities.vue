<template>
  <div>
    <input
      type="checkbox"
      id="Wi-Fi"
      @click="filterAmenity('Wi-Fi')"
      value="Wi-Fi"
    />
    <label for="Wi-Fi">Wi-Fi</label>

    <input
      type="checkbox"
      id="Pool"
      @click="filterAmenity('Pool')"
      value="Pool"
    />
    <label for="Pool">Pool</label>

    <input
      type="checkbox"
      id="Balcony"
      @click="filterAmenity('Balcony')"
      value="Balcony"
    />
    <label for="Balcony">Balcony</label>

    <input
      type="checkbox"
      id="Kitchen"
      @click="filterAmenity('Kitchen')"
      value="Kitchen"
    />
    <label for="Kitchen">Kitchen</label>
    <input
      type="checkbox"
      id="Freezer"
      @click="filterAmenity('Freezer')"
      value="Freezer"
    />
    <label for="Freezer">Freezer</label>
  </div>
</template>

<script>
export default {
  methods: {
    filterAmenity(value) {
      this.$parent.$parent.filteredListings = this.$store.state.listings.filter(
        (listing) =>
          listing.city === this.$route.params.id &&
          listing.amenities.includes(value)
      );
      console.log(value);
    },
  },
};
</script>

<style>
</style>