import { useEffect, useState } from 'react'
import './App.css';
import PageWrapper from './components/PageWrapper';

function App() {

  const [isLoading, setIsLoading] = useState(true)
  


  useEffect(() => {
    
    axios.get('http://localhost:8080/team/findAll')
      .then((response) => {
        setTeams(response.data)
        setIsLoading(false)

      })
      .catch((e) => {
        console.log(e)
      })
      

  }, [])

  return (
  <PageWrapper>
    Hi Mom
  </PageWrapper>
  );
}

export default App;
