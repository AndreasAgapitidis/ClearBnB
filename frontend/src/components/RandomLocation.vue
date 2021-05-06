<template>
  <div class="component7">
    <div class="studentTxt">
      <label for="studentTxt"
        >Not sure where you wanna go?<br />No worries,we got you covered.</label
      >
    </div>

    <button class="rndLocationBtn">Get random location</button>
  </div>
</template>

<script>
export default {};
</script>

<style>
.component7 {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-evenly;
  margin-bottom: 10%;
}

.studentTxt {
  font-size: 20px;
  font-weight: bolder;
}

.rndLocationBtn {
  height: 55px;
  width: 240px;
  border-radius: 20px;
  background-color: white;
  color: black;
  font-weight: bold;
  font-size: 16px;
  cursor: grab;
  margin-top: 10%;
  margin-bottom: 5%;
}
</style>
