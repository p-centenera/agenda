package dominio;
import java.util.ArrayList;
import java.io.Serializable;
/**
 * Clase Libreta
 * Colección de contactos
 * 
 * @author Paloma Centenera
 * @version 1.0
 */
public class Libreta implements Serializable{
	private ArrayList<Contacto> lista;
/**
 * Constructor de Libreta
 * Crea una libreta con una lista vacía de contactos
 */
	public Libreta(){
		lista=new ArrayList<Contacto>();
	}
/**
 * Añade un contacto a la libreta
 * @param c Contacto contacto a añadir
 * @return la propia libreta, para encadenar operaciones
*/
	public Libreta add(Contacto c){
 		lista.add(c);
		return this;
	}
/**
 * Serializa la libreta a una cadena de caracteres
 * 
 */
	public String toString(){
		String cadena="";//cadena=new String();
		for ( Contacto c:lista)
			cadena+=c+"\n";
		return cadena;
	}
}

