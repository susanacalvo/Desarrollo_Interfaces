package gui.componentes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import datos.Persona;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Dimension;

/**
 * Clase Panel Persona. Muestra información de ésta
 * @author Susana
 *
 */
public class PanelPersona extends JPanel {

	/**
	 * Atributos de la clase
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblAlturaPersona;
	private JLabel lblEdadPersona;
	private JLabel lblDNIPersona;
	private JLabel lblNombrePersona;
	private JPanel panelRestoDatos;
	private JLabel lblApellidoPersona;
	

	/**
	 * Create the panel.
	 */
	public PanelPersona(Persona persona) {
		setMaximumSize(new Dimension(450, 109));
	
		
		
		
		initGUI();
		
		mostrarDatosPersona(persona);

	}
	public void initGUI() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBorder(new EmptyBorder(10, 15, 5, 0));
		FlowLayout flowLayout = (FlowLayout) panelNombre.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		add(panelNombre, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelPersona.class.getResource("/img/circulo-negro .jpg")));
		panelNombre.add(lblNewLabel_1);
		
		lblNombrePersona = new JLabel("");
		lblNombrePersona.setFont(new Font("Arial", Font.BOLD, 12));
		panelNombre.add(lblNombrePersona);
		
		lblApellidoPersona = new JLabel("");
		lblApellidoPersona.setFont(new Font("Arial", Font.BOLD, 12));
		panelNombre.add(lblApellidoPersona);
		
		panelRestoDatos = new JPanel();
		add(panelRestoDatos, BorderLayout.CENTER);
		panelRestoDatos.setVisible(false);
		panelRestoDatos.setLayout(new BoxLayout(panelRestoDatos, BoxLayout.Y_AXIS));
		
		JPanel panelDNIPersona = new JPanel();
		panelDNIPersona.setBorder(new EmptyBorder(0, 35, 0, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panelDNIPersona.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEADING);
		panelRestoDatos.add(panelDNIPersona);
		
		JLabel lblNewLabel = new JLabel("DNI: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDNIPersona.add(lblNewLabel);
		
		lblDNIPersona = new JLabel("");
		lblDNIPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDNIPersona.add(lblDNIPersona);
		
		JPanel panelEdadPersona = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelEdadPersona.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEADING);
		panelEdadPersona.setBorder(new EmptyBorder(0, 35, 0, 0));
		panelRestoDatos.add(panelEdadPersona);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEdadPersona.add(lblNewLabel_2);
		
		lblEdadPersona = new JLabel("");
		lblEdadPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEdadPersona.add(lblEdadPersona);
		
		JPanel panelAlturaPersona = new JPanel();
		panelAlturaPersona.setBorder(new EmptyBorder(0, 35, 0, 0));
		FlowLayout flowLayout_3 = (FlowLayout) panelAlturaPersona.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEADING);
		panelRestoDatos.add(panelAlturaPersona);
		
		JLabel lblNewLabel_4 = new JLabel("Altura:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAlturaPersona.add(lblNewLabel_4);
		
		lblAlturaPersona = new JLabel("");
		lblAlturaPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAlturaPersona.add(lblAlturaPersona);
		
		panelNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelRestoDatos.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelRestoDatos.setVisible(false);
			}
		});
	}
	public void mostrarDatosPersona(Persona persona) {
		lblNombrePersona.setText(persona.getNombre());
		lblApellidoPersona.setText(persona.getApellidos());
		lblDNIPersona.setText(persona.getDni());
		lblEdadPersona.setText(String.valueOf(persona.getEdad()));
		lblAlturaPersona.setText(String.valueOf(persona.getAltura()));
	}
	

}
