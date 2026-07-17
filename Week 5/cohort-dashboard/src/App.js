import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {

  const cohorts = [
    { id: 1, title: 'AWS Cloud Practitioner', startDate: '01-May-2026', endDate: '15-Jul-2026', status: 'completed' },
    { id: 2, title: 'Java FSE with React', startDate: '10-Jun-2026', endDate: '30-Aug-2026', status: 'ongoing' },
    { id: 3, title: 'Data Science & ML', startDate: '01-Jul-2026', endDate: '15-Sep-2026', status: 'ongoing' },
    { id: 4, title: 'DevOps Engineering', startDate: '15-Mar-2026', endDate: '30-May-2026', status: 'completed' }
  ];

  return (
      <div className="App" style={{ padding: '30px', fontFamily: 'Arial, sans-serif' }}>
        <header style={{ textAlign: 'center', marginBottom: '40px' }}>
          <h1 style={{ color: '#2c3e50' }}>Cognizant Academy Dashboard</h1>
          <p style={{ color: '#7f8c8d' }}>Ongoing & Completed Training Cohorts</p>
          <hr style={{ maxWidth: '600px', border: '0.5px solid #ccc' }} />
        </header>

        <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center' }}>
          {cohorts.map(cohort => (
              <CohortDetails
                  key={cohort.id}
                  title={cohort.title}
                  startDate={cohort.startDate}
                  endDate={cohort.endDate}
                  status={cohort.status}
              />
          ))}
        </div>
      </div>
  );
}

export default App;