import React, { useContext, useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { doLogout, getCurrentUserDetail, isLoggedIn } from "../auth";
import userContext from "../context/userContext";

function CustomNavbar() {
  const userContextData = useContext(userContext);
  let navigate = useNavigate();
  let location = useLocation();
  const [login, setLogin] = useState(false);
  const [user, setUser] = useState(undefined);

  useEffect(() => {
    setLogin(isLoggedIn());
    setUser(getCurrentUserDetail());
  }, [login]);

  const logout = () => {
    doLogout(() => {
      setLogin(false);
      userContextData.setUser({
        data: null,
        login: false,
      });

      navigate("/");
    });
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
        <div className="container">
          <Link
            className={`navbar-brand ${location.pathname === "/" ? "active" : ""}`}
            to="/"
          >
            E-Commerce Site
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link
                  className={`nav-link ${
                    location.pathname === "/products" ? "active" : ""
                  }`}
                  to="/products"
                >
                  Products
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className={`nav-link ${
                    location.pathname === "/cart" ? "active" : ""
                  }`}
                  to="/cart"
                >
                  Cart
                </Link>
              </li>
              <li className="nav-item">
                <Link
                  className={`nav-link ${
                    location.pathname === "/wishlist" ? "active" : ""
                  }`}
                  to="/wishlist"
                >
                  Wishlist
                </Link>
              </li>
            </ul>
            <div className="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
              <ul className="nav navbar-nav">
                <li>
                  {!login ? (
                    <Link
                      className={`nav-link ${
                        location.pathname === "/login" ? "active" : ""
                      }`}
                      to="/login"
                    >
                      <i className="fa-solid fa-right-to-bracket"></i> Login
                    </Link>
                  ) : (
                    <Link
                      className="nav-link"
                      to="/user-profile"
                    >
                      <i className="fa-solid fa-user"></i> {user.username}
                    </Link>
                  )}
                </li>
                <li>
                  {login && (
                    <Link
                      className="nav-link"
                      to="/login"
                      onClick={logout}
                    >
                      <i className="fa-solid fa-sign-out-alt"></i> Log Out
                    </Link>
                  )}
                </li>
              </ul>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
}

export default CustomNavbar;
