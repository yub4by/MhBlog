import axios from 'axios'

import Element from 'element-ui'
import router from './router'
import store from './store'


axios.defaults.baseURL='http://localhost:8081'

// 前置拦截
axios.interceptors.request.use(config => {
    console.log('前置拦截')
    return config
})

// 后置拦截
axios.interceptors.response.use(response => {
    let res = response.data;
    console.log("=================")
    console.log('后置拦截')
    console.log(res)
    console.log("=================")
    if (res.code === 200) { //放行
        return response
    } else { //code!=200说明异常
        Element.Message.error('错了哦，这是一条错误消息', {duration: 3 * 1000})
        return Promise.reject(response.data.msg)
    }
},
error => {
    console.log(error)
    if(error.response.data) {
        error.message = error.response.data.msg
    }
    if(error.response.status === 401) {
        store.commit("REMOVE_INFO")
        router.push("/login")
    }
    Element.Message.error(error.message, {duration: 3 * 1000})
    return Promise.reject(error)
})