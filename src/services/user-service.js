import { myAxios } from "./helper";

export const signUp = (user) =>{
    return myAxios.post('/nursery.com/users/register', user).then((response) => response.data);
};

export const loginUser = (loginDetail) => {
    return myAxios
      .post("/nursery.com/users/authenticate", loginDetail)
      .then((response) => response.data);
  };
  
  export const getUser = (userId) => {
    return myAxios.get(`/users/${userId}`).then((resp) => resp.data);
  };