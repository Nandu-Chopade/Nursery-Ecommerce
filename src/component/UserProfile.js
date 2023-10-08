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
                <h1>This is my Profile</h1>
               </div>
            </div>
        </div>
       </Base>
    );
}

export default UserProfile;
