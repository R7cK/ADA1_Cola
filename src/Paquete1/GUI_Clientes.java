package Paquete1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		JLabel A1 = new JLabel("Imagenes");
		A1.setHorizontalAlignment(SwingConstants.CENTER);
		A1.setBounds(10, 11, 150, 130);
		contentPane.add(A1);
		
		Text1 = new JTextField();
		Text1.setBounds(214, 77, 141, 20);
		contentPane.add(Text1);
		Text1.setColumns(10);
		
		// Los botones de Anterior y Siguiente funcionaran solamente para intercambiar imagenes
		
		JButton Siguiente = new JButton("<<");
		Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Siguiente.setBackground(new Color(222, 184, 135));
		Siguiente.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Siguiente.setBounds(10, 150, 70, 23);
		contentPane.add(Siguiente);
		
		JButton Boton2 = new JButton("UU");
		Boton2.setBounds(71, 194, 89, 23);
		contentPane.add(Boton2);
		
		JLabel A2 = new JLabel("\"Nombre de Juego\"");
		A2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		A2.setHorizontalAlignment(SwingConstants.CENTER);
		A2.setBounds(166, 11, 235, 40);
		contentPane.add(A2);
		
		JButton Anterior = new JButton(">>");
		Anterior.setBackground(new Color(222, 184, 135));
		Anterior.setForeground(Color.BLACK);
		Anterior.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Anterior.setBounds(90, 150, 70, 23);
		contentPane.add(Anterior);
		
		JLabel A3 = new JLabel("FONDO");
		A3.setHorizontalAlignment(SwingConstants.CENTER);
		A3.setBounds(0, 0, 434, 261);
		contentPane.add(A3);
	}
}
