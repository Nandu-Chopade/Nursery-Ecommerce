import React, { useState, useEffect } from 'react';
import Base from "./Base"
function ProductDetail({ match }) {
    const [product, setProduct] = useState(null);

    useEffect(() => {
        // Fetch product details based on match.params.productId
        // Example: fetch(`/api/products/${match.params.productId}`).then(response => response.json()).then(data => setProduct(data));
    }, [match.params.productId]);

    return (
        <Base>   <div className="container">
        {product ? (
            <div>
                {/* Display product details */}
                {/* Use Bootstrap components or custom styling */}
            </div>
        ) : (
            <div>Loading...</div>
        )}
    </div>
    </Base>
     
    );
}

export default ProductDetail;
