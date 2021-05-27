<template>
 
  <div class="profilepic-container">
    <div class="profilepic"></div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.profilepic {
  background-image: url("https://randomuser.me/api/portraits/men/72.jpg");
  background-size: cover;
  background-repeat: no-repeat;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 7px solid rgb(247, 247, 247);
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
}
</style>