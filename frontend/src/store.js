import { createStore } from 'vuex'

export default createStore({
  state: {

    cities: [],

    usersCity: null,

    listings: {},

    user: null,

    dateRange: {
      start: '',
      end: ''
    },

    reservations: [],

    latestReservation: null

  },

  // this.$store.commit('mutationName')
  mutations: {

    setCities(state, cities) {
      state.cities = cities
    },

    // listings updates and overwrite by java listing object
    setListings(state, listings) {
      state.listings = listings
    },

    setUser(state, user) {
      state.user = user
    },

    setBookingDates(state, range) {
      state.dateRange = range
    },

    createReservation(state, reservation) {
      state.reservations.push(reservation)
    },

    setUsersCity(state, city) {
      state.usersCity = city
    },

    createLatestReservation(state, reservation) {
      state.latestReservation = reservation
    }

  },

  // this.$store.dispatch('actionName')
  actions: {
    async logout(store) {
      let res = await fetch('/api/logout')

      // remove user from state
      store.commit('setUser', null)
    },

    async whoAmI(store) {
      let res = await fetch('/api/whoami')
      let user = await res.json()

      store.commit('setUser', user)
    },

    async register(store, credentials) {
      let res = await fetch('/api/register', {
        method: 'POST',
        body: JSON.stringify(credentials)
      })

      let loggedInUser = await res.json()

      if (loggedInUser.error) {
        store.commit('setUser', null)
        return
      }

      store.commit('setUser', loggedInUser)
    },

    async login(store, credentials) {
      let res = await fetch('/api/login', {
        method: 'POST',
        body: JSON.stringify(credentials)
      })

      let loggedInUser = await res.json()

      if (loggedInUser.error) {
        store.commit('setUser', null)
        return
      }
      store.commit('setUser', loggedInUser)
    },

    async fetchCities(store) {

      let res = await fetch('/rest/SearchByCity')
      let cities = await res.json();

      store.commit('setCities', cities)
    },

    async fetchListings(store) {

      let res = await fetch('/rest/listings');
      let listings = await res.json();
      // setListing runs setListing in mutations
      store.commit('setListings', listings)
    },

    // set the date range to be referenced when selecting a booking
    setBookingDates(store, range) {
      store.commit('setBookingDates', range)
    },

    async postReservation(store, reservation) {
      let res = await fetch('/rest/reservations', {
        method: 'POST',
        body: JSON.stringify(reservation)
      })

      let reservationFromServer = await res.json();

      store.commit('createLatestReservation', reservationFromServer)
      store.commit('createReservation', reservationFromServer)
    },

    async putListing(store, listing) {
      await fetch('/rest/listings', {
        method: 'PUT',
        body: JSON.stringify(listing)
      })
    }
  }
});

