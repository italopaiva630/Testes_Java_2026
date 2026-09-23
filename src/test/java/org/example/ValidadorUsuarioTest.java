package org.example;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorUsuarioTest {

    @ParameterizedTest(name = "O nome é valido")
    @ValueSource(strings = {"Ana", "Carlos", "Maria", "Joao123", "usuario" })
    void verificarNomeValido(String nome){

        boolean resultado = ValidadorUsuario.nomeValido(nome);

        assertTrue(resultado);
    }


    @ParameterizedTest(name = "O nome é invalido")
    @NullAndEmptySource
    @ValueSource(strings = {"   ", "  "})
    void verificarNomeVazioNulo(String nome) {

        boolean resultado = ValidadorUsuario.nomeValido(nome);

        assertFalse(resultado);
    }
}
