package Paquete1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class GUI_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lbl_Logo;
    private int i = 0;
    private int ticket = 1;
    private int disponible = 100;
    private int vendido;
    private GUI_Administrador admin;
    Datos_Juego juego = new Datos_Juego();
    public Queue<Datos_Juego> cola = new LinkedList<Datos_Juego>();

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

        GUI_Administrador admin = new GUI_Administrador(this);
        admin.setVisible(false);

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
        lbl_ProdDisp.setForeground(new Color(255, 255, 255));
        lbl_ProdDisp.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbl_ProdDisp.setBounds(20, 386, 275, 43);
        contentPane.add(lbl_ProdDisp);

        JButton btnPreordena = new JButton("Preordenar");
        btnPreordena.setForeground(new Color(0, 0, 0));
        btnPreordena.setFont(new Font("Times New Roman", Font.BOLD, 26));
        btnPreordena.setBackground(new Color(255, 255, 0));
        btnPreordena.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 int Ticket = ticket;
                 String Nombre = JOptionPane.showInputDialog("Ingresa el nombre del responsable");
                 int Cantidad = Integer.parseInt(JOptionPane.showInputDialog("�Cu�ntas copias quieres apartar?"));

                 if (Cantidad > disponible) {
                     JOptionPane.showMessageDialog(null, "No hay suficientes unidades disponibles.");
                 } else if(Cantidad <= disponible){
                     juego = new Datos_Juego(Ticket, Nombre, Cantidad);
                     cola.offer(juego);
                     admin.actualizarTabla(cola);
                     ticket++;
                     vendido += Cantidad;
                     disponible -= Cantidad;
                     JOptionPane.showMessageDialog(null, "Su producto ha sido apartado");
                 }
            }
        });
        btnPreordena.setBounds(20, 440, 275, 43);
        contentPane.add(btnPreordena);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cola.remove(juego);
        		admin.actualizarTabla(cola);
        	}
        });
        btnCancelar.setBackground(new Color(250, 128, 114));
        btnCancelar.setForeground(new Color(0, 0, 0));
        btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnCancelar.setBounds(633, 360, 207, 43);
        contentPane.add(btnCancelar);

        JButton btnConseguir = new JButton("Conseguir");
        btnConseguir.setBackground(new Color(240, 230, 140));
        btnConseguir.setForeground(new Color(0, 0, 0));
        btnConseguir.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnConseguir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int Buscar = Integer.parseInt(JOptionPane.showInputDialog("Dame el numero de ticker"));
				Datos_Juego resultado = buscarTicket(cola, Buscar);
		        if (resultado != null) {
		            JOptionPane.showMessageDialog(null, "Ticket encontrado: \nNombre: " + resultado.getnombre() + "\nCantidad: " + resultado.getcantidad());
		        } else {
		            JOptionPane.showMessageDialog(null, "Ticket no encontrado.");
		        }
		    }

		    public static Datos_Juego buscarTicket(Queue<Datos_Juego> cola, int Buscar) {
		        for (Datos_Juego juego : cola) {
		            if (juego.getticket() == Buscar) {
		                return juego;
		            }
		        }
		        return null;
             
                }
        
        });
        btnConseguir.setBounds(633, 252, 207, 43);
        contentPane.add(btnConseguir);

        JLabel lbl_GameName = new JLabel("");
        lbl_GameName.setIcon(new ImageIcon("Icons//GTA.png"));
        lbl_GameName.setForeground(new Color(0, 0, 0));
        lbl_GameName.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_GameName.setFont(new Font("Franklin Gothic Book", Font.BOLD, 56));
        lbl_GameName.setBounds(20, 13, 590, 57);
        contentPane.add(lbl_GameName);

        lbl_Logo = new JLabel("");
        lbl_Logo.setIcon(new ImageIcon("Icons//LogoJuego.png"));
        lbl_Logo.setBounds(633, 79, 207, 145);
        contentPane.add(lbl_Logo);

        JButton btn_Carrito = new JButton("A�adir al carrito");
        btn_Carrito.setBackground(new Color(255, 192, 203));
        btn_Carrito.setForeground(new Color(0, 0, 0));
        btn_Carrito.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btn_Carrito.setBounds(633, 306, 207, 43);
        contentPane.add(btn_Carrito);

        JButton btn_Siguiente = new JButton(">>");
        btn_Siguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {       	
            	 
                if (i == 0) {
                	i++;
                    lbl_GameImg.setIcon(new ImageIcon("Icons//IMG2.jpg"));
                } else if (i == 1) {
                	i++;
                    lbl_GameImg.setIcon(new ImageIcon("Icons//IMG3.jpg"));
                } else if (i == 2) {
                	i++;
                    lbl_GameImg.setIcon(new ImageIcon("Icons//IMG4.png"));
                } else if (i == 3) {
                	i++;
                    lbl_GameImg.setIcon(new ImageIcon("Icons//IMG5.jpg"));
                } else if (i == 4) {
                    lbl_GameImg.setIcon(new ImageIcon("Icons//IMG1.jpg"));
                    i = 0;
                } 
            }
        });
        btn_Siguiente.setBackground(new Color(255, 0, 255));
        btn_Siguiente.setForeground(new Color(0, 0, 0));
        btn_Siguiente.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btn_Siguiente.setBounds(549, 398, 61, 23);
        contentPane.add(btn_Siguiente);

        JButton botonGUI_Administrador = new JButton("GUI_Administrador");
        botonGUI_Administrador.setBackground(new Color(222, 184, 135));
        botonGUI_Administrador.setForeground(new Color(0, 0, 0));
        botonGUI_Administrador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin.setVisible(true);
                setVisible(false);
            }
        });
        botonGUI_Administrador.setFont(new Font("Tahoma", Font.ITALIC, 13));
        botonGUI_Administrador.setBounds(671, 439, 169, 23);
        contentPane.add(botonGUI_Administrador);

        JLabel lblNewLabel = new JLabel("<html> La famosa saga de videojuego \"Grand Theft Auto\" regresa con Lucia y Jason. Una pareja que viv�a tranquilamente la Ciudad de Vice City. Pero por diversas circunstancias se ven envueltos en los problemas relacionados a la ciudad. A tal punto que sus vidas corren peligro y deber�n cuidarse las espaldas hasta encontrar una soluci�n. <br> Re�ne lo necesario y asegurate de vivir un nuevo viaje con rostros del pasado tratando de apoyar a nuestros protagonistas.");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setBounds(305, 440, 336, 136);
        contentPane.add(lblNewLabel);

        JLabel lblEstrellas = new JLabel("\r\n");
        lblEstrellas.setIcon(new ImageIcon("Icons//Estrellas.png"));
        lblEstrellas.setBounds(20, 494, 275, 57);
        contentPane.add(lblEstrellas);

        JLabel lblSocial = new JLabel("\r\n");
        lblSocial.setIcon(new ImageIcon("Icons//LogoSocial.png"));
        lblSocial.setBounds(633, 13, 207, 57);
        contentPane.add(lblSocial);

        JLabel lblFondoGUI = new JLabel("");
        lblFondoGUI.setBackground(new Color(238, 130, 238));
        lblFondoGUI.setIcon(new ImageIcon("Icons//IMG8.png"));
        lblFondoGUI.setHorizontalAlignment(SwingConstants.CENTER);
        lblFondoGUI.setBounds(0, 0, 861, 587);
        contentPane.add(lblFondoGUI);
        
    }

    
    public void actualizarcantidad(int cantidad) {
        disponible += cantidad;
    }

    public int getDisponible() {
        return disponible;
    }

    public int getVendido() {
        return vendido;
    }
}