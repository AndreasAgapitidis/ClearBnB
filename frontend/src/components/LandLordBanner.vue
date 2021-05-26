<template>
  <!-- a -->
  <div class="component6">
    <div class="LookingForCustomers">
      <h1>Looking For Customers?</h1>
      <button class="LandLordBtn">Become a landlord</button>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

.component6 {
  height: 250px;
  background-image: linear-gradient(rgb(0 0 0 / 40%), rgb(0 0 0 / 40%)),
    url("../assets/landlordpic.png");
  background-repeat: no-repeat;
  background-size: cover;
  display: flex;
  align-items: center;
  justify-content: space-around;
  flex-direction: column;
  margin: 5em auto;
  width: 85%;
}

.LandLordBtn {
  font-family: "Roboto", sans-serif;
  height: 55px;
  width: 240px;
  border-radius: 50px;
  background-color: #fafafa;
  color: rgb(58, 58, 58);
  font-weight: 100;
  font-size: 18px;
  cursor: pointer;
  margin-bottom: 15px;
  letter-spacing: 1px;
}

.LookingForCustomers {
  color: rgb(240, 240, 240);
  font-weight: bolder;
  margin: 0;
  font-size: 0.7rem;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

@media only screen and (max-width: 320px) {
  .LookingForCustomers {
    font-size: 0.7rem;
  }
}

@media only screen and (min-width: 992px) {
  .component6 {
    align-items: flex-end;
    max-width: 1020px;
  }
  .LookingForCustomers {
    margin-right: 50px;
  }
}
</style>