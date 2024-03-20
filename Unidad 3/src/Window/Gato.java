package Window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Gato extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private boolean turno = true;

    // Botones del juego
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gato frame = new Gato();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Gato() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 3, 0, 0));

        //Ajusté la creacion de botones 
        btn1 = new JButton(" ");
        btn2 = new JButton(" ");
        btn3 = new JButton(" ");
        btn4 = new JButton(" ");
        btn5 = new JButton(" ");
        btn6 = new JButton(" ");
        btn7 = new JButton(" ");
        btn8 = new JButton(" ");
        btn9 = new JButton(" ");

        
        contentPane.add(btn1);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        contentPane.add(btn5);
        contentPane.add(btn6);
        contentPane.add(btn7);
        contentPane.add(btn8);
        contentPane.add(btn9);

       
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn1);
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn2);
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn3);
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn4);
            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn5);
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn6);
            }
        });
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn7);
            }
        });
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn8);
            }
        });
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jugar(btn9);
            }
        });
    }

    // Asignamos un valor a un boton al ser presionado
    private void jugar(JButton btn) {
        if (btn.getText().equals(" ")) {
            if (turno) 
            {
                btn.setText("X");
            } 
            else 
            {
                btn.setText("O");
            }
            
            turno = !turno;
            
            if (ganador()) 
            {
                JOptionPane.showMessageDialog(null, "¡" + ((turno) ? "Gato" : "Ratón") + " gana!");
                reiniciarJuego();
            } 
            else if (empate()) 
            {
                JOptionPane.showMessageDialog(null, "Empate");
                reiniciarJuego();
            }
        }
    }

    // Verificar si hay un ganador en x fila, x columna o x diagonal
    
    private boolean ganador() {
    	
        // Verificar filas
        if (comprobarGanador(btn1, btn2, btn3))
            return true;
        if (comprobarGanador(btn4, btn5, btn6))
            return true;
        if (comprobarGanador(btn7, btn8, btn9))
            return true;
        
        // Verificar columnas
        if (comprobarGanador(btn1, btn4, btn7))
            return true;
        if (comprobarGanador(btn2, btn5, btn8))
            return true;
        if (comprobarGanador(btn3, btn6, btn9))
            return true;
        
        // Verificar diagonales
        if (comprobarGanador(btn1, btn5, btn9))
            return true;
        if (comprobarGanador(btn3, btn5, btn7))
            return true;

        return false;
    }

    // Método para comprobar si hay un ganador en una línea
    
    private boolean comprobarGanador(JButton b1, JButton b2, JButton b3) {
        return !b1.getText().equals(" ") && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText());
    }

    // Verificar si hay empate
    
    private boolean empate() {
        return !btn1.getText().equals(" ") && !btn2.getText().equals(" ") && !btn3.getText().equals(" ") &&
                !btn4.getText().equals(" ") && !btn5.getText().equals(" ") && !btn6.getText().equals(" ") &&
                !btn7.getText().equals(" ") && !btn8.getText().equals(" ") && !btn9.getText().equals(" ");
    }

    // Método para reiniciar el juego
    private void reiniciarJuego() {
        btn1.setText(" ");
        btn2.setText(" ");
        btn3.setText(" ");
        btn4.setText(" ");
        btn5.setText(" ");
        btn6.setText(" ");
        btn7.setText(" ");
        btn8.setText(" ");
        btn9.setText(" ");
    }
}

    