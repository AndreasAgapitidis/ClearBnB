<template>
  <transition name="fade" appear>
    <div class="overlay" v-if="!showConfirmationBox">
      <div class="darken" @click="toggleShowAddListingPopUp"></div>
      <div class="popUpcontainer" v-if="!showConfirmationBox">
        <div id="mdiv" @click="toggleShowAddListingPopUp">
          <div class="mdiv">
            <div class="md"></div>
          </div>
        </div>
        <form class="form" @submit.prevent="sendListingToBackEnd">
          <h1>Add new listing</h1>
          <input
            class="txtInput"
            type="text"
            placeholder="City"
            v-model="city"
            required
          />
          <input
            class="txtInput"
            type="text"
            placeholder="Address"
            v-model="address"
            required
          />
          <div id="v-model-checkbox">
            <input
              class="checkbox"
              type="checkbox"
              id="Apartment"
              v-model="isApartment"
              @click="isHouse = false"
            />
            <label class="checkbox" for="Apartment">Apartment</label>
            <br />
            <input
              class="checkbox"
              type="checkbox"
              id="House"
              v-model="isHouse"
              @click="isApartment = false"
            />
            <label class="checkbox" for="House">House</label>
            <br />
          </div>
          <AmenitiesWhenAddingListing />
          <textarea
            class="txtInput"
            v-model="description"
            placeholder="Listing description"
            required
          ></textarea>
          <input
            class="txtInput"
            type="number"
            min="1"
            placeholder="Area (Integer)"
            v-model="area"
            required
          />
          <input
            class="txtInput"
            type="number"
            min="1"
            placeholder="Beds (Integer)"
            v-model="beds"
            required
          />
          <input
            class="txtInput"
            type="number"
            min="1"
            placeholder="Price per night (Integer)"
            v-model="price"
            required
          />
          <input
            class="imgInput"
            type="text"
            placeholder="Add image URL (up to 5 images)"
            v-model="imageURL"
            required
          />
          <button
            class="addImg"
            @click.prevent="addImage"
            v-if="images.length < 5"
          >
            Add image
          </button>
          <button
            class="removeImg"
            @click.prevent="removeImages"
            v-if="images.length > 0"
          >
            Remove all images
          </button>
          <div class="images">
            <img
              :src="image"
              class="addedImages"
              v-for="image of images"
              v-bind:key="image"
            />
          </div>
          <button class="addListing">ADD LISTING</button>
        </form>
      </div>
    </div>
  </transition>
  <ConfirmationTemplate
    class="ConfirmationTemplate"
    v-if="owner && showConfirmationBox && addedListing"
    :header="'Thank You ' + owner.firstName"
    :headerTwo="'Thank you for your listing, it has been added'"
    :headerThree="'Listing ID: ' + addedListing.id"
    :text1="'City: ' + city"
    :text2="'Address: ' + address"
    :text3="'Listing type: ' + typeOfHouse"
    :text4="'Area : ' + area + '㎡'"
    :text5="'Beds: ' + beds"
    :text6="'Owner: '"
    :text7="'Firstname: ' + owner.firstName"
    :text8="'Lastname: ' + owner.lastName"
    :text9="'Price: ' + price + ' sek(exclude administration fee)'"
    :img="addedListing.images[0]"
  />
</template>

<script>
import ConfirmationTemplate from "../confirmationComponents/Confirmation.vue";
import AmenitiesWhenAddingListing from "./AmenitiesWhenAddingListing.vue";

export default {
  created() {
    this.$store.dispatch("fetchCities");
  },

  data() {
    return {
      owner: this.$store.state.user,
      address: "",
      isApartment: "",
      isHouse: "",
      city: "",
      area: "",
      beds: "",
      price: "",
      description: "",
      images: [],
      chosenAmenities: [],
      imageURL: "",
      showPopUp: true,
      showConfirmationBox: false,
      addedListing: null,
      typeOfHouse: "",
    };
  },

  components: {
    ConfirmationTemplate,
    AmenitiesWhenAddingListing,
  },

  methods: {
    async sendListingToBackEnd() {
      let listing = {
        owner: this.$store.state.user.id,
        address: this.address,
        isApartment: this.isApartment,
        isHouse: true,
        city: this.city,
        area: this.area,
        beds: this.beds,
        price: this.price,
        description: this.description,
        images: this.images,
        amenities: this.chosenAmenities,
      };

      if (this.isHouse == true) {
        this.typeOfHouse = "House";
      } else {
        this.typeOfHouse = "Apartment";
      }

      let res = await fetch("/rest/listings", {
        method: "POST",
        body: JSON.stringify(listing),
      });
      this.addedListing = await res.json();
      this.$store.dispatch('signalAddedListing') // this is done to signal that the User Profile Page should re-render
      this.showConfirmationBox = true;
    },
    addImage() {
      if (this.images.length < 5) {
        this.images.push(this.imageURL);
        this.imageURL = "";
      }
      document.getElementsByClassName("imgInput").removeAttribute(required);
    },
    removeImages() {
      this.images = [];
      document.getElementsByClassName("imgInput").addAttribute(required);
    },
    toggleShowAddListingPopUp() {
      this.$parent.showPopUp = !this.$parent.showPopUp;
      document.body.classList.remove("modal-open");
    },
  },
};
</script>

<style scoped>
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

label.checkbox {
  color: white;
}

.form h1 {
  color: white;
}
.overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 2;
}

.popUpcontainer {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;
  width: 100%;

  max-width: 75vw;
  max-height: 100vh;
  background-image: linear-gradient(rgb(0 0 0 / 40%), rgb(0 0 0 / 40%)),
    url("https://images.contentstack.io/v3/assets/blte962564a7ccdad95/blt6673351f18e18b68/5d0a6279b58121dc58ed5303/5.2.1Stockholm.jpg?auto=webp&format=pjpg&quality=80&width=1200&height=1200&fit=crop&crop=1200:630,smart");
  background-repeat: no-repeat;
  background-size: cover;
  border-radius: 16px;
  overflow-y: auto;
}

.ConfirmationTemplate {
  background: none;
  z-index: 1;
}

.closePopup {
  width: 50px;
  height: 50px;
  background-color: red;
  border-radius: 50px;
}

.darken {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 98;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

form {
  display: inline-block;
  justify-content: center;
  margin-top: 20px;
  width: 100%;
}

.txtInput,
button,
.imgInput {
  display: block;
  margin: 0 auto 15px;
  width: 50%;
  height: 25px;
  border-radius: 10px;
  border: none;
}
.removeImg {
  margin-top: 5px;
  background-color: rgb(121, 49, 49);
  color: white;
}

.txtInput:focus {
  outline: none;
}

#House {
  margin-bottom: 15px;
}

button {
  display: block;
}

.addImg {
  margin: auto;
  width: 50%;
  margin-bottom: 10px;
}

img {
  max-height: 50px;
}
.addListing {
  bottom: 0;
}

.images {
  display: flex;
  flex-direction: row;
  min-width: 100%;
  place-content: center;
  min-height: 50px;
}

.addedImages {
  height: 100%;
  overflow: hidden;
}

#v-model-checkbox {
  margin-top: 10px;
}

/*----------- closeBTN ----------- */
#mdiv {
  width: 25px;
  height: 25px;
  background-color: red;
  border: 1px solid black;
  display: flex;
  float: right;
}

.mdiv {
  height: 25px;
  width: 2px;
  margin-left: 12px;
  background-color: black;
  transform: rotate(45deg);
  z-index: 1;
}

.md {
  height: 25px;
  width: 2px;
  background-color: black;
  transform: rotate(90deg);
  z-index: 2;
}
</style>