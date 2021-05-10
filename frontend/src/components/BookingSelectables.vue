<template>
  <div class="calendar">
    <v-date-picker
      class="date-picker"
      v-model="date"
      :disabled-dates="[new Date(2021, 9, 10), new Date(2021, 10, 10)]"
      color="blue"
      is-range
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      range: {
        start: new Date(2020, 0, 1),
        end: new Date(2020, 0, 5),
      },
    };
  },
};
</script>

<style>
</style>