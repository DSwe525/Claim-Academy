import React from 'react'
import AgentProfile from '../components/AgentProfile'
import CreateACrib from '../components/CreateACrib'
import AddressForm from '../components/AddressForm'
import '../css/addacrib.css'




function AddACrib(props) {


    const renderAddress = () => {
        if(props.cribs.id !== undefined) {
            return (
                <AddressForm className='half-height' address={props.address} addressId={props.cribs.address.id} setAddress={props.setAddress}/>
            )
        } else {
            return null
        }
    }
    return (
        <div className='flex-row half-width justify-center'>
            <div className='half-width justify-center'>
            <AgentProfile agent={props.agent} />
            </div>
            <div className='half-width flex-col justify-center'>
            <CreateACrib className='justify-center half-height' cribs={props.cribs} setCribs={props.setCribs}/>
            {
            renderAddress()
            }
            </div>
       </div>
    )
}

export default AddACrib