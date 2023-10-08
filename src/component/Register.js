import React, { useState } from "react";
import { signUp } from "../services/user-service";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Base from "./Base";
import {Link} from 'react-router-dom'
function Register() {


  const [formData, setFormData] = useState({
    username: "",
    password: "",
    firstName: "",
    lastName: "",
    gender: "",
    dob:"",
    mobile: "",
    email: "",
    roles: "ROLE_USER", // Set the default role to ROLE_USER
    street: "",
    city: "",
    district: "",
    state: "",
    pincode: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    signUp(formData)
      .then((response) => {
        console.log(response);
        toast.success("user registration successfully !!");
        console.log("registration successfully");
      })
      .catch((error) => {
        toast.error("failed to registration something went wrong tray again !");
      });
    // Handle form submission here, e.g., send data to a server or perform validation
  };

  return (
    <>
      <ToastContainer />
      <Base>
        <div className="form-v10">
          <div className="page-content">
            <div className="form-v10-content">
              <form onSubmit={handleSubmit} className="form-detail" id="myform">
                <div className="form-left">
                  <h2>General Infomation</h2>
                  <div className="form-row">
                    <input
                      type="username"
                      name="username"
                      className="input-text"
                      placeholder="username"
                      value={formData.username}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="form-row">
                    <input
                      type="password"
                      name="password"
                      className="input-text"
                      placeholder="password"
                      value={formData.password}
                      onChange={handleChange}
                      required
                    />
                  </div>

                  <div className="form-group">
                    <div className="form-row form-row-1">
                      <input
                        type="text"
                        name="firstName"
                        placeholder="First Name"
                        value={formData.firstName}
                        onChange={handleChange}
                        required
                      />
                    </div>
                    <div className="form-row form-row-2">
                      <input
                        type="text"
                        name="lastName"
                        placeholder="Last Name"
                        value={formData.lastName}
                        onChange={handleChange}
                        required
                      />
                    </div>
                  </div>

                  <div className="form-row">
                    <select
                      onChange={handleChange}
                      name="gender"
                      value={formData.gender}
                    >
                      <option className="option" value="gender">
                        Gender
                      </option>
                      <option className="option" value="male">
                        Male
                      </option>
                      <option className="option" value="female">
                        Female
                      </option>
                    </select>
                  </div>
                 
                    <div className="form-row">
                    <label htmlFor="dob"></label>
                   <input
                      type="date"
                      id="dob"
                      name="dob"
                      placeholder="Date of Birth"
                      value={formData.dob}
                      onChange={handleChange}
                      max="2005-12-31" // Optional: Set a maximum date if needed
                    />
                    </div>
                   
                  
                 
                </div>

                {/* LEFT SIDE CARD */}
                <div className="form-right">
                  <h2>Contact Details</h2>
                  <div className="form-row">
                    <input
                      type="text"
                      name="street"
                      className="street"
                      id="street"
                      placeholder="Street"
                      value={formData.street}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="form-group">
                    <div className="form-row form-row-1">
                      <input
                        type="text"
                        name="pincode"
                        placeholder="Pin Code"
                        value={formData.pincode}
                        onChange={handleChange}
                        required
                      />
                    </div>
                    <div className="form-row form-row-2">
                      <input
                        type="text"
                        name="city"
                        placeholder="City"
                        value={formData.city}
                        onChange={handleChange}
                        required
                      />
                    </div>
                  </div>
                  <div className="form-row">
                    <input
                      type="text"
                      name="district"
                      placeholder="District"
                      value={formData.district}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="form-row">
                    <input
                      type="text"
                      name="state"
                      placeholder="State"
                      value={formData.state}
                      onChange={handleChange}
                      required
                    />
                    <span className="select-btn">
                      <i className="zmdi zmdi-chevron-down"></i>
                    </span>
                  </div>
                  <div className="form-row">
                    <input
                      type="text"
                      name="mobile"
                      placeholder="Mobile Number"
                      value={formData.mobile}
                      onChange={handleChange}
                      required
                    />
                  </div>
                  <div className="form-row">
                    <input
                      type="text"
                      name="email"
                      required
                      pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}"
                      placeholder="Your Email"
                      value={formData.email}
                      onChange={handleChange}
                    />
                  </div>
                  <div className="form-checkbox">
                    <label className="container">
                      <p>
                        I do accept the{" "}
                        <Link to="" className="text">
                          Terms and Conditions
                        </Link>{" "}
                        of your site.
                      </p>
                      <input type="checkbox" name="checkbox" />
                      <span className="checkmark"></span>
                    </label>
                  </div>
                  <div className="form-row-last">
                    <input
                      type="submit"
                      name="register"
                      className="register"
                      value="Register Badge"
                    />
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </Base>
    </>
  );
}

export default Register;
