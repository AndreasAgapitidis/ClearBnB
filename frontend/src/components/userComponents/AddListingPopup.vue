<template>
  <div class="overlay">
    <div class="darken" @click="toggleShowAddListingPopUp"></div>
    <div class="popUpcontainer">
      <div id="mdiv" @click="toggleShowAddListingPopUp">
        <div class="mdiv">
          <div class="md"></div>
        </div>
      </div>
      <form>
        <h1>Add new listing</h1>
        <input class="txtInput" type="text" placeholder="City" v-model="city" />
        <input
          class="txtInput"
          type="text"
          placeholder="Address"
          v-model="address"
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
        <textarea
          class="txtInput"
          v-model="description"
          placeholder="Listing description"
        ></textarea>
        <input
          class="txtInput"
          type="text"
          placeholder="Area (Integer)"
          v-model="area"
        />
        <input
          class="txtInput"
          type="text"
          placeholder="Beds (Integer)"
          v-model="beds"
        />
        <input
          class="txtInput"
          type="text"
          placeholder="Price per night (Integer)"
          v-model="price"
        />
        <input
          class="txtInput"
          type="text"
          placeholder="Add image URL (up to 5 images)"
          v-model="imageURL"
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
        <button
          class="addListing"
          @click.prevent="sendListingToBackEnd"
          type="submit"
        >
          ADD LISTING
        </button>
      </form>
    </div>
  </div>
  <ConfirmationTemplate
    class="ConfirmationTemplate"
    v-if="loggedInUser && showConfirmationBox"
    :header="'Thank You for your new listing!'"
    :headerTwo="''"
    :headerThree="''"
    :text1="''"
    :text2="''"
    :text3="''"
    :text4="''"
    :text5="''"
    :text6="''"
    :text7="''"
    :text8="''"
    :text9="''"
    :img="''"
  />
</template>

<script>
import ConfirmationTemplate from "../confirmationComponents/confirmationTemplate.vue";

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
      imageURL: "",
      showPopUp: true,
      showConfirmationBox: false,
    };
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
      };

      let res = await fetch("/rest/listings", {
        method: "POST",
        body: JSON.stringify(listing),
      });
      this.showConfirmationBox = true;
    },
    addImage() {
      if (this.images.length < 5) {
        this.images.push(this.imageURL);
        this.imageURL = "";
      } else {
      }
    },
    removeImages() {
      this.images = [];
    },
    toggleShowAddListingPopUp() {
      this.$parent.showPopUp = !this.$parent.showPopUp;
      document.body.classList.remove("modal-open");
    },

    components: {
      ConfirmationTemplate,
    },
  },
};
</script>

<style scoped>
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
  height: 100%;
  max-width: 70vw;
  max-height: 90vh;
  background-color: rgb(83, 168, 168);
  border-radius: 16px;
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
button {
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
.addListing {
  bottom: 0;
}

.images {
  display: flex;
  flex-direction: row;
  width: 100%;
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