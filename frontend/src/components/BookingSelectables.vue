<template>
  <div class="calendar">
    <form class="calendar-form">
      <v-date-picker
        class="date-picker"
        is-expanded
        v-model="range"
        :disabled-dates="[new Date(2021, 9, 10), new Date(2021, 10, 10)]"
        color="blue"
        is-range
      />
    </form>
  </div>

  <div class="info-display">
    <div class="priceCalculator">
      <p>
        Adult:
        {{ adult.id }}
      </p>
      <p>
        Children:
        {{ children.id }}
      </p>
      <p>Your stay: 0 days</p>
      <p v-if="detailprop">Total: {{ priceWithProfit }} SEK</p>
    </div>

    <form class="custom-number" @submit.prevent="addReservation">
      <!-- <p>Please select the amount of customers:</p> -->
      <label for="adultCustomer"
        ><h4 class="adult">Please select the amount of adults:</h4>
      </label>
      <select name="adultCustomer" id="adultCustomer" v-model="adult" required>
        <option disabled value="">Adult</option>
        <option
          v-for="adult in adultMenu"
          :key="adult.id"
          v-bind:value="{ id: adult.id, text: adult.name }"
        >
          {{ adult.name }}
        </option>
      </select>

      <label for="childrenCustomer"
        ><h4 class="children">Please select the amount of children:</h4>
      </label>
      <select name="childrenCustomer" id="childrenCustomer" v-model="children">
        <option disabled value="">Children</option>
        <option
          v-for="child in childrenMenu"
          :key="child.id"
          v-bind:value="{ id: child.id, text: child.name }"
        >
          {{ child.name }}
        </option>
      </select>
      <div class="buttons">
        <button class="book-now" value="Click" onclick="submitForms()">
          Book now!
        </button>
        <button class="cancel" type="reset">Cancel</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  props: ["detailprop"],

  data() {
    return {
      adult: { id: "" },
      children: { id: "" },
      price: this.price,
      date: "",

      childrenMenu: [
        { id: 0, name: "0" },
        { id: 1, name: "1" },
        { id: 2, name: "2" },
        { id: 3, name: "3" },
      ],
      adultMenu: [
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

  methods: {
    addReservation() {
      if (!this.$store.state.user) {
        alert("You need to log in in order to book!");
        return;
      }

      let reservation = {
        adult: this.adult.id,
        children: this.children.id,
        price: this.priceWithProfit,
        userId: this.$store.state.user.id,
        startDate: this.range.start,
        endDate: this.range.end,
        listingId: this.detailprop.id,
      };
      this.$store.dispatch("postReservation", reservation);
      alert("Booking has been submitted");
    },

    submitForms() {
      document.getElementsByClassName("calendar-form").submit();
      document.getElementsByClassName("custom-number").submit();
    },
  },

  computed: {
    priceWithProfit() {
      return Math.round(this.detailprop.price * 1.15);
    },
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
  background-color: white;
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

button:hover {
  border: none;
}

.book-now {
  background-color: limegreen;
}

.cancel {
  background-color: red;
}
</style>