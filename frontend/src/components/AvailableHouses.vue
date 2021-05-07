<template>
  
    <div class="component4">
      <div class="availableHouses">
        <p>Available apt./houses</p>
        </div>

      <div class="HouseCard1">
        <img
          class="HouseWithPool1"
          src="../assets/Houses/HouseWithPool1.jpg"
          alt="HouseWithPool"
        />

        <div class="textHouseWithPool1 text"><h4>5000sek</h4></div>
      </div>

      <div class="HouseCard2">
        <img
          class="HouseWithPool2"
          src="../assets/Houses/HouseWithPool2.jpg"
          alt="HouseWithPool2"
          width="260"
          height="250"
        />

        <div class="textHouseWithPool2 text"><h4>12.000sek</h4></div>
      </div>

      <div class="HouseCard3">
        <img
          class="House1"
          src="../assets/Houses/House1.jpg"
          alt="House1"
       
        />

        <div class="textHouse1 text"><h4>3500sek</h4></div>
      </div>

      <div class="HouseCard4">
        <img
          class="House2"
          src="../assets/Houses/House2.jpg"
          alt="House2"
        />
        <div class="textHouse2 text"><h4>5000sek</h4></div>
      </div>

    </div>
  
</template>

<script>
export default {};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');

.component4 {
  font-family: 'Roboto', sans-serif;
  display: grid;
  grid-template-columns: auto auto;
  grid-template-rows: 10% 0.5fr 0.5fr;
  grid-template-areas: 
  ". title"
  "H1 H2"
  "H3 H4"
  ;
  grid-gap: 2em 2em;
  margin-bottom: 5%;
  margin-top: 5%;
  place-content: center;
}

.availableHouses {

  font-weight: bold;
  grid-area: title;
  font-size: 20px;

}

.HouseCard1{
grid-area: H1;
border: 1px solid black;
border-radius: 20px;
width: 200px;
box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
.HouseCard2{
grid-area: H2;
border: 1px solid black;
border-radius: 20px;
width: 200px;
box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
.HouseCard3{
grid-area: H3;
border: 1px solid black;
border-radius: 20px;
width: 200px;
box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
.HouseCard4{
grid-area: H4;
border: 1px solid black;
border-radius: 20px;
width: 200px;
box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}

.textHouseWithPool1 {
  text-align: center;
  font-size: 24px;
  font-style: italic;
  color: black;
}

.textHouseWithPool2 {
 
  font-size: 24px;
  font-style: italic;
  color: black;
}

.textHouse1 {
  
  font-size: 24px;
  font-style: italic;
  color: black;
}

.textHouse2 {
 
  font-size: 24px;
  font-style: italic;
  color: black;
}

.component4 > div > img {
  height: 150px;
  width: 200px;
  border-radius: 20px 20px 0 0;
  filter: grayscale(0.5);
  transition: 0.5s;
}
.component4 > div > img:hover{
  filter: none;
}

.component4 > div > div > h4{
 margin: 0.5em;
}

</style>