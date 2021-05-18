<template>
  <div class="info-Container">

     <div class="about">
      <p>About me</p>
      <div class="divider"></div>
      <p>Hi! <br>
        My name is Hello Helloson and i live in Stockholm, Sweden.
        When i'm not working, you'll find me fishing for trophy-fishes in the Bahamas!
        I own a few apartments in Stockholm that are newly renovated and ready to be booked by you!</p></div>

        
    <div class="verified">
      <p class="verifiedUserText">Verified user</p>
      <div class="divider"></div>
      <p class="email"><span>&#10004;</span> Email</p>
      <p class="phonenumber"><span>&#10004;</span> Phonenumber</p>
    </div>
    
   

  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

.info-Container{
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: space-between;
}

.verified{
  width: 8em;
  height: 80px;
  padding: 10px;
}

.divider{
  width: 80%;
  height: 1px;
  background: rgb(179, 179, 179);
}

.about{
  width: 13em;
  padding: 10px;
  overflow: scroll;
  overflow-x: hidden;
}

p{
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

span{
  color: rgb(22, 150, 5);
}
</style>