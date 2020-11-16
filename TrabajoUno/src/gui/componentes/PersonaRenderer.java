package gui.componentes;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import datos.Persona;
import java.awt.FlowLayout;
/**
 * Clase PersonaRenderer, implementa un ListCellRenderer de tipo Persona para poder personalizar las listas
 * @author Susana
 *
 */
public class PersonaRenderer extends JPanel implements ListCellRenderer<Persona>{
	/**
	 * Atributos de la clase
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblNombre;
	JLabel lblApellido;
	JLabel lblAltura;

	/**
	 * Construimos el JPanel
	 */
	public PersonaRenderer() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		initUI();
	}
	
	/**
	 * Método de los componentes gráficos del JPanel
	 */
	public void initUI() {
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(PersonaRenderer.class.getResource("/img/circulo-negro .jpg")));
		add(lblIcono);
		
		lblNombre = new JLabel("");
		add(lblNombre);
		
		lblApellido = new JLabel("");
		add(lblApellido);
		
		lblAltura = new JLabel("");
		add(lblAltura);
	}

	/**
	 * Método implementado de la interfaz ListCellRenderer
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param selected
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Persona> arg0, Persona arg1, int arg2, boolean selected,
			boolean arg4) {
		if(arg1 !=null) {
			lblNombre.setText(arg1.getNombre());
			lblApellido.setText(arg1.getApellidos());
			lblAltura.setText(String.valueOf((arg1.getAltura() )));
		} else{
			
			lblNombre.setText("");
			lblApellido.setText("");
			lblAltura.setText("");
		}
		
		if(selected) {
			this.setBackground(arg0.getSelectionBackground());
			this.setForeground(arg0.getSelectionForeground());
		}else {
			this.setBackground(arg0.getBackground());
			this.setForeground(arg0.getForeground());
		}
		return this;
	}

}
