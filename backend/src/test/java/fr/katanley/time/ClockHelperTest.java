package fr.katanley.time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockHelperTest {

    @ParameterizedTest
    @MethodSource("singleMinutesToTextRow")
    public void shouldBeAbleToGetTheSingleMinuteRowsProperly(LocalTime time, String textRepresentation) {
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theSingleMinutesRow = clockHelper.getTheSingleMinutesRow(time);

        //then
        assertEquals(textRepresentation, theSingleMinutesRow);
    }

    private static Stream<Arguments> singleMinutesToTextRow() {
        return Stream.of(
                Arguments.arguments(LocalTime.of(0, 0, 0), "OOOO"),
                Arguments.arguments(LocalTime.of(23, 59, 59), "YYYY"),
                Arguments.arguments(LocalTime.of(12, 32, 0), "YYOO"),
                Arguments.arguments(LocalTime.of(12, 34, 0), "YYYY"),
                Arguments.arguments(LocalTime.of(12, 35, 0), "OOOO")
        );
    }


    @ParameterizedTest
    @MethodSource("fiveMinutesToTextRow")
    public void shouldBeAbleToGetTheFiveMinuteRowsProperly(LocalTime time, String textRepresentation) {
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theFiveMinutesRow = clockHelper.getTheFiveMinutesRow(time);

        //then
        assertEquals(textRepresentation, theFiveMinutesRow);
    }

    private static Stream<Arguments> fiveMinutesToTextRow() {
        return Stream.of(
                Arguments.arguments(LocalTime.of(0, 0, 0), "OOOOOOOOOOO"),
                Arguments.arguments(LocalTime.of(23, 59, 59), "YYRYYRYYRYY"),
                Arguments.arguments(LocalTime.of(12, 4, 0), "OOOOOOOOOOO"),
                Arguments.arguments(LocalTime.of(12, 23, 0), "YYRYOOOOOOO"),
                Arguments.arguments(LocalTime.of(12, 35, 0), "YYRYYRYOOOO")
        );
    }

    @ParameterizedTest
    @MethodSource("singleHoursToTextRow")
    public void shouldBeAbleToGetTheSingleHoursRowsProperly(LocalTime time, String textRepresentation) {
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theSingleHoursRow = clockHelper.getTheSingleHoursRow(time);

        //then
        assertEquals(textRepresentation, theSingleHoursRow);
    }

    private static Stream<Arguments> singleHoursToTextRow() {
        return Stream.of(
                Arguments.arguments(LocalTime.of(0, 0, 0), "OOOO"),
                Arguments.arguments(LocalTime.of(23, 59, 59), "RRRO"),
                Arguments.arguments(LocalTime.of(2, 4, 0), "RROO"),
                Arguments.arguments(LocalTime.of(8, 23, 0), "RRRO"),
                Arguments.arguments(LocalTime.of(14, 35, 0), "RRRR")
        );
    }

    @ParameterizedTest
    @MethodSource("fiveHoursToTextRow")
    public void shouldBeAbleToGetTheFiveHoursRowsProperly(LocalTime time, String textRepresentation) {
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theSingleHoursRow = clockHelper.getTheFiveHoursRow(time);

        //then
        assertEquals(textRepresentation, theSingleHoursRow);
    }

    private static Stream<Arguments> fiveHoursToTextRow() {
        return Stream.of(
                Arguments.arguments(LocalTime.of(0, 0, 0), "OOOO"),
                Arguments.arguments(LocalTime.of(23, 59, 59), "RRRR"),
                Arguments.arguments(LocalTime.of(2, 4, 0), "OOOO"),
                Arguments.arguments(LocalTime.of(8, 23, 0), "ROOO"),
                Arguments.arguments(LocalTime.of(16, 35, 0), "RRRO")
        );
    }

    @ParameterizedTest
    @MethodSource("secondsToLamp")
    public void shouldBeAbleToGetTheSecondLampProperly(LocalTime time, String textRepresentation) {
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theSecondsLamp = clockHelper.getTheSecondsLamp(time);

        //then
        assertEquals(textRepresentation, theSecondsLamp);
    }

    private static Stream<Arguments> secondsToLamp() {
        return Stream.of(
                Arguments.arguments(LocalTime.of(0, 0, 0), "Y"),
                Arguments.arguments(LocalTime.of(23, 59, 59), "O")
        );
    }

    @ParameterizedTest
    @MethodSource("fillTimeToTextRepresentation")
    public void shouldBeAbleToGetTheEntireBerlinClock(LocalTime time, String textRepresentation) {
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theEntireClockRepresentation = clockHelper.getTheEntireClockRepresentation(time);

        //then
        assertEquals(textRepresentation, theEntireClockRepresentation);
    }

    private static Stream<Arguments> fillTimeToTextRepresentation() {
        return Stream.of(
                Arguments.arguments(LocalTime.of(0, 0, 0), "YOOOOOOOOOOOOOOOOOOOOOOO"),
                Arguments.arguments(LocalTime.of(23, 59, 59), "ORRRRRRROYYRYYRYYRYYYYYY"),
                Arguments.arguments(LocalTime.of(16, 50, 6), "YRRROROOOYYRYYRYYRYOOOOO"),
                Arguments.arguments(LocalTime.of(11, 37, 1), "ORROOROOOYYRYYRYOOOOYYOO")
        );
    }
}