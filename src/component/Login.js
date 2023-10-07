import React, { useState } from "react";
import Base from './Base'
import { Link,useNavigate } from "react-router-dom"
import { loginUser } from "../services/user-service";
import { doLogin } from "../auth";
import userContext from "../context/userContext";
import { useContext } from "react";
import './LoginForm.css';



import {toast} from "react-toastify"
function Login() {
  const userContxtData = useContext(userContext);

  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const navigate = useNavigate();


  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (
      formData.username.trim() === "" ||
      formData.password.trim() === ""
    ) {
      toast.error("Username or Password  is required !!");
      return;
    }
        //submit the data to server to generate token
        loginUser(formData)
        .then((data) => {
          console.log(data);
  
          //save the data to localstorage
          doLogin(data, () => {
            console.log("login detail is saved to localstorage");
            //redirect to user dashboard page
            userContxtData.setUser({
              data: data.user,
              login: true,
            });
            navigate("/");
           
          });
  
          toast.success('Login Successfully!', {
            position: "top-right",
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
            theme: "dark",
            });
        })
        .catch((error) => {
          console.log(error);
          if (error.response.status === 400 || error.response.status === 404) {
            toast.error(error.response.data.message);
          } else {
            toast.error("Something went wrong  on sever !!");
          }
        });

  };
  
  return (
     <>
     <Base>
    <div class="login-container container py-5">
        <form onSubmit={handleSubmit} className="login-form">
            <h2>Login</h2>
            <input type="text" id="username" placeholder="Username"
            name="username"
            className="my-element"
            value={formData.username}
            onChange={handleChange}  
             required />
            <input type="password" id="password" placeholder="Password"
            name="password"
             value={formData.password}
             onChange={handleChange}
              required />
            <button type="submit">Login</button>
        </form>
        <p class="register-link">Not registered yet? <Link to="/register">Register</Link></p>
    </div>
     </Base>
     </>
  );
}

export default Login;
