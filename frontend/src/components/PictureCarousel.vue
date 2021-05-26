<template>
  <!-- a -->
  <transition name="fade" appaer>
    <div class="darken" v-if="showModal"></div>
  </transition>
  <div class="slideshow" v-if="carouselprop">
    <transition name="fade" appear>
      <div class="imgModal" v-if="showModal">
        <div class="leftArrow" @click="ModalprevIndex">
          <span></span>
          <span></span>
          <span></span>
        </div>
        <img class="imgZoomIn" :src="ModalUrl" alt="" @click="closeModal" />
        <div class="rightArrow" @click="ModalnextIndex">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </div>
    </transition>
    <h1>{{ carouselprop.address }}</h1>
    <img
      class="sliderCover"
      v-if="carouselprop"
      :src="carouselprop.images[count]"
      alt="photo of the listing cover"
    />
  </div>
  <div class="slides" v-if="carouselprop">
    <!-- <button class="btn-left" @click="prevIndex">Prev</button> -->
    <span class="btn-left" @click="prevIndex"></span>
    <div class="container">
      <div
        class="images"
        v-for="(image, index) in carouselprop.images"
        :key="index"
      >
        <img
          :src="carouselprop.images[index]"
          :key="index"
          @click="ImgModal(index)"
        />
      </div>
    </div>
    <!-- <button class="btn-right" @click="nextIndex">Next</button> -->
    <span class="btn-right" @click="nextIndex"></span>
  </div>
</template>

<script>
export default {
  props: ["carouselprop"],

  methods: {
    prevIndex() {
      this.count = this.count - 1;
      if (this.count < 0) {
        this.count = this.carouselprop.images.length - 1;
      }

      // document.getElementsByTagName("img").setAttribute(index, (index += 1));
    },

    nextIndex() {
      this.count = this.count + 1;
      if (this.count >= this.carouselprop.images.length) {
        this.count = 0;
      }
    },

    ModalprevIndex() {
      if (this.ModalIndex - 1 < 0) {
        this.ModalIndex = this.carouselprop.images.length - 1;
        return (this.ModalUrl = this.carouselprop.images[this.ModalIndex]);
      }
      this.ModalIndex -= 1;
      return (this.ModalUrl = this.carouselprop.images[this.ModalIndex]);
    },

    ModalnextIndex() {
      if (this.ModalIndex + 1 >= this.carouselprop.images.length) {
        this.ModalIndex = 0;
        return (this.ModalUrl = this.carouselprop.images[this.ModalIndex]);
      }
      this.ModalIndex += 1;
      return (this.ModalUrl = this.carouselprop.images[this.ModalIndex]);
    },

    ImgModal(url) {
      this.showModal = true;
      this.ModalIndex = url;
      this.ModalUrl = this.carouselprop.images[url];
      document.body.classList.add("modal-open");
    },

    closeModal() {
      this.showModal = false;
      document.body.classList.remove("modal-open");
    },
  },

  data() {
    return {
      count: 0,
      img: [],
      showModal: false,
      ModalIndex: null,
      ModalUrl: "",
    };
  },
};
</script>

<style scoped>
.container {
  display: flex;
  min-width: 65vw;
  justify-content: space-between;
}

.images img {
  height: 65px;
  width: 50px;
  border-radius: 10px;
}

h1 {
  z-index: 1;
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  font-size: 3em;
  font-family: serif;
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

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.imgModal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 99;
  border-radius: 16px;
  display: grid;
  width: 100%;
  max-width: 80vw;
  /* place-content: center; */
  /* place-content: space-evenly; */
  grid-template-areas:
    "mo mo mo"
    "mo mo mo"
    "mo mo mo"
    "left . right";
  grid-template-columns: repeat(3, minmax(0, 1fr));
  grid-template-rows: repeat(4, minmax(0, 1fr));
}

.imgZoomIn {
  width: 80vw;
  height: 70vh;
  object-fit: cover;
  padding: 15px;
  background-color: white;
  box-shadow: 0 1px 3px rgb(34 25 25 / 40%);
  -moz-box-shadow: 0 1px 2px rgba(34, 25, 25, 0.4);
  -webkit-box-shadow: 0 1px 3px rgb(34 25 25 / 40%);
  border-radius: 15px;
  grid-area: mo;
  margin-top: 50px;
  justify-self: center;
  animation: 0.5s ease-out 0s 1 slideInFromLeft;
}

@keyframes slideInFromLeft {
  0% {
    transform: translateX(-100%);
  }
  100% {
    transform: translateX(0);
  }
}

@keyframes scroll {
  0% {
    opacity: 0;
    transform: rotate(45deg) translate(0px, 0px);
  }
  50% {
    opacity: 1;
  }
  100% {
    opacity: 0;
    transform: rotate(45deg) translate(0px, 0px);
  }
}

.main {
  scroll-behavior: smooth;
  overflow-y: scroll;
}

.leftArrow {
  place-self: center;
  display: flex;
  flex-direction: row-reverse;
  grid-area: left;
}

.rightArrow {
  place-self: center;
  display: flex;
  grid-area: right;
}

.leftArrow span {
  display: block;
  width: 20px;
  height: 20px;
  border-bottom: 5px solid white;
  border-left: 5px solid white;
  margin: -5px;
  transform: rotate(45deg);
  animation: scroll 2s infinite;
}

.rightArrow span {
  display: block;
  width: 20px;
  height: 20px;
  border-top: 5px solid white;
  border-right: 5px solid white;
  margin: -5px;
  transform: rotate(45deg);
  animation: scroll 2s infinite;
}

.leftArrow span:nth-child(2),
.rightArrow span:nth-child(2) {
  animation-delay: 0.2s;
}

.leftArrow span:nth-child(3),
.rightArrow span:nth-child(3) {
  animation-delay: 0.4s;
}

.slideshow {
  top: 50px;
  left: 0;
  position: relative;
}

.sliderCover {
  height: 300px;
  width: 100vw;
  object-fit: cover;
  z-index: -1;
  filter: brightness(60%);
}

.slides {
  display: flex;
  flex-direction: row;
  margin-top: 60px;
  justify-content: space-around;
}

.photo1,
.photo2,
.photo3,
.photo4 {
  height: 75px;
  width: 50px;
}

/* button {
  padding: 5px;
  height: 20px;
  border-radius: 10%;
  border-style: none;
  border: 2px solid gray;
} */

.btn-left {
  align-self: center;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-right: 10px solid black;
}

.btn-right {
  align-self: center;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-left: 10px solid black;
}

@media (min-width: 320px) {
}

@media (min-width: 576px) {
  .images img {
    height: 100px;
    width: 80px;
    border-radius: 10px;
  }

  .container {
    display: flex;
    min-width: 75vw;
    justify-content: space-between;
  }

  h1 {
    left: 13vw;
    top: 190px;
    transform: none;
  }
}

@media (min-width: 768px) {
  .images img {
    height: 125px;
    width: 105px;
  }

  .slideshow {
    margin-top: 55px;
  }
}

@media (min-width: 992px) {
  .images img {
    height: 165px;
    width: 135px;
  }

  .slides {
    margin-top: 85px;
  }
}

@media (min-width: 1200px) {
  .images img {
    height: 190px;
    width: 165px;
  }
}
</style>