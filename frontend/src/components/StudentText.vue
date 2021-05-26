<template>
  <!-- a -->
  <div class="component5">
    <div class="studentTxt">
      <label for="studentTxt">
        <span class="student">Student?</span>
        <br />
        No worries,with our beneficial student package<br />
        you'll be eligible for student dorms/apt. in no time!<br />
        Read more <span class="readMore">here</span></label
      >
    </div>
    <div class="picture"></div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.component5 {
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-evenly;
  margin: 3em auto;
  text-align: left;
  letter-spacing: 1px;
  width: 85%;
  height: 200px;
}

.studentTxt {
  font-size: 20px;
  font-weight: normal;
  color: black;
  letter-spacing: -0.5px;
}

.readMore {
  font-weight: bold;
}

.student {
  font-weight: bold;
  margin-bottom: 5px;
}

@media only screen and (max-width: 320px) {
  .studentTxt {
    text-align: center;
  }

  .picture {
    display: none;
  }
}

@media only screen and (max-width: 576px) {
  .picture {
    display: none;
  }
}

@media only screen and (min-width: 992px) {
  .component5 {
    flex-direction: row;
    justify-content: space-evenly;
    align-items: center;
  }

  .studentTxt {
    flex: 1;
    width: 80%;
  }

  .picture {
    flex: 1;
    background-image: url("https://images.pexels.com/photos/5965927/pexels-photo-5965927.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
    background-size: cover;
    background-repeat: no-repeat;
    height: 100%;
    width: 100%;
  }
}

@media only screen and (min-width: 1200px) {
  .component5 {
    max-width: 1020px;
  }

  .picture {
    flex: 1;
    background-image: url("https://images.pexels.com/photos/5965927/pexels-photo-5965927.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
    background-size: cover;
    background-repeat: no-repeat;
    height: 100%;
    width: 100%;
  }
}
</style>

