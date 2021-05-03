<template>
<header>
  
      <nav class="container">
        <ul>
          <li class="logo"><img src=".\assets\Logo ClearBnB\Company Logo\Logo ClearBnB White.png" alt=""></li>
          <li>Login</li>
        </ul>
      </nav>

</header>
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


  header{
    background-color: #454545;
    height: 50px;
    text-align: center;
    color: #FAFAFA;
    display: flex;
    justify-content: center;
  }

.container{
    display: flex;
    width: 100%;
}

  ul{
    width: 100%;
    margin: 0;
    
    padding: 5px;
    list-style: none;
     display: flex;
    justify-content: space-between;
    align-items: center;
  }
  li:nth-child(2){
    margin-right: 10px;
  }
  li:nth-child(1){
    margin-left: 10px;
  }

  img{
    height: 50px;
    width: 50px;
  }
</style>