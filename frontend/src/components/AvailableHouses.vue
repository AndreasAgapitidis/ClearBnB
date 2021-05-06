<template>
  <div>
    <div class="availableHouses">
      <label for="availableHouses" class="availableHouseTxt"
        >Available apt./houses</label
      >
    </div>

    <div class="component4">
      <a href="">
        <img
          class="HouseWithPool1"
          src="../assets/Houses/HouseWithPool1.jpg"
          alt="HouseWithPool"
          width="260"
          height="250"
        />

        <div type="button" class="textHouseWithPool1">Price1</div>
      </a>

      <a href="">
        <img
          class="HouseWithPool2"
          src="../assets/Houses/HouseWithPool2.jpg"
          alt="HouseWithPool2"
          width="260"
          height="250"
        />

        <div type="button" class="textHouseWithPool2">Price2</div>
      </a>

      <a href="">
        <img
          class="House1"
          src="../assets/Houses/House1.jpg"
          alt="House1"
          width="260"
          height="250"
        />

        <div class="textHouse1">PriceA</div>
      </a>

      <a href="">
        <img
          class="House2"
          src="../assets/Houses/House2.jpg"
          alt="House2"
          width="260"
          height="250"
        />

        <div class="textHouse2">PriceB</div>
      </a>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.availableHouseTxt {
  font-size: 24px;
  font-weight: bold;
  margin-left: 35%;
}

.component4 {
  display: inline-grid;
  grid-template-columns: 5% 5%;
  grid-gap: 50px 400px;
  margin-left: 10%;
  margin-bottom: 5%;
  margin-top: 2%;
}

.HouseWithPool1 {
  border-radius: 20px 20px 20px 20px;
  box-shadow: 0px 0px 2px 2px black;
  border-bottom: 80px solid white;
}

.textHouseWithPool1 {
  position: relative;
  top: -60px;
  left: 70px;
  margin-right: 25%;
  margin-left: 40%;
  width: 10%;
  font-size: 24px;
  font-style: italic;
  color: black;
}

.HouseWithPool2 {
  border-radius: 20px 20px 20px 20px;
  box-shadow: 0px 0px 2px 2px black;
  border-bottom: 80px solid white;
}

.textHouseWithPool2 {
  position: relative;
  top: -60px;
  left: 70px;
  margin-right: 25%;
  margin-left: 40%;
  width: 10%;
  font-size: 24px;
  font-style: italic;
  color: black;
}

.House1 {
  border-radius: 20px 20px 20px 20px;
  box-shadow: 0px 0px 2px 2px black;
  border-bottom: 80px solid white;
}

.textHouse1 {
  position: relative;
  top: -60px;
  left: 70px;
  margin-right: 25%;
  margin-left: 40%;
  width: 10%;
  font-size: 24px;
  font-style: italic;
  color: black;
}

.House2 {
  border-radius: 20px 20px 20px 20px;
  box-shadow: 0px 0px 2px 2px black;
  border-bottom: 80px solid white;
}

.textHouse2 {
  position: relative;
  top: -60px;
  left: 70px;
  margin-right: 25%;
  margin-left: 40%;
  width: 10%;
  font-size: 24px;
  font-style: italic;
  color: black;
}
</style>