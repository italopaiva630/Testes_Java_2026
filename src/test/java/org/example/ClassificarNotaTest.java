package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

public class ClassificarNotaTest {

    // Teste de alunos reprovados
    @ParameterizedTest
    @ValueSource(doubles = {0.0, 2.5, 4.9})
    void deveClassificarComoReprovado(double nota) {
        assertEquals("REPROVADO", ClassificarNota.classificar(nota));
    }

    // Teste de alunos em recuperação
    @ParameterizedTest
    @ValueSource(doubles = {5.0, 6.0, 6.9})
    void deveClassificarComoRecuperacao(double nota) {
        assertEquals("RECUPERACAO", ClassificarNota.classificar(nota));
    }

    // Teste de alunos aprovados
    @ParameterizedTest
    @ValueSource(doubles = {7.0, 8.5, 10.0})
    void deveClassificarComoAprovado(double nota) {
        assertEquals("APROVADO", ClassificarNota.classificar(nota));
    }

    // Teste de limites com CsvSource
    @ParameterizedTest
    @CsvSource({
            "0.0, REPROVADO",
            "4.9, REPROVADO",
            "5.0, RECUPERACAO",
            "6.9, RECUPERACAO",
            "7.0, APROVADO",
            "10.0, APROVADO"
    })
    void deveClassificarNosLimites(double nota, String esperado) {
        assertEquals(esperado, ClassificarNota.classificar(nota));
    }

    // Teste de notas inválidas (negativas e maiores que 10)
    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -5.0, 10.1, 15.0})
    void deveLancarExcecaoParaNotasInvalidas(double nota) {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> ClassificarNota.classificar(nota));

        assertEquals("Nota deve estar entre 0 e 10.", exception.getMessage());
    }
}
