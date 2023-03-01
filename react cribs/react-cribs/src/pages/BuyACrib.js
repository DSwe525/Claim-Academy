import React from 'react'
import axios from 'axios'
import {useEffect} from 'react'
import '../css/home.css'
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime'
import AvailableCribs from '../components/AvailableCribs';

function BuyACrib(props) {
  
  useEffect(() => {
      
    axios.get('http://localhost:8080/crib/getlist')
      .then((response) => {
        props.setCribs(response.data)
        props.setIsLoading(false)

      })
      .catch((e) => {
        console.log(e)
      })
  }, [])

  const renderContent = () => {

    if(props.isLoading) {
        return null
    } else {
        return (
            <AvailableCribs cribs={props.cribs} setCribs={props.setCribs} />
          )
        }
      }

  dayjs.extend(relativeTime);
  
  return (
    renderContent()
  )
}

export default BuyACrib