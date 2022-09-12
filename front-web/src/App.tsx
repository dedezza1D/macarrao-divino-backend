import { ToastContainer } from "react-toastify";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./Home";
import Navbar from "./Navbar";
import Orders from "./Orders";
import Login from "./Login/AppLogin";
import "react-toastify/dist/ReactToastify.css";

import "./App.css";
import Register from "./Register/Register";


function App() {
  return (
    <>
    <BrowserRouter>
    <Navbar/>
      <Routes>
        <Route path="/orders" element={<Orders/>}></Route>
        <Route path="/login" element={<Login/>}></Route>
        <Route path="/register" element={<Register/>}></Route>
        <Route path="/Home" element={<Home/>}></Route>
      </Routes>
      <ToastContainer />
  </BrowserRouter>
    </>
  );
}

export default App;