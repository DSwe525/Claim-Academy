import { useEffect, useState } from 'react'
import './App.css';
import PageWrapper from './components/PageWrapper';
import axios from 'axios';
import dayjs from 'dayjs';
import relativeTime from 'dayjs/plugin/relativeTime'

function App() {

  const [isLoading, setIsLoading] = useState(true)
  const [cribs, setCribs] = useState([])

dayjs.extend(relativeTime);
  useEffect(() => {
    
    axios.get('http://localhost:8080/crib/getlistofspecials')
      .then((response) => {
        setCribs(response.data)
        setIsLoading(false)

      })
      .catch((e) => {
        console.log(e)
      })
      

  }, [])

  const renderContent = () => {

    if(isLoading) {
      return null
    } else {
      return (
      <PageWrapper>
        <div className="justify-content-center">
        <div className="main-page-box flex-row">
        {
          cribs.map((crib) => {
            const daysFromNow = dayjs(crib.datePosted).fromNow()
            return (
            <div className='flex-col justify-content-center'>
            <img src={crib.image} className="crib-photos"/>
            <div className='align-text-center'>Square Feet: {crib.size}</div>
            <div className='align-text-center'>Beds: {crib.beds}</div>
            <div className='align-text-center'>Baths: {crib.baths}</div>
            <div className='align-text-center'>Day(s) On Market:  {daysFromNow}</div>
            <div className='align-text-center'>Price: ${crib.price}</div>
            <button className="button-format">Buy Now!</button>
            </div>
            )
          })
        }
        </div>
        </div>
      </PageWrapper>
      )
    }
  }
  return (
    renderContent()
  )
}

export default App;
