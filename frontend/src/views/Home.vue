<template>
  <div>
    <Herobanner />
    <NotAMember />
    <AdBanner />
    <AvailableHouses />
    <StudentText />
    <LandLordBanner />
    <RandomLocation />
  </div>
</template>

<script>
import Herobanner from "../components/Herobanner.vue";
import NotAMember from "../components/NotAMember.vue";
import AdBanner from "../components/AdBanner.vue";
import AvailableHouses from "../components/AvailableHouses.vue";
import StudentText from "../components/StudentText.vue";
import LandLordBanner from "../components/LandLordBanner.vue";
import RandomLocation from "../components/RandomLocation.vue";

export default {
  components: {
    Herobanner,
    NotAMember,
    AdBanner,
    AvailableHouses,
    StudentText,
    LandLordBanner,
    RandomLocation,
  },
};
</script>

<style scoped>
</style>




