import React from 'react'

function AddressForm() {
  return (
    <div className='flex-col full-width'>
    <h1 className='content-center'>Enter Address Info</h1>
<div className='flex-row'>
    <div className='flex-col half-width align-center'>
        <label className='label'>Street Number</label>
        <input name="streetNo" type="number" className='property-input' placeholder='Street No.'
            value={props.address.streetNo} onChange={props.changeHandler}
        />
    </div>
    <div className='flex-col half-width align-center'>
        <label className='label'>Street Name</label>
        <input name="streetName" type="text" className='property-input' placeholder='Street Name'
            value={props.address.streetName} onChange={props.changeHandler}
        />
    </div>
</div>
<div className='flex-row'>
    <div className='flex-col half-width align-center'>
        <label className='label'>Unit Number</label>
        <input name="unitNumber" type="number" className='property-input' placeholder='Unit Number'
            value={props.address.unitNumber} onChange={props.changeHandler}
        />
    </div>
    <div className='flex-col half-width align-center'>
        <label className='label'>City</label>
        <input name="city" type="text" className='property-input' placeholder='City'
            value={props.address.city} onChange={props.changeHandler}
        />
    </div>
</div>
<div className='flex-row'>
    <div className='flex-col half-width align-center'>
        <label className='label'>State</label>
        <input name="state" type="text" className='property-input' placeholder='State'
            value={props.address.state} onChange={props.changeHandler}
        />
    </div>
    <div className='flex-col half-width align-center'>
        <label className='label'>ZipCode</label>
        <input name="zipCode" type="number" className='property-input' placeholder='Zip Code'
            value={props.address.zipCode} onChange={props.changeHandler}
        />
    </div>
</div>
<button className='submit' onClick={props.submitHandler}>
    Submit
</button>
</div>
  )
}

export default AddressForm