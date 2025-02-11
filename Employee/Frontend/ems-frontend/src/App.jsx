
import './App.css'
import Navbar from "./components/Navbar"; // If Navbar.jsx is inside a "components" folder
import {BrowserRouter, Routes,Route} from 'react-router-dom'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import EmployeeComponent from './components/EmployeeComponent';

function App() {
  return (
    <>
    <BrowserRouter>
    <Navbar/>
    <Routes>
      <Route path='/' element={<ListEmployeeComponent/>}></Route>
      <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
      <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
    </Routes>

    </BrowserRouter>

    </>
  )
}
export default App
