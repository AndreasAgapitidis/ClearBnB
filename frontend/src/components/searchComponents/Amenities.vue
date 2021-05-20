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

    <label for="Kitchen">Kitchen</label>
    <input
      type="checkbox"
      id="Kitchen"
      @change="filterAmenities('Kitchen')"
      value="Kitchen"
      v-model="chosenAmenities"
    />
    <label for="Freezer">Freezer</label>
    <input
      type="checkbox"
      id="Freezer"
      @change="filterAmenities('Freezer')"
      value="Freezer"
      v-model="chosenAmenities"
    />
  </div>

  <button @click="reloadPage()" class="reloadBtn">Reset</button>
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
    reloadPage() {
      window.location.reload();
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