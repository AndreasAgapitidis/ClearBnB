<template>
    <div class="housing-Container">
    <h4>Houses/Apartments</h4>
    <div class="divider"></div>
    <ProfileHouseAptList />
  </div>
</template>

<script>
  import ProfileHouseAptList from '../userPageComponents/ProfileHouseAptList.vue'
export default {
  components: {
    ProfileHouseAptList
  }
}
</script>

<style scoped>
.housing-Container{

  margin: 1em auto;
  width: 100%;
  height: 20em;
  overflow: scroll;
  overflow-x: hidden;
}

.divider {
  width: 50%;
  height: 1px;
  background: #929292;
  margin-left: 10px;
}

h4{
  text-align: left;
  margin-left: 10px;
  margin-bottom: 3px;
}
</style>