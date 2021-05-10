<template>
  <div class="component3">
    
    <div class="picture">
      <button class="bookNowBtn">Book now!</button>
    </div>

    <div class="shameLessTxt">
      <label for="shameLessTxt">
        Treat yourself and your family.<br />This gem is located close<br />to
        the italian wine-yards in Toscana.<br /><br /><br />Read more.</label
      >
    </div>

  
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');

.component3 {
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  height: 250px;
  margin-bottom: 10%;
}

.picture{
  background-image: url("../assets/Houses/HouseWithPool1.jpg");
  background-size: cover;
  border-radius: 0px 15px 15px 0px;
  width: 25em;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
  flex: 1;
  
}

.shameLessTxt {
  font-size: 15px;
  font-weight: bold;
  padding-inline: 2px 2px;
  color: black;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  flex: 1;
}

.bookNowBtn {
  font-family: 'Roboto', sans-serif;
  margin-bottom: 15px;
  height: 40px;
  width: 10em;
  border-radius: 20px;
  background-color: rgb(39, 39, 39);
  color: white;
  font-weight: 200;
  letter-spacing: 1px;
  font-size: 16px;
  cursor: pointer;
  box-shadow: 3px 3px 3px black;
}
</style>