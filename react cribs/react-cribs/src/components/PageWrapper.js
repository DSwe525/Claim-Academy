import React from 'react'
import Header from './Header'
import MainContent from './MainContent'

function PageWrapper(props) {
  return (
    <div className="App flex-col page">
    <Header customer={props.customer} setCustomer={props.setCustomer} agent={props.agent} setAgent={props.setAgent}/>
    <MainContent>
      {props.children}
    </MainContent>
  </div>
  )
}

export default PageWrapper