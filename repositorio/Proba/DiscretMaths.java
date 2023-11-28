package Proba;

import java.util.Arrays;

public class DiscretMaths {
    static int[] datos = DataSet.datos;

    public static int calcularNumClases(int[] data) {
        int n = data.length;
        return (int) Math.ceil(1 + 3.3 * Math.log10(n));
    }

    public static int calcularRango(int[] data) {
        int max = Arrays.stream(data).max().getAsInt();
        int min = Arrays.stream(data).min().getAsInt();
        return max - min;
    }

    public static void imprimirTabla(int[] clases, int[] frecuenciaAbsoluta, double[] puntoMedio,
            int[] frecuenciaAcumulada, double[] frecuenciaRelativa, double[] frecuenciaRelativaAcumulada) {
        // Encabezados de la tabla
        System.out.println("Datos\t\tFrecuencia Absoluta\tPunto Medio\tFrecuencia Acumulada\tFrecuencia Relativa");

        for (int i = 0; i < clases.length; i++) {
            System.out.println(clases[i] + "-" + (clases[i] + 9) + "\t\t\t" + frecuenciaAbsoluta[i] + "\t\t\t" + puntoMedio[i]
                    + "\t\t\t" + frecuenciaAcumulada[i] + "\t\t\t" + frecuenciaRelativa[i]);
        }

        // Imprimir el número de clases, rango y amplitud
        int numClases = clases.length;
        int rango = calcularRango(datos);
        int amplitud = rango / numClases;
        System.out.println("\nNúmero de Clases: " + numClases);
        System.out.println("Rango: " + rango);
        System.out.println("Amplitud: " + amplitud);

        // Imprimir la frecuencia relativa acumulada
        double frecuenciaRelativaAcumuladaTotal = frecuenciaRelativaAcumulada[frecuenciaRelativaAcumulada.length - 1];
        System.out.println("\nFrecuencia Relativa Acumulada: " + frecuenciaRelativaAcumuladaTotal);
        System.out.println("Porcentaje de Frecuencia Relativa Acumulada: " + (frecuenciaRelativaAcumuladaTotal * 100) + "%");

        double moda = calcularModa(clases, frecuenciaAbsoluta, amplitud);
        if (moda != -1) {
            System.out.println("\nModa: " + moda);
        } else {
            System.out.println("\nNo hay una moda clara en los datos.");
        }

        double mediana = calcularMediana(puntoMedio, frecuenciaAbsoluta, datos.length);
        System.out.println("Mediana: " + mediana);

        double media = calcularMedia(puntoMedio, frecuenciaAbsoluta, datos.length);
        System.out.println("Media: " + media);
    }

    public static double calcularModa(int[] clases, int[] frecuenciaAbsoluta, int amplitud) {
        int maxFrecuencia = -1; // Establece el valor máximo inicialmente a -1
        int indiceModa = -1;

        for (int i = 0; i < frecuenciaAbsoluta.length; i++) {
            if (frecuenciaAbsoluta[i] > maxFrecuencia) {
                maxFrecuencia = frecuenciaAbsoluta[i];
                indiceModa = i;
            }
        }

        if (indiceModa == -1) {
            return -1; // Valor inválido para la moda
        }

        int f1 = frecuenciaAbsoluta[indiceModa]; // Frecuencia del intervalo modal
        int f0 = 0; // Frecuencia del intervalo anterior
        int f2 = 0; // Frecuencia del intervalo siguiente

        if (indiceModa > 0) {
            f0 = frecuenciaAbsoluta[indiceModa - 1];
        }

        if (indiceModa < frecuenciaAbsoluta.length - 1) {
            f2 = frecuenciaAbsoluta[indiceModa + 1];
        }

        double l = clases[indiceModa]; // Límite inferior del intervalo modal
        double moda = l + amplitud * ((f1 - f0) / (2.0 * f1 - f0 - f2));

        return moda;
    }

    public static double calcularMediana(double[] puntoMedio, int[] frecuenciaAbsoluta, int n) {
        double medianaReal = (n + 1) / 2.0; // Posición de la mediana en la lista ordenada (n + 1) / 2
        double frecuenciaAcumuladaAnterior = 0;
        for (int i = 0; i < puntoMedio.length; i++) {
            frecuenciaAcumuladaAnterior += frecuenciaAbsoluta[i];
            if (medianaReal <= frecuenciaAcumuladaAnterior) {
                double l = puntoMedio[i]; // Límite inferior de la clase
                int h = calcularAmplitud(puntoMedio); // Amplitud de la clase
                int f = frecuenciaAbsoluta[i]; // Frecuencia de la clase
                double mediana = l + ((medianaReal - frecuenciaAcumuladaAnterior + f / 2) / f) * h;
                return mediana;
            }
        }
        return -1; // Valor inválido si no se encuentra la mediana
    }

    public static int calcularAmplitud(double[] puntoMedio) {
        return (int) (puntoMedio[1] - puntoMedio[0]); // Suponemos que las clases tienen igual amplitud
    }

    public static double calcularMedia(double[] puntoMedio, int[] frecuenciaAbsoluta, int n) {
        double suma = 0;
        for (int i = 0; i < puntoMedio.length; i++) {
            suma += puntoMedio[i] * frecuenciaAbsoluta[i];
        }
        double media = suma / (double) Arrays.stream(frecuenciaAbsoluta).sum();
        return media;
    }

    public static void main(String[] args) {
        int numClases = calcularNumClases(datos);
        int rango = calcularRango(datos);
        int amplitud = rango / numClases;

        int minData = Arrays.stream(datos).min().getAsInt();
        int[] clases = new int[numClases];
        for (int i = 0; i < numClases; i++) {
            clases[i] = minData + i * amplitud;
        }

        int[] frecuenciaAbsoluta = new int[numClases];
        double[] puntoMedio = new double[numClases];
        int[] frecuenciaAcumulada = new int[numClases];
        double[] frecuenciaRelativa = new double[numClases];
        double[] frecuenciaRelativaAcumulada = new double[numClases];

        for (int i = 0; i < numClases; i++) {
            int claseSuperior = clases[i] + amplitud;
            for (int dato : datos) {
                if (i == numClases - 1) {
                    // Para la última clase, incluir los valores iguales a la clase superior
                    if (dato >= clases[i] && dato <= claseSuperior) {
                        frecuenciaAbsoluta[i]++;
                    }
                } else {
                    if (dato >= clases[i] && dato < claseSuperior) {
                        frecuenciaAbsoluta[i]++;
                    }
                }
            }
        }

        int acumulada = 0;
        for (int i = 0; i < numClases; i++) {
            puntoMedio[i] = (clases[i] + clases[i] + amplitud) / 2.0;
            acumulada += frecuenciaAbsoluta[i];
            frecuenciaAcumulada[i] = acumulada;
            frecuenciaRelativa[i] = (double) frecuenciaAbsoluta[i] / datos.length;
            frecuenciaRelativaAcumulada[i] = (double) acumulada / datos.length;
        }

        imprimirTabla(clases, frecuenciaAbsoluta, puntoMedio, frecuenciaAcumulada, frecuenciaRelativa,
                frecuenciaRelativaAcumulada);
    }
}


