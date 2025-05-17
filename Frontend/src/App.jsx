import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import CourseRegistration from './Components/CourseRegistration'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h2>Hi</h2>
      <CourseRegistration />
    </>
  )
}

export default App
