<template>
 
  <div class="ProfileName">
    <h2 v-if="user">{{ user.firstName }} {{ user.lastName }}</h2>
    <h4>Member since December 2016</h4>
  </div>
</template>

<script>
export default {

  computed: {
    user: function () {
      return this.$store.state.user;
    },
  },
};
</script>

<style scoped>
.ProfileName {
  width: 100%;
}
h2,
h4 {
  margin: 0;
}
h2 {
  margin-top: 10px;
  letter-spacing: -2px;
}
h4 {
  font-family: "Roboto", sans-serif;
  font-weight: 100;
  font-size: 15px;
}
@media only screen and (max-width: 320px) {
  .ProfileName {
    text-align: center;
  }
}

@media only screen and (min-width: 576px) {
  .ProfileName {
    text-align: left;
  }
}
@media only screen and (min-width: 992px) {
  .ProfileName {
    text-align: left;
  }
}
</style>