package jacobi;
import java.util.Arrays;

public class Jacobi{

   
    public static double[] jacobi(double[][] A, double[] b, int iteracionesMaximas, double tolerancia) {
        int n = A.length;
        double[] x = new double[n];
        double[] xAnterior = new double[n];
        Arrays.fill(xAnterior, 0); 
  for (int k = 0; k < iteracionesMaximas; k++) {
            for (int i = 0; i < n; i++) {
                double suma = b[i];
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma -= A[i][j] * xAnterior[j];
                    }
                }
                x[i] = suma / A[i][i];
            }