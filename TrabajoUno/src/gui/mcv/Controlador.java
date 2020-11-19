package gui.mcv;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.time.LocalDate;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import datos.Carrera;
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
	 * Constructor de la clase Controlador, basándome en el método Modelo Vista Controlador
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
	 * Método que reacciona ante los action listeners
	 * @param listener
	 */
	private void initActionHandlers(ActionListener listener) {
		vista.btnEliminarPersona.addActionListener(listener);
		vista.btnNuevoPersona.addActionListener(listener);
		vista.mntFondo.addActionListener(listener);
		vista.mntGuardar.addActionListener(listener);
		vista.mntCargar.addActionListener(listener);
		vista.mntSalir.addActionListener(listener);
		vista.btnEliminarCarrera.addActionListener(listener);
		vista.btnNuevaCarrera.addActionListener(listener);
	}
	
	/**
	 * Método que reacciona ante  las listas
	 * @param listener
	 */
	private void initListListeners(ListSelectionListener listener) {
		vista.listaPersonas.addListSelectionListener(listener);
		vista.listaCarreras.addListSelectionListener(listener);
		vista.listaContenidoCarrera.addListSelectionListener(listener);
		vista.listaContenidoPersonas.addListSelectionListener(listener);
	}
	
	/**
	 * Método que reacciona antes los Key Listeners
	 * @param listener
	 */
	private void initKeyListeners(KeyListener listener) {
		vista.listaPersonas.addKeyListener(listener);
		vista.txtNombre.addKeyListener(listener);
		vista.txtApellido.addKeyListener(listener);
		vista.txtEdad.addKeyListener(listener);
		vista.txtDenominacion.addKeyListener(listener);
		vista.txtDistancia.addKeyListener(listener);
		vista.txtLugar.addKeyListener(listener);
	}
	
	/**
	 * Método del Action Listener que reacciona a diferentes pulsaciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			/**
			 * Añade una nueva persona 
			 */
			case "NuevaPersona":
			{
				String dni=vista.txtDni.getText();
				String nombre = vista.txtNombre.getText();
				String apellido = vista.txtApellido.getText();
				String edad = vista.txtEdad.getText();
				String altura = vista.txtAltura.getText();
				Carrera carrera = (Carrera)vista.cbRace.getSelectedItem();
				if(dni.length()==0 || nombre.length()==0 || apellido.length()==0 || edad.length()==0 || altura.length()==0)
					Util.mostrarDialogoError("Los campos están vacíos");
				else
					this.modelo.altaPersona(dni, nombre, apellido, Integer.parseInt(edad), Double.parseDouble(altura),carrera);
			}
				break;
			/**
			 * Elimina una persona	
			 */
			case "EliminarPersona":
					deletePerson();
				break;
			/**
			 * Añade una nueva carrera
			 */
			case "NuevaCarrera":
				{
				String denominacion = vista.txtDenominacion.getText();
				String metros = vista.txtDistancia.getText();
				String lugar = vista.txtLugar.getText();
				LocalDate fecha = vista.datePicker.getDate();
				Boolean realizado = vista.chRealizado.isSelected();
				
				if(denominacion.length()==0 || metros.length()==0 || lugar.length()==0 || fecha ==null) 
					Util.mostrarDialogoError("Los campos están vacíos");
				else
					this.modelo.altaCarrera(denominacion, Double.parseDouble(metros), fecha, lugar, realizado);
				
				refrescarComboBox();
				}
				break;
			/**
			 * Elimina una carrera
			 */
			case "EliminarCarrera":
					deleteRace();
					refrescarComboBox();
				break;
			/**
			 * Cambia el color de fondo de la aplicación
			 */
			case "Fondo":
					Color colorSeleccionado = JColorChooser.showDialog(null, "Elige un color", Color.BLACK);
					vista.contentPane.setBackground(colorSeleccionado);
					vista.panelBotones.setBackground(colorSeleccionado);
					vista.panelDatos.setBackground(colorSeleccionado);
					vista.panelLista.setBackground(colorSeleccionado);
					vista.panelButtom.setBackground(colorSeleccionado);
					vista.panelAltura.setBackground(colorSeleccionado);
					vista.panelApellido.setBackground(colorSeleccionado);
					vista.panelNombre.setBackground(colorSeleccionado);
					vista.panelDni.setBackground(colorSeleccionado);
					vista.panelEdad.setBackground(colorSeleccionado);
					vista.panelCopyRight.setBackground(colorSeleccionado);
					vista.panelSolo.setBackground(colorSeleccionado);
					vista.panelInfo.setBackground(colorSeleccionado);
					vista.panelCarrera.setBackground(colorSeleccionado);
					vista.panelBotonesCarrera.setBackground(colorSeleccionado);
					vista.panelDatosCarrera.setBackground(colorSeleccionado);
					vista.panelButtomCarrera.setBackground(colorSeleccionado);
					vista.panelListaCarrera.setBackground(colorSeleccionado);
					vista.panelRelacion.setBackground(colorSeleccionado);
					vista.panelDenominacion.setBackground(colorSeleccionado);
					vista.panelDistancia.setBackground(colorSeleccionado);
					vista.panelLugar.setBackground(colorSeleccionado);
					vista.panelFecha.setBackground(colorSeleccionado);
					vista.panelRealizado.setBackground(colorSeleccionado);
					vista.panel_1.setBackground(colorSeleccionado);
					vista.panelCopyRight_1.setBackground(colorSeleccionado);
					vista.panelLista.setBackground(colorSeleccionado);
					vista.panelInfoCarrera.setBackground(colorSeleccionado);
					vista.chRealizado.setBackground(colorSeleccionado);
					vista.panelCopyRight_2.setBackground(colorSeleccionado);
					vista.panel.setBackground(colorSeleccionado);
					vista.panel_2.setBackground(colorSeleccionado);
					vista.panelPersonas.setBackground(colorSeleccionado);
					vista.panelCarreras.setBackground(colorSeleccionado);
					vista.panelC.setBackground(colorSeleccionado);
				break;
			/**
			 * Guarda los datos en un fihcero a través de un selector de ficheros llamando al método guardarDatos
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
			 * Carga los datos de un fichero a través de un selector de ficheros llamando al método cargarDatos
			 */
			case "Cargar":{
					JFileChooser selector = new JFileChooser();
					int opcion = selector.showOpenDialog(vista);
					if(opcion == JFileChooser.APPROVE_OPTION) {
						File fichero = selector.getSelectedFile();
						modelo.cargarDatos(fichero);
					}
					refrescarComboBox();
					}
				break;
			/**
			 * Sale del sistema de gestión de carreras volviendo al login
			 */
			case "Salir":
				int respuesta = Util.mostrarDialogoSiNo("¿Estás seguro de que quieres salir?");
				if(respuesta==0) {
					Login login = new Login();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
					login.setResizable(false);
					vista.dispose();
				}
				break;
		}
		refrescarListaPersona();
		refrescarListaCarrera();
		listarCarreraRelacion();
		
	}
	
	/**
	 * Método que lista las carreras en la relación
	 */
	public void listarCarreraRelacion() {
		vista.dlmContenidoCarrera.clear();
		for(Carrera carrera : modelo.getCarrera()) {
			vista.dlmContenidoCarrera.addElement(carrera);
		}
	}
	/**
	 * Método para mostrar la relacion entre Personas y Carreras
	 * @param carrera
	 */
	public void mostrarPersonasDeCarreras(Carrera carrera) {
			
		vista.dlmContenidoPersona.clear();
		for(Persona persona : modelo.getPersona()) {
			if(persona.getCarrera() == carrera) {
				vista.dlmContenidoPersona.addElement(persona);
			}
		}
	
	}
	
	/**
	 * Método para refrescar el comboBox de las Carreras
	 */
	public void refrescarComboBox() {
		
		vista.dcbmCarrera.removeAllElements();
		
		vista.dcbmCarrera.addElement(null);
		
		for(Carrera carrera : modelo.getCarrera()) {
			vista.dcbmCarrera.addElement(carrera);
		}
		
	}
	/**
	 * Método para eliminar una Carrera
	 */
	public void deleteRace() {
		Carrera carrera = vista.listaCarreras.getSelectedValue();
		modelo.eliminarCarrera(carrera);
	}

	/**
	 * Método para eliminar una persona
	 */
	public void deletePerson() {
		Persona persona = vista.listaPersonas.getSelectedValue();
		modelo.eliminarPersona(persona);
	}
	
	/**
	 * Método para refrecar la lista cada vez que insertas un elemento nuevo o lo eliminas en la lista Persona
	 */
	private void refrescarListaPersona() {
		vista.dlmPersona.clear();
		for(Persona persona : modelo.getPersona()) {
			vista.dlmPersona.addElement(persona);
		}
		
	}
	
	/**
	 * Método para refrecar la lista cada vez que insertas un elemento nuevo o lo eliminas en la lista Carrera
	 */
	private void refrescarListaCarrera() {
		vista.dlmCarrera.clear();
		for(Carrera carrera : modelo.getCarrera()) {
			vista.dlmCarrera.addElement(carrera);
		}
		
	}
	
	/**
	 * Método implementado del ListSelectionEvent
	 * @param arg0
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		if(e.getSource()==vista.listaPersonas) {
			Persona seleccionado = vista.listaPersonas.getSelectedValue();
			if(seleccionado!=null) mostrarValores(seleccionado);
			else limpiarCampos();
			
		}else if(e.getSource()==vista.listaCarreras){
			Carrera c = vista.listaCarreras.getSelectedValue();
			if(c!=null) mostrarValores(c);
			else limpiarCampos();
			
		}else if(e.getSource()==vista.listaContenidoCarrera) {
			Carrera ca = vista.listaContenidoCarrera.getSelectedValue();
			mostrarPersonasDeCarreras(ca);
		}
	}
	
	/**
	 * Método para mostrar los datos en las cajas cuando lo seleccionas en la lista, recibe un objeto de tipo Persona
	 * @param seleccionado
	 */
	private void mostrarValores(Persona seleccionado) {
		vista.txtDni.setText(seleccionado.getDni());
		vista.txtNombre.setText(seleccionado.getNombre());
		vista.txtApellido.setText(seleccionado.getApellidos());
		vista.txtEdad.setText(String.valueOf(seleccionado.getEdad()));
		vista.txtAltura.setText(String.valueOf(seleccionado.getAltura()));
		vista.cbRace.setSelectedItem(seleccionado.getCarrera());
	}
	
	/**
	 * Método para mostrar los datos en las cajas cuando lo seleccionas en la lista, recibe un objeto de tipo Carrera
	 * @param seleccionado
	 */
	private void mostrarValores(Carrera seleccionado) {
		vista.txtDenominacion.setText(seleccionado.getDenominacion());
		vista.txtDistancia.setText(String.valueOf(seleccionado.getMetros()));
		vista.txtLugar.setText(seleccionado.getLugar());
		vista.datePicker.setDate(seleccionado.getFecha());
		vista.chRealizado.setSelected(seleccionado.isRealizado());
	}
	
	/**
	 * Método para vaciar los campos de texto
	 */
	private void limpiarCampos() {
		vista.txtDni.setText("");
		vista.txtNombre.setText("");
		vista.txtApellido.setText("");
		vista.txtEdad.setText("");
		vista.txtAltura.setText("");
		vista.txtDenominacion.setText("");
		vista.txtDistancia.setText("");
		vista.txtLugar.setText("");
		vista.datePicker.setDateToToday();
		vista.chRealizado.setSelected(false);
		vista.cbRace.setSelectedItem(null);
	}
	
	/**
	 * Método que reacciona ante la pulsación de una tecla, la cual comprueba si se han introducido correctamente los datos
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e) {

		if(e.getSource()==vista.txtNombre || e.getSource()==vista.txtApellido || e.getSource()==vista.txtDenominacion || e.getSource()==vista.txtLugar) {
			if(Character.isDigit(e.getKeyChar())) {
				e.consume();
				Util.mostrarDialogoError("Ingresa sólo letras");
				limpiarCampos();
			}
		 }
		
		if(e.getSource()== vista.txtEdad || e.getSource()==vista.txtDistancia) {

			if(Character.isLetter(e.getKeyChar())) {
				
				e.consume();
				Util.mostrarDialogoError("Ingresa sólo números");
				limpiarCampos();
			}
		}
		
	}
	/**
	 * Método que reacciona ante la pulsacion de la tecla suprimir para eliminar objetos
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.getSource() == vista.listaPersonas) {
			
			if (e.getKeyCode() == KeyEvent.VK_DELETE) {
				deletePerson();
				refrescarListaPersona();
			}
		}
		
		if (e.getSource() == vista.listaCarreras) {
			
			if (e.getKeyCode() == KeyEvent.VK_DELETE) {
				deleteRace();
				refrescarListaCarrera();
			}
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}
