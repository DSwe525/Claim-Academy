import React from 'react'
import axios from 'axios'
import '../css/SignIn.css'
import { useNavigate } from 'react-router';

function SignUp(props) {
  
  const navigator = useNavigate()

  const changeHandler = (e) => {
    console.log(e)
    const name = e.target.name;
    const value = e.target.value;
    const tempCustomer = { ...props.customer };
    tempCustomer[name] = value;
    props.setCustomer(tempCustomer)
}

const submitHandler = () => {
    axios.post('http://localhost:8080/customer/signup', props.customer)
    .then((response)=> {
      localStorage.setItem("email", response.data.email)
      props.setCustomer(response.data)
      navigator('/')
    })
    .catch((e) => {
      console.log(e)
    })
}
 
  return (
    <div className='main-page-box flex-col'>
      <div className='title-text'>Sign Up!!!</div>
    <div className='text-box-margins'>
        Email: 
        <input className='text-format' onChange={changeHandler} value={props.customer.email} type="text" name='email' />
    </div>
    <div>
        Password: 
        <input className='text-format' onChange={changeHandler} value={props.customer.password} type="password" name='password'/>
    </div>
         <button className='button-formatting' onClick={submitHandler}>Submit</button>
</div>
  )
}
export default SignUp