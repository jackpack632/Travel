import axios from 'axios';
import {MessageBox} from "element-ui";

//axios的配置，请求头添加token
axios.interceptors.request.use((config)=>{
    const jwtToken=localStorage.getItem("token")
    if(jwtToken){
        config.headers['Authorization']=`Bearer ${jwtToken}`
    }
    return config;
},(error)=>{
    return Promise.reject(error);
})
axios.interceptors.response.use((response)=>{
    const code=response.data.code||200;
    switch (code) {
        case 200://为200执行该行
            return response;
        case 403:MessageBox.confirm("登录状态已过期，重新登录", "系统提示", {
            confirmButtonText: "重新登录",
            type: "warning",
            showCancelButton: false,
            showClose: false
        }).then(() => {
            //删除token
            localStorage.removeItem("token")
            window.location.href = '/Home' })//跳转首页
            .catch(() => { window.location.href = '/Home' })//跳转首页
            return response
        default://都不相同执行该行
            return response
    }
})

export default axios;//需要添加请求头的axios实例就导入这个文件