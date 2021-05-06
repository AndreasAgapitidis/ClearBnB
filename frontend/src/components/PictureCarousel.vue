<template>
  <div class="slideshow" v-if="carouselprop">
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
    <img
      class="photo1"
      :src="carouselprop.images[1]"
      alt="photo of the listing1"
    />

    <img
      class="photo2"
      :src="carouselprop.images[2]"
      alt="photo of the listing2"
    />

    <img
      class="photo3"
      :src="carouselprop.images[3]"
      alt="photo of the listing3"
    />

    <img
      class="photo4"
      :src="carouselprop.images[4]"
      alt="photo of the listing4"
    />
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

      console.log(this.count);
    },

    nextIndex() {
      this.count = this.count + 1;
      if (this.count >= this.carouselprop.images.length) {
        this.count = 0;
      }
    },
  },

  data() {
    return {
      count: 0,
      img: [],
    };
  },
};
</script>

<style scoped>
h1 {
  z-index: 1;
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
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
</style>