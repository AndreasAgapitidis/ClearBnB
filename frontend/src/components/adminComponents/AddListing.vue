<template>
  <button @click="autoFill()" class="autofill">auto fill</button>
  <form>
    <input
      class="txtInput"
      type="text"
      placeholder="Owner ID"
      v-model="owner"
    />
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
      />
      <label class="checkbox" for="Apartment">Apartment</label>
      <br />
      <input class="checkbox" type="checkbox" id="House" v-model="isHouse" />
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
    <p>added pictures: {{ images.length }}</p>
    <button @click.prevent="addImage">Add image</button>
    <button @click.prevent="sendListingToBackEnd" type="submit">
      ADD LISTING
    </button>
    <h1>{{ isApartment }}{{ isHouse }}</h1>
  </form>
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