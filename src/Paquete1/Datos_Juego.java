package Paquete1;

public class Datos_Juego {
	
	private String nombre;
	private int cantDisponible;
	private double precio;
	
	public Datos_Juego(String nombre, int cantDisponible, double precio) {
		this.nombre = nombre;
		this.cantDisponible = cantDisponible;
		this.precio = precio;
	}
	Datos_Juego(){}
	
	public Datos_Juego(int ticket, String nombre2, int cantidad) {
		// TODO Auto-generated constructor stub
	}
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
	public String getcantidad() {
		// TODO Auto-generated method stub
		return null;
	}
	public int getticket() {
		// TODO Auto-generated method stub
		return 0;
	}

}
