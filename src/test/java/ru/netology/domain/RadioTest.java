package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 0, true button)' | true  | 0 | 9 | 0 | 9 ",
                    "'(Start station 9, true button)' | true  | 0 | 9 | 9 | 8 ",
                    "'(Start station 9, false button)'| false | 0 | 9 | 9 | 9 "
            },
            delimiter = '|'
    )
    void setPrevButton (String test, boolean prevButton, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        station.setPrevButton(prevButton);
        assertEquals(expected,station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Start station 9, true button)' | true  | 0 | 9 | 7 | 8 ",
                    "'(Start station 9, true button)' | true  | 0 | 9 | 9 | 0 ",
                    "'(Start station 5, false button)'| false | 0 | 9 | 5 | 5 "
            },
            delimiter = '|'
    )
    void setNextButton (String test, boolean nextButton, int minStation, int maxStation,  int currentStation, int expected) {
        Radio station = new Radio();

        station.setMinStation(minStation);
        station.setMaxStation(maxStation);
        station.setCurrentStation(currentStation);
        station.setNextButton(nextButton);
        assertEquals(expected,station.getCurrentStation());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'(Volume 11)'| 10 | 0 | 11 | 0 ",
                    "'(Volume 9)' | 10 | 0 | 9  | 9 ",
                    "'(Volume 0)' | 10 | 2 | 1  | 0 "
            },
            delimiter = '|'
    )
    void setCurrentVolume(String test, int maxVolume, int minVolume, int currentVolume, int expected) {
        Radio station = new Radio();

        station.setMaxVolume(maxVolume);
        station.setMinVolume(minVolume);
        station.setCurrentVolume(currentVolume);
        assertEquals(expected, station.getCurrentVolume());
    }
}