package Paquete1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbl_Logo;
	private int i = 0;
	Datos_Juego Juego1 = new Datos_Juego();
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

		JLabel lbl_GameImg = new JLabel("");
		lbl_GameImg.setIcon(new ImageIcon("Icons//IMG1.jpg"));
		lbl_GameImg.setBounds(20, 79, 590, 308);
		contentPane.add(lbl_GameImg);		
		
		JLabel lbl_ProdDisp = new JLabel("Numero de copias disponibles:");
		lbl_ProdDisp.setBounds(20, 386, 275, 54);
		contentPane.add(lbl_ProdDisp);
		
		JButton btnPreordena = new JButton("Preordenar");
		btnPreordena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String Nombre = JOptionPane.showInputDialog("Ingresa el nombre");
			double Precio = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el precio"));
			int CantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Ingresa las copias disponibles"));
			Datos_Juego Juego1 = new Datos_Juego(Nombre,CantidadDisponible,Precio);			
			}
		});
		btnPreordena.setBounds(20, 451, 275, 43);
		contentPane.add(btnPreordena);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(671, 360, 169, 43);
		contentPane.add(btnCancelar);
		
		JButton btnComprar = new JButton("Conseguir");
		btnComprar.setBounds(671, 252, 169, 43);
		contentPane.add(btnComprar);
		
		JLabel lbl_GameName = new JLabel("Grand Theft Auto VI");
		lbl_GameName.setFont(new Font("Franklin Gothic Book", Font.BOLD, 46));
		lbl_GameName.setBounds(20, 11, 422, 57);
		contentPane.add(lbl_GameName);
		
		lbl_Logo = new JLabel("");
		lbl_Logo.setIcon(new ImageIcon("C:\\Users\\ferna\\Desktop\\4to Semestre\\POO2\\Imagenes TrabajoGIT\\LogoJuego.png"));
		lbl_Logo.setBounds(633, 79, 207, 145);
		contentPane.add(lbl_Logo);
		
		JButton btn_Carrito = new JButton("A\u00F1adir al carrito");
		btn_Carrito.setBounds(671, 306, 169, 43);
		contentPane.add(btn_Carrito);
		
		JButton btn_Anterior = new JButton("<<");
		btn_Anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (i==5) {lbl_GameImg.setIcon(new ImageIcon("Icons//IMG2.jpg"));} 
			else if (i==4){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG3.jpg"));}
			else if (i==3){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG4.png"));}
			else if (i==2){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG5.jpg"));}
			else if (i==0){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG1.jpg"));}
			else if (i==1){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG2.jpg"));}
			i--;	
			}
		});
		btn_Anterior.setBackground(new Color(255, 0, 255));
		btn_Anterior.setForeground(new Color(0, 0, 0));
		btn_Anterior.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btn_Anterior.setBounds(478, 398, 61, 23);
		contentPane.add(btn_Anterior);
		
		JButton btn_Siguiente = new JButton(">>");
		btn_Siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (i==0) {lbl_GameImg.setIcon(new ImageIcon("Icons//IMG2.jpg"));} 
			else if (i==1){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG3.jpg"));}
			else if (i==2){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG4.png"));}
			else if (i==3){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG5.jpg"));}
			else if (i==4){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG1.jpg"));}
			else if (i==5){lbl_GameImg.setIcon(new ImageIcon("Icons//IMG2.jpg")); 			
			i = 0;}
			i++;
			}
		});
		btn_Siguiente.setBackground(new Color(255, 0, 255));
		btn_Siguiente.setForeground(new Color(0, 0, 0));
		btn_Siguiente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btn_Siguiente.setBounds(549, 398, 61, 23);
		contentPane.add(btn_Siguiente);
		
	}
}
