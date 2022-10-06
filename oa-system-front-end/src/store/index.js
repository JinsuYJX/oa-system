import { createStore } from 'vuex'

export default createStore({
  state: {
    token: null,
    info: {

    }
  },
  getters: {
  },
  mutations: {
    logout(state) {
      state.token = null;
      state.info = null;
    }
  },
  actions: {
  },
  modules: {
  }
})
