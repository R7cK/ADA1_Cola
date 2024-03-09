package Paquete1;

import java.util.Queue;

public class Cola {

	private String nombre;
	private int ticket;
	private int cantidad;
	
	public Cola(int ticket, String nombre, int cantidad) {
		this.ticket = ticket;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}


	public Cola () {}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
