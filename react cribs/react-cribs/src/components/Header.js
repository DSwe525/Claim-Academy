import React from 'react'
import { useNavigate } from 'react-router'

const Header = (props) => {

  const navigate = useNavigate()

  const signOut = () => {
    localStorage.removeItem("email")
    props.setCustomer({
        email: '',
        password: ''
    })
    navigate('/')
  }

  const renderHeader = () => {
    if(props.customer.id === undefined) {
      return (
        <div className="flow-row header">
        <div className="third-width justify-content-center">
          <a href="/" className="left-links">Home</a>
        </div>
        <div className="third-width justify-content-center">
              <img src="https://www.pennlive.com/resizer/1_N2a7ZmcLf6LYtYAkWG07PML8Y=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/OYGGYJAY3BEKXJOHW7LAQRYI7M.png" />
        </div>
        <div className="third-width justify-content-right">
          <a href="/SignIn" className="right-links">Sign In</a>
          <a href="/SignUp" className="right-links">Sign Up</a>
        </div>
      </div>
      )
    } else {
      return (
        <div className="flow-row header">
        <div className="third-width justify-content-center">
          <a href="/" className="left-links">Home</a>
          <a href="/BuyACrib" className="left-links">See The Cribs</a>
        </div>
        <div className="third-width justify-content-center">
              <img src="https://www.pennlive.com/resizer/1_N2a7ZmcLf6LYtYAkWG07PML8Y=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/OYGGYJAY3BEKXJOHW7LAQRYI7M.png" />
        </div>
        <div className="third-width justify-content-right">
          <a href="/" className="right-links" onClick={signOut}>Sign Out</a>
        </div>
      </div>
      )
    }
  }

  return (

    /*<div className="flow-row header">
      <div className="third-width justify-content-center">
        <a href="/" className="left-links">Home</a>
        <a href="/BuyACrib" className="left-links">See The Cribs</a>
        <a href="/Agent" className="left-links">Realtors</a>
      </div>
      <div className="third-width justify-content-center">
            <img src="https://www.pennlive.com/resizer/1_N2a7ZmcLf6LYtYAkWG07PML8Y=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/OYGGYJAY3BEKXJOHW7LAQRYI7M.png" />
      </div>
      <div className="third-width justify-content-right">
        <a href="/SignIn" className="right-links">Sign In</a>
        <a href="/SignUp" className="right-links">Sign Up</a>
      </div>
    </div> */
    renderHeader()
  )
}

export default Header