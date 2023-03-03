import React from 'react'
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime'
import '../css/home.css'
import { useNavigate } from 'react-router'
import axios from 'axios'
import Dropdown from 'react-bootstrap/Dropdown';
import 'bootstrap/dist/css/bootstrap.min.css'

function AvailableCribs(props) {

    const navigator = useNavigate()

    const submitHandler = (event) => {

        axios.post(`http://localhost:8080/crib/buycrib/${event.target.id}`, props.customer)
        .then((response)=> {
            props.setCustomer(response.data)
            navigator('/BuyACrib')
        })
        .catch((e) => {
            console.log(e)
        })
    }
    dayjs.extend(relativeTime);

  return (
    <div className="main-page-box flex-col">
      <div className="flex-row margin-bottom">
      <div className='third-width justify-content-center'>
        
      <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        Square Footage
      </Dropdown.Toggle>
      <Dropdown.Menu>
        <Dropdown.Item href="#/action-1">Less than 3,000</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Less than 5,000</Dropdown.Item>
        <Dropdown.Item href="#/action-3">Greater Than 5,001</Dropdown.Item>
      </Dropdown.Menu>
      </Dropdown>
      </div>
      <div className='third-width justify-content-center'>
      <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        Price
      </Dropdown.Toggle>
      <Dropdown.Menu>
        <Dropdown.Item href="#/action-1">Less than $3,000,000</Dropdown.Item>
        <Dropdown.Item href="#/action-2">Less than $5,000,000</Dropdown.Item>
        <Dropdown.Item href="#/action-3">Greater than $5,000,001</Dropdown.Item>
      </Dropdown.Menu>
      </Dropdown>
      </div>
      <div className='third-width justify-content-center'>
      <Dropdown>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        City/State
      </Dropdown.Toggle>
      <Dropdown.Menu>
      {
        props.address.map((address) => {
        <Dropdown.Item href="#/action-1">{address.city}</Dropdown.Item>
      })
  }
      </Dropdown.Menu>
      </Dropdown>
      </div>
      </div>
    <div className='main-content-title2 flex-row'>Buy a Crib Today!</div>
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
        <button onClick={submitHandler} id={crib.id} className="button-format">Buy Now!</button>
        </div>
        )
      })
    }
    </div>
    </div>
  )
}

export default AvailableCribs