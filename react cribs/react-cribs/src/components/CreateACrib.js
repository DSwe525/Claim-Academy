import React from 'react'
import axios from 'axios'
import '../css/createacrib.css'


function CreateACrib(props) {
  
    const changeHandler = (e) => {
        console.log(e)
        const name = e.target.name;
        const value = e.target.value;
        const tempCrib = { ...props.cribs };
        tempCrib[name] = value;
        props.setCribs(tempCrib)
    }

    const submitHandler = () => {

        axios.post('http://localhost:8080/crib/create', props.cribs)
        .then((response)=> {
            props.setCribs(response.data)
        })
        .catch((e) => {
            console.log(e)
        })
    }
  
   return (
            <div className='flex-col full-width main-page-box margin justify-center'>
            <h1>Enter Crib Information</h1>
                <div className='flex-row'>
                    <div className='flex-col'>
                        <label>Beds</label>
                        <input name="beds" type="number" className='' placeholder='beds'
                            value={props.cribs.beds} onChange={changeHandler}
                        />
                    </div>
                    <div className='flex-col'>
                        <label>Baths</label>
                        <input name="baths" type="number" className='' placeholder='baths'
                            value={props.cribs.baths} onChange={changeHandler}
                        />
                    </div>
                </div>
                <div className='flex-row'>
                    <div className='flex-col'>
                        <label>Square Feet</label>
                        <input name="size" type="number" className='' placeholder='size'
                            value={props.cribs.size} onChange={changeHandler}
                        />
                </div>
                <div className='flex-row'>
                    <div className='flex-col'>
                        <label className='label'>Price</label>
                        <input name="price" type="number" className='' placeholder='price'
                            value={props.cribs.price} onChange={changeHandler}
                        />
                </div>
                </div>
                </div>
                <div className='flex-row'>
                <div className='flex-row'>
                    <div className='flex-col'>
                        <label>Image</label>
                        <input name="image" type="text" className='' placeholder='image'
                            value={props.cribs.image} onChange={changeHandler}
                        />
                    </div>
                    </div>
                </div>
                <button className='submit' onClick={submitHandler}></button>
            </div>
        )
    }
export default CreateACrib