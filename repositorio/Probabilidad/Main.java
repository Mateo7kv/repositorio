package Probabilidad;

public class Main {

    public static void main(String[] nousan) {
        double su_x;
        double su_y;
        double cant;
        double x_2;
        double y_2;
        double x_y;
        double prox;
        double proy;
        double b1;
        double b0;

        float[] dat_pred;
        float[] dat_pred_x;
        DataSet ds = new DataSet();
        DiscreteMaths dm = new DiscreteMaths();

        su_x = dm.sumX(ds.getX());
        su_y = dm.sumY(ds.getY());
        cant = dm.num_N(ds.getY());
        x_2 = dm.potX(ds.getX());
        y_2 = dm.potY(ds.getY());
        x_y = dm.multip_x_y(ds.getX(), ds.getY());
        prox = dm.promedioX(ds.getX(), su_x);
        proy = dm.promedioY(ds.getY(), su_y);
        b1 = dm.calcularB1(ds.getX(), ds.getY(), su_x, su_y, cant, x_2);
        b0 = dm.calcularB0(proy, b1, prox);

        System.out.println("Cantidad de numeros: " + cant);
        System.out.println("Suma de X: " + su_x);
        System.out.println("Suma de Y: " + su_y);
        System.out.println("Suma de potencias de X: " + x_2);
        System.out.println("Suma de potencias de Y: " + y_2);
        System.out.println("Suma de multiplicacion de X * Y: " + x_y);
        System.out.println("Promedio de X: " + prox);
        System.out.println("Promedio de Y: " + proy);
        System.out.println("-----------------");
        System.out.println("B1 = " + b1);
        System.out.println("B0 = " + b0);

        dat_pred_x = new float[] { 20, 21, 22, 23 };
        dat_pred = new float[dat_pred_x.length];

        for (int i = 0; i < dat_pred_x.length; i++)
            dat_pred[i] = (float) (b1 * dat_pred_x[i] + b0);

        for (int i = 0; i < dat_pred.length; i++) {
            System.out.println("-----------------");
            System.out.println("Prediccion numero: " + dat_pred_x[i]);
            System.out.println(dat_pred[i]);
        }
    }
}