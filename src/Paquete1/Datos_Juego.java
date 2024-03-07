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

}
