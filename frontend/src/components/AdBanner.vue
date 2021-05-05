<template>
  <div class="component3">
    <img
      class="poolHousePic"
      src="../assets/poolhouse.jpg"
      alt="poolhouse.jpg"
    />

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

.poolHousePic {
  width: 50%;
  height: 40%;
  border-radius: 0px 15px 15px 0px;
}

.shameLessTxt {
  font-size: 20px;
  font-weight: bold;
  padding-inline: 2px 2px;
  color: black;
  margin-bottom: 10%;
  margin-right: 10%;
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
  margin-bottom: 5%;
  margin-left: 16%;
}
</style>