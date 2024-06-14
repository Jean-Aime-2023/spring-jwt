import axios from "axios";

axios.defaults.baseURL = 'http://localhost:5000/messages?continue'
axios.defaults.headers.post["Content-type"] = 'application/json'

export const request = (method,url,data) => {
    return axios({
        method:method,
        url:url,
        data:data
    })
}