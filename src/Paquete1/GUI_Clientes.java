package Paquete1;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
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
    private GUI_Administrador admin; 
    private int ticket = 1; //contador para el numero de tickets
    public Queue<Datos_Juego> cola = new LinkedList<>(); // Cola de productos apartados
    private int disponible = 100; // Cantidad disponible de productos
    private int vendido = 0; // Cantidad vendida de productos

   
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
        admin = new GUI_Administrador(this); // Inicializar la interfaz de administrador
        admin.setVisible(false); // Ocultar la interfaz de administrador al inicio

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setBounds(100, 100, 877, 626); 
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane); 
        contentPane.setLayout(null); 

        JButton btnComprar = new JButton("Apartar"); 
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 int ticket1 = ticket; // Obtener el n�mero de ticket para la compra
                 String Nombre = JOptionPane.showInputDialog("�Cu�l es su nombre?"); 
                 int Cantidad = Integer.parseInt(JOptionPane.showInputDialog("�Cu�ntos vas a comprar?"));

                 // Verificar si la cantidad solicitada est� disponible
                 if (Cantidad > disponible) {
                     JOptionPane.showMessageDialog(null, "No hay suficientes unidades disponibles.");
                 } else {
                     Datos_Juego juego = new Datos_Juego(Nombre, Cantidad, ticket1); // Crear un nuevo juego con los datos proporcionados
                     cola.offer(juego); // Agregar el juego a la cola de productos apartados
                     admin.actualizarTabla(cola); // Actualizar la tabla en la interfaz de administrador con los productos apartados
                     ticket++; // Incrementar el n�mero de ticket para la pr�xima compra
                     vendido += Cantidad; // Incrementar la cantidad vendida de productos
                     disponible -= Cantidad; // Reducir la cantidad disponible de productos
                     actualizarLabels(disponible, vendido); // Actualizar los labels de cantidad disponible y vendida en la interfaz de administrador
                 }
            }
        });
        btnComprar.setBounds(671, 252, 169, 43); // Establecer la posici�n y el tama�o del bot�n
        contentPane.add(btnComprar); // Agregar el bot�n al panel principal

        JButton btn_Carrito = new JButton("Gui Admin"); // Crear un bot�n para abrir la interfaz de administrador
        btn_Carrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.setVisible(true); // Hacer visible la interfaz de administrador al hacer clic en el bot�n
            }
        });
        btn_Carrito.setBounds(671, 306, 169, 43); // Establecer la posici�n y el tama�o del bot�n
        contentPane.add(btn_Carrito); // Agregar el bot�n al panel principal
    }

    // M�todo para actualizar los labels de cantidad disponible y vendida en la interfaz de administrador.
     
    public void actualizarLabels(int disponible, int vendido) {
        admin.actualizarLabels(disponible, vendido); // Llamar al m�todo en la interfaz de administrador para actualizar los labels
    }

    //M�todo para a�adir una cantidad espec�fica a la cantidad disponible de productos.
    public void actualizarcantidad(int cantidad) {
        disponible += cantidad; // A�adir la cantidad especificada a la cantidad disponible de productos
    }
    //Metodos para obtener cantidades
    public int getDisponible() {
        return disponible; // Devolver la cantidad disponible de productos
    }

    public int getVendido() {
        return vendido; // Devolver la cantidad vendida de productos
    }
}
