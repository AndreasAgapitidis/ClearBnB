<template>
  <div class="component3">
    <a href="">
      <img
        class="poolHousePic"
        src="../assets/Houses/HouseWithPool1.jpg"
        alt="HouseWithPool"
        width="600"
        height="400"
      />
    </a>

    <button class="bookNowBtn">Book Now!</button>

    <div class="shameLessTxt">
      <label for="shameLessTxt">
        Treat yourself and your family.<br />This gem is located close<br />to
        the italian wine-yards in Toscana.<br /><br /><br />Read more.</label
      >
    </div>

    <button class="bookNowBtn">Book Now!</button>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.component3 {
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 10%;
}

.picture{
  background-image: url("../assets/poolhouse.jpg");
  background-size: cover;
  border-radius: 0px 15px 15px 0px;
  width: 25em;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
  filter: grayscale(0.5);
}

.picture:hover{
  transition: 0.5s;
  filter: none;
}

.shameLessTxt {
  font-size: 20px;
  font-weight: bold;
  padding-inline: 2px 2px;
  color: black;
  margin-bottom: 15%;
  margin-right: 5%;
}

.bookNowBtn {
  position: absolute;
  height: 40px;
  width: 200px;
  border-radius: 20px;
  background-color: rgb(37, 37, 37);
  color: white;
  font-weight: bold;
  font-size: 16px;
  cursor: grab;
  margin-bottom: 10%;
  margin-left: 16%;
  box-shadow: 3px 3px 3px black;
}
</style>