import React from 'react'

function AgentProfile(props) {
  return (
        <div className="main-page-box flex-col">
        <div className='main-content-title flex-row'>Buy a Crib</div>
        <div className='flex-row'>
        {
          props.agent.map((agent) => {
            return (
            <div className='flex-col justify-content-center'>
            <img src={agent.image} className="crib-photos"/>
            <div className='justify-content-center'>Square Feet: {agent.size}</div>
            <div className='justify-content-center'>Beds: {agent.beds}</div>
            <div className='justify-content-center'>Baths: {agent.baths}</div>
            <div className='justify-content-center'>Price: ${agent.price}</div>
            </div>
            )
          })
        }
        </div>
        </div>
      )
}

export default AgentProfile