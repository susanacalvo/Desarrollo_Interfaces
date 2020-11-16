package gui.mcv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import componentes.PanelCopyRight;
import datos.Persona;
import gui.componentes.PersonaRenderer;
/**
 * Clase Vista, representa el diseño principal del programa
 * @author Susana
 *
 */
public class Vista extends JFrame {
	/**
	 * Atributos de la clase
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JButton btnNuevoPersona;
	JButton btnEliminarPersona;
	JTextField txtDni;
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtEdad;
	JTextField txtAltura;
	JList<Persona> listaPersonas;
	DefaultListModel<Persona>dlmPersona;
	JButton btnAbrirColores;
	JMenuItem mntGuardar;
	JMenuItem mntCargar;
	JMenuItem mntSalir;


	/**
	 * Construimos el JFrame
	 */
	public Vista() {
		dlmPersona = new DefaultListModel<Persona>();
		
		initComponents();
		
		listaPersonas.setModel(dlmPersona);
		listaPersonas.setCellRenderer(new PersonaRenderer());
	}

	/**
	 * Método que englobla todos los componentes gráficos de la vista
	 */
	public void initComponents() {
		setTitle("Gesti\u00F3n de Atletismo 2020");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vista.class.getResource("/img/corriendo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 477);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntGuardar = new JMenuItem("Guardar");
		mntGuardar.setToolTipText("Guardar archivo");
		mnArchivo.add(mntGuardar);
		
		mntCargar = new JMenuItem("Cargar");
		mntCargar.setToolTipText("Cargar archivo");
		mnArchivo.add(mntCargar);
		
		mntSalir = new JMenuItem("Salir");
		mnArchivo.add(mntSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel panelPersona = new JPanel();
		tabbedPane.addTab("Persona", null, panelPersona, null);
		panelPersona.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 0, 20, 0));
		FlowLayout fl_panelBotones = (FlowLayout) panelBotones.getLayout();
		fl_panelBotones.setAlignment(FlowLayout.LEADING);
		panelPersona.add(panelBotones, BorderLayout.NORTH);
		
		btnNuevoPersona = new JButton("Nuevo");
		btnNuevoPersona.setToolTipText("Nueva Persona");
		btnNuevoPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBotones.add(btnNuevoPersona);
		
		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setToolTipText("Eliminar Persona");
		btnEliminarPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBotones.add(btnEliminarPersona);
		
		btnAbrirColores = new JButton("Elegir Color");
		btnAbrirColores.setActionCommand("ElegirColor");
		btnAbrirColores.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBotones.add(btnAbrirColores);
		
		JPanel panelDatos = new JPanel();
		panelPersona.add(panelDatos, BorderLayout.WEST);
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		
		JPanel panelDni = new JPanel();
		panelDatos.add(panelDni);
		panelDni.setLayout(new GridLayout(0, 2, 0, 0));
		panelDni.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JLabel lblDni = new JLabel("Dni:");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDni.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setToolTipText("");
		txtDni.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDni.add(txtDni);
		txtDni.setColumns(10);
		
		JPanel panelNombre = new JPanel();
		panelDatos.add(panelNombre);
		panelNombre.setLayout(new GridLayout(0, 2, 0, 0));
		panelNombre.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNombre.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		panelNombre.add(txtNombre);
		txtNombre.setColumns(10);
		
		JPanel panelApellido = new JPanel();
		panelDatos.add(panelApellido);
		panelApellido.setLayout(new GridLayout(0, 2, 0, 0));
		panelApellido.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		panelApellido.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		panelApellido.add(txtApellido);
		txtApellido.setColumns(10);
		
		JPanel panelEdad = new JPanel();
		panelDatos.add(panelEdad);
		panelEdad.setLayout(new GridLayout(0, 2, 0, 0));
		panelEdad.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEdad.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Arial", Font.PLAIN, 12));
		panelEdad.add(txtEdad);
		txtEdad.setColumns(10);
		
		JPanel panelAltura = new JPanel();
		panelDatos.add(panelAltura);
		panelAltura.setLayout(new GridLayout(0, 2, 0, 0));
		panelAltura.setBorder(new EmptyBorder(5, 10, 5, 10));
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAltura.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Arial", Font.PLAIN, 12));
		panelAltura.add(txtAltura);
		txtAltura.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panelDatos.add(panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0};
		gbl_panel_8.rowHeights = new int[]{0};
		gbl_panel_8.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JPanel panelButtom = new JPanel();
		panelPersona.add(panelButtom, BorderLayout.SOUTH);
		panelButtom.setLayout(new BorderLayout(0, 0));
		
		PanelCopyRight panelCopyRight = new PanelCopyRight();
		panelButtom.add(panelCopyRight);
		panelCopyRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelLista = new JPanel();
		panelPersona.add(panelLista, BorderLayout.CENTER);
		panelLista.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBorder(new TitledBorder(null, "Lista de Personas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInfo.setLayout(new BorderLayout(0, 0));
		panelLista.add(panelInfo, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.PLAIN, 12));
		panelInfo.add(scrollPane);
		
		listaPersonas = new JList<Persona>();
		listaPersonas.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		listaPersonas.setToolTipText("");
		listaPersonas.setVisibleRowCount(10);
		listaPersonas.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(listaPersonas);
		
		JPanel panelCarrera = new JPanel();
		tabbedPane.addTab("Carrera", null, panelCarrera, null);
		panelCarrera.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
