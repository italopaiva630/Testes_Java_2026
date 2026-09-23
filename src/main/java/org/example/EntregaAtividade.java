package org.example;

public class EntregaAtividade {

    public static String verificar(int minutosAtraso, boolean justificativa) {
        if (minutosAtraso < 0 || minutosAtraso == 0) {
            return "NO_PRAZO";
        }

        if (minutosAtraso >= 1 && minutosAtraso <= 10) {
            return "ATRASO_TOLERADO";
        }

        if (minutosAtraso > 10 && justificativa) {
            return "ANALISE_PROFESSOR";
        }

        return "ATRASADA";
    }
}
