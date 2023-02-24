import React from 'react'

function CreateACrib(props) {
  return (
            <div className='flex-col full-width'>
                <div className='flex-row'>
                    <div className='flex-col half-width align-center'>
                        <label className='label'>Beds</label>
                        <input name="beds" type="number" className='property-input' placeholder='Beds'
                            value={props.property.beds} onChange={props.changeHandler}
                        />
                    </div>
                    <div className='flex-col half-width align-center'>
                        <label className='label'>Baths</label>
                        <input name="baths" type="number" className='property-input' placeholder='Baths'
                            value={props.property.baths} onChange={props.changeHandler}
                        />
                    </div>
                </div>
                <div className='flex-row'>
                    <div className='flex-col half-width align-center'>
                        <label className='label'>Square Feet</label>
                        <input name="sqFeet" type="number" className='property-input' placeholder='Square Feet'
                            value={props.property.sqFeet} onChange={props.changeHandler}
                        />
                </div>
                    <div className='flex-col half-width align-center'>
                        <label className='label'>Image Url</label>
                        <input name="imageUrl" type="text" className='property-input' placeholder='Image Url'
                            value={props.property.imageUrl} onChange={props.changeHandler}
                        />
                    </div>
                </div>
                <button className='submit' onClick={props.submitHandler}></button>
            </div>
        )
    }
export default CreateACrib