package fr.katanley.time;

import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.katanley.time.Symbol.*;

/**
 * Here is the class that helps to convert a given time into the BerlinClock Representation
 * @author kaflamalice
 */
public class ClockHelper {

    public static final int SINGLE_MINUTES_ROW_LENGTH = 4;
    public static final int SINGLE_HOURS_ROW_LENGTH = 4;
    public static final int FIVE_MINUTES_ROW_LENGTH = 11;
    public static final int FIVE_HOURS_ROWS_LENGTH = 4;

    /**
     *
     * @param time is the time that we want to convert
     * @return the single minute Row of the Berlin Clock, see
     * @see fr.katanley.time.Symbol to change Light Symbol
     */
    public String getTheSingleMinutesRow(LocalTime time) {
        int minute = time.getMinute();
        int i = minute % 5;
        if (i == 0) {
            return IntStream.range(0, SINGLE_MINUTES_ROW_LENGTH).mapToObj((id) -> NO_LIGHT_SYMBOL.toString()).collect(Collectors.joining());
        }
        StringBuilder minutesRow;
        minutesRow = new StringBuilder(YELLOW_LIGHT_SYMBOL.toString().repeat(i));
        while (minutesRow.length() < SINGLE_MINUTES_ROW_LENGTH) {
            minutesRow.append(NO_LIGHT_SYMBOL);
        }
        return minutesRow.toString();
    }

    public String getTheSingleHoursRow(LocalTime time) {
        int hour = time.getHour();
        int i = hour % 5;
        if (i == 0) {
            return IntStream.range(0, SINGLE_HOURS_ROW_LENGTH).mapToObj((id) -> NO_LIGHT_SYMBOL.toString()).collect(Collectors.joining());
        }
        StringBuilder hoursRow;
        hoursRow = new StringBuilder(RED_LIGHT_SYMBOL.toString().repeat(i));
        while (hoursRow.length() < SINGLE_HOURS_ROW_LENGTH) {
            hoursRow.append(NO_LIGHT_SYMBOL);
        }
        return hoursRow.toString();
    }

    public String getTheFiveHoursRow(LocalTime time) {
        int hours = time.getHour();
        int i = hours / 5;
        if (i == 0) {
            return IntStream.range(0, FIVE_HOURS_ROWS_LENGTH).mapToObj((id) -> NO_LIGHT_SYMBOL.toString()).collect(Collectors.joining());
        }
        StringBuilder fiveHoursRow = new StringBuilder();
        fiveHoursRow.append(RED_LIGHT_SYMBOL.toString().repeat(i));
        while (fiveHoursRow.length() < FIVE_HOURS_ROWS_LENGTH) {
            fiveHoursRow.append(NO_LIGHT_SYMBOL);
        }
        return fiveHoursRow.toString();
    }

    public String getTheFiveMinutesRow(LocalTime time) {
        int minute = time.getMinute();
        int i = minute / 5;
        if (i == 0) {
            return IntStream.range(0, FIVE_MINUTES_ROW_LENGTH).mapToObj((id) -> NO_LIGHT_SYMBOL.toString()).collect(Collectors.joining());
        }
        StringBuilder fiveMinutesRow = this.fillTheFiveMinuteRow(i);
        while (fiveMinutesRow.length() < FIVE_MINUTES_ROW_LENGTH)
            fiveMinutesRow.append(NO_LIGHT_SYMBOL);
        return fiveMinutesRow.toString();
    }

    private StringBuilder fillTheFiveMinuteRow(int quotient){
        StringBuilder fiveMinutesRow = new StringBuilder();
        for (int j = 1; j <= quotient; j++) {
            if (j % 3 == 0) {
                fiveMinutesRow.append(RED_LIGHT_SYMBOL);
            } else {
                fiveMinutesRow.append(YELLOW_LIGHT_SYMBOL);
            }
        }
        return fiveMinutesRow;
    }

    public String getTheSecondsLamp(LocalTime time) {
        int second = time.getSecond();
        if (second % 2 == 0) {
            return YELLOW_LIGHT_SYMBOL.toString();
        }
        return NO_LIGHT_SYMBOL.toString();
    }

    public String getTheEntireClockRepresentation(LocalTime time) {
        return getTheSecondsLamp(time)
                .concat(getTheFiveHoursRow(time))
                .concat(getTheSingleHoursRow(time))
                .concat(getTheFiveMinutesRow(time))
                .concat(getTheSingleMinutesRow(time));
    }
}
