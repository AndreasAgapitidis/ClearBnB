<template>
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
    <p>added pictures: {{ pictureCount }}</p>
    <button @click.prevent="addImage">Add image</button>
    <button @click.prevent="sendListingToBackEnd" type="submit">
      ADD LISTING
    </button>
    <h1>{{ isApartment }}{{ isHouse }}</h1>
  </form>
  <button @click="autoFill()">auto fill</button>
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
      pictureCount: 0,
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

      console.log(listing);

      let res = await fetch("/rest/listings", {
        method: "POST",
        body: JSON.stringify(listing),
      });

      this.pictureCount = 0;
    },
    addImage() {
      this.images.push(this.imageURL);
      this.pictureCount++;
      this.imageURL = "";
    },

    autoFill() {
      this.owner = this.randomGenerator();
      this.address =
        this.randomGenerator() + " gatan" + Math.floor(Math.random() * 50);
      this.isHouse = "House";
      this.city = this.$store.state.cities[
        Math.floor(Math.random() * this.$store.state.cities.length)
      ].name;
      this.area = Math.floor(Math.random() * 50);
      this.beds = Math.floor(Math.random() * 10);
      this.price = Math.floor(Math.random() * 10000);
      this.description = this.randomGenerator();
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
        let x = Math.floor(Math.random() * 8);
        let y = Math.floor(Math.random() * 19);

        randomizedName += consonants[Math.floor(Math.random() * 19)];
        randomizedName += wovels[x];
        randomizedName += consonants[y];
        randomizedName += wovels[x];
      }

      return randomizedName;
    },
    randomImg() {
      for (let i = 0; i < 10; i++) {
        this.images.push("https://source.unsplash.com/collection/travel/");
      }
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
</style>