<template>
  <div class="availableHouses">
    <label for="availableHouses" class="availableTxt"
      >Available apt./houses</label
    >

    <div class="component4">
      <div class="leftSide">
        <img 
          src="../assets/poolhouse.jpg"
          alt="HouseWithPool"
          width="250"
          height="300"
       
    >
  
        />
        <img
          src="../assets/poolhouse.jpg"
          alt="HouseWithPool"
          width="250"
          height="300"
        />
      </div>

      <div class="rightSide">
        <img
          src="../assets/poolhouse.jpg"
          alt="HouseWithPool"
          width="250"
          height="300"
        />
        <img
          src="../assets/poolhouse.jpg"
          alt="HouseWithPool"
          width="250"
          height="300"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.component4 {
  display: flex;
  align-items: flex-end;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 10%;
}

.leftSide {
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content:space-between;
  margin-bottom: 10%;
  margin-left: 25%;
  margin-bottom:10%;
  width:10%;
  height:10%;
  
}

.rightSide {
  display: flex;
  align-items: flex-end;
  flex-direction: column;
  justify-content: space-between;
  margin-right: 10%;
  margin-bottom:10%;
  width:10%;
  height:10%;
  
}

.availableTxt {
  font-size: 24px;
  font-weight: bold;
  margin-left: 50%;

 
}
</style>