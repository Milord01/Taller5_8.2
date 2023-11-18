/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notas;

public class Notas {
    double[] listaNotas = new double[5];

    public double calcularPromedio() {
        double sum = 0;
        for (double nota : listaNotas) {
            sum += nota;
        }
        return sum / listaNotas.length;
    }

    public double calcularDesviación() {
        double mean = calcularPromedio();
        double sum = 0;
        for (double nota : listaNotas) {
            sum += Math.pow(nota - mean, 2);
        }
        return Math.sqrt(sum / ((listaNotas.length)-1));
    }

    public double calcularMayor() {
        double max = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota > max) {
                max = nota;
            }
        }
        return max;
    }

    public double calcularMenor() {
        double min = listaNotas[0];
        for (double nota : listaNotas) {
            if (nota < min) {
                min = nota;
            }
        }
        return min;
    }
}
