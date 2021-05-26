<template>
  <!-- a -->
  <div class="component7">
    <div class="studentTxt">
      <p>
        Not sure where you wanna go?
        <br />
        No worries,we got you covered.
      </p>
      <button class="rndLocationBtn" @click="randomCity">
        Get random location
      </button>
    </div>
    <div class="picture"></div>
  </div>
</template>

<script>
export default {
  methods: {
    randomCity() {
      this.$store.dispatch("fetchCities");
      let randomCity = this.$store.state.cities[
        Math.floor(Math.random() * this.$store.state.cities.length)
      ].name;

      this.$store.dispatch("setUsersCity", randomCity);

      this.$router.push("/searchbycity/" + randomCity);
      window.scrollTo(0, 0);
    },
  },
};
</script>

<style scoped>
.component7 {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-evenly;
  margin: 4em auto;
  width: 85%;
  height: 300px;
}

.studentTxt {
  font-size: 20px;
  font-weight: bolder;
  color: black;
}

.rndLocationBtn {
  height: 55px;
  width: 240px;
  border-radius: 20px;
  background-color: white;
  color: black;
  font-weight: bold;
  font-size: 16px;
  cursor: pointer;
  margin-top: 10%;
  margin-bottom: 5%;
}

.picture {
  height: 100%;
  width: 100%;
}

@media only screen and (max-width: 320px) {
}
@media only screen and (max-width: 576px) {
}
@media only screen and (min-width: 992px) {
  .component7 {
    width: 85%;
    flex-direction: row-reverse;
    justify-content: space-around;
    align-items: flex-start;
    margin: 3em auto;
  }

  .studentTxt {
    flex: 1;
  }
  .picture {
    flex: 1;
    display: initial;
    background-image: url("https://img.flaticon.com/icons/png/512/235/235861.png?size=1200x630f&pad=10,10,10,10&ext=png&bg=FFFFFFFF");
    background-size: contain;
    background-repeat: no-repeat;
  }
}
@media only screen and (min-width: 1200px) {
  .component7 {
    max-width: 1020px;
  }
}
</style>
