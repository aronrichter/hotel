package io.arichter.hotel.checkin.payload;

import io.arichter.hotel.checkin.Checkin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckinResponse extends Checkin {

    private Double valorEstadia;
}
