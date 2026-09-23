package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EntregaAtividadeTest {

    @ParameterizedTest
    @MethodSource("fornecedorDeCasos")
    void deveVerificarEntregaCorretamente(int minutos, boolean justificativa, String esperado) {
        assertEquals(esperado, EntregaAtividade.verificar(minutos, justificativa));
    }

    static Stream<Arguments> fornecedorDeCasos() {
        return Stream.of(
                // Fronteiras obrigatórias
                Arguments.of(-1, false, "NO_PRAZO"),
                Arguments.of(0, false, "NO_PRAZO"),
                Arguments.of(1, false, "ATRASO_TOLERADO"),
                Arguments.of(10, false, "ATRASO_TOLERADO"),
                Arguments.of(11, true, "ANALISE_PROFESSOR"),
                Arguments.of(11, false, "ATRASADA"),

                // Casos adicionais
                Arguments.of(5, false, "ATRASO_TOLERADO"),
                Arguments.of(5, true, "ATRASO_TOLERADO"),
                Arguments.of(20, true, "ANALISE_PROFESSOR"),
                Arguments.of(20, false, "ATRASADA"),
                Arguments.of(100, true, "ANALISE_PROFESSOR")
        );
    }
}

