import React from 'react'
import axios from 'axios'
import '../css/SignIn.css'
import { useNavigate } from 'react-router';

function Agent(props) {
  
  const navigator = useNavigate()

  const changeHandler = (e) => {
    console.log(e)
    const name = e.target.name;
    const value = e.target.value;
    const tempAgent = { ...props.agent };
    tempAgent[name] = value;
    props.setAgent(tempAgent)
}

const submitHandler = () => {

    axios.post('http://localhost:8080/agent/login', props.agent)
    .then((response)=> {
      localStorage.setItem("agentEmail", response.data.email)
      props.setAgent(response.data)
      navigator('/')
    })
    .catch((e) => {
      console.log(e)
    })
    }

 
  return (
    <div className='main-page-box flex-col'>
      <div className='title-text'>Agent Sign In</div>
    <div className='text-box-margins'>
        Email: 
        <input className='text-format' onChange={changeHandler} value={props.agent.email} type="text" name='email' />
    </div>
    <div>
        Password: 
        <input className='text-format' onChange={changeHandler} value={props.agent.password} type="password" name='password'/>
    </div>
         <button className='button-formatting' onClick={submitHandler}>Submit</button>
</div>
  )
}

export default Agent