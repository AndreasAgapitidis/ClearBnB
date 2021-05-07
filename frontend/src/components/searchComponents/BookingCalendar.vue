<template>
  <div class="Herobanner2"></div>
  <v-date-picker v-model="range" is-range>
    <template v-slot="{ inputValue, inputEvents }">
      <div class="flex justify-center items-center">
        <input
          :value="inputValue.start"
          v-on="inputEvents.start"
          class="border px-2 py-1 w-32 rounded focus:outline-none focus:border-indigo-300"
        />

        <input
          :value="inputValue.end"
          v-on="inputEvents.end"
          class="border px-2 py-1 w-32 rounded focus:outline-none focus:border-indigo-300"
        />
      </div>
    </template>
  </v-date-picker>
</template>

<script>
export default {
  data() {
    return {
      range: {
        start: null,
        end: null,
      },
    };
  },
};
</script>

<style scoped>
.HeroBanner2 {
  height: 200px;
  width: 200px;
  background: Black;
}
</style>