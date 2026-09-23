package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AutenticadorTest {

    @ParameterizedTest
    @MethodSource("fornecedorDeDados")
    void deveAutenticarCorretamente(String usuario, String senha, boolean ativo, boolean esperado) {
        assertEquals(esperado, Autenticador.autenticar(usuario, senha, ativo));
    }

    static Stream<Arguments> fornecedorDeDados() {
        return Stream.of(
                // usuário correto + senha correta + ativo
                Arguments.of("admin", "Senai123", true, true),

                // usuário correto + senha errada + ativo
                Arguments.of("admin", "SenhaErrada", true, false),

                // usuário errado + senha correta + ativo
                Arguments.of("user", "Senai123", true, false),

                // usuário correto + senha correta + inativo
                Arguments.of("admin", "Senai123", false, false),

                // usuário null
                Arguments.of(null, "Senai123", true, false),

                // senha null
                Arguments.of("admin", null, true, false),

                // casos extras para robustez
                Arguments.of("ADMIN", "Senai123", true, false), // case-sensitive
                Arguments.of("admin", "senai123", true, false), // senha minúscula
                Arguments.of("root", "123456", true, false)     // totalmente errado
        );
    }
}
