<template>
  <div class="guestContainer">
    <p class="totalGuest">Total guests:</p>
    <input
      type="number"
      class="guestInput"
      min="1"
      @input="updateGuestNumber()"
      v-model="minGuest"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      minGuest: 1,
    };
  },

  methods: {
    updateGuestNumber() {
      if (this.minGuest <= 0) {
        this.minGuest = 1;
      }
      this.$emit("updateMinGuest", this.minGuest);
    },
  },
};
</script>

<style scoped>
.guestContainer {
  width: 40%;
  margin-inline: auto;
}

.guestInput {
  min-width: 30%;
  text-align: center;
  border-radius: 15px;
  max-width: 40%;
}

.guestInput:focus-visible {
  outline: none;
}

p {
  color: black;
  font-size: 16px;
  text-shadow: 1px 1px 2px black;
}
</style>