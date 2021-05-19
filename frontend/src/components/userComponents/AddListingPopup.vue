<template>
  <div class="overlay">
    <div class="darken"></div>
    <div class="popUpcontainer">
      <form>
        <h1>Owner Name</h1>
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
        <button @click.prevent="addImage">Add image</button>
        <p>Added pictures: {{ images.length }}</p>
        <button @click.prevent="sendListingToBackEnd" type="submit">
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
      this.images.push(this.imageURL);
      this.imageURL = "";
    },

    autoFill() {
      this.images = []; //Reset the pictures
      this.owner = this.randomUser();
      this.address =
        this.randomGenerator() + " Gatan " + Math.floor(Math.random() * 50);
      this.isHouse = "House";
      this.city = this.$store.state.cities[
        Math.floor(Math.random() * this.$store.state.cities.length)
      ].name;
      this.area = Math.floor(Math.random() * 50) + 1;
      this.beds = Math.floor(Math.random() * 10) + 1;
      this.price = Math.floor(Math.random() * 10000) + 1;
      this.description = "Description text here about the listing";
      this.randomImg();
    },

    randomGenerator() {
      let wovels = ["a", "e", "i", "o", "u", "y", "å", "ä"];
      let consonants = [
        "b",
        "c",
        "d",
        "f",
        "g",
        "h",
        "j",
        "k",
        "l",
        "m",
        "n",
        "p",
        "q",
        "r",
        "s",
        "t",
        "v",
        "w",
        "x",
      ];

      let randomizedName = "";

      for (let i = 0; i < 1; i++) {
        randomizedName += consonants[
          Math.floor(Math.random() * 19)
        ].toUpperCase();
        randomizedName += wovels[Math.floor(Math.random() * 8)];
        randomizedName += consonants[Math.floor(Math.random() * 19)];
        randomizedName += wovels[Math.floor(Math.random() * 8)];
      }

      return randomizedName;
    },
    randomImg() {
      this.images.push("https://source.unsplash.com/800x600/?Apartment");
      this.images.push("https://source.unsplash.com/800x600/?House");
      this.images.push("https://source.unsplash.com/800x600/?Barcelona");
      this.images.push("https://source.unsplash.com/800x600/?Milano");
      this.images.push("https://source.unsplash.com/800x600/?London");
    },
    async randomUser() {
      let res = await fetch("/rest/getAllUsers/");
      let users = await res.json();
      this.owner = users[Math.floor(Math.random() * users.length)].id;
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
  max-height: 70vh;
  background-color: rgb(70, 112, 76);
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
}
.txtInput {
  display: block;
  margin-top: 15px;
}
button {
  display: block;
}
button {
  margin: 10px;
}
#v-model-checkbox {
  margin-top: 10px;
}

.autofill {
  width: 200px;
  height: 50px;
  margin: auto;
}
</style>