<template>
  <div class="overlay">
    <div class="darken"></div>
    <div class="popUpcontainer">
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
          placeholder="Add image (URL)"
          v-model="imageURL"
        />
        <button
          class="addImg"
          @click.prevent="addImage"
          v-if="images.length < 5"
        >
          Add image
        </button>
        <button class="removeImg" @click.prevent="removeImages">
          Remove all images
        </button>
        <!-- <p>Added pictures: {{ images.length }}</p> -->
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
</template>

<script>
export default {
  created() {
    this.$store.dispatch("fetchCities");
  },

  data() {
    return {
      owner: "",
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
    };
  },

  methods: {
    async sendListingToBackEnd() {
      let listing = {
        owner: this.owner,
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

      this.pictureCount = 0;
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

.addImg,
.addListing {
  margin: auto;
  width: 50%;
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
</style>