<template>
  <!-- <div class="background"></div> -->
  <div v-show="show" class="overlay">
    <div class="confirmationContainer">
      <div class="content">
        <h2 class="header">{{ header }}</h2>
        <p class="headerTwo">{{ headerTwo }}</p>
        <p class="headerThree">{{ headerThree }}</p>
        <p v-if="text1">{{ text1 }}</p>
        <p v-if="text2">{{ text2 }}</p>
        <p v-if="text3">{{ text3 }}</p>
        <p v-if="text4">{{ text4 }}</p>
        <p v-if="text5">{{ text5 }}</p>
        <p v-if="text6">{{ text6 }}</p>
        <p v-if="text7">{{ text7 }}</p>
        <p v-if="text8">{{ text8 }}</p>
      </div>
      <div class="confirmationFooter">
        <button @click="confirm" class="confirm">Confirm</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: [
    "show", //This is needed for this container to be shown (boolean).
    "header",
    "headerTwo",
    "headerThree",
    "text1",
    "text2",
    "text3",
    "text4",
    "text5",
    "text6",
    "text7",
    "text8",
    "confirm", // This is a function
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