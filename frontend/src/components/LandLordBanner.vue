<template>
  <div class="component6">
    <div class="LookingForCustomers">
      <label for="LookingForCustomers">Looking For Customers?</label>
    </div>

    <img
      class="LandLordPic"
      src="../assets/landlordpic.png"
      alt="LandLordPic"
    />
    <button class="LandLordBtn">Become a landlord</button>
  </div>
</template>

<script>
export default {};
</script>

<style>
.component6 {
  display: flex;
  align-items: center;
  flex-direction: unset;
  margin-bottom: 10%;
}

.LandLordPic {
  width: 100%;
  height: 20%;
}

.LandLordBtn {
  position: absolute;
  height: 55px;
  width: 240px;
  border-radius: 20px;
  background-color: black;
  color: rgb(255, 174, 0);
  box-shadow: 2px 2px 2px white;
  font-weight: bold;
  font-size: 18px;
  cursor: grab;
  margin-bottom: 5%;
  margin-left: 75%;
}

.LookingForCustomers {
  position: absolute;
  font-size: 32px;
  font-weight: bold;
  padding-inline: 2px 2px;
  font-style: italic;
  color: rgb(255, 174, 0);
  margin-bottom: 50px;
  margin-left: 5%;
  padding: 3px 3px;
  box-shadow: 2px 2px 2px white;
  text-shadow: 2px 2px rgb(0, 0, 0);
}
</style>