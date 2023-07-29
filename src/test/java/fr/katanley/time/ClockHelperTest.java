package fr.katanley.time;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockHelperTest {

    @ParameterizedTest
    @MethodSource("minutesToTextRow")
    public void shouldBeAbleToGetTheSingleRowsProperly(LocalTime time, String textRepresentation){
        //Given
        ClockHelper clockHelper = new ClockHelper();

        //When
        String theSingleMinutesRow = clockHelper.getTheSingleMinutesRow(time);

        //then
        assertEquals(textRepresentation, theSingleMinutesRow);
    }

    private static Stream<Arguments> minutesToTextRow() {
        return Stream.of(
            Arguments.arguments(LocalTime.of(0,0,0), "OOOO"),
            Arguments.arguments(LocalTime.of(23,59,59), "YYYY"),
            Arguments.arguments(LocalTime.of(12,32,0), "YYOO"),
            Arguments.arguments(LocalTime.of(12,34,0), "YYYY"),
            Arguments.arguments(LocalTime.of(12,35,0), "OOOO")
        );
    }
}