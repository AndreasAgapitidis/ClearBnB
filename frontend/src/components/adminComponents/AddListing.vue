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
    <input class="txtInput" type="text" placeholder="Area" v-model="area" />
    <input class="txtInput" type="text" placeholder="Beds" v-model="beds" />
    <input
      class="txtInput"
      type="text"
      placeholder="Price per night"
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
</template>

<script>
export default {
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
        isHouse: this.isHouse,
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