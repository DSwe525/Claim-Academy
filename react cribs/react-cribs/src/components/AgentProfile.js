import React from 'react'
import '../css/agentprofile.css'


function AgentProfile(props) {


    const renderContent = () => {
        return (
        <div>
        <div className="main-page-box flex-col">
        <div className='main-content-title flex-row'>Agent Profile</div>
        <div className='flex-row'>
            <div className='flex-col justify-content-center'>
            <img src={props.agent.image} className="crib-photos"/>
            <div className='justify-content-center'>Agent: {props.agent.name}</div>
            <div className='justify-content-center'>Phone #: {props.agent.phoneNumber}</div>
            <div className='justify-content-center'>Email: {props.agent.email}</div>
            </div>
        </div>
    </div>
    </div>
    )}

    return (
        renderContent()
    )
}   

export default AgentProfile