<template>
<header>
  
      <nav class="container">
        <ul>
          <li>
            <a href="#">
              <img src="../assets/Logo ClearBnB/Company Logo/Logo.png" alt="" srcset="">
            </a>
            </li>
          <li>
            <a href="#">Login</a>
            </li>
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
    height: 100px;
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
  li:nth-child(1){
    margin-left: 10px;
  }
  li:nth-child(2){
    margin-right: 10px;
  }
  li:nth-child(2)>a{
    text-decoration: none;
    color: #FAFAFA;
    text-transform: uppercase;
  }
  

  img{
    height: 5em;
    width: 5em;
  }
</style>