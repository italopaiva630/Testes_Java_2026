package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ControleAcessoTest {

    @ParameterizedTest(name = "Idade: {0}, Acompanhado {1} -> pode entrar: {2}")
    @CsvSource({"15,true,false",
            "15,false,false",
            "16,true,true",
            "16,	false,	false",
            "17,	true,	true",
            "17,	false,	false",
            "18,	true,	true",
            "18,	false,	true",
            "25,	false,	true"
    })
    void verificandoPermissaodeEntrada(int idade, boolean acompanhado, boolean entrada){


        boolean resultado = ControleAcesso.podeEntrar(idade, acompanhado);

        assertEquals(entrada,resultado);
    }

}
