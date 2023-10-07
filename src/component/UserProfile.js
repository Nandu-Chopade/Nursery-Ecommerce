import React, {  useEffect } from 'react';
import Base from './Base';
import './UserProfile.css'

function UserProfile() {
    // const [userData, setUserData] = useState(null);

    useEffect(() => {
        // Fetch user profile data
        // Example: fetch('/api/user/profile').then(response => response.json()).then(data => setUserData(data));
    }, []);

    return (
       <Base>
        <div className="container margin-top">
            <div className="row">
               <div className="card">
               This is card
               </div>
            </div>
        </div>
       </Base>
    );
}

export default UserProfile;
