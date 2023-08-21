import React, { useState } from 'react';
import BerlinClockService from '../service/BerlinClockService';

const BerlinTimeDisplayer = () => {

    let clockService = new BerlinClockService();
    const [time, setTime] = useState("LOADING");
    setInterval(() => {
        clockService.convertTimeRepresentation(new Date())
        .then(
            (timeConverted) => 
            {setTime(timeConverted)}
        ).catch((error) => {
            setTime("Error While Connecting to Api")
        })
        
      }, 5000);

    return <div> Berlin Time Equivalent is {time} </div>
};

export default BerlinTimeDisplayer;