import React from 'react';
import logo from './logo.svg';
import './App.css';
import TimeDisplayer from './components/TimeDisplayer';
import BerlinTimeDisplayer from './components/BerlinTimeDisplayer';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
      <TimeDisplayer />
      <BerlinTimeDisplayer />
    </div>
  );
}

export default App;
