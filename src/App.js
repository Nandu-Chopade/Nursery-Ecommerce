import React from "react";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./component/Header";
import ProductList from "./component/ProductList";
import ProductDetail from "./component/ProductDetail";
import Cart from "./component/Cart";
import Login from "./component/Login";
import Register from "./component/Register";
import Wishlist from "./component/Wishlist";
import OrderHistory from "./component/OrderHistory";
import UserProfile from "./component/UserProfile";
import Search from "./component/Search";
import ReviewsRatings from "./component/ReviewsRatings";
import Checkout from "./component/Checkout";
import Security from "./component/Security";
import Footer from "./component/Footer";
import ProductManagement from "./component/ProductManagement";
import Dashboard from "./component/Dashboard";
import OrderTracking from "./component/OrderTracking";
import AboutUs from "./component/AboutUs";
import UserProvider from "./context/UeserProvider";
import { ToastContainer } from "react-toastify";
import Home from "./component/Home";
import Privateroute from "./component/Privateroute";
function App() {
  return (
    <UserProvider>
      <Header />
      <BrowserRouter>
        <ToastContainer position="bottom-center" />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<ProductList />} />
          <Route path="/products/:productId" element={<ProductDetail />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/wishlist" element={<Wishlist />} />
          <Route path="/order-history" element={<OrderHistory />} />
          <Route path="/search" element={<Search />} />
          <Route path="/product-review" element={<ReviewsRatings />} />
          <Route path="/checkout" element={<Checkout />} />
          <Route path="/security" element={<Security />} />
          <Route path="/product-management" element={<ProductManagement />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/order-tracking" element={<OrderTracking />} />
          <Route path="/about-us" element={<AboutUs />} />
          <Route path="/" element={<Privateroute />}>
            <Route path="/user-profile" element={<UserProfile />} />
          </Route>
        </Routes>
      </BrowserRouter>
      <Footer />
    </UserProvider>
  );
}

export default App;
