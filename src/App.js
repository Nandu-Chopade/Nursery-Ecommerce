import React from 'react';
import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from './component/Header'; // Updated import path
import ProductList from './component/ProductList'; // Updated import path
import ProductDetail from './component/ProductDetail'; // Updated import path
import Cart from './component/Cart'; // Updated import path
import Login from './component/Login'; // Updated import path
import Register from './component/Register'; // Updated import path
import Wishlist from './component/Wishlist'; // Updated import path
import OrderHistory from './component/OrderHistory'; // Updated import path
import UserProfile from './component/UserProfile'; // Updated import path
import Search from './component/Search'; // Updated import path
import ReviewsRatings from './component/ReviewsRatings'; // Updated import path
import Checkout from './component/Checkout'; // Updated import path
import Security from './component/Security'; // Updated import path
import Footer from './component/Footer'; // Updated import path
import ProductManagement from './component/ProductManagement'; // Updated import path
import Dashboard from './component/Dashboard'; // Updated import path
import OrderTracking from './component/OrderTracking'; // Updated import path
import AboutUs from './component/AboutUs'; // Updated import path
import UserProvider from './context/UeserProvider';
import { ToastContainer } from "react-toastify";
import Home from "./component/Home";
function App() {
    return (
      <UserProvider> 
        <Header/>       
      <BrowserRouter>
        <ToastContainer position="bottom-center" />
        <Routes>

                <Route path="/" element={<Home/>} />
                    <Route path="/products" element={<ProductList/>} />
                    <Route path="/products/:productId" element={<ProductDetail/>} />
                    <Route path="/cart" element={<Cart/>} />
                    <Route path="/login" element={<Login/>} />
                    <Route path="/register" element={<Register/>} />
                    <Route path="/wishlist" element={<Wishlist/>} />
                    <Route path="/order-history" element={<OrderHistory/>} />
                    <Route path="/user-profile" element={<UserProfile/>} />
                    <Route path="/search" element={<Search/>} />
                    <Route path="/product-review" element={<ReviewsRatings/>} />
                    <Route path="/checkout" element={<Checkout/>} />
                    <Route path="/security" element={<Security/>} />
                    <Route path="/product-management" element={<ProductManagement/>} />
                    <Route path="/dashboard" element={<Dashboard/>} />
                    <Route path="/order-tracking" element={<OrderTracking/>} />
                    <Route path="/about-us" element={<AboutUs/>} />
        </Routes>
      </BrowserRouter>
      <Footer/>
    </UserProvider>
    );
  }
  
  export default App;
  
