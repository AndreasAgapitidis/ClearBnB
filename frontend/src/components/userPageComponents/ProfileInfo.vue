<template>
  <!-- a -->
  <div class="info-Container">
    <div class="about">
      <p class="aboutMe">About me</p>
      <div class="divider"></div>
      <p>
        Lorem! <br />
        Ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,
        molestiae quas vel sint commodi repudiandae consequuntur voluptatum
        laborum numquam blanditiis harum quisquam eius sed odit.
      </p>
    </div>

    <div class="verified">
      <p class="verifiedUserText">Verified user</p>
      <div class="divider"></div>
      <p class="email"><span>&#10004;</span> Email</p>
      <p class="phonenumber"><span>&#10004;</span> Phonenumber</p>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.info-Container {
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: space-between;
}

.verified {
  width: 10em;
  height: 80px;
  padding: 10px;
}

.divider {
  width: 80%;
  height: 1px;
  background: rgb(179, 179, 179);
}

.about {
  width: 20em;
  padding: 10px;
}

p {
  text-align: left;
  margin-left: 10px;
}

.verified > p {
  margin: 3px;
  letter-spacing: -1px;
}

.about > p {
  margin: 3px;
  letter-spacing: -1px;
  line-height: 20px;
}

span {
  color: rgb(22, 150, 5);
}

@media only screen and (max-width: 320px) {
  .info-Container {
    flex-direction: column-reverse;
    justify-content: center;
    align-items: center;
    text-align: center;
  }

  .about,
  .verified {
    width: 85%;
  }

  .divider {
    display: none;
  }

  .verifiedUserText,
  .aboutMe {
    font-weight: bold;
  }
}

@media only screen and (max-width: 576px) {
  .verifiedUserText,
  .aboutMe {
    font-weight: bold;
  }
}

@media only screen and (max-width: 992px) {
  .verifiedUserText,
  .aboutMe {
    font-weight: bold;
  }
}
</style>