package fr.katanley.time;

import java.time.LocalTime;

public class ClockHelper {

    public String getTheSingleMinutesRow(LocalTime time) {
        int minute = time.getMinute();
        int i = minute % 5;
        if(i == 0)
            return "OOOO";
        return null;
    }
}
