<template>
  <div v-if="reservations" class="card-Container">
    <div
      v-for="reservation in reservationList"
      v-bind:key="reservation.id"
      v-bind:reserv="reservation"
     class="reservationCards">

      <img :src="reservation.listingInfo.images[0]">

      <h5 class="streetName">{{reservation.listingInfo.address}}</h5>

      <p class="guests">{{reservation.adult}} Adults {{reservation.children}} children</p>

      <p class="checkInText">
        <span>&#8592;</span>
         <br> 
         <span>&#8594;</span></p>
      <h5 class="price"><br> {{reservation.price }}SEK<span><br>Total</span></h5>
      <a class="cancel"><span>&#10539;</span></a>
    </div>
    </div>
  
</template>

<script>


export default {

  data() {
    return {
      reservationList : []
    }
  },

  computed: {
    reservations: async function() {
      if (!this.$store.state.user) {
        return [];
      }

      let response = await fetch('/rest/userlistings/' + this.$store.state.user.id);
      let reservations = await response.json();

      // loop through and add a "listing" property to each reservation in "reservations" array

      for (let i = 0; i < reservations.length; i++) {
        let res = await fetch('/rest/reservation/' + reservations[i].listingId);
        reservations[i].listingInfo = await res.json();
      }

      this.reservationList = reservations
      
      return reservations;
    }
  }
}
</script>

<style scoped>
.card-Container{
  width: 350px;
  height: 100%;
  margin-left: 10px;
  margin-top: 10px;
}

.reservationCards{
  margin: 1em 0;
  width: 100%;
  height: 100px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
  "img sn sn . p"
  "img g g . ."
  "img ch ch . ca"
  ;
}

.reservationCards > img {
  grid-area: img;
  height: 100%;
  width: 120px;
  object-fit: cover;
  border-radius: 17px 0 0 17px;
}

.streetName{
  text-align: left;
  margin: 0 0 0 10px;
  grid-area: sn;
 
}

.guests{
  text-align: left;
margin: 0 0 0 10px;
  grid-area: g;
}

.checkInText{
 margin: 0 0 0 10px;
  text-align: left;
  grid-area: ch;
  align-self: flex-end;
}

.price{
  margin: 0;
  grid-area: p;
  text-align: right;
  color: rgb(114, 209, 233);
}

.price > span{
  font-size: 12px;
  font-weight: 200;
  color: black;
}

.cancel{
  font-size: 25px;
  color: red;
  grid-area: ca;
}

 a {
    border: 1px solid black;
    border-radius: 50%;
    width: 30px;
    justify-self: flex-end;
}

p{
  font-size: 12px;
}

</style>