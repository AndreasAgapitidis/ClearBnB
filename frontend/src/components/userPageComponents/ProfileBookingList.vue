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
        {{reservation.startDate.substring(10,0)}}
        <span>&#8592;</span>
         <br>
         {{reservation.endDate.substring(10,0)}}
         <span>&#8594;</span></p>

      <h5 class="price"><br> {{ reservation.price }}SEK<span><br>Total</span></h5>

      <button 
      v-on:click="select(reservation)"
      class="cancel">&#10008;</button>

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

  methods:{

    select: async function(event) {
      if(confirm("Are you sure you want to delete this reservation?")){
        let targetId = event.id;
        await this.$store.dispatch('deleteReservation', targetId);

        // update displayed reservation array to re-render bookings
        for(let i = 0; i < this.reservationList.length; i++){ 
          if (this.reservationList[i].id === targetId) {
            this.reservationList.splice(i, 1);
          }
        }
      }
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
  width: 85%;
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
  width: 100%;
  object-fit: cover;
  border-radius: 17px 0 0 17px;
}

.streetName{
  text-align: left;
  margin: 10px 0 0 10px;
  grid-area: sn;
 
}

.guests{
  text-align: left;
margin: 10px 0 0 10px;
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
  color: red;
  grid-area: ca;
}

 button {
  border: none;
  justify-self: flex-end;
  background: transparent;
}

p{
  font-size: 12px;
}

@media only screen and (min-width: 320px){

.reservationCards{
 margin-bottom: 30px;
  width: 100%;
  height: 200px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr 1fr;
  grid-template-areas:
  "img img img img"
  "sn sn . p"
  "ch ch . ."
  "g g . ca"
  ;
}

.reservationCards > img {
  height: 100px;
  border-radius: 17px;
}

.card-Container{
    margin: 0 auto;
  }
}
@media only screen and (min-width: 576px){
.reservationCards{
  margin-bottom: 35px;
  height: 100px;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
        "img img sn sn p"
        "img img g g ."
        "img img ch ch ca";
}

  .reservationCards > img {
  height: 100%;
  border-radius: 17px 0 0 17px;
}

 .card-Container{
     width: 85%;
    margin: 0 auto;
  }


}
@media only screen and (min-width: 992px){
  .reservationCards{
  width: 100%;
  margin: 0 auto 35px auto;
}
   .card-Container{
     width: 85%;
    margin: 0 auto;
  }

}
@media only screen and (min-width: 1200px){

   .card-Container{
     width: 85%;
    margin: 0 auto;
  }

}

</style>