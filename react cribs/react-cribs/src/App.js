import { useState, useEffect } from 'react'
import './App.css';
import PageWrapper from './components/PageWrapper';
import Home from './pages/Home';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';
import { Routes, Route } from 'react-router-dom'
import axios from 'axios'

function App() {

  const [isLoading, setIsLoading] = useState(true)
  const [cribs, setCribs] = useState({
    size: null,
    beds: null,
    baths: null,
    price: null,
    datePosted: '',
    image: ''
  })
  const [customer, setCustomer] = useState({
    email: '',
    password: ''
  })
  useEffect(() => {
    const email = localStorage.getItem("email")
    axios.get(`http://localhost:8080/customer/getCustomerByEmail/${email}`)
    .then((response) =>{
      setCustomer(response.data)
      setIsLoading(false)
    })
    .catch((e) => {
      console.log(e)
    })
  }, [])


  return (
    <PageWrapper customer={customer} setCustomer={setCustomer}>
    <Routes>
      <Route path="/" element={<Home customer={customer} isLoading={isLoading} setIsLoading={setIsLoading} cribs={cribs} setCribs={setCribs}/>} />
      <Route path="/SignUp" element={<SignUp customer={customer} setCustomer={setCustomer} />} />
      <Route path="/SignIn" element={<SignIn customer={customer} setCustomer={setCustomer} />} />
    </Routes>
    </PageWrapper>
  )
}

export default App;
