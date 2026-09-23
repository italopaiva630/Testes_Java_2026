package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidadorSenhaTest {

    @ParameterizedTest
    @CsvSource({
            "Senha123, true",
            "Teste2026, true",
            "senha123, false",
            "SENHAAAA, false",
            "Abc1, false",
            "12345678, false",
            "MinhaSenha9, true",
            "Password1, true",
            "Curta7, false"
    })
    void deveValidarSenhasCorretamente(String senha, boolean esperado) {
        assertEquals(esperado, ValidadorSenha.senhaValida(senha));
    }
}

