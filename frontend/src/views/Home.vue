<template>
  <h1>Home</h1>
</template>

<script>
import Herobanner from '../components/Herobanner'
import NotAMember from '../components/NotAMemeber'

export default {


  components: {
    Herobanner,
    NotAMember
}

};


</script>

<style>




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