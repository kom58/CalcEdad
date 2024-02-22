package edadcalcb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Aplicacion {

    private JPanel panPrincipal;
    private JPanel panSuperior;
    private JPanel panMedio;
    private JPanel panInferior;
    private JLabel txtTitulo;
    private JButton btnSalir;
    private JButton btnCalcular;
    private JLabel txtFechaActual;
    private JLabel titFechaActual;
    private JLabel titFechaNacimiento;
    private JTextField tflMesNac;
    private JTextField tflDiaNac;
    private JTextField tflAnoNac;
    private JLabel separador1;
    private JLabel separador2;
    private JPanel panResultado;
    private JLabel txtResultadoAnos;
    private JLabel txtResultadoMeses;
    private JLabel txtResultadoDias;
    private int diaA, mesA, anoA;

    public Aplicacion() {

        ponerFechaActual();

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                calcularEdad();
            }
        });
        tflAnoNac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                calcularEdad();
            }
        });
    }

    public void ponerFechaActual() {

        String FechaActual;
        Calendar ahora = Calendar.getInstance();
        diaA = ahora.get(Calendar.DAY_OF_MONTH);
        mesA = ahora.get(Calendar.MONTH) + 1;
        anoA = ahora.get(Calendar.YEAR);
        FechaActual = (diaA + "/" + mesA + "/" + anoA);
        txtFechaActual.setText(FechaActual);
    }

    public void calcularEdad() {

        CalculadoraEdad c = new CalculadoraEdad();

        String diaNStr = tflDiaNac.getText();
        String mesNStr = tflMesNac.getText();
        String anoNStr = tflAnoNac.getText();

        Comprobar cpb = new Comprobar();
        if (cpb.esFecha(diaNStr, mesNStr, anoNStr)) {

            int diaN = Integer.parseInt(diaNStr);
            int mesN = Integer.parseInt(mesNStr);
            int anoN = Integer.parseInt(anoNStr);

            String tusAnos, tusMeses, tusDias;

            int tuEdad = (c.ano(anoN, anoA, mesN, mesA, diaN, diaA));
            int tuRestoMeses = (c.mes(anoN, anoA, mesN, mesA, diaN, diaA) % 12);

            tusAnos = ("Tu edad es de " + tuEdad + " años y " + tuRestoMeses + " meses.");
            tusMeses = ("Ya has conocido " + c.mes(anoN, anoA, mesN, mesA, diaN, diaA) + " meses.");
            tusDias = ("Has visto amanecer " + c.dia(anoN, anoA, mesN, mesA, diaN, diaA) + " días.");

            txtResultadoAnos.setText(tusAnos);
            txtResultadoMeses.setText(tusMeses);
            txtResultadoDias.setText(tusDias);
        } else {
            txtResultadoAnos.setText(" ");
            txtResultadoMeses.setText("La fecha " + diaNStr + "/" + mesNStr + "/" + anoNStr + " no es válida.");
            txtResultadoDias.setText(" ");
        }
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame("Calculadora de edad");
        frame.setContentPane(new Aplicacion().panPrincipal);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

