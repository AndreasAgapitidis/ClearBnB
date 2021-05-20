<template>
  <div class="card-Container">
    <div class="reservationCards">

        <img src="https://images.trvl-media.com/hotels/21000000/20210000/20209100/20209060/de854d89.jpg?impolicy=fcrop&w=1200&h=800&p=1&q=medium">
        <h5 class="streetName">Abdullagatan 72A</h5>
        <p class="guests">2 adults, 2 children</p>
        <h5 class="price">500 SEK<br> <span>per Night</span></h5>
        <a class="cancel"><span>&#10539;</span></a>

      </div>
    </div>
  
</template>

<script>
export default {

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
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
  "img sn sn . p"
  "img g g . ."
  "img . . . ca"
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