package jacobi;
import java.util.Arrays;

public class Jacobi{

   
    public static double[] jacobi(double[][] A, double[] b, int iteracionesMaximas, double tolerancia) {
        int n = A.length;
        double[] x = new double[n];
        double[] xAnterior = new double[n];
        Arrays.fill(xAnterior, 0); 