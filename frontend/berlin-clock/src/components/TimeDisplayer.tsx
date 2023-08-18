import React from 'react';

type TimeDisplayerProps = {
    time: string;
  };

const TimeDisplayer = ({ time } : TimeDisplayerProps) => <div> Current Time is {time} </div>;

export default TimeDisplayer;