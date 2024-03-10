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
                 int ticket1 = ticket; // Obtener el número de ticket para la compra
                 String Nombre = JOptionPane.showInputDialog("¿Cuál es su nombre?"); 
                 int Cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos vas a comprar?"));

                 // Verificar si la cantidad solicitada está disponible
                 if (Cantidad > disponible) {
                     JOptionPane.showMessageDialog(null, "No hay suficientes unidades disponibles.");
                 } else {
                     Datos_Juego juego = new Datos_Juego(Nombre, Cantidad, ticket1); // Crear un nuevo juego con los datos proporcionados
                     cola.offer(juego); // Agregar el juego a la cola de productos apartados
                     admin.actualizarTabla(cola); // Actualizar la tabla en la interfaz de administrador con los productos apartados
                     ticket++; // Incrementar el número de ticket para la próxima compra
                     vendido += Cantidad; // Incrementar la cantidad vendida de productos
                     disponible -= Cantidad; // Reducir la cantidad disponible de productos
                     actualizarLabels(disponible, vendido); // Actualizar los labels de cantidad disponible y vendida en la interfaz de administrador
                 }
            }
        });
        btnComprar.setBounds(671, 252, 169, 43); // Establecer la posición y el tamaño del botón
        contentPane.add(btnComprar); // Agregar el botón al panel principal

        JButton btn_Carrito = new JButton("Gui Admin"); // Crear un botón para abrir la interfaz de administrador
        btn_Carrito.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.setVisible(true); // Hacer visible la interfaz de administrador al hacer clic en el botón
            }
        });
        btn_Carrito.setBounds(671, 306, 169, 43); // Establecer la posición y el tamaño del botón
        contentPane.add(btn_Carrito); // Agregar el botón al panel principal
    }

    // Método para actualizar los labels de cantidad disponible y vendida en la interfaz de administrador.
     
    public void actualizarLabels(int disponible, int vendido) {
        admin.actualizarLabels(disponible, vendido); // Llamar al método en la interfaz de administrador para actualizar los labels
    }

    //Método para añadir una cantidad específica a la cantidad disponible de productos.
    public void actualizarcantidad(int cantidad) {
        disponible += cantidad; // Añadir la cantidad especificada a la cantidad disponible de productos
    }
    //Metodos para obtener cantidades
    public int getDisponible() {
        return disponible; // Devolver la cantidad disponible de productos
    }

    public int getVendido() {
        return vendido; // Devolver la cantidad vendida de productos
    }
}
