<template>
  <div
    class="rentalCard"
    v-bind:style="{
      backgroundImage:
        'linear-gradient(to right, rgb(255 255 255 / 0%), rgb(255 255 255 / 90%), rgb(255 255 255 / 100%) ) ,url(' +
        listing.images[0] +
        ')',
    }"
  >
    <div class="text-container">
      <h4>{{ listing.address }}</h4>
      <p>{{ listing.description }}</p>
      <p>Price: {{ listing.price }}sek / night</p>
      <p>Size: {{ listing.area }}m2</p>
    </div>
  </div>
</template>

<script>
export default {
  props: ["listing"],

  data() {
    return {};
  },
};
</script>

<style scoped>
@media only screen and (min-device-width: 320px) and (max-device-width: 576px) {
  .text-container {
    color: rgb(43, 43, 43);
    margin-right: 2em;
  }

  .text-container p {
    font-size: 13px;
    margin: 3px;
    text-align: end;
    font-style: italic;
  }

  .text-container h4 {
    text-align: end;
  }

  .text-conatiner > p:nth-child(1) {
    color: white;
  }

  .rentalCard {
    background-size: cover;
    background-repeat: no-repeat;
    margin: 1em auto;
    width: 80%;
    height: 150px;
    border-radius: 0 47px 0 47px;
    overflow: hidden;
    position: relative;
    top: 1em;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    border-right: 1px solid rgb(75, 75, 75);
    border-bottom: 1px solid rgb(75, 75, 75);
    margin-right: 10%;
  }

  .rentalCard:hover {
    transform: scale(1.02);
    cursor: pointer;
  }

  .rentalCard:last-child {
    margin-bottom: 1em;
  }

  img {
    width: 100%;
    height: 180px;
    object-fit: cover;
    object-position: center;
    opacity: 70%;
  }
}
@media only screen and (min-device-width: 576px) and (max-device-width: 992px) {
  .text-container {
    color: rgb(43, 43, 43);
    margin-right: 2em;
  }

  .text-container p {
    font-size: 13px;
    margin: 3px;
    text-align: end;
    font-style: italic;
  }

  .text-container h4 {
    text-align: end;
  }

  .text-conatiner > p:nth-child(1) {
    color: white;
  }

  .rentalCard {
    background-size: cover;
    background-repeat: no-repeat;
    margin: 1em auto;
    width: 80%;
    height: 150px;
    border-radius: 0 47px 0 47px;
    overflow: hidden;
    position: relative;
    top: 1em;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    border-right: 1px solid rgb(75, 75, 75);
    border-bottom: 1px solid rgb(75, 75, 75);
    margin-right: 10%;
  }

  .rentalCard:hover {
    transform: scale(1.02);
    cursor: pointer;
  }

  .rentalCard:last-child {
    margin-bottom: 1em;
  }

  img {
    width: 100%;
    height: 180px;
    object-fit: cover;
    object-position: center;
    opacity: 70%;
  }
}
@media only screen and (min-device-width: 992px) {
  .text-container {
    color: rgb(43, 43, 43);
    margin-right: 2em;
  }

  .text-container p {
    font-size: 13px;
    margin: 3px;
    text-align: end;
    font-style: italic;
  }

  .text-container h4 {
    text-align: end;
  }

  .text-conatiner > p:nth-child(1) {
    color: white;
  }

  .rentalCard {
    background-size: cover;
    background-repeat: no-repeat;
    margin: 1em auto;
    width: 80%;
    height: 150px;
    border-radius: 0 47px 0 47px;
    overflow: hidden;
    position: relative;
    top: 1em;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    border-right: 1px solid rgb(75, 75, 75);
    border-bottom: 1px solid rgb(75, 75, 75);
    margin-right: 11%;
  }

  .rentalCard:hover {
    transform: scale(1.02);
    cursor: pointer;
  }

  .rentalCard:last-child {
    margin-bottom: 1em;
  }

  img {
    width: 100%;
    height: 180px;
    object-fit: cover;
    object-position: center;
    opacity: 70%;
  }
}
</style>