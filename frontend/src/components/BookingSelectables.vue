<template>
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
      <!-- <p>Please select the amount of customers:</p> -->
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
    :headerTwo="'Thank you for your booking, the booking is now confirmed'"
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

  // Everytime a data changes, the relevant computed will run
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

    // Yang: because our method when clicking confirm will force refresh, we don't need to remove class.
    // closeModal() {
    //   this.showConfirmationBox = false;
    //   document.body.classList.remove("modal-open");
    // },

    clearFields() {
      (this.adult.id = 1), (this.child.id = 0);
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
        console.log(
          "disabledDates: " +
            new Date(latestUnavailableDates[i] * 1000 + 86400000)
              .toISOString()
              .substring(0, 10)
        );

        console.log(
          "start: " + new Date(this.range.start).toISOString().substring(0, 10)
        );

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

      // console.log(this.detailprop.unavailableDates);
      // console.log(this.range.start);
      // console.log(this.range.start.getTime());

      // alert(this.range.start);
      // // this.range.start.setHours(0, 0, 0, 0);
      // this.range.end.setHours(0, 0, 0, 0);

      let reservation = {
        adult: this.adult.id,
        children: this.child.id,
        price: this.priceWithProfit * this.differenceInDays,
        userId: this.$store.state.user.id,
        startDate: this.range.start,
        endDate: this.range.end,
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
.ConfirmationTemplate {
  background: none;
  z-index: 1;
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
}

.prieContrainer {
  grid-area: det;
  border: solid;
  align-self: center;
  border-radius: 15px;
}

.custom-number {
  grid-area: sel;
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
  border: none;
  color: white;
  transition: box-shadow 0.3s;
  float: left;
}

button:hover {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.6), 0 10px 25px 0 rgba(0, 0, 0, 0.19);
}

.book-now {
  background-color: limegreen;
}

.cancel {
  background-color: red;
}
</style>