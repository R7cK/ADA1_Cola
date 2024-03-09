package Paquete1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.util.Queue;

public class GUI_Administrador extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel tablaApartados = new DefaultTableModel();
    private JTable tabla;
    private int precio = 100;

    public GUI_Administrador(GUI_Clientes clientesGUI) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tabla = new JTable(tablaApartados) {
            public boolean isCellEditable(int fila, int column){  
                return false;  
            }
        };
        tabla.setFont(new Font("Inter", Font.PLAIN, 14));
        tabla.setBackground(new Color(192, 192, 192));

        tablaApartados.addColumn("Ticket");
        tablaApartados.addColumn("Nombre");
        tablaApartados.addColumn("Cantidad");
        tablaApartados.addColumn("Total a pagar ($)");

        // Agregamos una fila inicial de encabezados con valores predeterminados
        tablaApartados.addRow(new Object[]{"Ticket", "Nombre", "Cantidad", "Total a pagar ($)"});

        tabla.setBounds(27, 75, 483, 492);
        contentPane.add(tabla);

        // Botón para mostrar la GUI de Clientes
        JButton btnMostrarClientes = new JButton("Mostrar Clientes");
        btnMostrarClientes.addActionListener(e -> {
        	setVisible(false);
        	clientesGUI.setVisible(true);
        });
        btnMostrarClientes.setBounds(600, 451, 250, 43);
        contentPane.add(btnMostrarClientes);
    }

    // Método para actualizar la tabla con los datos de la cola
    public void actualizarTabla(Queue<Datos_Juego> cola) {
        // Limpiamos la tabla antes de actualizarla
       

        // Iteramos sobre la cola y agregamos los datos
        for (Datos_Juego juego : cola) {
            int totalAPagar = juego.getcantidad() * precio; // Calcular el total a pagar
            tablaApartados.addRow(new Object[]{
                juego.getTicket(),
                juego.getnombre(),
                juego.getcantidad(),
                totalAPagar
            });
        }
    }
}
