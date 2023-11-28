package TestConjuntos;

import java.util.HashSet;
import java.util.Set;

public class DataSet {
    //public static Set<String> A = new HashSet<>();
    public static Set<Integer> A = new HashSet<>();
    public static Set<Integer> B = new HashSet<>();
    public static Set<Integer> C = new HashSet<>();
    public static Set<Integer> D = new HashSet<>();
    public static Set<Integer> E = new HashSet<>();
    public static Set<Integer> F = new HashSet<>();
    public static Set<Integer> G = new HashSet<>();

    static {
        A.add(2);
        A.add(4);
        A.add(6);
        A.add(8);
        A.add(10);
        

        B.add(1);
        B.add(3);
        B.add(5);
        B.add(7);
        B.add(9);

        C.add(5);
        C.add(6);
        C.add(7);
        C.add(8);

        D.add(7);
        D.add(8);
        D.add(9);
        D.add(10);

        E.add(1);
        E.add(2);
        E.add(3);
        E.add(4);

        F.add(2);
        F.add(4);
        F.add(6);
        F.add(8);
       // F.add(9);

        G.add(3);
        G.add(6);
        G.add(9);
        G.add(10);
    }
}

