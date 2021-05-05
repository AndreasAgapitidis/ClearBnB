<template>
  <div>

    <Herobanner />
    <NotAMember />
    <AdBanner />
    <AvailableHouses />
    <LandLordBanner />
    <StudentText />
    <RandomLocation />

  </div>
</template>

<script>
import Herobanner from "../components/Herobanner.vue";
import NotAMember from "../components/NotAMember.vue";
import AdBanner from "../components/AdBanner.vue";
import AvailableHouses from "../components/AvailableHouses.vue";
import LandLordBanner from "../components/LandLordBanner.vue";
import StudentText from "../components/StudentText.vue";
import RandomLocation from "../components/RandomLocation.vue";

export default {
  components: {
    Herobanner,
    NotAMember,
    AdBanner,
    AvailableHouses,
    LandLordBanner,
    StudentText,
    RandomLocation
  },
};
</script>

<style scoped>
</style>




