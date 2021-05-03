<template>
  <footer>
  <div class="top">

  </div>

  <div class="divider"></div>

  <div class="bottom">
    <ul>
      <li><a href="#"><img src='../assets/Logo ClearBnB/Footer/Face.png' alt=""></a></li>
      <li><a href="#"><img src='../assets/Logo ClearBnB/Footer/Insta.png' alt=""></a></li>
      <li><a href="#"><img src='../assets/Logo ClearBnB/Footer/Twitter.png' alt=""></a></li>
    </ul>
  </div>
  </footer>
</template>

<script>

export default {
  data(){
    return {
     
    }
  }
}
</script>

<style scoped>

  footer {
  background-image: url('../assets/Footer-Header/Footer-Final.png');
  background-repeat: no-repeat;
  background-size: cover;
  height: 10em;
  width: 100vw;
  margin: 0px;
  color: #FAFAFA;
  display: flex;
  flex-flow: column;
}

.top{

}

.divider {
  background-color: #FAFAFA;
  height: 1px;
  width: 90%;
}

.bottom{

}

.bottom > ul {
  list-style: none;
  display: flex;
  flex-flow: row;
}

.bottom > li > a > img {
  height: 50px;
  widows: 50px;
  border: 1px solid black;
}


</style>