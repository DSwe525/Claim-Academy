import React from 'react'
import Specials from '../components/Specials'
import '../css/home.css'
import axios from 'axios'
import { useEffect } from 'react'

function Home(props) {

    useEffect(() => {
      
        axios.get('http://localhost:8080/crib/getlistofspecials')
          .then((response) => {
            props.setCribs(response.data)
            props.setIsLoading(false)
    
          })
          .catch((e) => {
            console.log(e)
          })
          
    
      }, [])

    const renderContent = () => {

    if(props.agent.id !== undefined || props.customer.id === undefined) {
      if(props.isLoading) {
          return null
      } else {
          return (
            <></>
            )
          }
        } else {
          if(props.isLoading) {
            return null
        } else {
            return (
                <Specials cribs={props.cribs} setCribs={props.setCribs} />
              )
            }
        }
      }
    return (
      renderContent()
    )
  }

export default Home