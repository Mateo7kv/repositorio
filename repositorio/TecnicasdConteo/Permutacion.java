package TecnicasdConteo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutacion {

    // Función para obtener el factorial de un número usando un ciclo for
    public static int obtenerFactorial(int n) {
        int resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Función para obtener el primer factorial
    public static int obtenerPrimerFactorial(List<String> datos) {
        int totalDatos = datos.size();
        return obtenerFactorial(totalDatos);
    }

    // Función para obtener un mapa con las repeticiones de cada elemento
    private static Map<String, Integer> obtenerRepeticiones(List<String> datos) {
        Map<String, Integer> repeticiones = new HashMap<>();
        for (String dato : datos) {
            repeticiones.put(dato, repeticiones.getOrDefault(dato, 0) + 1);
        }
        return repeticiones;
    }

    // Función para calcular el segundo factorial y multiplicarlos
    public static int obtenerProductoFactoriales(List<String> datos) {
        Map<String, Integer> repeticiones = obtenerRepeticiones(datos);//sacar la frecuencia de cada dato

        int productoFactoriales = 1;
        for (int repeticion : repeticiones.values()) {//se le asinga a repeticion el valor de cada una de las que se repite
            productoFactoriales *= obtenerFactorial(repeticion);//para sacar el factorial y despues multiplicarlos 
        }

        return productoFactoriales;
    }

    // Función para calcular y mostrar el resultado final
    public static void calcularYMostrarResultado(List<String> datos) {
        int primerFactorial = obtenerPrimerFactorial(datos);
        int segundoFactorial = obtenerProductoFactoriales(datos);

        double resultadoFinal = (double) primerFactorial / segundoFactorial;

        System.out.println("Numero de combinaciones: " + resultadoFinal);
    }
    
    public static void main(String[] args) {
        // Obtener datos del DataSet
        List<String> datos = DataSet.A;

        // Calcular y mostrar resultados
        calcularYMostrarResultado(datos);

        // Generar y mostrar todas las permutaciones
     //   generarYMostrarPermutaciones(datos);
    }
}
