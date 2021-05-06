<template>
  <div class="component3">
    
    <div class="picture">
      <button class="bookNowBtn">Book now!</button>
    </div>
    

    <div class="shameLessTxt">
      <label for="shameLessTxt">
        Treat yourself and your family.<br />This gem is located close<br />to
        the italian wine-yards in Toscana.<br /><br /><br />
        <span>Read more.</span>
        
        </label>
    </div>

    
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap');

.component3 {
  font-family: 'Roboto', sans-serif;
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 10%;
  width: 100%;
  height: 300px;
}

.picture{
  background-image: url("../assets/poolhouse.jpg");
  background-size: cover;
  border-radius: 0px 15px 15px 0px;
  width: 25em;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: flex-end;
  box-shadow: rgba(0, 0, 0, 0.15) 1.95px 1.95px 2.6px;
  filter: grayscale(0.5);
}

.picture:hover{
  transition: 0.5s;
  filter: none;
}


.shameLessTxt {
  text-align: right;
  display: flex;
  font-size: 20px;
  font-weight: bold;
  padding-inline: 2px 2px;
  color: black;
  height: 100%;
  align-items: center;
}

span {
  text-decoration: underline;
}

.bookNowBtn {
  font-family: 'Roboto', sans-serif;
  height: 40px;
  width: 200px;
  border-radius: 20px;
  background-color: #2C2B2B;
  color: white;
  font-weight: 100;
  font-size: 16px;
  cursor: pointer;
  margin-bottom: 20px;
  outline: none;
}
</style>