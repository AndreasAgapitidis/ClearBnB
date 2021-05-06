<template>
  <div>
    <div class="availableHouses">
      <label for="availableHouses" class="availableHouseTxt"
        >Available apt./houses</label
      >
    </div>

    <div class="component4">
      <div class="leftSide">
        <a href="">
          <img
            src="../assets/Houses/HouseWithPool1.jpg"
            alt="HouseWithPool"
            width="250"
            height="300"
          />
          <div class="textHouseWithPool1">
            <h4>Price1</h4>
          </div>
        </a>

        <a href="">
          <img
            src="../assets/Houses/HouseWithPool2.jpg"
            alt="HouseWithPool2"
            width="250"
            height="300"
          />

          <div class="textHouseWithPool2">
            <h4>Price2</h4>
          </div>
        </a>
      </div>

      <div class="rightSide">
        <a href="">
          <img
            src="../assets/Houses/House1.jpg"
            alt="House1"
            width="250"
            height="300"
          />

          <div class="textHouse1">
            <h4>Price3</h4>
          </div>
        </a>

        <a href="">
          <img
            src="../assets/Houses/House2.jpg"
            alt="House2"
            width="250"
            height="300"
          />

          <div class="textHouse2">
            <h4>Price4</h4>
          </div>
        </a>
      </div>
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
  margin-left: 40%;
}

.component4 {
  display: grid;
  display: inline-grid;
  grid-template-columns: auto auto auto;
  grid-gap: 50px 100px;
  margin-left: 10%;
  margin-bottom: 10%;
}

.leftSide {
}

.rightSide {
}

.textHouseWithPool1 {
  margin-right: 25%;
  margin-left: 40%;
  margin-bottom: 10%;
  width: 10%;
  height: 10%;
  font-size: 24px;
  font-weight: bold;
}

.textHouseWithPool2 {
  margin-right: 25%;
  margin-left: 40%;
  margin-bottom: 10%;
  width: 10%;
  height: 10%;
  font-size: 24px;
  font-weight: bold;
}

.textHouse1 {
  margin-right: 25%;
  margin-left: 40%;
  margin-bottom: 10%;
  width: 10%;
  height: 10%;
  font-size: 24px;
  font-weight: bold;
}

.textHouse2 {
  margin-right: 25%;
  margin-left: 40%;
  margin-bottom: 10%;
  width: 10%;
  height: 10%;
  font-size: 24px;
  font-weight: bold;
}
</style>