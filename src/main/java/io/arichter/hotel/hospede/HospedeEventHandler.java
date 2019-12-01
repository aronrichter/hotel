package io.arichter.hotel.hospede;

import io.arichter.hotel.hospede.service.HospedeService;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class HospedeEventHandler {

    private HospedeService hospedeService;

    public HospedeEventHandler(HospedeService hospedeService) {
        this.hospedeService = hospedeService;
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    public void beforeSave(Hospede hospede) {
        hospedeService.checkCreate(hospede);
    }

    @HandleBeforeDelete
    public void beforeDelete(Hospede hospede) {
        hospedeService.checkDelete(hospede);
    }
}
