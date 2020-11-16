package principal;

import gui.mcv.Login;
/**
 * Clase Principal desde dónde se ejecuta la aplicación
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
