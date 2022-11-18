package interfaz;
import java.util.Scanner;
import dominio.*;
/**
 * Clase Interfaz
 * Responsable de leer y procesar las solicitudes de usuario
 * 
 * @author Paloma Centenera
 * @version 1.0
 */
public class Interfaz{
/**
 * Procesa una petición
 * @param peticion String con la petición a ejecutar
 * @param l Libreta sobre la que se realiza la petición
 * @return true: se esperan más peticiones, false: terminar
 */
	public boolean procesarPeticion (String peticion, Libreta l){
		String [] p=peticion.split(" ");
		if (p[0].equals("add"))
			if (p.length!=3)// peticion erronea
				System.out.print("peticion erronea. Pida la ayuda 'help'");
			else
				l.add(new Contacto(p[1],p[2]));
		else 
			if (p.length!=1)// peticion erronea
				System.out.print("peticion erronea. Pida la ayuda 'help'");
			else if (p[0].equals("list"))
				System.out.print (l);
			else if (p[0].equals("help"))
				System.out.print("introduzca ua de las siguientes peticiones: \n add nombre telefono: aÃ±adir contacto a la agenda\n list: listar la agenda\n exit: salir\n");
			else if (p[0].equals("exit"))
				return false;
			else {
				System.out.print("petición erronea");
				procesarPeticion("help",l);
			}
		return true;//en todos los casos debe seguir pidiendo y procesando peticiones
	}
/**
 * Lee una petición de usuario
 *
 * @return un String con la petición leida
 */

	public String leerPeticion(){
		Scanner sc = new Scanner(System.in);
  		System.out.print("?>");
		String cadena = sc.nextLine();
		return cadena;
	}

}

