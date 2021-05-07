<template>
  <div class="container">
    <input type="text" placeholder="Search first name" v-model="userInput" />
    <button @click="fetchUser(this.userInput)">Search</button>
    <UserItem this.user />
  </div>
</template>

<script>
import UserItem from "../userComponents/UserItem.vue";

export default {
  data() {
    return {
      userInput: "",
      user: [],
    };
  },

  methods: {
    async fetchUser(userInput) {
      console.log(userInput);
      let res = fetch("/rest/findUser/" + userInput);
      let user = await res.json();
      console.log(user);
      this.user = user;
    },
  },

  components: {
    UserItem,
  },
};
</script>

<style>
</style>