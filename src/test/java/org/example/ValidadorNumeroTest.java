package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidadorNumeroTest {

    @ParameterizedTest(name = "O numero é par")
    @ValueSource(ints ={2, 4, 10, 20, 100, 1000})
    void ConfirmaSeNumeroEPar(int numero) {
        boolean resultado = ValidadorNumero.ehPar(numero);

        assertTrue(resultado);
    }

    @ParameterizedTest(name = "O numero é impar")
    @ValueSource(ints = {1,3,7,15,99,101})
    void validadorDeveRetornarFalso(int numero){

        boolean resultado = ValidadorNumero.ehPar(numero);

        assertFalse(resultado);

    }

}

