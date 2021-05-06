<template>
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
          <h4>Price</h4>
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
          <h4>Price</h4>
        </div>
      </a>
    </div>

    <div class="rightSide">
      <div class="availableHouses">
        <label for="availableHouses" class="availableHouseTxt"
          >Available apt./houses</label
        >
        <a href="">
          <img
            src="../assets/Houses/House1.jpg"
            alt="House1"
            width="250"
            height="300"
          />

          <div class="textHouse1">
            <h4>Price</h4>
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
            <h4>Price</h4>
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
.component4 {
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-evenly;
  margin-bottom: 10%;
  margin-top: -50%;
  flex-wrap: wrap;
  gap: 5%;
}

.availableHouseTxt {
  font-size: 24px;
  font-weight: bold;
}

.leftSide {
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  justify-content: space-between;
  width: 10%;
  height: 10%;
}

.rightSide {
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: space-evenly;
  margin-top: 50%;
  width: 10%;
  height: 10%;
}

.textHouseWithPool1 {
  margin-right: 25%;
  margin-left: 40%;
  margin-bottom: 10%;
  margin-top: 10%;
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