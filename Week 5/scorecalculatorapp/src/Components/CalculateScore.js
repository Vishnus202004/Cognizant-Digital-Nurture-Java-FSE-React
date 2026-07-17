import React from 'react';
import '../Stylesheets/mystyle.css';


const CalculateScore = ({ Name, School, Total, Goal }) => {

    const average = Total && Goal ? ((Total / Goal) * 100).toFixed(2) : 0;

    return (
        <div className="score-card">
            <h2>Student Score Details</h2>
            <div className="score-details">
                <p><strong>Name:</strong> {Name}</p>
                <p><strong>School:</strong> {School}</p>
                <p><strong>Total Marks:</strong> {Total}</p>
                <p><strong>Goal Marks:</strong> {Goal}</p>
                <p className="highlight"><strong>Average Score:</strong> {average}%</p>
            </div>
        </div>
    );
};

export default CalculateScore;