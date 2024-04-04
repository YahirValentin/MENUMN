/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menumn;

import euler.Euler;
import hermite.Hermite;
import jacobi.Jacobi;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import simpson.Simpson;

/**
 *
 * @author yahir
 */
public class MenuMN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("METODOS NUMERICOS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); 
         JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.decode("#d8bfd8")); 
        
        JButton botonUno = createButton("SIMPSON COMPUESTA", e -> ejecutarSimp());
        JButton botonDos = createButton("EULER", e -> ejecutarEuler());
        JButton botonTres = createButton("HERMMITE", e -> ejecutarHermite());
        JButton botonCuatro = createButton("JACOBI", e -> ejecutarJacobi());
       
        mainPanel.add(botonUno);
        mainPanel.add(Box.createVerticalStrut(10)); 
        mainPanel.add(botonDos);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(botonTres);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(botonCuatro);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        }
          
    private static JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.decode("#f7a8b8"));
        button.setForeground(Color.WHITE); 
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
        button.addActionListener(listener);
        return button;
    }
    
     public static void ejecutarSimp() {
        DoubleUnaryOperator func = x -> Math.sin(x);
        double a = 0.0;
        double b = Math.PI;
        int n = 100;
        double integral = Simpson.simpsonCompuesto(func, a, b, n);
        mostrarResultado("Resultado", "La integral de sin(x) de 0 a PI es aproximadamente: " + integral);
    }
      public static void ejecutarEuler() {
        double x0 = 0;
        double y0 = 1;
        double h = 0.1;
        double xf = 1;
        double[] y = Euler.euler(x0, y0, h, xf);
        mostrarResultado("Resultado", "Valores aproximados de y utilizando el metodo de Euler:\n" + Arrays.toString(y));
    }

    public static void ejecutarHermite() {
        List<Hermite.Punto> puntos = new ArrayList<>();
        puntos.add(new Hermite.Punto(0, 1, 2));
        puntos.add(new Hermite.Punto(1, 3, 4));
        puntos.add(new Hermite.Punto(2, 5, 6));
        double valorInterpolado = Hermite.interpolacionhermite(puntos, 1.5);
        mostrarResultado("Resultado", "El valor interpolado en x=1.5 es: " + valorInterpolado);
    }

    public static void ejecutarJacobi() {
        double[][] A = {{4, 1, -1}, {2, 7, 1}, {1, 2, 5}};
        double[] b = {3, 19, 2};
        int iteracionesMaximas = 100;
        double tolerancia = 1e-6;
        double[] solucion = Jacobi.jacobi(A, b, iteracionesMaximas, tolerancia);
        mostrarResultado("Resultado", "Solucion:\n" + Arrays.toString(solucion));
    }

    public static void mostrarResultado(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
    

    
    

