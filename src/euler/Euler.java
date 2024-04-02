package euler;
public class Euler {

    public static double funcion(double x, double y) {
        return 2 * x + y;
    }
     
    public static double[] euler(double x0, double y0, double h, double xf) {
        int n = (int) Math.ceil((xf - x0) / h) + 1; 
        double[] x = new double[n]; 
        double[] y = new double[n]; 
        x[0] = x0;
        y[0] = y0;
        