package aplicacion;
import java.io.*;
import dominio.*;
import interfaz.Interfaz;
/**
 * Aplicación de manejo de un listín telefónico
 * 
 * @author Paloma Centenera
 * @version 1.0
 */
public class Principal{
	public static void main(String [] args){
		ObjectInputStream fi;
		ObjectOutputStream fo;
		Libreta l;
		try {
			fi=new ObjectInputStream(
new FileInputStream("agenda.txt"));
		l= (Libreta) fi.readObject();
		fi.close();
		} catch (Exception e) {
			l=new Libreta();
		}
		Interfaz IU=new Interfaz();
		String peticion;
		IU.procesarPeticion("help",l);// para que muestre la ayuda al principio
		do {
			peticion=IU.leerPeticion();
		} while (IU.procesarPeticion(peticion,l));
		System.out.print("fin. Guardando la libreta");
		try {
			fo=new ObjectOutputStream(new FileOutputStream("agenda.txt"));
			fo.writeObject(l);
			fo.close();
		}catch (Exception e){
			System.out.print("Error al crear el fichero");
		}
	}
}

		
