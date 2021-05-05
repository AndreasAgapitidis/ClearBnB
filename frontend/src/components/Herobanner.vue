<template>

  <div class="component1">
      <label for="cities">Choose City:</label>
      <select name="cities" id="cities">
        <option value="malmö">Malmö</option>
        <option value="göteborg">Göteborg</option>
        <option value="stockholm">Stockholm</option>
      </select>

      <label for="checkInOutDate">Check in/out:</label>
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
export default {

}
</script>

<style scoped>

.component1 {
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: space-evenly;
  margin-bottom: 20%;
  margin-right: 5%;
  border: 2px solid black;
}

</style>