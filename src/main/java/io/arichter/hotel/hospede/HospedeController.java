package io.arichter.hotel.hospede;

import io.arichter.hotel.hospede.payload.HospedeResponse;
import io.arichter.hotel.hospede.service.HospedeService;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestController
public class HospedeController {

    private HospedeService hospedeService;

    private HospedeFactory hospedeFactory;

    public HospedeController(HospedeService hospedeService, HospedeFactory hospedeFactory) {
        this.hospedeService = hospedeService;
        this.hospedeFactory = hospedeFactory;
    }

    @GetMapping("hospedes/pesquisar")
    @ResponseBody
    public List<HospedeResponse> findHospede(@RequestParam(required = false) String nome,
                                             @RequestParam(required = false) String cpf,
                                             @RequestParam(required = false) Integer telefone) {
        List<Hospede> hospedes = hospedeService.findHospede(nome, cpf, telefone);

        return hospedeFactory.create(hospedes);
    }
}
