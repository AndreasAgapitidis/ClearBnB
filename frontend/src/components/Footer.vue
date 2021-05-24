<template>
  <footer>
    <div class="container">
      
      <div class="top">
        
          <div class="Contact">
          <img src='../assets/Logo ClearBnB/Footer/Calling.png' alt="">
          <h3>Contact us</h3>
          <p>+99 (0) 101 0000 888</p></div>
          <div class="Maps">
          <img src='../assets/Logo ClearBnB/Footer/Location.png' alt="">
          <h3>Adress</h3>
          <p>Blabla street 69<br>23365 155 Schweiz</p>
          </div>
          <div class="getBack">
            <a href="#" @click="scrollToTop()">
              <img src="../assets/Logo ClearBnB/Footer/Arrow - Up Square.png" alt="">
            </a>
          </div>
        
      </div>

  <div class="divider"></div>

    <div class="bottom">
      <div class="left-bottom">
        <ul>
        <li><a href="#"><img src='../assets/Logo ClearBnB/Footer/Face.png' alt=""></a></li>
        <li><a href="#"><img src='../assets/Logo ClearBnB/Footer/Insta.png' alt=""></a></li>
        <li><a href="#"><img src='../assets/Logo ClearBnB/Footer/Twitter.png' alt=""></a></li>
      </ul>
      </div>
     <div class="right-bottom">
       <p>Copyright Anno 2021</p>
     </div>
      
    </div>
  </div>
  
  </footer>
</template>

<script>

export default {
  data(){
    return {
     
    }
  },

  methods:
  {
    scrollToTop(){
      window.scrollTo(0,0);
     
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');

footer{
  height: auto;
  
}

  .container {
  height: 20em;
  background-image: url('../assets/Footer-Header/Footer-Final.png');
  background-repeat: no-repeat;
  background-size: cover;
  width: 100vw;
  margin: 0px;
  color: #FAFAFA;
  display: flex;
  flex-flow: column;
  justify-content: flex-end;
  align-items: center;
  font-family: Roboto, sans-serif;
}

.top{
 
  width: 100%;
  display: flex;
  justify-content: space-around;
}

.top > .Maps h3, p{
  margin: 0;
 
}

.top > .Maps p {
  margin-top: 10px;
  font-size: 13px;
}


.top > 
.Contact h3, p{
  margin: 0;
}

.top > 
.Contact p{
  margin-top: 10px;
  font-size: 13px;
}

.Maps{
  text-align: justify;
  margin-top: 20px;
}

.Contact {
  text-align: center;
  margin-top: 20px;
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  justify-content: flex-end;
}

.getBack {
  display: flex;
  align-items: flex-end;
}

.divider {
  background-color: rgb(70, 70, 70);
  height: 1px;
  width: 90%;
  margin: 0 auto;
  margin-top: 20px;
margin-bottom: 20px;
}

.bottom{
display: flex;
justify-content: space-around;
width: 100%;

}

.left-bottom > ul {
  padding: 0px;
  list-style: none;
  display: flex;
  flex-flow: row;
  margin: 0px;
  width: 200px;
  justify-content: space-around;
}

.left-bottom > ul > li > a > img {
  height: 20px;
  widows: 20px;
  margin-bottom: 15px;
 
}

.right-bottom > p{
  font-weight: 100;
  font-size: 12px;
  font-style: italic;
  margin-bottom: 15px;
  
}


@media screen and (max-width: 320px){

  .container{
   height: 25em;
  }
  .getBack{
    display: none;
  }
  .Maps{
      text-align: start;
  margin-top: 20px;
  display: flex;
  align-items: flex-start;
  flex-direction: column;
  justify-content: flex-end;
  }

  .Contact{
    justify-content: end;
    
  }

}

</style>