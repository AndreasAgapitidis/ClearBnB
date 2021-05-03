<template>
  <header>
    <h3>{{ title }}</h3>
    </header>
</template>

<script>
export default {
  data(){
    return {
      title: "Webbapp Yahoo"
    }
  }
}
</script>

<style scoped>
  header{
    background-color: #454545;
    padding: 10px;
    height: 50px;
    text-align: center;
    color: #FAFAFA;
  }
</style>