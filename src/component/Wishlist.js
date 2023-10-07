import React, { useState, useEffect } from 'react';
import Base from "./Base"
function Wishlist() {
    const [wishlistItems, setWishlistItems] = useState([]);

    useEffect(() => {
        // Fetch user's wishlist items
        // Example: fetch('/api/wishlist').then(response => response.json()).then(data => setWishlistItems(data));
    }, []);

    return (
        <Base>
            <div className="container">
            <div className="row">
                {/* Display wishlist items */}
                {/* Use Bootstrap cards or custom styling */}
            </div>
        </div></Base>
        
    );
}

export default Wishlist;
