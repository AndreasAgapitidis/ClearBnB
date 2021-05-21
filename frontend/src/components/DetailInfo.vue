<template>
  <div class="DetailInfoContainer" v-if="detailprop">
    <div class="Description">
      <h1>Description</h1>
      <p>{{ detailprop.description }}</p>
    </div>

    <div class="Amenity">
      <ul>
        <li v-if="isWifi() == true">
          <img src="../assets/Amenities/wifi.png" width="24" height="24" />
          Wi-Fi
        </li>
        <li v-if="isPool() == true">
          <img src="../assets/Amenities/pool.png" width="24" height="24" />
          Pool
        </li>
        <li v-if="isBalcony() == true">
          <img src="../assets/Amenities/balcony.png" width="24" height="24" />
          Balcony
        </li>
        <li v-if="isFamily() == true">
          <img src="../assets/Amenities/family.png" width="24" height="24" />
          Family-Friendly
        </li>
        <li v-if="isHandicap() == true">
          <img src="../assets/Amenities/disabled.png" width="24" height="24" />
          Disability
        </li>
        <li v-if="isExtra() == true">
          <img src="../assets/Amenities/disabled.png" width="24" height="24" />
          Extra
        </li>
      </ul>
    </div>

    <div class="DetailsContainer">
      <div class="details">
        <p>Price: {{ priceWithProfit }} SEK / night</p>
        <p>Rating: {{ detailprop.rating }}</p>
        <p>City: {{ detailprop.city }}</p>
        <p>Beds: {{ detailprop.beds }}</p>
        <p>Area: {{ detailprop.area }} ㎡</p>
        <p v-if="detailprop.isHouse == 'true'">Building Type: House</p>
        <p v-else-if="detailprop.isApartment == 'true'">
          Building Type: Apartment
        </p>
        <p v-if="owner">Owner: {{ owner.email }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["detailprop", "owner"],

  computed: {
    priceWithProfit() {
      /* this.getOwner(); */
      return Math.round(this.detailprop.price * 1.15);
    },
  },

  methods: {
    isWifi() {
      let check = false;
      if (this.detailprop.amenities.includes("Wi-Fi")) {
        check = true;
      }
      return check;
    },
    isPool() {
      let check = false;
      if (this.detailprop.amenities.includes("Pool")) {
        check = true;
      }
      return check;
    },
    isBalcony() {
      let check = false;
      if (this.detailprop.amenities.includes("Balcony")) {
        check = true;
      }
      return check;
    },
    isFamily() {
      let check = false;
      if (this.detailprop.amenities.includes("Family friendly")) {
        check = true;
      }
      return check;
    },
    isHandicap() {
      let check = false;
      if (this.detailprop.amenities.includes("Disability")) {
        check = true;
      }
      return check;
    },
    isExtra() {
      let check = false;
      let chosenAmenities = this.$store.state.chosenAmenities;
      for (let i = 0; i < chosenAmenities.length; i++) {
        if (
          !chosenAmenities[i] == "Wi-Fi" ||
          !chosenAmenities[i] == "Pool" ||
          !chosenAmenities[i] == "Balcony" ||
          !chosenAmenities[i] == "Family friendly" ||
          !chosenAmenities[i] == "Disability"
        ) {
          check = true;
        }
      }
      return check;
    },
  },
};
</script>

<style scoped>
ul {
  list-style-type: none;
  padding: 0;
  display: flex;
  flex-direction: column;
  min-height: 100%;
  justify-content: space-evenly;
  margin: 0;
}

li {
  display: flex;
  flex-direction: column;
  place-items: center;
  padding: 5px 0 5px 0;
}

.DetailInfoContainer {
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  grid-template-rows: repeat(4, minmax(0, 1fr));
  grid-template-areas:
    "des des des des"
    "des des des des"
    "am det det det"
    "am det det det";
  margin-top: 50px;
  justify-items: center;
}

.Description {
  grid-area: des;
}

.Amenity {
  grid-area: am;
}

.DetailsContainer {
  grid-area: det;
  border: 2px solid black;
  border-radius: 15px 40px 15px 40px;
}

.Description h1 {
  font-size: 25px;
}

.Description p {
  font-size: 15px;
}

.details {
  align-self: center;
}
</style>