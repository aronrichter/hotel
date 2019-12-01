package io.arichter.hotel.tabelapreco.service;

import io.arichter.hotel.tabelapreco.TabelaPreco;
import io.arichter.hotel.tabelapreco.TabelaPrecoRepository;
import io.arichter.hotel.tabelapreco.exception.ValorNotValidException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TabelaPrecoServiceImplTest {

    private static final Double VALOR_MENOR_ZERO = -1.20;
    private static final Double VALOR_MAIOR_ZERO = 15.50;

    @InjectMocks
    private TabelaPrecoServiceImpl tabelaPrecoService;

    @Mock
    private TabelaPreco tabelaPreco;

    @Mock
    private TabelaPrecoRepository tabelaPrecoRepository;


    @Test
    public void shouldUpdateValue() {
        when(tabelaPreco.getValor()).thenReturn(VALOR_MAIOR_ZERO);
        when(tabelaPrecoRepository.save(tabelaPreco)).thenReturn(tabelaPreco);

        TabelaPreco tabelaPrecoUpdated = tabelaPrecoService.upate(tabelaPreco, VALOR_MAIOR_ZERO);

        assertThat(tabelaPrecoUpdated.getValor()).isEqualTo(VALOR_MAIOR_ZERO);
    }

    @Test(expected = ValorNotValidException.class)
    public void shouldThrowValorNotValidException() {
        tabelaPrecoService.upate(tabelaPreco, VALOR_MENOR_ZERO);
    }
}