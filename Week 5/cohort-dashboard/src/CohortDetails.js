import React from 'react';
import styles from './CohortDetails.module.css'; // Import CSS Module

const CohortDetails = ({ title, startDate, endDate, status }) => {

    const titleStyle = {
        color: status.toLowerCase() === 'ongoing' ? 'green' : 'blue',
        marginTop: '0px',
        marginBottom: '12px'
    };

    return (
        <div className={styles.box}>
            <h3 style={titleStyle}>{title}</h3>
            <dl>
                <dt>Start Date</dt>
                <dd>{startDate}</dd>

                <dt>End Date</dt>
                <dd>{endDate}</dd>

                <dt>Status</dt>
                <dd style={{ fontWeight: 'bold', textTransform: 'capitalize' }}>{status}</dd>
            </dl>
        </div>
    );
};

export default CohortDetails;