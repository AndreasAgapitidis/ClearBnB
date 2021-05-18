<template>
  <div class="info-Container">
    <div class="verified">
      <p class="verifiedUserText">Verified user</p>
      <div class="divider"></div>
      <p class="email"><span>&#10004;</span> Email</p>
      <p class="phonenumber"><span>&#10004;</span> Phonenumber</p>
    </div>
    <div class="about">
      <p>About me</p>
      <div class="divider"></div>
      <p>Placeholder text Placeholder text 
      Placeholder text Placeholder text Placeholder text 
      Placeholder text Placeholder text Placeholder text </p></div>

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
  height: 100%;
  width: 13em;
  border: 1px solid black;
  overflow: hidden;
  
}

p{
  text-align: left;
  margin-left: 10px;
}

.verified > p {
  margin: 3px;
  letter-spacing: -1px;
}

span{
  color: rgb(22, 150, 5);
}
</style>