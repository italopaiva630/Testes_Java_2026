package org.example;

public final class CalculadoraFrete {

    private CalculadoraFrete() {}

    public static double calcular(double pesoKg, boolean entregaExpressa) {

        if (pesoKg <= 0) {
            throw new IllegalArgumentException(
                    "O peso deve ser maior que zero."
            );
        }

        double valor = 8.00 + (2.00 * pesoKg);

        if (entregaExpressa) {
            valor = valor * 1.50;
        }

        return valor;
    }
}