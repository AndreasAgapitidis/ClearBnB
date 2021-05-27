<template>
  <div class="slideContainer">
    <input
      type="range"
      min="1"
      max="50000"
      v-model="value"
      class="priceRange"
      @input="updatePrice()"
    />
    <p>Max-Price:<span class="maxPrice"></span></p>
    <input
      class="priceDisplay"
      type="number"
      v-model="value"
      @input="updatePrice()"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: 50000,
      slider: null,
    };
  },

  created() {
    let slider = document.getElementsByClassName("priceRange");
  },

  methods: {
    updatePrice() {
      this.$emit("updatePrice", this.value);
    },
  },
};
</script>

<style scoped>
.slideContainer {
  width: 40%;
  margin-inline: auto;
  margin-top: 20px;
}

.priceRange {
  width: 100%;
  opacity: 0.7;
}

.priceRange:hover {
  opacity: 1;
}

.priceDisplay {
  min-width: 30%;
  text-align: center;
  border-radius: 15px;
  max-width: 40%;
}

.priceDisplay:focus-visible {
  outline: none;
}

.maxPrice {
  font-family: "Roboto";
}

.maxPrice::before {
  content: "0";
  position: absolute;
  left: 30.5%;
  /* top: 90%; */
}

.maxPrice::after {
  content: "50000";
  position: absolute;
  left: 67.5%;
  /* top: 90%; */
}

p {
  color: black;
  font-size: 16px;
  text-shadow: 1px 1px 2px black;
}
</style>