/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JLabel promedio, desviación, mayor, menor;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        setTitle("Notas");
        setSize(280, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        initComponents();
    }

    private void initComponents() {
        Container contenedor = getContentPane();
        contenedor.setLayout(null);

        // Inicializar y posicionar etiquetas y campos de texto para las notas
        campoNota1 = new JTextField();
        campoNota1.setBounds(105, 20, 135, 23);
        JLabel nota1 = new JLabel("Nota 1:");
        nota1.setBounds(20, 20, 135, 23);

        campoNota2 = new JTextField();
        campoNota2.setBounds(105, 50, 135, 23);
        JLabel nota2 = new JLabel("Nota 2:");
        nota2.setBounds(20, 50, 135, 23);

        campoNota3 = new JTextField();
        campoNota3.setBounds(105, 80, 135, 23);
        JLabel nota3 = new JLabel("Nota 3:");
        nota3.setBounds(20, 80, 135, 23);

        campoNota4 = new JTextField();
        campoNota4.setBounds(105, 110, 135, 23);
        JLabel nota4 = new JLabel("Nota 4:");
        nota4.setBounds(20, 110, 135, 23);

        campoNota5 = new JTextField();
        campoNota5.setBounds(105, 140, 135, 23);
        JLabel nota5 = new JLabel("Nota 5:");
        nota5.setBounds(20, 140, 135, 23);

        // Botón Calcular
        calcular = new JButton("Calcular");
        calcular.setBounds(20, 170, 100, 23);
        calcular.addActionListener(this);

        // Botón Limpiar
        limpiar = new JButton("Limpiar");
        limpiar.setBounds(125, 170, 80, 23);
        limpiar.addActionListener(this);

        // Etiquetas para resultados
        promedio = new JLabel("Promedio = ");
        promedio.setBounds(20, 210, 135, 23);
        desviación = new JLabel("Desviación = ");
        desviación.setBounds(20, 240, 200, 23);
        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(20, 270, 120, 23);
        menor = new JLabel("Nota menor = ");
        menor.setBounds(20, 300, 120, 23);

        // Añadir todos los componentes al contenedor
        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviación);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            Notas notas = new Notas();
            // Obtener y convertir las notas ingresadas
          try {   
            notas.listaNotas[0] = Double.parseDouble(campoNota1.getText());
            notas.listaNotas[1] = Double.parseDouble(campoNota2.getText());
            notas.listaNotas[2] = Double.parseDouble(campoNota3.getText());
            notas.listaNotas[3] = Double.parseDouble(campoNota4.getText());
            notas.listaNotas[4] = Double.parseDouble(campoNota5.getText());

            // Calcular y mostrar resultados
            double prom = notas.calcularPromedio();
            promedio.setText("Promedio = " + String.format("%.2f", prom));
            double desv = notas.calcularDesviación();
            desviación.setText("Desviación estándar = " + String.format("%.2f", desv));
            mayor.setText("Nota mayor = " + notas.calcularMayor());
            menor.setText("Nota menor = " + notas.calcularMenor());
            
          }catch(NumberFormatException e) {
                // Mostrar mensaje de alerta si se ingresa un valor no numérico
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos en todas las notas. ;)",
                        "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (evento.getSource() == limpiar) {
            campoNota1.setText("");
            campoNota2.setText("");
            campoNota3.setText("");
            campoNota4.setText("");
            campoNota5.setText("");
        }
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
