package interfaz;
import java.util.Scanner;
import dominio.*;
import java.io.*;
/**
 * Clase Interfaz
 * Responsable de leer y procesar las solicitudes de usuario
 * 
 * @author Paloma Centenera
 * @version 1.0
 */


/**
 * Procesa una petición
 * @param peticion String con la petición a ejecutar
 * @param l Libreta sobre la que se realiza la petición
 * @return true: se esperan más peticiones, false: terminar
 */
public class Interfaz{

	Libreta l;
	Scanner sc = new Scanner(System.in);

/**
 * Constructor. Construye la libreta  leyendola del flujo de objetos

 */

	public Interfaz(){
	l= leer();

	}
	public Libreta leer(){
		ObjectInputStream fi;

		try {
			fi=new ObjectInputStream(new FileInputStream("agenda.txt"));
		l= (Libreta) fi.readObject();
		fi.close();
		} catch (Exception e) {
			l=new Libreta();
		}
		return l;
	}
	public void grabar(){
		ObjectOutputStream fo;
		try {
			fo=new ObjectOutputStream(new FileOutputStream("agenda.txt"));
			fo.writeObject(l);
			fo.close();
		}catch (Exception e){
			System.out.print("Error al crear el fichero");
		}

	}

	public boolean procesarPeticion (String peticion){
		String [] p=peticion.split(" ");
		if (p.length==3)
			if (p[0].equals("add"))
				l.add(new Contacto(p[1],p[2]));
			else // peticion erronea
				System.out.print("peticion erronea. Pida la ayuda 'help'");
		else if (p.length ==2)
			if (p[0].equals("del"))
				l.del(p[1]);
			else if (p[0].equals("search"))
				System.out.println(l.search(p[1]));
			else 
				System.out.print("peticion erronea. Pida la ayuda 'help'");
		else if (p.length==1)
			if (p[0].equals("list"))
				System.out.print (l);
			else if (p[0].equals("help"))
				System.out.print("introduzca una de las siguientes peticiones: \n add nombre telefono: añadir contacto a la agenda\n del nombre: borrar por nombre\n search nombre: buscar por nombre\n list: listar la agenda\n exit: salir\n");
			else if (p[0].equals("exit")){
				grabar();
				return false;
			}
			else {
				System.out.print("petición erronea");
				procesarPeticion("help");
			}
		else// peticion erronea
			System.out.print("peticion erronea. Pida la ayuda 'help'");

		return true;//en todos los casos debe seguir pidiendo y procesando peticiones
	}
/**
 * Lee una petición de usuario
 *
 * @return un String con la petición leida
 */

	public String leerPeticion(){
  		System.out.print("?>");
		String cadena = sc.nextLine();
		return cadena;
	}

}

