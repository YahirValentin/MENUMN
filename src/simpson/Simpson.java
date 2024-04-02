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