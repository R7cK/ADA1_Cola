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
	private int Q;
	private JLabel lbl_Logo;
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
		setBounds(100, 100, 877, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_GameImg = new JLabel("Imagen Juego");
		lbl_GameImg.setBounds(20, 79, 590, 308);
		contentPane.add(lbl_GameImg);
		
		JLabel lbl_ProdDisp = new JLabel("Numero de copias disponibles");
		lbl_ProdDisp.setBounds(20, 386, 275, 54);
		contentPane.add(lbl_ProdDisp);
		
		JButton btnPreordena = new JButton("Preordenar");
		btnPreordena.setBounds(20, 451, 275, 43);
		contentPane.add(btnPreordena);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(671, 306, 169, 43);
		contentPane.add(btnCancelar);
		
		JButton btnComprar = new JButton("Conseguir");
		btnComprar.setBounds(671, 252, 169, 43);
		contentPane.add(btnComprar);
		
		JLabel lbl_GameName = new JLabel("Nombre del juego");
		lbl_GameName.setBounds(20, 11, 422, 43);
		contentPane.add(lbl_GameName);
		
		lbl_Logo = new JLabel("Logo del juego");
		lbl_Logo.setBounds(644, 40, 207, 145);
		contentPane.add(lbl_Logo);
	}
}
