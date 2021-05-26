<template>
  <!-- a -->
  <div class="amenitiesContainer">
    <div
      class="amenityCard"
      v-for="amenity of amenities"
      v-bind:key="amenity"
      @click="addAmenities(amenity)"
    >
      <div v-if="toggleClass(amenity)" class="isClicked">
        <p>{{ amenity }}</p>
      </div>
      <p v-else>{{ amenity }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      chosenAmenities: this.$store.state.chosenAmenities,
      amenities: ["Wi-Fi", "Pool", "Balcony", "Disability", "Family friendly"],
    };
  },

  methods: {
    addAmenities(amenity) {
      if (!this.chosenAmenities.includes(amenity)) {
        this.chosenAmenities.push(amenity);
      } else {
        this.chosenAmenities = this.chosenAmenities.filter(
          (item) => item !== amenity
        );
      }

      this.$parent.chosenAmenities = this.chosenAmenities;
      try {
        this.$parent.filterAmenities();
      } catch (error) {}
    },
    toggleClass(amenity) {
      if (this.chosenAmenities.includes(amenity)) {
        return true;
      }
    },
  },
};
</script>

<style scoped>
p {
  padding: 0;
  margin: 0;
}

.amenitiesContainer {
  padding: 10px;
  display: grid;
  gap: 2px;
  grid-template-columns: repeat(auto-fill, minmax(100px, 1fr));
  grid-auto-rows: 45px;
  max-width: 50%;
  margin: auto;
}

.amenityCard,
.isClicked {
  width: 100%;
  height: 100%;
  background-color: #262626;
  border-radius: 0 22px 0 22px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  box-shadow: rgb(0 0 0 / 25%) 0px 14px 28px, rgb(0 0 0 / 22%) 0px 10px 10px;
}
.isClicked {
  background-color: rgb(185, 240, 222);
  color: rgb(36, 36, 36);
  box-shadow: none;
}
.amenityCard:hover {
  background-color: rgb(185, 240, 222);
  color: rgb(36, 36, 36);
  cursor: pointer;
  transform: scale(1.015);
}
</style>