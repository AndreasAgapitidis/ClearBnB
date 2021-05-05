<template>
  <div class="component1">
    <label for="cities">Choose City:</label>
    <select name="cities" id="cities">
      <option value="malmö">Malmö</option>
      <option value="göteborg">Göteborg</option>
      <option value="stockholm">Stockholm</option>
    </select>

    <label for="checkInOutDate">Check in:</label>
    <input
      type="date"
      id="start"
      name="checkInOut"
      min="2021-01-01"
      max="2022-12-31"
    />

    <button class="PLACEHOLDER">PLACEHOLDER</button>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.component1 {
  background: url("../assets/Banner-Pictures/5.2.1Stockholm.jpeg");
  mix-blend-mode: darken;
  margin: 0 auto;
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: space-evenly;
  height: 15em;
}
</style>