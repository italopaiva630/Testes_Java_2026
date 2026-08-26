package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraFreteTest {

    @ParameterizedTest(name = "caso {index}: peso {0}kg | expressa: {1} = R$ {2}")
    @CsvSource({
            " 0.01, false,  8.02",
            " 0.01,  true, 12.03",
            " 2.00, false, 12.00",
            " 2.00,  true, 18.00",
            "10.00, false, 28.00"
    })
    void calcularDeveCalcularFreteCorretamente(
            double pesoKg,
            boolean entregaExpressa,
            double esperado) {

        double obtido = CalculadoraFrete.calcular(pesoKg, entregaExpressa);

        assertEquals(esperado, obtido, 0.001);
    }

    @ParameterizedTest(name = "peso 0 deve ser rejeitado")
    @ValueSource(doubles = {0.0, -0.01, -5.0})
    void pesoZeroOuNegativoDeveLancarExcecao(double pesoKg) {
        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> CalculadoraFrete.calcular(pesoKg, false)
        );

        assertEquals(
                "O peso deve ser maior que zero.",
                excecao.getMessage()
        );
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void calcularDeveTerminarRapidamente() {

        CalculadoraFrete.calcular(10.0, true);
    }
}