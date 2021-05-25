<template>
  <div class="overlay">
    <transition name="fade" appear>
      <div class="darken" v-if="divSwitch"></div>
    </transition>

    <transition name="fade" appear>
      <div
        class="confirmationContainer"
        v-if="img && divSwitch"
        :style="backgroundStyles(img)"
      >
        <div class="darkerBackGround"></div>
        <div class="content">
          <h2 class="header">{{ header }}</h2>
          <p class="headerTwo">{{ headerTwo }}</p>
          <div class="profilePicContainer" v-if="profilePic">
            <img
              v-if="profilePic"
              v-bind:src="profilePic"
              alt=""
              class="profilePic"
            />
          </div>
          <p class="headerThree" v-if="!profilePic">{{ headerThree }}</p>
          <p class="text1" v-if="text1">{{ text1 }}</p>
          <p class="text2" v-if="text2">{{ text2 }}</p>
          <p class="text3" v-if="text3">{{ text3 }}</p>
          <p class="text4" v-if="text4">{{ text4 }}</p>
          <p class="text5" v-if="text5">{{ text5 }}</p>
          <p class="text6" v-if="text6">{{ text6 }}</p>
          <p class="text7" v-if="text7">{{ text7 }}</p>
          <p class="text8" v-if="text8">{{ text8 }}</p>
          <p class="text9" v-if="text9">{{ text9 }}</p>
          <button @click="closeConfirmationBox" class="confirm"></button>
        </div>
      </div>
    </transition>
  </div>
</template>



<script>
export default {
  data() {
    return {
      divSwitch: true,
    };
  },

  props: [
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
    "text9",
    "img",
    "profilePic",
  ],

  methods: {
    closeConfirmationBox() {
      this.$parent.showConfirmationBox = false;
      // window.location.reload();
      document.body.classList.remove("modal-open");
      this.$parent.$parent.showPopUp = false;
      this.divSwitch = false;
      this.$parent.showModal = false;
    },

    backgroundStyles(image) {
      return {
        "background-image": `url(${image})`,
      };
    },
  },
};
</script>

<style scoped>
.ConfirmationTemplate {
  background: none;
  z-index: 1;
}

.overlay {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 2;
}

.content {
  color: white;
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  grid-template-rows: repeat(11, minmax(0, 1fr));
  grid-template-areas:
    "h1 h1 h1 h1"
    "h2 h2 h2 h2"
    "h3 h3 h3 h3"
    "h3 h3 h3 h3"
    "text1 text1 . ."
    "text2 text2 text6 text6"
    "text3 text3 text7 text7"
    "text4 text4 text8 text8"
    "text5 text5 text9 text9"
    "btn btn btn btn"
    "btn btn btn btn";
  height: 100%;
  overflow-y: auto;
  /* margin: 10px; */
}

.header {
  grid-area: h1;
}

.headerTwo {
  grid-area: h2;
}

.headerThree {
  grid-area: h3;
  align-self: center;
}

.text1 {
  grid-area: text1;
}

.text2 {
  grid-area: text2;
}

.text3 {
  grid-area: text3;
}

.text4 {
  grid-area: text4;
}

.text5 {
  grid-area: text5;
}

.text6 {
  grid-area: text6;
}

.text7 {
  grid-area: text7;
}

.text8 {
  grid-area: text8;
}

.text9 {
  grid-area: text9;
}

.profilePicContainer {
  grid-area: h3;
}

.profilePic {
  height: 100%;
}

.confirm {
  grid-area: btn;
  align-self: center;
  background-image: url("https://cdn.discordapp.com/attachments/826036003193880596/844533424253435914/ok_1.png");
  background-size: cover;
  width: 80px;
  height: 80px;
  place-self: center;
  background-color: #ffffff00;
  border: none;
}

.darkerBackGround {
  position: absolute;
  top: 0px;
  left: 0px;
  bottom: 0;
  right: 0;
  opacity: 0.9;
  width: 100%;
  height: 100%;
  z-index: -1;
  border-radius: 16px;
  background-color: rgba(0, 0, 0, 0.4);
}

.darken {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 98;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
}

.confirmationContainer {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;
  width: 100%;
  height: 100%;
  max-width: 90vw;
  max-height: 95vh;
  background-color: black;
  border-radius: 16px;
  background-repeat: no-repeat;
  background-size: cover;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

@media (min-width: 320px) {
  .content {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    grid-template-rows: repeat(4, 1fr);
    grid-template-areas:
      "h1 h1 h1 h1"
      "h2 h2 h2 h2"
      "h3 h3 h3 h3"
      "text1 text1 text1 text1"
      "text2 text2 text2 text2"
      "text3 text3 text3 text3"
      "text4 text4 text4 text4"
      "text5 text5 text5 text5"
      "text6 text6 text6 text6"
      "text7 text7 text7 text7"
      "text8 text8 text8 text8"
      "text9 text9 text9 text9"
      "btn btn btn btn"
      "btn btn btn btn";
    height: 100%;
    overflow-y: auto;
  }
}

@media (min-width: 576px) {
  /* For mobile phones: */
}

@media (min-width: 768px) {
}
</style>