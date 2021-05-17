<template>
  <div class="DetailInfoContainer" v-if="detailprop">
    <div class="Description">
      <h1>Description</h1>
      <p>{{ detailprop.description }}</p>
    </div>

    <div class="Details">
      <p>Price: {{ priceWithProfit }} SEK / night</p>
      <p>Rating: {{ detailprop.rating }}</p>
      <p>City: {{ detailprop.city }}</p>
      <p>Beds: {{ detailprop.beds }}</p>
      <p>Area: {{ detailprop.area }} ㎡</p>
      <p v-if="detailprop.house == true">Building Type: House</p>
      <p v-else-if="detailprop.apartment == true">Building Type: Apartment</p>
      <p v-if="user">Owner: {{ user.email }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: ["detailprop"],

  /*  mounted() { VARFÖÖÖÖÖÖÖÖÖR FUNKAR INTE DENNNAAAAAAAAAAAAAA!?!?!?!?!? DEN FUNKAR I RAD 37!?!?!??!
    this.getOwner();
  }, */

  data() {
    return {
      user: null,
    };
  },

  computed: {
    priceWithProfit() {
      this.getOwner();
      return Math.round(this.detailprop.price * 1.15);
    },
  },

  methods: {
    async getOwner() {
      console.log();
      let res = await fetch("/rest/findUserByID/" + this.detailprop.owner);
      this.user = await res.json();
    },
  },
};
</script>

<style scoped>
.DetailInfoContainer {
  display: flex;
  flex-direction: row;
  margin-top: 50px;
  justify-content: space-evenly;
}

.Description h1 {
  font-size: 25px;
}

.Description p {
  font-size: 15px;
}

.Details {
  border: 2px solid black;
  border-radius: 15px 40px 15px 40px;
}
</style>