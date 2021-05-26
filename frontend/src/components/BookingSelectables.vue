<template>
  <!-- a -->
  <div class="calendar" z-index="0">
    <form class="calendar-form">
      <!-- v-if will run this method/computed once before -->
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
          {{ adult }}
        </p>
        <p>
          Children:
          {{ child }}
        </p>
        <p>Your stay: {{ differenceInDays }} days</p>
        <p v-if="detailprop">
          Total: {{ priceWithProfit * differenceInDays }} SEK
        </p>
      </div>
    </div>

    <form class="custom-number" @submit.prevent="addReservation">
      <!-- <p>Please select the amount of customers:</p> -->
      <label for="adultCustomer"
        ><h4 class="adult">Please select the amount of adults:</h4>
      </label>
      <select
        name="adultCustomer"
        id="adultCustomer"
        v-model="adult"
        @change="renderKidsSelect()"
        required
      >
        <option disabled value="0">Adult</option>
        <option
          v-for="adultNumber in beds"
          :key="adultNumber"
          :value="adultNumber"
        >
          {{ adultNumber }}
        </option>
      </select>

      <label for="childrenCustomer"
        ><h4 class="children">Please select the amount of children:</h4>
      </label>
      <select
        name="childrenCustomer"
        id="childrenCustomer"
        class="childSelect"
        v-model="child"
        disabled
      >
        <option disabled>Children</option>
        <option
          v-for="childNumber in kidsArray"
          :key="childNumber"
          v-bind:value="childNumber"
        >
          {{ childNumber }}
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
    :text1="'Total guests: ' + totalGuests + ' person'"
    :text2="'Name: ' + loggedInUser.firstName"
    :text3="'City: ' + detailprop.city"
    :text4="'Address: ' + detailprop.address"
    :text5="'Owner: ' + owner.firstName + ' ' + owner.lastName"
    :text6="'Check-in: ' + range.start.toString().substring(15, 0)"
    :text7="'Check-out: ' + range.end.toString().substring(15, 0)"
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

  // Everytime a data changes, the relevant computed will run
  data() {
    return {
      adult: null,
      child: 0,
      price: this.price,
      date: "",
      days: null,
      disabledDates: [],
      showConfirmationBox: false,
      currentReservationID: null,
      loggedInUser: null,
      currentCheckInDate: null,
      currentCheckOutDate: null,
      beds: [],
      kidsArray: [],
      totalGuests: null,

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

    for (let i = 1; i < this.detailprop.beds + 1; i++) {
      this.beds.push(i);
    }
  },

  methods: {
    openModal() {
      this.showConfirmationBox = true;
      document.body.classList.add("modal-open");
    },

    renderKidsSelect() {
      document
        .getElementsByClassName("childSelect")[0]
        .removeAttribute("disabled");

      // this.child = null;

      if (this.adult + this.child > this.detailprop.beds) {
        this.child = this.detailprop.beds - this.adult;
      }
      this.kidsArray = [];

      for (let i = 0; i < this.detailprop.beds - this.adult + 1; i++) {
        this.kidsArray.push(i);
      }
    },

    // Yang: because our method when clicking confirm will force refresh, we don't need to remove class.
    // closeModal() {
    //   this.showConfirmationBox = false;
    //   document.body.classList.remove("modal-open");
    // },

    clearFields() {
      (this.adult = 1), (this.child = 0);
      document.getElementsByClassName("childSelect")[0].disabled = true;
    },

    async checkDuplicatedBooking() {
      let res = await fetch("/rest/listings/" + this.detailprop.id);
      let listing = await res.json();
      let latestUnavailableDates = listing.unavailableDates;
      // console.log(this.detailprop.unavailableDates);
      // console.log(this.disabledDates);
      // console.log("start " + this.range.start);
      // console.log(new Date(this.range.start).toISOString());
      // console.log("disabled " + this.disabledDates[0]);
      // console.log("unavailable date: " + this.detailprop.unavailableDates[0]);
      // console.log(new Date(this.range.start).toISOString().substring(0, 10));
      // console.log(
      //   new Date(this.disabledDates[0].getTime() + 86400000)
      //     .toISOString()
      //     .substring(0, 10)
      // );
      // console.log(this.range.start.getTime() / 1000);
      let duplicate = false;
      for (let i = 0; i < latestUnavailableDates.length; i++) {
        // console.log(
        //   "DISABLED LIST " +
        //     new Date(this.disabledDates[i].getTime())
        //       .toISOString()
        //       .substring(0, 10)
        // );
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
      } else if (!this.adult) {
        alert("Please choose how many adults");
        return;
      } else if (this.differenceInDays == 0) {
        alert("You need to select dates!");
        return;
      } else if ((await this.checkDuplicatedBooking()) === true) {
        alert("Ops, one of the days have been booked by others just a sec ago");
        window.location.reload();
        return;
      }
      this.totalGuests = this.adult + this.child;

      // console.log(this.detailprop.unavailableDates);
      // console.log(this.range.start);
      // console.log(this.range.start.getTime());

      // alert(this.range.start);
      console.log(this.range.start.toString());
      this.range.end.toString();

      let reservation = {
        adult: this.adult,
        children: this.child,
        price: this.priceWithProfit * this.differenceInDays,
        userId: this.$store.state.user.id,
        startDate: this.range.start.toString(),
        endDate: this.range.end.toString(),
        listingId: this.detailprop.id,
      };

      // divding with 1000 to get Unix format we are using in backend listing.unavailableDates
      let dateUnix = this.range.start / 1000;
      // console.log("date " + dateUnix);

      for (let i = 0; i < this.differenceInDays; i++) {
        this.detailprop.unavailableDates.push(dateUnix);

        // 86400 is a day in Unix format
        dateUnix += 86400;
      }

      await this.$store.dispatch("postReservation", reservation);

      // for (let i = 0; i < this.detailprop.unavailableDates.length; i++) {
      //   if (
      //     this.detailprop.unavailableDates[i] ==
      //     this.range.start.getTime() / 1000
      //   ) {
      //     let duplicate = true;
      //     return console.log("from detailprop: " + duplicate);
      //   }
      // }

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

  //   submitForms() {
  //     document.getElementsByClassName("calendar-form").submit();
  //     document.getElementsByClassName("custom-number").submit();
  //   },
  // },

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
      // Adding if to avoid sync problem
      // props didn't fetch info before being looped, thus returning an error
      // with the if(!this.detailprop), it will stop renderTime from running
      // but once props got info, the value changed, thus computed will run again

      if (!this.detailprop) {
        return;
      }
      for (let i = 0; i < this.detailprop.unavailableDates.length; i++) {
        this.disabledDates.push(
          new Date(this.detailprop.unavailableDates[i] * 1000)
          // using UnixTimestamp from java which was divided by 1000 to fit as an int
          // ** changing on sprint 2
        );
      }
      return true;
    },
  },
};
</script>

<style scoped>
/* body.modal-open {
  overflow: hidden;
} */
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