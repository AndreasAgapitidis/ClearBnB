<template>
  <div>
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

    <div class="component2">
      <div class="userSignUp">
        <label for="userSignUp">Not a member?</label>
      </div>

      <button class="registerBtn">Register here</button>
    </div>

    <div class="component3">
      <img
        src="../assets/poolhouse.jpg"
        alt="HouseWithPool"
        width="500"
        height="400"
      />

      <div class="shameLessTxt">
        <label for="shameLessTxt"
          >Treat yourself and your family.<br />This gem is located close<br />to
          the italian wine-yards in Toscana.<br /><br /><br />Read more.</label
        >
      </div>
    </div>

    <div class="availableTxt">
      <label for="availableTxt">Available apt./houses</label>
    </div>

    <div class="component4">
      <img
        src="../assets/poolhouse.jpg"
        alt="HouseWithPool"
        width="250"
        height="300"
      />
      <img
        src="../assets/poolhouse.jpg"
        alt="HouseWithPool"
        width="250"
        height="300"
      />
      <img
        src="../assets/poolhouse.jpg"
        alt="HouseWithPool"
        width="250"
        height="300"
      />
      <img
        src="../assets/poolhouse.jpg"
        alt="HouseWithPool"
        width="250"
        height="300"
      />
    </div>

    <div class="component5">
      <div class="studentTxt">
        <label for="studentTxt"
          >Student?<br />No worries,with our beneficial student package<br />
          you'll be eligible for student dotms/apt. in no time!<br />Read more
          here</label
        >
      </div>
    </div>

    <div class="component6">
      <img
        src="../assets/landlordpic.png"
        alt="LandLordPic"
        width="100%"
        height="5%"
      />

      <button class="landlordBtn">Become a landlord</button>
    </div>

    <div class="component7">
      <div class="studentTxt">
        <label for="studentTxt"
          >Not sure where you wanna go?<br />No worries,we got you
          covered.</label
        >
      </div>

      <button class="rndLocationBtn">Get random location</button>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
.component1 {
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: space-evenly;
  margin-bottom: 20%;
  margin-right: 5%;
}

.component2 {
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 10%;
  margin-left: 10%;
  margin-right: 10%;
}

.component3 {
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 10%;
}
.component4 {
  display: flex;
  align-items: flex-start;
  flex-direction: row;
  justify-content: space-evenly;
  margin-bottom: 10%;
}
.component5 {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-evenly;
  margin-bottom: 10%;
}
.component6 {
  display: flex;
  align-items: center;
  flex-direction: unset;
  margin-bottom: 10%;
}

.component7 {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-evenly;
  margin-bottom: 10%;
}
</style>