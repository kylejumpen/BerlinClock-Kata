import React from 'react';
import logo from './logo.svg';
import './App.css';
import TimeDisplayer from './components/TimeDisplayer';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
      <TimeDisplayer time='12:14:145'/>
    </div>
  );
}

export default App;
