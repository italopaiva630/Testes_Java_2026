package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstacionamentoTest {

    @ParameterizedTest(name = "Tempo Estacionado: {0} horas | Valor: {1} Reais")
    @CsvSource({"1,5.0" ,
            "2,10.0",
            "4,15.0"
    })
    void verificandoValoraPagar(int horas, double valor){

        double resultado = Estacionamento.calcularValor(horas);

        assertEquals(valor,resultado);

    }

    @ParameterizedTest(name = "Testando Horas Inválidas")
    @ValueSource(ints = {0,
            -1,
            -5,
            -100})
    void testandoException (int horas){

        double resultado = Estacionamento.calcularValor(horas);

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class,
                () -> Estacionamento.calcularValor(horas));

        assertEquals(
                "Horas Inválidas",
                excecao.getMessage()
        );

    }


}
