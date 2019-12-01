package io.arichter.hotel.hospede.payload;

import io.arichter.hotel.checkin.payload.CheckinResponse;
import io.arichter.hotel.hospede.Hospede;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospedeResponse extends Hospede {

    private CheckinResponse ultimaEstadia;
    private Double valorTotal;
}
