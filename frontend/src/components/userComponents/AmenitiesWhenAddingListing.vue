<template>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
      try {
        this.$parent.chosenAmenities = this.chosenAmenities;
        this.$emit("updateAmenities", this.chosenAmenities);
      } catch (error) {}

      try {
        this.$parent.filterAmenities();
      } catch (error) {}
    },
    toggleClass(amenity) {
      if (this.chosenAmenities.includes(amenity)) {
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>

<style scoped>
.amenitiesContainer {
  width: 40%;
}
@media only screen and (min-device-width: 320px) and (max-device-width: 576px) {
  p {
    padding: 0;
    margin: 0;
  }

  .amenitiesContainer {
    height: 200px;
    display: grid;
    gap: 12px;
    padding: 10px;
    grid-template-rows: repeat(auto-fit, minmax(30px, 1fr));
    grid-auto-rows: 30px;
    max-width: 50%;
    margin: auto;
    margin-top: 5%;
  }

  .amenityCard,
  .isClicked {
    width: 100%;
    height: 100%;
    background-color: rgb(238, 238, 238);
    border-radius: 0 22px 0 22px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: black;
    font-size: 13px;
    text-shadow: 1px 1px 2px black;
    box-shadow: rgb(0 0 0 / 25%) 0px 14px 28px, rgb(0 0 0 / 22%) 0px 10px 10px;
  }
  .isClicked {
    background-color: rgb(177, 230, 235);
    color: rgb(36, 36, 36);
    box-shadow: none;
  }
  .amenityCard:hover {
    background-color: rgb(177, 230, 235);
    color: rgb(36, 36, 36);
    cursor: pointer;
    transform: scale(1.2);
  }
}
@media only screen and (min-device-width: 576px) and (max-device-width: 992px) {
  p {
    padding: 0;
    margin: 0;
  }

  .amenitiesContainer {
    padding: 10px;
    display: grid;
    gap: 12px;
    grid-template-columns: repeat(auto-fit, minmax(100px, 1fr));
    grid-auto-rows: 45px;
    max-width: 50%;
    margin: auto;
    margin-top: 5%;
  }

  .amenityCard,
  .isClicked {
    width: 100%;
    height: 100%;
    background-color: rgb(238, 238, 238);
    border-radius: 0 22px 0 22px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: black;
    font-size: 13px;
    text-shadow: 1px 1px 2px black;
    box-shadow: rgb(0 0 0 / 25%) 0px 14px 28px, rgb(0 0 0 / 22%) 0px 10px 10px;
  }
  .isClicked {
    background-color: rgb(177, 230, 235);
    color: rgb(36, 36, 36);
    box-shadow: none;
  }
  .amenityCard:hover {
    background-color: rgb(177, 230, 235);
    color: rgb(36, 36, 36);
    cursor: pointer;
    transform: scale(1.2);
  }
}

@media only screen and (min-device-width: 992px) {
  p {
    padding: 0;
    margin: 0;
  }

  .amenitiesContainer {
    padding: 10px;
    display: grid;
    gap: 12px;
    grid-template-columns: repeat(auto-fit, minmax(100px, 1fr));
    grid-auto-rows: 55px;
    max-width: 720px;
    margin: auto;
    margin-top: 5%;
  }

  .amenityCard,
  .isClicked {
    width: 100%;
    height: 100%;
    background-color: rgb(238, 238, 238);
    border-radius: 0 22px 0 22px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: black;
    font-size: 16px;
    text-shadow: 1px 1px 2px black;
    box-shadow: rgb(0 0 0 / 25%) 0px 14px 28px, rgb(0 0 0 / 22%) 0px 10px 10px;
  }
  .isClicked {
    background-color: rgb(177, 230, 235);
    color: rgb(36, 36, 36);
    box-shadow: none;
  }
  .amenityCard:hover {
    background-color: rgb(177, 230, 235);
    color: rgb(36, 36, 36);
    cursor: pointer;
    transform: scale(1.2);
  }
}
</style>