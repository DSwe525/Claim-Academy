import React from 'react'

const Header = () => {
  return (
    <div className="flow-row header">
      <div className="third-width justify-content-center">
        <a href="/" class="left-links">Home</a>
        <a href="/BuyACrib" class="left-links">See The Cribs</a>
        <a href="/Agent" class="left-links">Realtors</a>
      </div>
      <div className="third-width justify-content-center">
            <img src="https://www.pennlive.com/resizer/1_N2a7ZmcLf6LYtYAkWG07PML8Y=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/OYGGYJAY3BEKXJOHW7LAQRYI7M.png" />
      </div>
      <div className="third-width justify-content-right">
        <a href="/SignIn" className="right-links">Sign In</a>
        <a href="/" className="right-links">Home</a>
        <a href="/SignUp" className="right-links">Sign Up</a>
      </div>
    </div>
  )
}

export default Header