<template>

  <div v-if="ownedHousing" class="card-Container">
    <div
      v-for="houses in ownedList"
      v-bind:key="houses.id"
      v-bind:reserv="houses"
      class="reservationCards"
    >
      <img :src="houses.images[0]" />
      <h5 class="streetName">{{ houses.address }}</h5>
      <p class="beds">{{ houses.beds }} Beds</p>
      <p class="area">{{ houses.area }} m2</p>
      <h5 class="price">
        {{ houses.price }}SEK<br />
        <span>per Night</span>
      </h5>
 
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ownedList: [],
    };
  },

  computed: {
    ownedHousing: async function () {
      if (!this.$store.state.user) {
        return [];
      }
      await this.$store.dispatch("fetchListings");

      let userId = this.$store.state.user.id;
      let houseListings = this.$store.state.listings;
      this.ownedList = [];

      for (let i = 0; i < houseListings.length; i++) {
        if (houseListings[i].owner === userId) {
          this.ownedList.push(houseListings[i]);
        }
      }
      return this.ownedList;
    },
  },


  watch: {
    "$store.state.addedListing": async function () {
      if (!this.$store.state.user) {
        return [];
      }
      await this.$store.dispatch("fetchListings");

      let userId = this.$store.state.user.id;
      let houseListings = this.$store.state.listings;
      this.ownedList = [];

      for (let i = 0; i < houseListings.length; i++) {
        if (houseListings[i].owner === userId) {
          this.ownedList.push(houseListings[i]);
        }
      }
    },
  },
};
</script>

<style scoped>
.card-Container {
  width: 85%;
  height: 100%;
  margin-left: 10px;
  margin-top: 10px;
}

.reservationCards {
  width: 100%;
  height: 100px;
  margin: 1em auto;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "img sn sn . p"
    "img g g . ."
    "img a . . .";
}

.reservationCards > img {
  grid-area: img;
  height: 100%;
  width: 100%;
  object-fit: cover;
  border-radius: 17px 0 0 17px;
}

.streetName {
  text-align: left;
  margin: 0 0 0 10px;
  grid-area: sn;
}

.beds {
  align-self: center;
  text-align: left;
  margin: 0 0 0 10px;
  grid-area: g;
}

.area {
  text-align: left;
  margin: 0 0 0 10px;
  grid-area: a;
}

.price {
  margin: 0;
  grid-area: p;
  text-align: right;
  color: rgb(114, 209, 233);
}

.price > span {
  font-size: 12px;
  font-weight: 200;
  color: black;
}

button {
  border: none;
  background: transparent;
  width: 30px;
  justify-self: flex-end;
}

p {
  font-size: 12px;
}


@media only screen and (min-width: 320px) {
  .reservationCards {
    margin-bottom: 30px;
    width: 100%;
    height: 200px;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr 1fr;
    grid-template-areas:
      "img img img img"
      "sn sn p p"
      "g g . . "
      "a a . . ";
  }

  .reservationCards > img {
    height: 100px;
    border-radius: 17px;
  }

  .card-Container {
    margin: 0 auto;
  }
}

@media only screen and (min-width: 576px) {
  .reservationCards {
    margin-bottom: 35px;
    height: 100px;
    grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
    grid-template-rows: 1fr 1fr 1fr;
    grid-template-areas:
      "img img sn sn p"
      "img img g g ."
      "img img a a .";
  }

  .reservationCards > img {
    height: 100%;
    border-radius: 17px 0 0 17px;
  }
  .card-Container {
    width: 85%;
    margin: 0 auto;
  }
}
@media only screen and (min-width: 992px) {
  .reservationCards {
    width: 100%;
    margin: 0 auto 35px auto;
  }
  .card-Container {
    width: 85%;
    margin: 0 auto;
  }
}
@media only screen and (min-width: 1200px) {
  .card-Container {
    width: 85%;
    margin: 0 auto;
  }
}
</style>