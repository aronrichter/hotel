package io.arichter.hotel.tabelapreco;

import io.arichter.hotel.tabelapreco.service.TabelaPrecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tabelas_preco")
public class TabelaPrecoController {

    private TabelaPrecoService tabelaPrecoService;

    public TabelaPrecoController(TabelaPrecoService tabelaPrecoService) {
        this.tabelaPrecoService = tabelaPrecoService;
    }

    @GetMapping
    public List<TabelaPreco> findTabelasPreco() {
        return tabelaPrecoService.findTabelasPreco();
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable TabelaPreco tabelaPreco, @RequestBody Double novoValor) {
        tabelaPrecoService.upate(tabelaPreco, novoValor);
    }
}
