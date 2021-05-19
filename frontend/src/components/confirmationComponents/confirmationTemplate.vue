<template>
  <div class="overlay">
    <transition name="fade" appear>
      <div class="darken" v-if="divSwitch"></div>
    </transition>
    <transition name="slide" appear>
      <div class="confirmationContainer" v-if="divSwitch">
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
          <button @click="closeConfirmationBox" class="confirm">
            Nice! Close this confirmation.
          </button>
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
  ],

  methods: {
    closeConfirmationBox() {
      this.$parent.showConfirmationBox = false;
      this.divSwitch = false;
      // window.location.reload();
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

.background {
  background-color: rgba(rgb(0, 0, 0), rgb(0, rgb(0, 0, 0)), rgb(0, 0, 0), 0.5);
  width: 100vw;
  height: 100vh;
  z-index: 10;
}

.darken {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 998;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  transition: opacity 4;
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}

.fade-enter,
.fade-leave-to {
  opacity: 0;
}

.confirmationContainer {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 999;
  width: 100%;
  max-width: 50vw;
  background-color: white;
  border-radius: 16px;
}

.slide-enter-active,
.slide-leave-active {
  transition: opacity 0.5s;
}

.slide-enter,
.slide-leave-to {
  opacity: 0;
}
</style>