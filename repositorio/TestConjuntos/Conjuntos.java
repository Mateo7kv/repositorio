package TestConjuntos;

import java.util.HashSet;
import java.util.Set;

public class Conjuntos {
    //Funciones
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {//Alarar que cualquier conjunto de tipo set no puede tener datos duplicados
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static Set<Integer> interseccion(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static Set<Integer> resta(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.removeAll(set2); 
        return result;
    }

    public static void main(String[] args) {
        // Operaciones solicitadas en el hans 8
        Set<Integer> result1 = interseccion(DataSet.A, DataSet.B);
        Set<Integer> result2 = interseccion(union(DataSet.A, DataSet.B), DataSet.C);
        Set<Integer> paren1 = interseccion(DataSet.C, DataSet.D);
        Set<Integer> result3 = interseccion(result1, paren1);
        Set<Integer> op1 = interseccion(DataSet.C, DataSet.D);
        Set<Integer> op2 = interseccion(DataSet.F, DataSet.G);
        Set<Integer> paren2 = interseccion(result1, op1);
        Set<Integer> result4 = resta(op2, paren2);

        // Resultados
        System.out.println("A union B: " + result1);
        System.out.println("A union B interseccion C: " + result2);
        System.out.println("(A union B) interseccion (C interseccion D): " + result3);
        System.out.println("((A union B) interseccion (C interseccion D)) menos (F interseccion G): " + result4);
    }
}