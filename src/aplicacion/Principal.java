package aplicacion;

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
		Interfaz IU=new Interfaz();
		String peticion;
		IU.procesarPeticion("help");// para que muestre la ayuda al principio
		do {
			peticion=IU.leerPeticion();
		} while (IU.procesarPeticion(peticion));
	}
}

		
