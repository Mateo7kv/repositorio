package Probabilidad;

public class DataSet {
    private final double[] x;
    private final double[] y;

    public DataSet() {
        x = new double[] {
                1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        y = new double[] {
                3, 6, 9, 12, 15, 18, 21, 24, 27
        };
    }

    public double[] getX() {
        return this.x;
    }

    public double[] getY() {
        return this.y;
    }
}
