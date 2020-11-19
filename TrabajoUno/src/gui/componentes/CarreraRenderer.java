package gui.componentes;

import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import datos.Carrera;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Clase CarreraRenderer, implementa un ListCellRenderer de tipo Carrera para poder personalizar las listas
 * @author Susana
 *
 */

public class CarreraRenderer extends JPanel implements ListCellRenderer<Carrera>{
	/**
	 * Atributos de la clase
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDenominacion;
	private JLabel lblMetros;
	private JLabel lblLugar;
	
	/**
	 * Construimos el JPanel
	 */
	public CarreraRenderer() {
		
		initUI();
	}
	
	/**
	 * Método de los componentes gráficos del JPanel
	 */
	public void initUI() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(PersonaRenderer.class.getResource("/img/circulo-negro .jpg")));
		add(lblIcono);
		
		lblDenominacion = new JLabel("");
		add(lblDenominacion);
		
		lblMetros = new JLabel("");
		add(lblMetros);
		
		lblLugar = new JLabel("");
		add(lblLugar);
	}
	
	/**
	 * Método implementado de la interfaz ListCellRenderer
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param selected
	 * @param arg4
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Carrera> arg0, Carrera arg1, int arg2, boolean selected,
			boolean arg4) {
		if(arg1 !=null) {
			lblDenominacion.setText(arg1.getDenominacion());
			lblMetros.setText(String.valueOf(arg1.getMetros()));
			lblLugar.setText((arg1.getLugar()));
		} else{
			
			lblDenominacion.setText("");
			lblMetros.setText("");
			lblLugar.setText("");
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
