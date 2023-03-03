import React from 'react'
import axios from 'axios'
import '../css/addressform.css'
import { useNavigate } from 'react-router'

function AddressForm(props) {

    const navigator = useNavigate()

    const changeHandler = (e) => {
        console.log(e)
        const name = e.target.name;
        const value = e.target.value;
        const tempAddress = { ...props.address };
        tempAddress[name] = value;
        props.setAddress(tempAddress)
    }

    const submitHandler = () => {

        const dummyAddress = props.address
        dummyAddress.id = props.addressId
        axios.post(`http://localhost:8080/address/create`, dummyAddress)
        .then((response)=> {
            navigator('/')
        })
        .catch((e) => {
            console.log(e)
        })
    }

  return (
    <div className='flex-col main-page-box'>
    <h1>Enter Address Info</h1>
<div className='flex-row'>
    <div className='flex-col'>
        <label>Street Number</label>
        <input name="streetNumber" type="number" className='property-input' placeholder='Street No.'
            value={props.address.streetNumber} onChange={changeHandler}/>
    </div>
    <div className='flex-col'>
        <label>Street Name</label>
        <input name="streetName" type="text" className='property-input' placeholder='Street Name'
            value={props.address.streetName} onChange={changeHandler}/>
    </div>
</div>
<div className='flex-row'>
    <div className='flex-col'>
        <label className='label'>City</label>
        <input name="city" type="text" className='property-input' placeholder='City'
            value={props.address.city} onChange={changeHandler}/>
    </div>
</div>
<div className='flex-row'>
    <div className='flex-col'>
        <label className='label'>State</label>
        <input name="state" type="text" className='property-input' placeholder='State'
            value={props.address.state} onChange={changeHandler}/>
    </div>
    <div className='flex-col'>
        <label className='label'>Zip Code</label>
        <input name="zipCode" type="number" className='property-input' placeholder='Zip Code'
            value={props.address.zipCode} onChange={changeHandler}/>
    </div>
</div>
<button className ='button' onClick={submitHandler}>
    Submit
</button>
</div>
  )
}

export default AddressForm