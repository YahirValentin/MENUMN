package hermite;
import java.util.ArrayList;
import java.util.List;

public class Hermite {

    public static class Punto {
        double x;
        double y;
        double dy;
        
public Punto(double x, double y, double dy){
    this.x = x;
    this.y = y;
    this.dy = dy;
    }
}
    public static double interpolacionhermite(List<Punto> puntos, double valor){
        double resultado = 0;
        for (int i = 0; i < puntos.size(); i++) {
            double termino = puntos.get(i).y;
            double producto = 1;
            for (int j = 0; j < puntos.size(); j++) {
                if (i!=j) {
                    producto *= (valor - puntos.get(j).x);
                    termino *= (valor - puntos.get(j).x)/ (puntos.get(i).x - puntos.get(j).x);
                    
                }
            }
            resultado += termino + producto * puntos.get(i).dy;
        }
        return resultado;
    }
    }