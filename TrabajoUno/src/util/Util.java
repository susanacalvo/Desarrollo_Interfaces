package util;

import javax.swing.JOptionPane;

public class Util {
	public static final int ACEPTAR = JOptionPane.OK_OPTION;
	public static final int CANCELAR = JOptionPane.CANCEL_OPTION;
	
	public static void mostrarDialogoError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje , "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static int mostrarDialogoSiNo(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);
	}
}
