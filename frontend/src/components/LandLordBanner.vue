<template>
  <div class="component6">
    <div class="LookingForCustomers">
      <label for="LookingForCustomers"><h1>Looking For Customers?</h1></label>
    </div>
    <button class="LandLordBtn">Become a landlord</button>
  </div>
</template>

<script>
export default {};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');


.component6 {
  height: 250px;
   background-image: linear-gradient( rgb(0 0 0 / 40%), rgb(0 0 0 / 40%) ), url('../assets/landlordpic.png');
  background-repeat: no-repeat;
  background-size: cover;
  display: flex;
  align-items: center;
  justify-content: space-around;
  flex-direction: column;
  margin-bottom: 10%;
  width: 100%;
}

.LandLordBtn {
  font-family: 'Roboto', sans-serif;
  height: 55px;
  width: 240px;
  border-radius: 50px;
  background-color: #FAFAFA;
  color: rgb(58, 58, 58);
  font-weight: 100;
  font-size: 18px;
  cursor: pointer;
  margin-bottom: 15px;
  letter-spacing: 1px;
}


.LookingForCustomers {
  

  font-weight: bold;
  padding-inline: 2px 2px;
  margin: 0;
  padding: 3px 3px;

  
}

label > h1 {
  font-size: 2em;
  color: rgb(240, 240, 240); 
  font-weight: bolder;
}

</style>