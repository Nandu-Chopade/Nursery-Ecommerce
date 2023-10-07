import React, { useContext, useEffect, useState } from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import { doLogout, getCurrentUserDetail, isLoggedIn } from "../auth";
import userContext from "../context/userContext";

function CustomNavbar() {
  const userContextData = useContext(userContext);
  let navigate = useNavigate();
  let location = useLocation();
  const [isOpen, setIsOpen] = useState(false);
  const [login, setLogin] = useState(false);
  const [user, setUser] = useState(undefined);

  useEffect(() => {
    setLogin(isLoggedIn());
    setUser(getCurrentUserDetail());
    console.log(user)
  }, [login]);

  const logout = () => {
    doLogout(() => {
      //logged out
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
      <nav className="navbar navbar-expand-lg  fixed-top navbar-dark bg-primary">
        <div className="container">
          <Link className={`navbar-brand ${location.pathname === "/" ? "active":"" }`}  to="/">
            E-Commerce Site
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link className={`nav-link ${location.pathname === "/products" ? "active":"" }`}  to="/products">
                  Products
                </Link>
              </li>
              <li className="nav-item">
                <Link  className={`nav-link ${location.pathname === "/cart" ? "active":"" }`} to="/cart">
                  Cart
                </Link>
              </li>
              <li className="nav-item">
                <Link  className={`nav-link ${location.pathname === "/wishlist" ? "active":"" }`} to="/wishlist">
                  Wishlist
                </Link>
              </li>
            </ul>
            <div
              class="collapse navbar-collapse justify-content-end"
              id="navbarSupportedContent"
            >
              {!login && (
                <ul class="nav navbar-nav ">
                  <li>
                    <Link  className={`nav-link ${location.pathname === "/login" ? "active":"" }`} to="/login">
                      <i class="fa-solid fa-right-to-bracket"></i> Login
                    </Link>
                  </li>
                  <li>
                    <Link  className={`nav-link ${location.pathname === "/register" ? "active":"" }`} to="/register">
                      <i class="fa-solid fa-registered"></i> Register
                    </Link>
                  </li>
                </ul>
              )}
              {login && (
                <ul class="nav navbar-nav ">
                  <li>
                    <Link  className={`nav-link ${location.pathname === "/login" ? "active":"" }`} to="/login" onClick={logout}>
                      <i class="fa-solid fa-right-to-bracket"></i> Log Out
                    </Link>
                  </li>
                  <li>
                    <Link  className={`nav-link ${location.pathname === "/user-profile" ? "active":"" }`} to="/user-profile">
                    <i class="fa-solid fa-user"></i>
                    </Link>
                  </li>
                </ul>
              )}
            </div>
          </div>
        </div>
      </nav>
    </div>
  );
}

export default CustomNavbar;
