import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    //类似javaBean中定义的私有属性

    token: '',
    // userInfo: {}

    // token: localStorage.getItem("token"),
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    //相当于setter
    SET_TOKEN: (state, token) => {
      state.token = token
      localStorage.setItem("token", token)
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo)) //sessionStorage中不能存对象
    },

    //删除
    REMOVE_INFO: (state) => {
      state.token = ''
      state.userInfo = {}
      localStorage.setItem("token", "")
      sessionStorage.setItem("userInfo", JSON.stringify(""))
    }
  },
  getters: {
    //相当于getter
    getUser: state => {
      return state.userInfo
    },
    getToken: state => {
      return state.token
    }
  },
  actions: {
  },
  modules: {
  }
})
