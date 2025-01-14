<template>
  <div class="calendar" z-index="0">
    <form class="calendar-form">
      <v-date-picker
        v-if="renderTime"
        :masks="masks"
        class="date-picker"
        is-expanded
        mode="date"
        :min-date="new Date()"
        :disabled-dates="disabledDates"
        color="blue"
        v-model="range"
        is-range
      />
    </form>
  </div>

  <div class="info-display">
    <div class="prieContrainer">
      <div class="priceCalculator">
        <p>
          Adult:
          {{ adult.id }}
        </p>
        <p>
          Children:
          {{ child.id }}
        </p>
        <p>Your stay: {{ differenceInDays }} days</p>
        <p v-if="detailprop">
          Total: {{ priceWithProfit * differenceInDays }} SEK
        </p>
      </div>
    </div>

    <form class="custom-number" @submit.prevent="addReservation">
      <label for="adultCustomer"
        ><h4 class="adult">Please select the amount of adults:</h4>
      </label>
      <select name="adultCustomer" id="adultCustomer" v-model="adult" required>
        <option disabled value="0">Adult</option>
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
      <select name="childrenCustomer" id="childrenCustomer" v-model="child">
        <option disabled value="0">Children</option>
        <option
          v-for="child in childrenMenu"
          :key="child.id"
          v-bind:value="{ id: child.id, text: child.name }"
        >
          {{ child.name }}
        </option>
      </select>
      <div class="moreCat">
        <img
          src="https://media1.tenor.com/images/551d452e9eb7377fd4d189bf905a61f3/tenor.gif?itemid=5588862"
          alt=""
          class="meowmeow"
        />
      </div>

      <div class="buttons">
        <button class="book-now">Book now!</button>
        <button class="cancel" type="reset" v-on:click="clearFields">
          Cancel
        </button>
      </div>
    </form>
  </div>
  <Confirmation
    class="ConfirmationTemplate"
    v-if="loggedInUser && showConfirmationBox && detailprop && owner"
    :header="'Thank you ' + loggedInUser.firstName"
    :headerTwo="'The booking is now confirmed'"
    :headerThree="'Booking number: ' + currentReservationID"
    :text1="'Name: ' + loggedInUser.firstName"
    :text2="'Lastname: ' + loggedInUser.lastName"
    :text3="'City: ' + detailprop.city"
    :text4="'Address: ' + detailprop.address"
    :text5="'Owner: ' + owner.firstName + ' ' + owner.lastName"
    :text6="'Check-in: ' + currentCheckInDate"
    :text7="'Check-out: ' + currentCheckOutDate"
    :text8="' ______________________________ '"
    :text9="'Price: ' + priceWithProfit * differenceInDays + ' sek'"
    :img="detailprop.images[0]"
  />
</template>

<script>
import Confirmation from "./confirmationComponents/Confirmation.vue";

export default {
  components: {
    Confirmation,
  },

  props: ["detailprop", "owner"],

  data() {
    return {
      adult: { id: "1" },
      child: { id: "0" },
      price: this.price,
      date: "",
      days: null,
      disabledDates: [],
      showConfirmationBox: false,
      currentReservationID: null,
      loggedInUser: null,
      currentCheckInDate: null,
      currentCheckOutDate: null,

      childrenMenu: [
        { id: 0, name: "0" },
        { id: 1, name: "1" },
        { id: 2, name: "2" },
        { id: 3, name: "3" },
        { id: 4, name: "4" },
        { id: 5, name: "5" },
        { id: 6, name: "6" },
        { id: 7, name: "7" },
        { id: 8, name: "8" },
        { id: 9, name: "9" },
      ],
      adultMenu: [
        { id: 1, name: "1" },
        { id: 2, name: "2" },
        { id: 3, name: "3" },
        { id: 4, name: "4" },
        { id: 5, name: "5" },
        { id: 6, name: "6" },
        { id: 7, name: "7" },
        { id: 8, name: "8" },
        { id: 9, name: "9" },
      ],

      range: {
        start: this.$store.state.dateRange.start,
        end: this.$store.state.dateRange.end,
      },
      masks: {
        input: "YYYY-MM-DD",
      },
    };
  },

  created() {
    if (!this.range.start || !this.range.end) {
      (this.range.start = new Date()), (this.range.end = new Date());
    }
  },

  methods: {
    openModal() {
      this.showConfirmationBox = true;
      document.body.classList.add("modal-open");
    },

    clearFields() {
      (this.adult.id = 1), (this.child.id = 0);
    },

    async checkDuplicatedBooking() {
      let res = await fetch("/rest/listings/" + this.detailprop.id);
      let listing = await res.json();
      let latestUnavailableDates = listing.unavailableDates;

      let duplicate = false;
      for (let i = 0; i < latestUnavailableDates.length; i++) {
        if (
          new Date(latestUnavailableDates[i] * 1000)
            .toISOString()
            .substring(0, 10) ===
          new Date(this.range.start).toISOString().substring(0, 10)
        ) {
          duplicate = true;
          break;
        }
      }
      return duplicate;
    },

    async addReservation() {
      if (!this.$store.state.user) {
        alert("You need to log in in order to book!");
        window.scrollTo(0, 0);
        return;
      } else if (this.$store.state.user.isAdmin === "true") {
        alert("You cannot make a personal booking when logged in as an admin");
        return;
      } else if (!this.adult.id) {
        alert("Please choose how many adults");
        return;
      } else if (this.differenceInDays == 0) {
        alert("You need to select dates!");
        return;
      } else if ((await this.checkDuplicatedBooking()) === true) {
        alert("Ops, one of the days have been booked by others just a sec ago");
        window.location.reload();
        return;
      } else if (0 + this.child.id + this.adult.id > this.detailprop.beds) {
        alert(
          "The maximum guests of this listing is " +
            this.detailprop.beds +
            ", please select an other bigger listing for your stay"
        );
        return;
      }

      let reservation = {
        adult: this.adult.id,
        children: this.child.id,
        price: this.priceWithProfit * this.differenceInDays,
        userId: this.$store.state.user.id,
        startDate: this.range.start,
        endDate: this.range.end,
        listingId: this.detailprop.id,
      };

      let dateUnix = this.range.start / 1000;

      for (let i = 0; i < this.differenceInDays; i++) {
        this.detailprop.unavailableDates.push(dateUnix);

        dateUnix += 86400;
      }

      await this.$store.dispatch("postReservation", reservation);

      this.$store.dispatch("putListing", this.detailprop);

      this.currentReservationID = this.$store.state.latestReservation.id;
      this.loggedInUser = this.$store.state.user;
      this.currentCheckInDate = this.$store.state.latestReservation.startDate.substring(
        0,
        10
      );
      this.currentCheckOutDate = this.$store.state.latestReservation.endDate.substring(
        0,
        10
      );

      this.openModal();
    },
  },

  computed: {
    priceWithProfit() {
      return Math.round(this.detailprop.price * 1.15);
    },

    differenceInDays() {
      return Math.round(
        (this.range.end.getTime() - this.range.start.getTime()) /
          (1000 * 3600 * 24)
      );
    },

    renderTime() {
      if (!this.detailprop) {
        return;
      }
      for (let i = 0; i < this.detailprop.unavailableDates.length; i++) {
        this.disabledDates.push(
          new Date(this.detailprop.unavailableDates[i] * 1000)
        );
      }
      return true;
    },
  },
};
</script>

<style scoped>
select {
  cursor: pointer;
}

select:focus-visible {
  outline: none;
}

.moreCat {
  z-index: -2;
  position: sticky;
  margin-right: 75px;
  margin-bottom: -4px;
}

.meowmeow {
  height: 60px;
  width: 60px;
}

.ConfirmationTemplate {
  background: none;
  z-index: 1;
  transition: all 2s ease-out;
}

.calendar {
  margin-top: 50px;
  width: 90vw;
  margin-inline: auto;
}

.info-display {
  display: grid;
  grid-template-columns: repeat(3, minmax(0, 1fr));
  grid-template-rows: repeat(2, minmax(0, 1fr));
  grid-template-areas:
    "det sel sel"
    "det sel sel";
  margin-top: 25px;
  justify-content: center;
  width: 90vw;
  margin-inline: auto;
}

.priceCalculator {
  align-self: center;
  text-decoration: underline;
  -webkit-text-stroke: thin;
  font-size: 1em;
  font-family: "Roboto";
}

.prieContrainer {
  grid-area: det;
  border: solid;
  align-self: center;
  border-radius: 15px;
}

.custom-number {
  grid-area: sel;
  font-size: 1em;
  font-family: "Roboto";
}

select {
  width: 100px;
  height: 30px;
  border-radius: 20px;
  background-color: white;
}

.buttons {
  display: flex;
  place-content: space-evenly;
  margin: 0px 0px 50px 0px;
}

button {
  width: 100px;
  height: 30px;
  border-radius: 20px;
  border: none;
  color: white;
  transition: 0.4s ease-out;
  box-shadow: 3px 3px rgba(0, 0, 0, 0.4);
  font-family: "Roboto";
  cursor: pointer;
}

.buttons button:hover {
  box-shadow: 6px 6px rgba(0, 0, 0, 0.6);
}

.book-now {
  background-color: limegreen;
}

.cancel {
  background-color: red;
}

@media (min-width: 320px) {
  .calendar {
    margin-top: 0px;
  }

  .info-display {
    display: grid;
    grid-template-columns: repeat(3, minmax(0, 1fr));
    grid-template-rows: repeat(4, minmax(0, 1fr));
    grid-template-areas:
      "det det det"
      "det det det"
      "sel sel sel"
      "sel sel sel";
    margin-top: 0px;
    justify-content: center;
    width: 90vw;
    margin-inline: auto;
  }

  .moreCat {
    margin-right: 30vw;
  }
}
@media (min-width: 576px) {
  .calendar {
    margin-top: 30px;
  }

  .info-display {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    grid-template-rows: repeat(1, minmax(0, 1fr));
    grid-template-areas: "det sel";
    margin-top: 30px;
  }

  .moreCat {
    margin-right: 15vw;
  }
}
@media (min-width: 768px) {
  .calendar {
    width: 60vw;
    margin-top: 50px;
  }

  .info-display {
    grid-template-columns: repeat(1, minmax(0, 1fr));
    grid-template-rows: repeat(2, minmax(0, 1fr));
    grid-template-areas:
      "det"
      "sel";
    width: 60vw;
    margin-top: 10px;
  }

  .moreCat {
    margin-right: 20vw;
  }
}

@media (min-width: 992px) {
  .info-display {
    grid-template-columns: repeat(2, minmax(0, 1fr));
    grid-template-rows: repeat(1, minmax(0, 1fr));
    grid-template-areas: "det sel";
    width: 60vw;
    margin-top: 30px;
  }
  .moreCat {
    margin-right: 12vw;
  }
}
</style>