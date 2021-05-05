import { createStore } from 'vuex'

export default createStore({
  state: {
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

    // listings updates and overwrite by java listing object
    setListings(state, listings) {
      state.listings = listings
    }
  },

  // this.$store.dispatch('actionName')
  actions: {

    async fetchListings(store) {

      let res = await fetch('/rest/listings');
      let listings = await res.json();

      // setListing runs setListing in mutations
      store.commit('setListings', listings)
    }
  }
})