package Paquete1;

public class Datos_Juego {
	
	private String nombre;
	private int ticket;
	private int cantidad;
	
	private Datos_Juego Siguiente;
	private Datos_Juego Inicio;
	private Datos_Juego Fin;
	
	private int cantDisponible;
	private double precio;
	
	// Para la GUI_Administrador
	public Datos_Juego(String nombre, int cantDisponible, double precio) {
		this.nombre = nombre;
		this.cantDisponible = cantDisponible;
		this.precio = precio;
	}
	// Para la GUI_Cliente
	public Datos_Juego(int ticket, String nombre, int cantidad) {
		this.ticket = ticket;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

	
	Datos_Juego(){}
	
	public String getnombre() {
		return nombre;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getcantDisponible() {
		return cantDisponible;
	}
	
	public void setnombre(int cantDisponible) {
		this.cantDisponible = cantDisponible;
	}
	
	public double getprecio() {
		return precio;
	}
	
	public void setprecio(double precio) {
		this.precio = precio;
	}

	public int getticket() {
		return ticket;
	} 
	
	public void setticket(int ticket) {
		this.ticket = ticket;
	}
	
	public int getcantidad() {
		return cantidad;
	}
	
	public void setcantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Datos_Juego getSiguiente() {
		return Siguiente;
	}
	
	public void setSiguiente(Datos_Juego Siguiente) {
		this.Siguiente = Siguiente;
	}
	
	// metodos
	
	public void Insertar(int ticket, String nombre, int cantidad) {
		Datos_Juego Juego1 = new Datos_Juego(ticket, nombre, cantidad);
		Juego1.setSiguiente(null);
		if (Inicio == null & Fin == null) {
			Inicio = Juego1;
			Fin = Juego1;
		}
		Fin.setSiguiente(Juego1);
		Fin = Fin.getSiguiente();
}
	 
}
