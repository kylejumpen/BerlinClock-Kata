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
        int minute = time.getMinute();
        int i = minute / 5;
        if(i == 0)
            return "OOOOOOOOOOO";
        StringBuilder minutesRow = new StringBuilder();
        for (int j = 1; j <= i; j++) {
            if(j % 3 == 0) {
                minutesRow.append("R");
            }else{
                minutesRow.append("Y");
            }
        }
        while(minutesRow.length() < 11)
            minutesRow.append("O");
        return minutesRow.toString();
    }

    public String getTheSingleHoursRow(LocalTime time) {
        return null;
    }
}
