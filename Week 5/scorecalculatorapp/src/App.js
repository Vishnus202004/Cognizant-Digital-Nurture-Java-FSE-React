import React from 'react';
import './App.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
      <div className="App">
        <h1 style={{ textAlign: 'center', marginTop: '20px' }}>Student Management Portal</h1>
        <CalculateScore
            Name="Vishnu"
            School="VIT Bhopal"
            Total={450}
            Goal={500}
        />
      </div>
  );
}

export default App;