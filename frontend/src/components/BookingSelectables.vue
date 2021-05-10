<template>
  <div class="calendar">
    <v-date-picker
      class="date-picker"
      is-expanded
      v-model="date"
      :disabled-dates="[new Date(2021, 9, 10), new Date(2021, 10, 10)]"
      color="blue"
      is-range
    />
  </div>

  <div class="info-display">
    <div class="priceCalculator">
      <p>
        Adult:
        {{ selectedAdults.id }}
      </p>
      <p>
        Children:
        {{ selectedChildren.id }}
      </p>
      <p>Your stay: 0 days</p>
      <p v-if="detailprop">Total: {{ detailprop.price }} SEK</p>
    </div>
    <div class="custom-number">
      <!-- <p>Please select the amount of customers:</p> -->
      <label for="adultCustomer"
        ><h4 class="checkInCustomer">Please select the amount of adults:</h4>
      </label>
      <select
        name="adultCustomer"
        id="adultCustomer"
        v-model="selectedAdults"
        required
      >
        <option disabled value="">Adult</option>
        <option
          v-for="adult in adults"
          :key="adult.id"
          v-bind:value="{ id: adult.id, text: adult.name }"
        >
          {{ adult.name }}
        </option>
      </select>

      <label for="childrenCustomer"
        ><h4 class="children">Please select the amount of children:</h4>
      </label>
      <select
        name="childrenCustomer"
        id="childrenCustomer"
        v-model="selectedChildren"
      >
        <option disabled value="">Children</option>
        <option
          v-for="child in children"
          :key="child.id"
          v-bind:value="{ id: child.id, text: child.name }"
        >
          {{ child.name }}
        </option>
      </select>
    </div>
  </div>
  <div class="buttons">
    <button class="book-now">Book now!</button>
    <button class="cancel">Cancel</button>
  </div>
</template>

<script>
export default {
  props: ["detailprop"],
  data() {
    return {
      selectedAdults: {
        id: "0",
      },

      selectedChildren: {
        id: "0",
      },
      date: "",
      children: [
        { id: 0, name: "0" },
        { id: 1, name: "1" },
        { id: 2, name: "2" },
        { id: 3, name: "3" },
      ],
      adults: [
        { id: 1, name: "1" },
        { id: 2, name: "2" },
        { id: 3, name: "3" },
      ],
      range: {
        start: new Date(2020, 0, 1),
        end: new Date(2020, 0, 5),
      },
    };
  },
};
</script>

<style scoped>
.calendar {
  margin-top: 50px;
  width: 90vw;
  margin-inline: auto;
}

.info-display {
  display: flex;
  flex-direction: row;
  margin-top: 25px;
  justify-content: center;
  width: 90vw;
  margin-inline: auto;
}

.priceCalculator {
  align-self: center;
  text-decoration: underline;
  -webkit-text-stroke: thin;
}

select {
  width: 100px;
  height: 30px;
  border-radius: 20px;
}

.buttons {
  margin: 50px 0px;
  display: flex;
  place-content: space-evenly;
}

button {
  width: 100px;
  height: 30px;
  border-radius: 20px;
  border-style: none;
  color: white;
}

.book-now {
  background-color: limegreen;
}

.cancel {
  background-color: red;
}
</style>