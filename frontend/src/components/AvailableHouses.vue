<template>
  <div class="component4">
    <div class="availableHouses">
      <p>Available apt./houses</p>
    </div>

    <div
      v-if="listings[0]"
      @click="bookingDetails(listings[0].id)"
      class="HouseCard1"
    >
      <img :src="listings[0].images[0]" />
      <div class="priceText text">
        <h4>{{ listings[0].price }}sek</h4>
      </div>
    </div>

    <div
      v-if="listings[1]"
      @click="bookingDetails(listings[1].id)"
      class="HouseCard2"
    >
      <img :src="listings[1].images[0]" />
      <div class="priceText text">
        <h4>{{ listings[1].price }}sek</h4>
      </div>
    </div>

    <div
      v-if="listings[2]"
      @click="bookingDetails(listings[2].id)"
      class="HouseCard3"
    >
      <img :src="listings[2].images[0]" />
      <div class="priceText text">
        <h4>{{ listings[2].price }}sek</h4>
      </div>
    </div>

    <div
      v-if="listings[3]"
      @click="bookingDetails(listings[3].id)"
      class="HouseCard4"
    >
      <img :src="listings[3].images[0]" />
      <div class="priceText text">
        <h4>{{ listings[3].price }}sek</h4>
      </div>
    </div>
  </div>
  <div class="divider"></div>
</template>

<script>
export default {
  async created() {
    // get 4 random listings from the database to display
    await this.$store.dispatch("fetchListings");

    if (this.$store.state.listings.length < 4) {
      return;
    }

    let randomNumberArray = [];
    let current = new Date();
    while (randomNumberArray.length < 4) {
      let r = Math.floor(Math.random() * this.$store.state.listings.length) + 1;
      if (randomNumberArray.indexOf(r) === -1) {
        randomNumberArray.push(r);
      }
    }
    for (let i = 0; i < randomNumberArray.length; i++) {
      this.listings.push(this.$store.state.listings[i]);
    }
  },

  data() {
    return {
      listings: [],
    };
  },

  methods: {
    bookingDetails(id) {
      this.$router.push("/house_details/" + id);
    },
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

.component4 {
  font-family: "Roboto", sans-serif;
  display: grid;
  grid-template-columns: auto auto;
  grid-template-rows: 10% 1fr 1fr;
  grid-template-areas:
    "title title"
    "H1 H2"
    "H3 H4";
  grid-gap: 1em 1em;
  place-items: center;
  cursor: pointer;
}

.availableHouses {
  font-weight: bold;
  grid-area: title;
  font-size: 1.1em;
  width: 100%;
  text-align: left;
}

.HouseCard1,
.HouseCard2,
.HouseCard3,
.HouseCard4{
  border: 1px solid black;
  border-radius: 20px;
  width: 150px;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
  overflow: hidden;
}

.HouseCard1 {
  grid-area: H1;
}
.HouseCard2 {
  grid-area: H2;
}
.HouseCard3 {
  grid-area: H3;

}
.HouseCard4 {
  grid-area: H4;
}

.priceText {
  font-family: "Roboto", sans-serif;
  text-align: center;
  font-size: 20px;
  font-weight: 200;
  font-style: italic;
  color: black;
}

.component4 > div > img {
  object-fit: cover;
  height: 120px;
  width: 100%;
  filter: grayscale(0.5);
  transition: 0.5s;
}
.component4 > div > img:hover {
  filter: none;
}

.component4 > div > div > h4 {
  margin: 0.5em;
}

.divider{
    margin: 4em auto;
  width: 85%;
  height: 1px;
  background: rgb(165, 165, 165);
}

@media only screen and (max-width: 320px){

  .component4{
    gap: 1.5em;
    grid-template-columns: 1fr;
    grid-template-rows: 10% 1fr 1fr 1fr 1fr;
    grid-template-areas:
    "title"
    "H1"
    "H2"
    "H3" 
    "H4";
  }

  .HouseCard1,
  .HouseCard2,
  .HouseCard3,
  .HouseCard4{
  width: 15em ;
}
  .availableHouses{
        text-align: center;
        font-size: 18px;
  }
}

@media only screen and (max-width: 576px){
  .component4{
    width: 85%;
    margin: 0 auto;
  }
  .availableHouses{
        text-align: center;
        font-size: 20px;
  }
  .HouseCard1,
  .HouseCard2,
  .HouseCard3,
  .HouseCard4{
  width: 100% ;
}
}

@media only screen and (max-width: 992px){
   .component4{
    width: 85%;
    margin: 10em auto;
  }
 .availableHouses{
        text-align: left;
        font-size: 25px;
  }
  .HouseCard1,
  .HouseCard2,
  .HouseCard3,
  .HouseCard4{
  width: 100% ;
}

}

@media only screen and (min-width: 993px){
   .component4{
    width: 85%;
    margin: 10em auto;
    gap: 1.5em;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 10% 1fr 1fr;
    grid-template-areas:
    "title ."
    "H1 H2"
    "H3 H4";
  
  }
 .availableHouses{
        text-align: center;
         font-size: 25px;
  }
  .HouseCard1,
  .HouseCard2,
  .HouseCard3,
  .HouseCard4{
  width:  25rem;
}
}

@media only screen and (min-width: 1200px){
  .component4{
    max-width: 1020px;
  }

}

</style>