package simpson;
import java.util.function.DoubleUnaryOperator;

public class Simpson {
    public static double simpsonCompuesto(DoubleUnaryOperator func, double a, double b, int n) {
        double h = (b - a) / n;
        double sum = func.applyAsDouble(a) + func.applyAsDouble(b); 

        for (int i = 1; i < n; i += 2) {
            double x = a + i * h;
            sum += 4 * func.applyAsDouble(x);
        }
          for (int i = 2; i < n - 1; i += 2) {
            double x = a + i * h;
            sum += 2 * func.applyAsDouble(x); 
        }

        return (h / 3) * sum;
    }
}
