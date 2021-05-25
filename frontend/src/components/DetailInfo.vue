<template>
  <div class="DetailInfoContainer" v-if="detailprop">
    <div class="Description">
      <h1>Description</h1>
      <p>{{ detailprop.description }}</p>
    </div>

    <div class="randomCat">
      <img
        src="https://media.tenor.com/images/4223cf9120369eea473fcf3565c4e676/tenor.gif"
        alt=""
      />
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
          <img src="../assets/Amenities/more.png" width="24" height="24" />
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
        <p v-if="owner" @click="checkInfoAndOpenModal()" class="ownerField">
          Owner: {{ owner.email }}
        </p>
      </div>
    </div>
  </div>

  <Confirmation
    class="ConfirmationTemplate"
    v-if="showModal && detailprop && owner && ownedListing != 0"
    :header="'Contact information'"
    :headerTwo="owner.firstName + ' ' + owner.lastName"
    :headerThree="''"
    :text1="''"
    :text2="'Owned Listings on ClearBnB: ' + ownedListing"
    :text3="''"
    :text4="'Email: ' + owner.email"
    :text5="''"
    :text6="'Phone: ' + phone"
    :text7="''"
    :text8="''"
    :text9="''"
    :img="detailprop.images[0]"
    :profilePic="owner.profilePicture"
  />
</template>

<script>
import Confirmation from "./confirmationComponents/Confirmation.vue";

export default {
  props: ["detailprop", "owner"],

  components: {
    Confirmation,
  },

  data() {
    return {
      showModal: false,
      ownedListing: 0,
      allListings: [],
      phone: "",
    };
  },

  computed: {
    priceWithProfit() {
      return Math.round(this.detailprop.price * 1.15);
    },
  },

  methods: {
    async checkInfoAndOpenModal() {
      this.ownedListing = 0;
      this.allListings = await this.$store.state.listings;
      this.phone = this.owner.phoneNumber;

      if (this.detailprop.owner) {
        for (let i = 0; i < this.allListings.length; i++) {
          if (this.allListings[i].owner == this.detailprop.owner) {
            this.ownedListing += 1;
          }
        }
        this.showModal = true;
        document.body.classList.add("modal-open");
      } else {
        return;
      }

      if (!this.owner.phoneNumber) {
        this.phone = "User did not provide phone number";
      }
    },

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
      for (let i = 0; i < this.detailprop.amenities.length; i++) {
        if (
          this.detailprop.amenities[i] !== "Wi-Fi" ||
          this.detailprop.amenities[i] !== "Pool" ||
          this.detailprop.amenities[i] !== "Balcony" ||
          this.detailprop.amenities[i] !== "Family friendly" ||
          this.detailprop.amenities[i] !== "Disability"
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
@import url("https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500&display=swap");

.ownerField {
  cursor: pointer;
}

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
  font-family: cursive;
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
  margin-top: 30px;
  padding: 20px;
}

.randomCat {
  grid-area: des;
  z-index: 2;
  position: sticky;
  text-align-last: right;
  margin-right: 40px;
  margin-bottom: -16px;
  align-self: self-end;
}

.randomCat img {
  max-height: 60px;
  max-width: 60px;
  transform: rotate(-13deg);
}

.Description {
  grid-area: des;
  margin-bottom: 30px;
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
  font-size: 3em;
  font-family: "Montserrat", sans-serif;
}

.Description p {
  font-size: 1.5em;
  font-family: "Montserrat", sans-serif;
}

.details {
  margin-top: 17px;
}

.details p {
  font-size: 1.5em;
  font-family: cursive;
}

@media (min-width: 320px) {
  .DetailInfoContainer {
    display: grid;
    grid-template-columns: repeat(4, minmax(0, 1fr));
    grid-template-rows: repeat(6, minmax(0, 1fr));
    grid-template-areas:
      "des des des des"
      "des des des des"
      "des des des des"
      "det det det det"
      "det det det det"
      "am am am am";
    margin-top: 30px;
    padding: 20px;
  }

  ul[data-v-83cbd962] {
    list-style-type: none;
    padding: 0;
    display: flex;
    flex-direction: row;
    align-items: center;
    min-height: 100%;
    justify-content: space-evenly;
    margin: 0;
  }

  li {
    max-width: 4vw;
    max-height: 5vh;
  }
}

@media (min-width: 576px) {
  .DetailInfoContainer {
    grid-template-columns: repeat(5, minmax(0, 1fr));
    grid-template-rows: repeat(5, minmax(0, 1fr));
    grid-template-areas:
      "des des des des des"
      "des des des des des"
      "des des des des des"
      "am am det det det"
      "am am det det det";
  }

  ul[data-v-83cbd962] {
    flex-direction: column;
  }

  li {
    max-width: 4vw;
    max-height: 5vh;
  }
}
@media (min-width: 768px) {
  ul[data-v-83cbd962] {
    flex-direction: row;
  }
  .DetailInfoContainer {
    padding: 50px;
    margin-top: auto;
  }
}
@media (min-width: 992px) {
  .Description h1[data-v-83cbd962] {
    font-size: 35px;
  }

  .Description p[data-v-83cbd962] {
    font-size: 20px;
  }

  .DetailsContainer {
    border: none;
  }

  .DetailInfoContainer {
    display: grid;
    grid-template-columns: repeat(4, minmax(0, 1fr));
    grid-template-rows: repeat(5, minmax(0, 1fr));
    grid-template-areas:
      "des des des des"
      "des des des des"
      "des des des des"
      "am am det det"
      "am am det det";
  }

  .randomCat {
    all: unset;
    grid-area: des;
    z-index: 2;
    position: sticky;
  }

  .details p {
    font-size: 20px;
  }

  li {
    max-width: 4vw;
    max-height: 5vh;
  }

  li img {
    width: 4vw;
    height: 5vh;
  }
}
@media (min-width: 1200px) {
  li img {
    width: 4vw;
    height: 5vh;
  }

  li {
    max-width: 4vw;
    max-height: 5vh;
  }
}
</style>