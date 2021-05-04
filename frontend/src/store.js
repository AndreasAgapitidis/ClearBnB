import { createStore } from 'vuex'

export default createStore({
  state: {
    user: null
  },

  // this.$store.commit('mutationName')
  mutations: {
    setUser(state, user) {
      state.user = user
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
      console.log(user);

      store.commit('setUser', user)
    },

    async register(store, credentials) {
      let res = await fetch('/api/register', {
        method: 'POST',
        body: JSON.stringify(credentials)
      })

      let loggedInUser = await res.json()

      console.log('registered user', loggedInUser)

      store.commit('setUser', loggedInUser)
    },

    async login(store, credentials) {
      let res = await fetch('/api/login', {
        method: 'POST',
        body: JSON.stringify(credentials)
      })

      let loggedInUser = await res.json()

      console.log('logged in user', loggedInUser)

      store.commit('setUser', loggedInUser)
    }
  }
})