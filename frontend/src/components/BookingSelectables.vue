<template>
  <div class="calendar">
    <v-date-picker
      class="date-picker"
      v-model="date"
      :disabled-dates="[new Date(2021, 9, 10), new Date(2021, 10, 10)]"
      color="blue"
      is-range
    />
  </div>

  <div class="info-display">
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

    <div class="priceCalculator">
      <h1>
        Adult:
        {{ selectedAdults.id }}
      </h1>
      <h1>
        Children:
        {{ selectedChildren.id }}
      </h1>
      <h1 v-if="detailprop">price: {{ detailprop.price }} SEK</h1>
    </div>
  </div>
</template>

<script>
export default {
  props: ["detailprop"],
  data() {
    return {
      selectedAdults: {
        id: String,
      },

      selectedChildren: {
        id: String,
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

<style>
select {
  width: 100px;
}
</style>