package io.arichter.hotel.checkin;

import io.arichter.hotel.checkin.service.CheckinService;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CheckinEventHandler {

    private CheckinService checkinService;

    public CheckinEventHandler(CheckinService checkinService) {
        this.checkinService = checkinService;
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    public void beforeSave(Checkin checkin) {
        if (checkin.getAdicionalVeiculo() == null) {
            checkin.setAdicionalVeiculo(false);
        }

        checkinService.beforeSave(checkin);
    }
}
