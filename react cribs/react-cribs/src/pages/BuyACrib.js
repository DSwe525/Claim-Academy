import React from 'react'
import axios from 'axios'
import {useEffect} from 'react'

function BuyACrib(props) {
  
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
  
  dayjs.extend(relativeTime);
  
  return (
    <div>Place Holder</div>
  )
}

export default BuyACrib