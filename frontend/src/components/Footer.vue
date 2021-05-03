<template>
  <footer>
    <p>{{ footerText }}</p>
  </footer>
</template>

<script>
export default {
  data(){
    return {
      footerText: "This is a footer"
    }
  }
}
</script>

<style scoped>
  footer {

  background-color: #454545;
  color: #FAFAFA;
  padding: 10px;
  }
</style>