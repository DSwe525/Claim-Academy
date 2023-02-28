import React from 'react'

function AvailableCribs(props) {
  return (
    <div className="main-page-box flex-col">
    <div className='main-content-title flex-row'>Get on these GREAT DEALS ! ! ! </div>
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
        <button className="button-format">Buy Now!</button>
        </div>
        )
      })
    }
    </div>
    </div>
  )
}

export default AvailableCribs