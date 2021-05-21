<template>
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
      chosenAmenities: [],
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

      console.log(this.$parent.chosenAmenities);
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
  grid-template-columns: repeat(auto-fill, minmax(70px, 1fr));
  grid-auto-rows: 20px;
  max-width: 50%;
  margin: auto;
}

.amenityCard {
  width: 100%;
  height: 100%;
  background-color: white;
}
.isClicked {
  width: 100%;
  height: 100%;
  background-color: rgb(19, 236, 92);
  color: rgb(51, 51, 51);
}
.amenityCard:hover {
  background-color: rgb(148, 243, 180);
  cursor: pointer;
  transform: scale(1.015);
}
</style>