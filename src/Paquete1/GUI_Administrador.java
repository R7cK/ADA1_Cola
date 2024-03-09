package Paquete1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Queue;

public class GUI_Administrador extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultTableModel tablaApartados;
    private JTable tabla;
    private int precio = 100;
    private GUI_Clientes clientesGUI; // Referencia a la GUI de clientes
    private JButton btnAadirCantidaes;

    public GUI_Administrador(GUI_Clientes clientesGUI) {
        this.clientesGUI = clientesGUI; // Asignar la referencia a la GUI de clientes

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 877, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        tabla = new JTable(tablaApartados) {
            public boolean isCellEditable(int fila, int column){  
                return false;  
            }
        };
        tabla.setBounds(27, 75, 483, 492);
        tabla.setFont(new Font("Inter", Font.PLAIN, 14));
        tabla.setBackground(new Color(192, 192, 192));

        tablaApartados = new DefaultTableModel();
        tabla.setModel(tablaApartados);
        tablaApartados.addColumn("Ticket");
        tablaApartados.addColumn("Nombre");
        tablaApartados.addColumn("Cantidad");
        tablaApartados.addColumn("Total a pagar ($)");

        // Agregamos una fila inicial de encabezados con valores predeterminados
        tablaApartados.addRow(new Object[]{"Ticket", "Nombre", "Cantidad", "Total a pagar ($)"});
        contentPane.setLayout(null);
        contentPane.add(tabla);

        // Botón para mostrar la GUI de Clientes
        JButton btnMostrarClientes = new JButton("Mostrar Clientes");
        btnMostrarClientes.setBounds(600, 451, 250, 43);
        btnMostrarClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ocultar la GUI de Administrador y mostrar la de Clientes
                setVisible(false);
                clientesGUI.setVisible(true);
            }
        });
        contentPane.add(btnMostrarClientes);
        
        btnAadirCantidaes = new JButton("A\u00F1adir Cantidaes");
        btnAadirCantidaes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int AddCant = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas cantidades deseas añadir?"));
        		clientesGUI.actualizarcantidad(AddCant);
        	}
        });
        btnAadirCantidaes.setBounds(588, 387, 250, 43);
        contentPane.add(btnAadirCantidaes);
    }

    // Método para actualizar la tabla con los datos de la cola
    public void actualizarTabla(Queue<Datos_Juego> cola) {
        // Limpiamos la tabla antes de actualizarla
        tablaApartados.setRowCount(1);

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
