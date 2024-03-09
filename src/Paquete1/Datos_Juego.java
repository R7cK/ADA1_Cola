package Paquete1;

public class Datos_Juego {
	
	private String nombre;
	private int cantidad;
	private int ticket;
	
	public Datos_Juego(String nombre, int cantidad, int ticket) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.ticket = ticket;
	}
	Datos_Juego(){}
	
	public String getnombre() {
		return nombre;
	}
	
	public void setnombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getcantidad() {
		return cantidad;
	}
	
	public void setcantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	private int precio;
}
