<template>
<div class="Banner-Bg">
      <InputCityAndPickDate />
</div> 

    <div class="popDestContainer">
       <div class="popDestination">
        <h3>Popular destinations</h3>
        <h4>Malmö | Stockholm | Madrid</h4>
      </div>
    </div>

    <div class="divider"></div>
     
    <!-- </div>
  -->
</template>

<script>
import InputCityAndPickDate from "../components/searchComponents/InputCityAndPickDate.vue";
export default {
  components: {
    InputCityAndPickDate,
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap");

#cities {
  width: 250px;
  height: 50px;
  outline: none;
  border: none;
  border-radius: 0 20px 0px 20px;
}

#start {
  color: transparent;
  width: 250px;
  height: 50px;
  outline: none;
  border: none;
  border-radius: 0 20px 0px 20px;
  font-weight: 200;
}

.Banner-Bg {
  background-image: linear-gradient(rgb(255 255 255 / 0%), rgb(255 255 255)), url('../assets/Banner-Pictures/Stockholm.jpeg');
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
  margin: 0 auto;
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: center;
  height: 35em;
  font-family: "Roboto", sans-serif;
}

.searchContainer {
  width: auto;
  height: auto;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 25em;
  align-items: flex-end;
  
}

.popDestination {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
  width: 20em;
  height: 7em;
  margin: 0 auto;
  background: rgba(0, 0, 0, 0.6);
  color: #fafafa;
  border-radius: 17px;
}

.popDestination > h3,
h4 {
  font-weight: 200;
  text-align: right;
  margin: 0px;
 
}

.checkInDate,
.checkInCity {
  color: #fafafa;
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 5px;
  letter-spacing: 3px;
  text-shadow: 2px 2px 2px black;
}

.divider{
  margin: 4em auto;
  width: 90%;
  height: 1px;
  background: rgb(165, 165, 165);
}

@media screen and (max-width: 320px){
  .popDestContainer{
    align-items: center;
    justify-content: center;
  }
  .popDestination{
  width: 16em;
  }
}

@media screen and (min-width: 992px){

  .popDestContainer{
    height: auto;
    width: 100%;
    display: flex;
    justify-content: end;
    align-items: flex-end;
  }

  .popDestination{
    width: 40%;
  }
}
</style>