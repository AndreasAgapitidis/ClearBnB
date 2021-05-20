<template>
  <div v-if="ownedHousing" class="card-Container">
    <div
    v-for="houses in ownedList"
    v-bind:key="houses.id"
    v-bind:reserv="houses"
     class="reservationCards">

        <img :src="houses.images[0]">
        <h5 class="streetName">{{houses.address}}</h5>
        <p class="beds">{{houses.beds}} Beds</p>
        <p class="area">{{houses.area}} m2</p>
        <h5 class="price">{{houses.price}}SEK<br> <span>per Night</span></h5>
        <button class="cancel">&#9998;</button>

      </div>
    </div>
  
</template>

<script>
export default {

     data(){
      return {
      ownedList: []
      }
  },

   computed: {
    ownedHousing: async function() {
      if (!this.$store.state.user) {
        return [];
      }
      await this.$store.dispatch("fetchListings")
    
      let userId = this.$store.state.user.id;
      let houseListings = this.$store.state.listings;
      
      for (let i = 0; i < houseListings.length; i++){
        if(houseListings[i].owner === userId){
          this.ownedList.push(houseListings[i])
        }
      }
      return this.ownedList;
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
  width: 100%;
  height: 100px;
  margin: 1em auto;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
  "img sn sn . p"
  "img g g . ."
  "img a . . ca"
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

.beds{
  align-self: flex-end;
  text-align: left;
margin: 0 0 0 10px;
  grid-area: g;
}

.area{
  text-align: left;
margin: 0 0 0 10px;
  grid-area: a;
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
  font-size: 20px;
  color: rgb(75, 75, 75);
  grid-area: ca;
}

 button {
    border: none;
    background: transparent;
    width: 30px;
    justify-self: flex-end;
}

p{
  font-size: 12px;
}

</style>