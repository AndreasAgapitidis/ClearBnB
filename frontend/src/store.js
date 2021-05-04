import { createStore } from 'vuex'

export default createStore({
  state: {

    cities: [],


  },

  // this.$store.commit('mutationName')
  mutations: {

    setCities(state, cities) {
      state.cities = cities
    },

  },

  // this.$store.dispatch('actionName')
  actions: {

    async fetchCities(store) {

      let res = await fetch('/rest/cities')
      let cities = await res.json()

      console.log(cities)

      store.commit('setCities', cities)

    }

  }
})