package fr.katanley.time;

import java.time.LocalTime;

public class ClockHelper {

    public String getTheSingleMinutesRow(LocalTime time) {
        int minute = time.getMinute();
        int i = minute % 5;
        if(i == 0)
            return "OOOO";
        StringBuilder minutesRow;
        minutesRow = new StringBuilder("Y".repeat(i));
        while(minutesRow.length() < 4)
            minutesRow.append("O");
        return minutesRow.toString();
    }

    public String getTheFiveMinutesRow(LocalTime time) {

        return null;
    }
}
