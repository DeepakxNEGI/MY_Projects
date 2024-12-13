// import axios from "axios";
// const baseURL='http://localhost:8080/api/v1'
// export const  customAxios= axios.create({

//    baseURL:baseURL,
// });


import axios from "axios";

// Use the REACT_APP_API_URL from the .env files
const baseURL = process.env.REACT_APP_API_URL;

export const customAxios = axios.create({
   baseURL: baseURL,
});