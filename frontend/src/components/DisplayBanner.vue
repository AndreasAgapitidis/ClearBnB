<template>
  <!-- a -->
  <div class="component3">
    <div class="picture"></div>

    <div class="textWrapper">
      <!-- <button class="bookNowBtn">Claim discount</button> -->
      <div class="shamelessTxt">
        <label for="shamelessTxt">
          Treat yourself and your family.<br />This gem is located close<br />to
          the italian wine-yards in Toscana.<br /><br /><br /><span
            >ONE-TIME OFFER!</span
          ></label
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

.component3 {
  background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),
    url("../assets/Houses/HouseWithPool1.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-evenly;
  height: 250px;
  width: 85%;
  margin: 0 auto;
  margin-bottom: 10%;
}

/* .picture{
  border-radius: 0px 15px 15px 0px;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  /* box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px; 
  flex: 1;
  }  */

.shamelessTxt {
  font-size: 16px;
  font-weight: bold;
  padding-inline: 2px 2px;
  color: rgb(255, 255, 255);
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.bookNowBtn {
  font-family: "Roboto", sans-serif;
  margin-top: 15px;
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

span {
  font-size: 20px;
  color: rgb(255, 255, 255);
}

@media only screen and (min-width: 320px) {
  .textWrapper {
    flex-flow: column-reverse;
    align-items: center;
    display: flex;
    height: 100%;
    width: 100%;
  }
}

@media only screen and (min-width: 576px) {
  .textWrapper {
    flex-flow: row;
    align-items: center;
    justify-content: space-evenly;
    display: flex;
    height: 100%;
    width: 100%;
  }
}

@media only screen and (min-width: 992px) {
  .component3 {
    background: none;
    width: 85%;
  }

  .textWrapper {
    flex-direction: column-reverse;
    flex: 1;
  }

  .shamelessTxt {
    color: black;
  }
  span {
    font-size: 20px;
    color: rgb(235, 22, 22);
  }

  .picture {
    width: 100%;
    height: 100%;
    background-image: linear-gradient(rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)),
      url("../assets/Houses/HouseWithPool1.jpg");
    background-size: cover;
    background-repeat: no-repeat;
    flex: 1;
  }
}

@media screen and (min-width: 1200px) {
  .component3 {
    max-width: 1020px;
  }
}
</style>