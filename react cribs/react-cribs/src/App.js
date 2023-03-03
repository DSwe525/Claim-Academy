import { useState, useEffect } from 'react'
import './App.css';
import PageWrapper from './components/PageWrapper';
import Home from './pages/Home';
import SignIn from './pages/SignIn';
import SignUp from './pages/SignUp';
import { Routes, Route } from 'react-router-dom'
import axios from 'axios'
import BuyACrib from './pages/BuyACrib';
import Agent from './pages/Agent';
import AddACrib from './pages/AddACrib';

function App() {

  const [isLoading, setIsLoading] = useState(true)
  const [address, setAddress] = useState({
    streetNumber: 0,
    streetName: '',
    city: '',
    state: '',
    zipCode: 0
  })
  const [cribs, setCribs] = useState({
    price: 0,
    beds: 0,
    baths: 0,
    size: 0,
    image: ""
})
  const [customer, setCustomer] = useState({
    email: '',
    password: ''
  })
  const [agent, setAgent] = useState({
    email: '',
    password: ''
  })

  useEffect(() => {
    const email = localStorage.getItem("email")
    const agentEmail = localStorage.getItem("agentEmail")
    if(email != null) {
    axios.get(`http://localhost:8080/customer/getCustomerByEmail/${email}`)
    .then((response) =>{
      setCustomer(response.data)
      setIsLoading(false)
    })
    .catch((e) => {
      console.log(e)
    })
  }
  else if(agentEmail != null) {
    axios.get(`http://localhost:8080/agent/findByEmail/${agentEmail}`)
    .then((response) =>{
      setAgent(response.data)
      setIsLoading(false)
    })
    .catch((e) => {
      console.log(e)
    })
  }
  },[])


  return (
    <PageWrapper customer={customer} setCustomer={setCustomer} agent={agent} setAgent={setAgent}>
    <Routes>
      <Route path="/" element={<Home customer={customer} isLoading={isLoading} setIsLoading={setIsLoading} cribs={cribs} setCribs={setCribs} agent={agent} setAgent={setAgent} />} />
      <Route path="/SignUp" element={<SignUp customer={customer} setCustomer={setCustomer} />} />
      <Route path="/SignIn" element={<SignIn customer={customer} setCustomer={setCustomer} />} />
      <Route path="/BuyACrib" element={<BuyACrib customer={customer} isLoading={isLoading} setIsLoading={setIsLoading} cribs={cribs} setCribs={setCribs} address={address} setAddress={setAddress}/>} />
      <Route path="/Agent" element={<Agent agent={agent} setAgent={setAgent} />} />
      <Route path="/AddACrib" element={<AddACrib agent={agent} cribs={cribs} setCribs={setCribs} address={address} setAddress={setAddress}/>} />
    </Routes>
    </PageWrapper>
  )
}

export default App;
