import React from 'react'
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime'
import '../css/home.css'
import { useNavigate } from 'react-router'
import axios from 'axios'

function AvailableCribs(props) {

    const navigator = useNavigate()

    const submitHandler = () => {

        axios.post('http://localhost:8080/crib/buycrib', props.cribs)
        .then((response)=> {
            localStorage.setItem("email", response.data.email)
            props.setCustomer(response.data)
            navigator('/')
        })
        .catch((e) => {
            console.log(e)
        })
    }
    dayjs.extend(relativeTime);

  return (
    <div className="main-page-box flex-col">
    <div className='main-content-title flex-row'>Buy a Crib</div>
    <div className='flex-row'>
    {
      props.cribs.map((crib) => {
        const daysFromNow = dayjs(crib.datePosted).fromNow()
        return (
        <div className='flex-col justify-content-center'>
        <img src={crib.image} className="crib-photos"/>
        <div className='justify-content-center'>Square Feet: {crib.size}</div>
        <div className='justify-content-center'>Beds: {crib.beds}</div>
        <div className='justify-content-center'>Baths: {crib.baths}</div>
        <div className='justify-content-center'>Day(s) On Market:  {daysFromNow}</div>
        <div className='justify-content-center'>Price: ${crib.price}</div>
        <button onClick={submitHandler} className="button-format">Buy Now!</button>
        </div>
        )
      })
    }
    </div>
    </div>
  )
}

export default AvailableCribs