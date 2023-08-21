package fr.katanley.berlinclockapi.controller;

import fr.katanley.berlinclockapi.service.time.ClockHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/convert")
public class TimeConverterController {

    ClockHelper clockHelper;

    public TimeConverterController(ClockHelper clockHelper){
        this.clockHelper = clockHelper;
    }
    @GetMapping("/fromCurrentTime")
    public String convertExactTimeToBerlinRepresentation(@RequestParam String time) {
        return this.clockHelper.getTheEntireClockRepresentation(LocalTime.parse(time));
    }
}
