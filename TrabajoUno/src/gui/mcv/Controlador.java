package gui.mcv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import datos.Persona;
import gui.Modelo;
import util.Util;
/**
 * Clase Controlador. Esta clase maneja todos los eventos producidos en la vista principal.
 * @author Susana
 *
 */
public class Controlador implements ActionListener, ListSelectionListener, KeyListener{
	private Modelo modelo;
	private Vista vista;
	
	/**
	 * Constructor de la clase Controlador, bas�ndome en el m�todo Modelo Vista Controlador
	 * @param modelo
	 * @param vista
	 */
	public Controlador(Modelo modelo, Vista vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
		initActionHandlers(this);
		initListListeners(this);
		initKeyListeners(this);
	}
	
	/**
	 * M�todo que reacciona ante los action listeners
	 * @param listener
	 */
	private void initActionHandlers(ActionListener listener) {
		vista.btnEliminarPersona.addActionListener(listener);
		vista.btnNuevoPersona.addActionListener(listener);
		vista.btnAbrirColores.addActionListener(listener);
		vista.mntGuardar.addActionListener(listener);
		vista.mntCargar.addActionListener(listener);
		vista.mntSalir.addActionListener(listener);
	}
	
	/**
	 * M�todo que reacciona ante  las listas
	 * @param listener
	 */
	private void initListListeners(ListSelectionListener listener) {
		vista.listaPersonas.addListSelectionListener(listener);
	}
	
	/**
	 * M�todo que reacciona antes los Key Listeners
	 * @param listener
	 */
	private void initKeyListeners(KeyListener listener) {
		vista.listaPersonas.addKeyListener(listener);
		vista.txtNombre.addKeyListener(listener);
		vista.txtApellido.addKeyListener(listener);
		vista.txtEdad.addKeyListener(listener);
	}
	
	/**
	 * M�todo del Action Listener que reacciona a diferentes pulsaciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			/**
			 * A�ade una nueva persona 
			 */
			case "Nuevo":
			{
				String dni=vista.txtDni.getText();
				String nombre = vista.txtNombre.getText();
				String apellido = vista.txtApellido.getText();
				String edad = vista.txtEdad.getText();
				String altura = vista.txtAltura.getText();
				
				if(dni.length()==0 || nombre.length()==0 || apellido.length()==0 || edad.length()==0 || altura.length()==0)
					Util.mostrarDialogoError("Los campos est�n vac�os");
				else
					this.modelo.altaPersona(dni, nombre, apellido, Integer.parseInt(edad), Double.parseDouble(altura));
			}
				break;
			/**
			 * Elimina una persona	
			 */
			case "Eliminar":
				Persona persona = vista.listaPersonas.getSelectedValue();
				modelo.eliminarPersona(persona);
				
				break;
				
			case "ElegirColor":
				
				break;
			/**
			 * Guarda los datos en un fihcero a trav�s de un selector de ficheros llamando al m�todo guardarDatos
			 */
			case "Guardar":{
					JFileChooser selector = new JFileChooser();
					int opcion = selector.showSaveDialog(vista);
					if(opcion == JFileChooser.APPROVE_OPTION) {
						File fichero = selector.getSelectedFile();
						modelo.guardarDatos(fichero);
					}
				}	
				break;
			/**
			 * Carga los datos de un fichero a trav�s de un selector de ficheros llamando al m�todo cargarDatos
			 */
			case "Cargar":{
					JFileChooser selector = new JFileChooser();
					int opcion = selector.showOpenDialog(vista);
					if(opcion == JFileChooser.APPROVE_OPTION) {
						File fichero = selector.getSelectedFile();
						modelo.cargarDatos(fichero);
					}
					
					}
				break;
			/**
			 * Sale del sistema de gesti�n de carreras volviendo al login
			 */
			case "Salir":
				int respuesta = Util.mostrarDialogoSiNo("�Est�s seguro de que quieres salir?");
				if(respuesta==0) {
					Login login = new Login();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
					login.setResizable(false);
					vista.dispose();
				}
				break;
		}
		refrescarLista();
		
	}
	
	/**
	 * M�todo para refrecar la lista cada vez que insertas un elemento nuevo o lo eliminas
	 */
	private void refrescarLista() {
		vista.dlmPersona.clear();
		for(Persona persona : modelo.getPersona()) {
			vista.dlmPersona.addElement(persona);
		}
		
	}
	
	/**
	 * M�todo implementado del ListSelectionEvent
	 * @param arg0
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		Persona seleccionado = vista.listaPersonas.getSelectedValue();
		if(seleccionado!=null) mostrarValoresCoche(seleccionado);
		else limpiarCampos();
	}
	
	/**
	 * M�todo para mostrar los datos en las cajas cuando lo seleccionas en la lista, recibe un objeto de tipo Persona
	 * @param seleccionado
	 */
	private void mostrarValoresCoche(Persona seleccionado) {
		vista.txtDni.setText(seleccionado.getDni());
		vista.txtNombre.setText(seleccionado.getNombre());
		vista.txtApellido.setText(seleccionado.getApellidos());
		vista.txtEdad.setText(String.valueOf(seleccionado.getEdad()));
		vista.txtAltura.setText(String.valueOf(seleccionado.getAltura()));
		
	}
	
	/**
	 * M�todo para vaciar los campos de texto
	 */
	private void limpiarCampos() {
		vista.txtDni.setText("");
		vista.txtNombre.setText("");
		vista.txtApellido.setText("");
		vista.txtEdad.setText("");
		vista.txtAltura.setText("");
	}
	
	/**
	 * M�todo que reacciona ante la pulsaci�n de una tecla, la cual comprueba si se han introducido correctamente los datos
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e) {

		if(e.getSource()==vista.txtNombre || e.getSource()==vista.txtApellido) {
			if(Character.isDigit(e.getKeyChar())) {
				e.consume();
				Util.mostrarDialogoError("Ingresa s�lo letras");
				limpiarCampos();
			}
		 }
		
		if(e.getSource()== vista.txtEdad) {

			if(Character.isLetter(e.getKeyChar())) {
				
				e.consume();
				Util.mostrarDialogoError("Ingresa s�lo n�meros");
				limpiarCampos();
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
}
