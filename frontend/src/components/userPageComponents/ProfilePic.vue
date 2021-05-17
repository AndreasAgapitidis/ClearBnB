<template>
<div class="profilepic-container">
  <div class="profilepic"></div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
  .profilepic-container{
   
    height: 150px;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  }

  .profilepic{

    background-image: url('https://randomuser.me/api/portraits/men/72.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    width: 150px;
    height: 150px;
    border-radius: 50%;
    box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
  }
</style>