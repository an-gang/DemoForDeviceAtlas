import axios from "axios";

const http = axios.create({
    // baseURL: 'http://localhost:8080/',
    baseURL: 'http://194.26.213.114/api/',
});

export default http;
