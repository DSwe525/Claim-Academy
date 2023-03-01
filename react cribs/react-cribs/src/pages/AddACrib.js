import React from 'react'
import AgentProfile from '../components/AgentProfile'
import axios from 'axios'
import {useEffect} from 'react'

function AddACrib(props) {

    useEffect(() => {
        const agentEmail = localStorage.getItem("agentEmail")
        axios.get(`http://localhost:8080/agent/findByEmail/${agentEmail}`)
          .then((response) => {
            props.setAgent(response.data)
            props.setIsLoading(false)
    
          })
          .catch((e) => {
            console.log(e)
          })
      }, [])

  return (
    <AgentProfile agent={props.agent} setAgent={props.setAgent}/>
  )
}

export default AddACrib