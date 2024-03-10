package Paquete1;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_Administrador extends JFrame {
    // Variables de instancia
    private static final long serialVersionUID = 1L; 
    private JPanel contentPane;
    private DefaultTableModel tablaApartados; 
    private JTable tabla;
    private int precio = 100; // Precio unitario de los productos
    private GUI_Clientes clientesGUI; // Referencia a la interfaz de clientes
    private JButton btnAadirCantidades;
    private JButton btnAtender;
    private JLabel lblDisponible; 
    private JLabel lblVendido;
    private int disponible; 
    private int vendido; 
    
    public GUI_Administrador(GUI_Clientes clientesGUI) {
        this.clientesGUI = clientesGUI; // Asignar la referencia a la interfaz de clientes
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        tabla = new JTable(tablaApartados) { // Crear una tabla para mostrar los productos apartados
            public boolean isCellEditable(int fila, int column){ // Deshabilitar la edición de celdas
                return false; 
            }
        };
        tabla.setBounds(27, 75, 483, 492); 
        tabla.setFont(new Font("Inter", Font.PLAIN, 14));
        tabla.setBackground(new Color(192, 192, 192)); 
        tablaApartados = new DefaultTableModel(); // Crear un nuevo modelo de tabla
        tabla.setModel(tablaApartados); // Asignar el modelo de tabla a la tabla
        tablaApartados.addColumn("Ticket"); // Agregar columnas a la tabla
        tablaApartados.addColumn("Nombre");
        tablaApartados.addColumn("Cantidad");
        tablaApartados.addColumn("Total a pagar ($)");
        tablaApartados.addRow(new Object[]{"Ticket", "Nombre", "Cantidad", "Total a pagar ($)"}); // Agregar una fila de encabezados a la tabla
        contentPane.setLayout(null);
        contentPane.add(tabla); 

        JButton btnMostrarClientes = new JButton("Mostrar Clientes");
        btnMostrarClientes.setBounds(569, 444, 250, 43); 
        btnMostrarClientes.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Ocultar la interfaz de administrador al hacer clic en el botón
                clientesGUI.setVisible(true); // Mostrar la interfaz de clientes
            }
        });
        contentPane.add(btnMostrarClientes); 

        btnAadirCantidades = new JButton("Añadir Cantidades"); 
        btnAadirCantidades.setBounds(569, 387, 250, 43); 
        btnAadirCantidades.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                int AddCant = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas cantidades deseas añadir?")); // Solicitar la cantidad a añadir
                clientesGUI.actualizarcantidad(AddCant); // Llamar al método en la interfaz de clientes para añadir cantidades
                actualizarDisponible(AddCant); // Actualizar la cantidad disponible en la interfaz de administrador
            }
        });
        contentPane.add(btnAadirCantidades);
        
        // Obtener las cantidades disponibles y vendidas desde la GUI de Clientes
        disponible = clientesGUI.getDisponible(); 
        vendido = clientesGUI.getVendido();
        
        //Labels para mostrar las cantidades disponibles y vendidas
        lblDisponible = new JLabel("Cantidad Disponible: " + disponible); 
        lblDisponible.setBounds(672, 137, 150, 30);
        contentPane.add(lblDisponible); 
        
        lblVendido = new JLabel("Cantidad Vendida: " + vendido); 
        lblVendido.setBounds(672, 188, 150, 30); 
        contentPane.add(lblVendido); 

        JButton btnAtender = new JButton("Atender");
        btnAtender.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  atenderPedido();
        	}
        });
        btnAtender.setBounds(569, 330, 250, 43);
        contentPane.add(btnAtender);
    }
    public void actualizarTabla(Queue<Datos_Juego> cola) {
        // Limpiamos la tabla antes de actualizarla
        tablaApartados.setRowCount(1);

        // Iteramos sobre la cola y agregamos los datos
        for (Datos_Juego juego : cola) {
            int totalAPagar = juego.getcantidad() * precio; // Calcular el total a pagar
            tablaApartados.addRow(new Object[]{
                juego.getticket(),
                juego.getnombre(),
                juego.getcantidad(),
                totalAPagar
            });
        }
 
    }
   //Metodo para actualizar los labels de cantidad vendida y disponible
    public void actualizarLabels(int disponible, int vendido) {
        this.disponible = disponible; // Actualizar la cantidad disponible
        this.vendido = vendido; // Actualizar la cantidad vendida
        lblDisponible.setText("Cantidad Disponible: " + disponible); 
        lblVendido.setText("Cantidad Vendida: " + vendido); 
    }
    
     //Método para actualizar la cantidad disponible de productos
    public void actualizarDisponible(int cantidadAñadida) {
        disponible += cantidadAñadida; // Añadir la cantidad especificada
        lblDisponible.setText("Cantidad Disponible: " + disponible); // Actualizar el texto del label de cantidad disponible
    }
    // Método para atender el siguiente pedido
    private void atenderPedido() {
        // Verificar si hay pedidos en la cola
        if (!clientesGUI.cola.isEmpty()) {
            // Obtener el primer pedido de la cola
            Datos_Juego pedido = clientesGUI.cola.poll();
            // Actualizar la tabla con los pedidos restantes
            actualizarTabla(clientesGUI.cola);
            // Actualizar las cantidades
            vendido += pedido.getcantidad();
            disponible -= pedido.getcantidad();
            // Actualizar los labels
            actualizarLabels(disponible, vendido);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos pendientes por atender.");
        }
    }
}