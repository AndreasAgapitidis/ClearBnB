<template>
  <!-- getAllusers -->
  <div class="container">
    <div v-if="listOfAllUsers" class="renderAllUsersContainer">
      <UserItem
        v-for="user of listOfAllUsers"
        v-bind:key="user.id"
        v-bind:user="user"
      />
    </div>
  </div>
</template>

<script>
import UserItem from "../userComponents/UserItem.vue";

export default {
  data() {
    return {
      listOfAllUsers: [],
    };
  },

  computed: {},

  created() {
    this.getAllUsers();
  },

  methods: {
    async getAllUsers() {
      let res = await fetch("/rest/getAllUsers");
      let list = await res.json();
      this.listOfAllUsers = list;
    },
  },
  components: {
    UserItem,
  },
};
</script>

<style scoped>
.container {
  margin: 0 1em 0 1em;
}
</style>