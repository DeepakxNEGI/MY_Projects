// import axios from "axios";
// // const baseURL='http://localhost:8080/api/v1'
// const baseURL='http://localhost:8080/api/v1'

// export const  customAxios= axios.create({

//    baseURL:baseURL,
// });


// import axios from "axios";

// // Use the REACT_APP_API_URL from the .env files
// const baseURL = process.env.REACT_APP_API_URL;

// export const customAxios = axios.create({
//    baseURL: baseURL,
// });


import axios from "axios";

// Check if we are running in a production environment (Render)
const baseURL = window.location.hostname === 'email-frontend-rd2z.onrender.com'
    ? 'https://my-projects-oism.onrender.com/api/v1'  // Render URL
    : 'http://localhost:8080/api/v1';  // Localhost URL for local development

export const customAxios = axios.create({
    baseURL: baseURL,
});