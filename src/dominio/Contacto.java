package dominio;
import java.io.Serializable;
/**
 * Clase Contacto
 * Responsable de leer y procesar las solicitudes de usuario
 * 
 * @author Paloma Centenera
 * @version 1.0
 */
public class Contacto implements Serializable{
	String nombre;
 	String telefono;
/**
 * Constructor de Contacto
 * @param n String con el nombre del contacto
 * @param t teléfono del contacto
 */
	public Contacto(String n, String t){
		nombre=n;
		telefono=t;
 	}
	public Contacto(String n){
		nombre=n;
		telefono="";
 	}
	public String toString(){
		return "Nombre: "+nombre+" Telefono: "+telefono;
	}
	public String getTelefono(){
		return telefono;
	}
	public boolean equals(Object obj){
		Contacto c=(Contacto)obj;
		return c.nombre.equals(nombre);
	}

}


