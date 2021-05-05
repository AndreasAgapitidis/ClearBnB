<template>
  <div class="wrapper">
    <label for="cities"></label>
    <select name="cities" id="cities">
      <option value="malmö">Malmö</option>
      <option value="göteborg">Göteborg</option>
      <option value="stockholm">Stockholm</option>
    </select>

    <label for="checkInOutDate"><h4 class="checkIn">Check in</h4></label>
    <input
      type="date"
      id="start"
      name="checkInOut"
      min="2021-01-01"
      max="2022-12-31"
    />

    <div class="popDestination">
      <h3>Popular destinations</h3>
      <h4>Malmö | Stockholm | Göteborg</h4>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
#cities {
  width: 250px;
  height: 50px;
  outline: none;
  border: none;
  border-radius: 13px 0px;
}

#start {
  width: 250px;
  height: 50px;
  outline: none;
  border: none;
  border-radius: 13px 0px;
}

.wrapper {
  background: #eb01a5;
  background-image: url("../assets/Banner-Pictures/5.2.1Stockholm.jpeg");
  background-image: url("../assets/Banner-Pictures/5.2.1Stockholm.jpeg"),
    linear-gradient(#ffffff, #d1363100);
  margin: 0 auto;
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: space-evenly;
  height: 25em;
}

.popDestination {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  width: 20em;
  height: 7em;
  background: rgba(0, 0, 0, 0.6);
  color: #fafafa;
  border-radius: 17px 0px 0px 17px;
}

.popDestination > h3,
h4 {
  word-spacing: 2px;
  text-align: right;
  margin: 0px;
  margin-right: 15px;
}

.checkIn {
  color: #fafafa;
  font-size: 15px;
}
</style>