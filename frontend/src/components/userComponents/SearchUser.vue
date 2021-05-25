<template>
  <div class="container">
    <input
      @keyup.enter="fetchUser(this.userInput)"
      placeholder="Search first name"
      v-model="userInput"
    />
    <button @click="fetchUser(this.userInput)">Search</button>
    <div v-if="pressed">
      <UserItem v-for="user of users" v-bind:key="user.id" v-bind:user="user" />
    </div>
  </div>
</template>

<script>
import UserItem from "../userComponents/UserItem.vue";

export default {
  data() {
    return {
      userInput: "",
      users: [],
      pressed: false,
    };
  },

  methods: {
    async fetchUser(userInput) {
      let res = await fetch("/rest/findUser/" + userInput);
      let users = await res.json();
      this.users = users;
      this.pressed = true;
      this.userInput = "";
    },
  },

  components: {
    UserItem,
  },
};
</script>

<style scoped>

.container {
  margin-top: 16px;
}

</style>