import React, { useState } from 'react';

const TimeDisplayer = () => {

    let dateTime = new Date();
    const [time, setTime] = useState(dateTime);
    setInterval(() => {
        setTime(new Date());
      }, 500);

    return <div> Current Time is {time.toLocaleTimeString()} </div>
};

export default TimeDisplayer;