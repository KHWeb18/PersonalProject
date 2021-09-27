import axios from 'axios';
// import JwtDecode from 'jwt-decode';
import store from "../store";

const baseURL = 'http://localhost:8081';
const timeout = 100000000;

const api = axios.create({
    // baseURL: ,
    baseURL,
    timeout,
    headers: {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Headers': '*',
        'Content-Type': 'application/json;charset=utf-8'
    },
});

api.interceptors.request.use(
    async function (config) {
        if (store.state.token) {
            const accessToken = store.state.token;

            if (accessToken) {
                // const jwtObject = JwtDecode(accessToken);
                // const payload = { ...jwtObject };
                //
                // localStorage.setItem('userInfo', JSON.stringify( payload ));

                config.headers.common["Authorization"] = `Bearer ${accessToken}`;
            } else{
                await this.$router.push({name: "Login"});
            }
        }
        return config;
    },
    function (error) {
        // 요청 에러 처리
        console.log(`===> api interceptors request error : ${error}`);
        return Promise.reject(error);
    }
)
export default api;
