package io.arichter.hotel.checkin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CheckinServiceImplTest {

    @InjectMocks
    private CheckinServiceImpl checkinService;

    @Test
    public void shouldSumOneDayWithMinute() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 12, 2, 16, 31);

        LocalDate localDate = checkinService.checkDataSaida(localDateTime);

        assertThat(localDate).isEqualTo(LocalDate.of(2019, 12, 3));
    }

    @Test
    public void shouldSumOneDayWithHour() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 12, 2, 17, 20);

        LocalDate localDate = checkinService.checkDataSaida(localDateTime);

        assertThat(localDate).isEqualTo(LocalDate.of(2019, 12, 3));
    }

    @Test
    public void shouldReturnSameDay() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 12, 2, 15, 20);

        LocalDate localDate = checkinService.checkDataSaida(localDateTime);

        assertThat(localDate).isEqualTo(LocalDate.of(2019, 12, 2));
    }
}