package principal;

import gui.mcv.Login;
/**
 * Clase Principal desde d�nde se ejecuta la aplicaci�n
 * @author Susana
 *
 */

public class Principal {

	public static void main(String[] args) {
		Login login = new Login();
		login.setVisible(true);
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		

	}

}
