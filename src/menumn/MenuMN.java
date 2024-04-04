/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menumn;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.function.DoubleUnaryOperator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

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
        double integral = Uno.simpsonCompuesto(func, a, b, n);
        mostrarResultado("Resultado", "La integral de sin(x) de 0 a PI es aproximadamente: " + integral);
    }
    }

    }
    
}
