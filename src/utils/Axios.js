import axios from 'axios';

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

export default axios;//需要添加请求头的axios实例就导入这个文件