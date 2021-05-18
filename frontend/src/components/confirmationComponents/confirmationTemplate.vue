<template>
  <!-- <div class="background"></div> -->
  <div v-show="show" class="overlay">
    <div class="dialog">
      <div class="dialog__content">
        <h2 class="dialog__title">{{ title }}</h2>
        <p class="dialog__description">{{ description }}</p>
        <p>{{ bookingId }}</p>
        <p>{{ row2 }}</p>
        <p>{{ checkOutDate }}</p>
        <p>Price: {{ price }} Sek</p>
      </div>

      <hr />

      <div class="dialog__footer">
        <button @click="confirm" class="dialog__confirm">Confirm</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: [
    "show",
    "title",
    "description",
    "confirm",
    "bookingId",
    "row2",
    "checkOutDate",
    "price",
  ],
};
</script>

<style>
.background {
  background-color: rgba(rgb(0, 0, 0), rgb(0, rgb(0, 0, 0)), rgb(0, 0, 0), 0.5);
  width: 100vw;
  height: 100vh;
  z-index: 10;
}
</style>