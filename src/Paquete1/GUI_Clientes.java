package Paquete1;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class GUI_Clientes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lbl_Logo;
    private int ticket = 1;
    private Queue<Datos_Juego> cola = new LinkedList<>();
    private int disponible = 100;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI_Clientes frame = new GUI_Clientes();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI_Clientes() {
        GUI_Administrador admin = new GUI_Administrador(GUI_Clientes.this);
        admin.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnComprar = new JButton("Apartar");
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 int ticket1 = ticket;
                 String Nombre = JOptionPane.showInputDialog("¿Cuál es el nombre?");
                 int Cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos vas a comprar"));

                 if (Cantidad > disponible) {
                     JOptionPane.showMessageDialog(null, "No hay suficientes unidades disponibles.");
                 } else {
                     Datos_Juego juego = new Datos_Juego(Nombre, Cantidad, ticket1);
                     cola.offer(juego);
                     admin.actualizarTabla(cola);
                     ticket++;
                     disponible -= Cantidad;
                 }
            }
        });
        btnComprar.setBounds(671, 252, 169, 43);
        contentPane.add(btnComprar);

        JButton btn_Carrito = new JButton("Gui Admin");
        btn_Carrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.setVisible(true);
               
            }
        });
        btn_Carrito.setBounds(671, 306, 169, 43);
        contentPane.add(btn_Carrito);
    }
    
    public void actualizarcantidad(int NCantidad) {
		disponible += NCantidad;
	}

}
