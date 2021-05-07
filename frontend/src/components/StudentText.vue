<template>
  <div class="component5">
    <div class="studentTxt">
      <label for="studentTxt"
        >Student?<br />No worries,with our beneficial student package<br />
        you'll be eligible for student dorms/apt. in no time!<br />
        <span>Read more here</span></label
      >
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.component5 {
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: space-evenly;
  margin: 15% auto;
  text-align: left;
  letter-spacing: 1px;
  width: 90%;
}

.studentTxt {
  font-size: 18px;
  font-weight: normal;
  color: black;
}

.studentTxt > span {
  font-weight: bold;
}
</style>