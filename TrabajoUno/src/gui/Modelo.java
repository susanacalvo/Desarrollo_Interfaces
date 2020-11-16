package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;

import datos.Carrera;
import datos.Persona;
import util.Util;
/**
 * Clase modelo, realiza todas las operaciones de la aplicacion
 * @author Susana
 *
 */
public class Modelo {
	private HashSet<Persona> listaPersonas;
	private LinkedList<Carrera> listaCarreras;
	
	/**
	 * Constructor de la clase
	 */
	public Modelo() {
		listaPersonas=new HashSet<Persona>();
		listaCarreras = new LinkedList<Carrera>();
	}
	
	/**
	 * Método para dar de Registrar una persona
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param altura
	 */
	public void altaPersona(String dni, String nombre, String apellido, int edad, double altura) {
		listaPersonas.add(new Persona(dni,nombre,apellido,edad,altura));
	}
	/**
	 * Método para eliminar una persona de la lista
	 * @param persona
	 */
	public void eliminarPersona(Persona persona) {
		listaPersonas.remove(persona);
	}
	
	/**
	 * Método para listar todas las personas de la lista
	 * @return lista de personas
	 */
	public HashSet<Persona> getPersona(){
		return listaPersonas;
		
	}
	
	/**
	 * Método para Registrar una carrera
	 * @param denominacion
	 * @param metros
	 * @param fecha
	 * @param lugar
	 * @param realizado
	 */
	public void altaCarrera(String denominacion, double metros, LocalDate fecha, String lugar, boolean realizado) {
		listaCarreras.add(new Carrera(denominacion,metros,fecha,lugar,realizado));
	}
	
	/**
	 * Método para eliminar una carrera de la lista
	 * @param carrera
	 */
	public void eliminarCarrera(Carrera carrera) {
		listaCarreras.remove(carrera);
	}
	
	/**
	 * Método que devuelve todas las carreras registradas en la lista
	 * @return lista de carreras
	 */
	public LinkedList<Carrera> getCarrera(){
		return listaCarreras;
	}
	
	/**
	 * Método para leer los datos de un fichero binario
	 * @param fichero
	 */
	@SuppressWarnings("unchecked")
	public void cargarDatos(File fichero) {
		try {
			
			FileInputStream flujoEntrada = new FileInputStream (fichero);
			ObjectInputStream deserializador = new ObjectInputStream(flujoEntrada);
			listaPersonas = (HashSet<Persona>) deserializador.readObject();
			listaCarreras = (LinkedList<Carrera>)deserializador.readObject();
			deserializador.close();
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println("Error: El fichero no existe. ");
			Util.mostrarDialogoError("Error,  El fichero no existe ");
		}catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error: Fallo en la lectura del fichero. ");
			Util.mostrarDialogoError("Error, fallo en la lectura del fichero ");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("No se pudo acceder a la clase adecuada para revertir la Serializacion al leer del fichero.");
			Util.mostrarDialogoError("Error, no se pudo acceder a la clase ");
		} 
		
	}
	/**
	 * Método para guardar los datos en un fichero binario
	 * @param fichero
	 */
	public void guardarDatos(File fichero) {
		try {
			FileOutputStream flujoSalida = new FileOutputStream (fichero);
			ObjectOutputStream serializador = new ObjectOutputStream(flujoSalida);
			serializador.writeObject(listaPersonas);
			serializador.writeObject(listaCarreras);
			serializador.close();
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
            System.out.println("Error: El fichero no existe. ");
            Util.mostrarDialogoError("Error: El fichero no existe.");
        }catch (IOException e) {
        	e.printStackTrace();
            System.out.println("Error: Fallo en la escritura en el fichero. ");
            Util.mostrarDialogoError("Error en la escritura del fichero");
        }
		
	}

}
