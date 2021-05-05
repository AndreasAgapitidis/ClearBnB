import { createStore } from 'vuex'

export default createStore({
  state: {

    cities: [],

    listing: {
      id: '',
      owner: '',
      isApartment: '',
      isHouse: '',
      city: '',
      address: '',
      description: '',
      area: '',
      beds: '',
      price: '',
      rating: '',
      unavailableDates: '',
      images: ''
    }
  },

  // this.$store.commit('mutationName')
  mutations: {

    setCities(state, cities) {
      state.cities = cities
    },

    // listings updates and overwrite by java listing object
    setListings(state, listings) {
      state.listings = listings
    }
  },

  // this.$store.dispatch('actionName')
  actions: {

    async fetchCities(store) {

      let res = await fetch('/rest/cities')
      let cities = await res.json()

      console.log(cities)

      store.commit('setCities', cities)

    },

    async fetchListings(store) {

      let res = await fetch('/rest/listings');
      let listings = await res.json();

      // setListing runs setListing in mutations
      store.commit('setListings', listings)
    }
  }
})