
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author migue
 */
public class Panel_TresEnRaya extends JPanel{
    private JButton[][] casillas;
    private char jugador;
    
    public Panel_TresEnRaya(){
        jugador = 'X';
        casillas = new JButton[3][3];
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j] = new JButton();
                casillas[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
                casillas[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton botonPresionado = (JButton) e.getSource();
                        hacerMovimiento(botonPresionado);
                    }
                });
                add(casillas[i][j]);
            }
        }
    }
    private void hacerMovimiento(JButton boton) {
        if (boton.getText().equals("")) {
            boton.setText(String.valueOf(jugadorActual));
            if (verificarGanador()) {
                JOptionPane.showMessageDialog(this, "¡El jugador " + jugadorActual + " ha ganado!");
                reiniciarJuego();
            } else if (verificarEmpate()) {
                JOptionPane.showMessageDialog(this, "¡Empate!");
                reiniciarJuego();
            } else {
                cambiarTurno();
            }
        }
    }
    
    private boolean verificarGanador() {
        // Lógica para verificar si hay un ganador
        return false; // Modificar según la lógica del juego
    }

    private boolean verificarEmpate() {
        // Lógica para verificar si hay un empate
        return false; // Modificar según la lógica del juego
    }

    private void cambiarTurno() {
        jugador = (jugador == 'X') ? 'O' : 'X';
    }

    private void reiniciarJuego() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casillas[i][j].setText("");
            }
        }
        jugador = 'X';
    }
}
