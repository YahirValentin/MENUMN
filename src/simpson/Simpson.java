package simpson;
import java.util.function.DoubleUnaryOperator;

public class Simpson {
    public static double simpsonCompuesto(DoubleUnaryOperator func, double a, double b, int n) {
        double h = (b - a) / n;