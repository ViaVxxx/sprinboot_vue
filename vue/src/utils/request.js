// 引入axios库，用于发起HTTP请求
import axios from "axios";

// 创建axios实例，并设置基础URL、请求超时时间等配置
const request = axios.create({
    baseURL: "http://localhost:8081", // 设置请求的基础URL
    timeout: 5000, // 设置请求的超时时间
});

// 添加请求拦截器
// 在发送请求前对请求配置进行处理，例如添加请求头等
request.interceptors.request.use(
    (config) => {
        // 设置请求头的Content-Type为application/json
        config.headers["Content-Type"] = "application/json;charset=UTF-8";

        // 设置请求头的token（如果用户已登录）
        // config.headers["token"] = user.token;

        // 返回处理后的请求配置
        return config;
    },
    (error) => {
        // 请求异常处理
        return Promise.reject(error);
    });

// 添加响应拦截器
// 在接收到响应后对响应数据进行处理
request.interceptors.response.use(
    (response) => {
        // response.data是后端返回的数据
        let res = response.data;

        // 如果返回的是字符串，尝试解析成JSON对象
        if (typeof res === "string") {
            res = res ? JSON.parse(res) : res;
        }

        // 返回处理后的响应数据
        return res;
    },
    (error) => {
        // 打印错误信息，用于调试
        console.log("err" + error);

        // 返回Promise.reject，中断请求链
        return Promise.reject(error);
    }
)

// 导出封装后的axios实例, 在main.js中引入并挂载到Vue原型上
export default request;
