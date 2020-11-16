package util;

import javax.swing.JOptionPane;
/**
 * Clase que contiene cuadros de di�logos para notificar de errores o avisos
 * @author Susana
 *
 */
public class Util {
	public static final int ACEPTAR = JOptionPane.OK_OPTION;
	public static final int CANCELAR = JOptionPane.CANCEL_OPTION;
	
	/**
	 * M�todo que muestra un cuadro de di�logo de error
	 * @param mensaje
	 */
	public static void mostrarDialogoError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje , "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * M�todo que muestra un cuadro de di�logo YES_NO_OPTION, devuelve un entero
	 * @param mensaje
	 * @return 
	 */
	public static int mostrarDialogoSiNo(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje, "Confirmaci�n", JOptionPane.YES_NO_OPTION);
	}
}
