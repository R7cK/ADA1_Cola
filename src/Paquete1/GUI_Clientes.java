package Paquete1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class GUI_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Text1;
	private int Q;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GUI_Clientes() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel A1 = new JLabel("PRUEBA GIT");
		A1.setBounds(10, 11, 116, 14);
		contentPane.add(A1);
		
		Text1 = new JTextField();
		Text1.setBounds(136, 8, 141, 20);
		contentPane.add(Text1);
		Text1.setColumns(10);
		
		JButton Boton1 = new JButton("Nuevo Boton");
		Boton1.setBounds(58, 40, 116, 23);
		contentPane.add(Boton1);
		
		JButton Boton2 = new JButton("UU");
		Boton2.setBounds(85, 76, 89, 23);
		contentPane.add(Boton2);
	}
}
