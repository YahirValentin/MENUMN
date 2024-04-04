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
              double normaDiferencia = normaDiferencia(x, xAnterior);
            if (normaDiferencia < tolerancia) {
                System.out.println("Convergencia alcanzada en la iteracion " + (k + 1));
                return x;
            }

          
            System.arraycopy(x, 0, xAnterior, 0, n);
        }

        System.out.println("Numero maximo de iteraciones alcanzado (" + iteracionesMaximas + ")");
        return x;
    }
    
    public static double normaDiferencia(double[] x, double[] y) {
        double sumaCuadrados = 0;
        for (int i = 0; i < x.length; i++) {
            sumaCuadrados += Math.pow(x[i] - y[i], 2);
        }
        return Math.sqrt(sumaCuadrados);
    }
}
