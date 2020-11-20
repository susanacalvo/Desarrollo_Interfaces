package gui.mcv;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
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
import datos.Carrera;
import datos.Persona;
import gui.componentes.CarreraRenderer;
import gui.componentes.PersonaRenderer;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JComboBox;
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
	JMenuItem mntGuardar;
	JMenuItem mntCargar;
	JMenuItem mntSalir;
	JMenuItem mntFondo;
	JPanel panelPersona;
	JPanel panelBotones;
	JPanel panelDatos;
	JPanel panelButtom;
	JPanel panelLista;
	PanelCopyRight panelCopyRight;
	JPanel panelDni;
	JPanel panelNombre;
	JPanel panelApellido;
	JPanel panelEdad;
	JPanel panelAltura;
	JPanel panelInfo;
	JPanel panelBotonesCarrera;
	JButton btnNuevaCarrera;
	JButton btnEliminarCarrera;
	JPanel panelRelacion;
	JPanel panelDatosCarrera;
	JPanel panelDenominacion;
	JLabel lblDenominacion;
	JTextField txtDenominacion;
	JPanel panelDistancia;
	JPanel panelLugar;
	JLabel lblDistancia;
	JTextField txtDistancia;
	JLabel lblLugar;
	JTextField txtLugar;
	JPanel panelFecha;
	JPanel panelRealizado;
	JLabel lblFecha;
	JLabel lblRealizado;
	JCheckBox chRealizado;
	JPanel panelButtomCarrera;
	PanelCopyRight panelCopyRight_1;
	DatePicker datePicker;
	JPanel panelListaCarrera;
	JPanel panelInfoCarrera;
	JScrollPane scrollPaneCarrera;
	JList<Carrera> listaCarreras;
	DefaultListModel<Carrera> dlmCarrera;
	JPanel panel_1;
	JPanel panelCarrera;
	private JPanel panel_5;
	private JPanel panel_6;
	JPanel panelCarreras;
	JPanel panelPersonas;
	PanelCopyRight panelCopyRight_2;
	JPanel panel;
	private JLabel lblNewLabel;
	JPanel panel_2;
	private JLabel lblPersonas;
	private JPanel panel_3;
	private JScrollPane scrollPane_1;
	JList<Carrera> listaContenidoCarrera;
	DefaultListModel<Carrera>dlmContenidoCarrera;
	private JPanel panel_4;
	private JScrollPane scrollPane_2;
	DefaultListModel<Persona>dlmContenidoPersona;
	JPanel panelC;
	private JLabel lblC;
	JComboBox <Carrera>cbRace;
	DefaultComboBoxModel<Carrera>dcbmCarrera;
	JPanel panelSolo;
	JPanel panelListarContenidoPersonas;


	/**
	 * Construimos el JFrame
	 */
	public Vista() {

		initComponents();
		
		initListCombo();
	
	}
	
	/**
	 * Método que engloba a las listas y comboBox
	 */
	public void initListCombo() {
		dlmPersona = new DefaultListModel<Persona>();
		listaPersonas.setModel(dlmPersona);
		listaPersonas.setCellRenderer(new PersonaRenderer());
		
		dlmCarrera = new DefaultListModel<Carrera>();
		listaCarreras.setModel(dlmCarrera);
		listaCarreras.setCellRenderer(new CarreraRenderer());
		
		dlmContenidoCarrera = new DefaultListModel<Carrera>();
		listaContenidoCarrera.setModel(dlmContenidoCarrera);
		
		dlmContenidoPersona = new DefaultListModel<Persona>();
		
		dcbmCarrera =  new DefaultComboBoxModel<Carrera>();
		cbRace.setModel(dcbmCarrera);
	}

	/**
	 * Método que englobla todos los componentes gráficos de la vista
	 */
	public void initComponents() {
		setTitle("Gesti\u00F3n de Atletismo 2020");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vista.class.getResource("/img/corriendo.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		
		JMenu mnEdit = new JMenu("Editar");
		menuBar.add(mnEdit);
		
		mntFondo = new JMenuItem("Cambiar color fondo");
		mntFondo.setActionCommand("Fondo");
		mnEdit.add(mntFondo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		panelPersona = new JPanel();
		tabbedPane.addTab("Persona", null, panelPersona, null);
		panelPersona.setLayout(new BorderLayout(0, 0));
		
		panelBotones = new JPanel();
		panelBotones.setBorder(new EmptyBorder(5, 0, 20, 0));
		FlowLayout fl_panelBotones = (FlowLayout) panelBotones.getLayout();
		fl_panelBotones.setAlignment(FlowLayout.LEADING);
		panelPersona.add(panelBotones, BorderLayout.NORTH);
		
		btnNuevoPersona = new JButton("Nuevo");
		btnNuevoPersona.setActionCommand("NuevaPersona");
		btnNuevoPersona.setToolTipText("Nueva Persona");
		btnNuevoPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBotones.add(btnNuevoPersona);
		
		btnEliminarPersona = new JButton("Eliminar");
		btnEliminarPersona.setActionCommand("EliminarPersona");
		btnEliminarPersona.setToolTipText("Eliminar Persona");
		btnEliminarPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBotones.add(btnEliminarPersona);
		
		panelDatos = new JPanel();
		panelDatos.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelPersona.add(panelDatos, BorderLayout.WEST);
		panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
		
		panelDni = new JPanel();
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
		
		panelNombre = new JPanel();
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
		
		panelApellido = new JPanel();
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
		
		panelEdad = new JPanel();
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
		
		panelAltura = new JPanel();
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
		
		panelC = new JPanel();
		panelC.setBorder(new EmptyBorder(5, 10, 5, 10));
		panelDatos.add(panelC);
		panelC.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblC = new JLabel("Carrera:");
		lblC.setFont(new Font("Arial", Font.PLAIN, 12));
		panelC.add(lblC);
		
		cbRace = new JComboBox<Carrera>();
		cbRace.setFont(new Font("Arial", Font.PLAIN, 12));
		panelC.add(cbRace);
		
		panelSolo = new JPanel();
		panelDatos.add(panelSolo);
		GridBagLayout gbl_panelSolo = new GridBagLayout();
		gbl_panelSolo.columnWidths = new int[]{0};
		gbl_panelSolo.rowHeights = new int[]{0};
		gbl_panelSolo.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelSolo.rowWeights = new double[]{Double.MIN_VALUE};
		panelSolo.setLayout(gbl_panelSolo);
		
		panelButtom = new JPanel();
		panelPersona.add(panelButtom, BorderLayout.SOUTH);
		panelButtom.setLayout(new BorderLayout(0, 0));
		
		panelCopyRight = new PanelCopyRight();
		panelButtom.add(panelCopyRight);
		panelCopyRight.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelLista = new JPanel();
		panelPersona.add(panelLista, BorderLayout.CENTER);
		panelLista.setLayout(new BorderLayout(0, 0));
		
		panelInfo = new JPanel();
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
		
		panelCarrera = new JPanel();
		tabbedPane.addTab("Carrera", null, panelCarrera, null);
		panelCarrera.setLayout(new BorderLayout(0, 0));
		
		panelBotonesCarrera = new JPanel();
		FlowLayout fl_panelBotonesCarrera = (FlowLayout) panelBotonesCarrera.getLayout();
		fl_panelBotonesCarrera.setAlignment(FlowLayout.LEADING);
		panelBotonesCarrera.setBorder(new EmptyBorder(5, 0, 20, 0));
		panelCarrera.add(panelBotonesCarrera, BorderLayout.NORTH);
		
		btnNuevaCarrera = new JButton("Nuevo");
		btnNuevaCarrera.setToolTipText("Nueva Persona");
		btnNuevaCarrera.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNuevaCarrera.setActionCommand("NuevaCarrera");
		panelBotonesCarrera.add(btnNuevaCarrera);
		
		btnEliminarCarrera = new JButton("Eliminar");
		btnEliminarCarrera.setToolTipText("Eliminar Persona");
		btnEliminarCarrera.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarCarrera.setActionCommand("EliminarCarrera");
		panelBotonesCarrera.add(btnEliminarCarrera);
		
		panelDatosCarrera = new JPanel();
		panelDatosCarrera.setBorder(new EmptyBorder(0, 0, 0, 5));
		panelCarrera.add(panelDatosCarrera, BorderLayout.WEST);
		panelDatosCarrera.setLayout(new BoxLayout(panelDatosCarrera, BoxLayout.Y_AXIS));
		
		panelDenominacion = new JPanel();
		panelDenominacion.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelDatosCarrera.add(panelDenominacion);
		panelDenominacion.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblDenominacion = new JLabel("Denominaci\u00F3n:");
		lblDenominacion.setPreferredSize(new Dimension(50, 13));
		lblDenominacion.setMaximumSize(new Dimension(50, 13));
		lblDenominacion.setMinimumSize(new Dimension(50, 13));
		lblDenominacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDenominacion.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDenominacion.add(lblDenominacion);
		
		txtDenominacion = new JTextField();
		txtDenominacion.setHorizontalAlignment(SwingConstants.LEFT);
		txtDenominacion.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDenominacion.add(txtDenominacion);
		txtDenominacion.setColumns(10);
		
		panelDistancia = new JPanel();
		panelDistancia.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelDatosCarrera.add(panelDistancia);
		panelDistancia.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblDistancia = new JLabel("Metros:");
		lblDistancia.setHorizontalAlignment(SwingConstants.LEFT);
		lblDistancia.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDistancia.add(lblDistancia);
		
		txtDistancia = new JTextField();
		txtDistancia.setFont(new Font("Arial", Font.PLAIN, 12));
		panelDistancia.add(txtDistancia);
		txtDistancia.setColumns(10);
		
		panelLugar = new JPanel();
		panelLugar.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelDatosCarrera.add(panelLugar);
		panelLugar.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Arial", Font.PLAIN, 12));
		panelLugar.add(lblLugar);
		
		txtLugar = new JTextField();
		txtLugar.setFont(new Font("Arial", Font.PLAIN, 12));
		panelLugar.add(txtLugar);
		txtLugar.setColumns(10);
		
		panelFecha = new JPanel();
		panelFecha.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelDatosCarrera.add(panelFecha);
		panelFecha.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Arial", Font.PLAIN, 12));
		panelFecha.add(lblFecha);
		
		datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setIcon(new ImageIcon(Vista.class.getResource("/img/calendario (1).png")));
		datePicker.getComponentToggleCalendarButton().setText("");
		panelFecha.add(datePicker);
		
		panelRealizado = new JPanel();
		panelRealizado.setBorder(new EmptyBorder(10, 10, 0, 0));
		panelDatosCarrera.add(panelRealizado);
		panelRealizado.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblRealizado = new JLabel("\u00BFSe ha realizado la prueba?");
		lblRealizado.setFont(new Font("Arial", Font.PLAIN, 12));
		panelRealizado.add(lblRealizado);
		
		chRealizado = new JCheckBox("");
		chRealizado.setHorizontalAlignment(SwingConstants.CENTER);
		panelRealizado.add(chRealizado);
		
		panel_1 = new JPanel();
		panelDatosCarrera.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panelButtomCarrera = new JPanel();
		panelCarrera.add(panelButtomCarrera, BorderLayout.SOUTH);
		panelButtomCarrera.setLayout(new BorderLayout(0, 0));
		
		panelCopyRight_1 = new PanelCopyRight();
		panelButtomCarrera.add(panelCopyRight_1);
		panelCopyRight_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelListaCarrera = new JPanel();
		panelCarrera.add(panelListaCarrera, BorderLayout.CENTER);
		panelListaCarrera.setLayout(new BorderLayout(0, 0));
		
		panelInfoCarrera = new JPanel();
		panelInfoCarrera.setBorder(new TitledBorder(null, "Lista de Carreras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListaCarrera.add(panelInfoCarrera, BorderLayout.CENTER);
		panelInfoCarrera.setLayout(new BorderLayout(0, 0));
		
		scrollPaneCarrera = new JScrollPane();
		panelInfoCarrera.add(scrollPaneCarrera, BorderLayout.CENTER);
		
		listaCarreras = new JList<Carrera>();
		scrollPaneCarrera.setViewportView(listaCarreras);
		
		panelRelacion = new JPanel();
		tabbedPane.addTab("Relaci\u00F3n", null, panelRelacion, null);
		panelRelacion.setLayout(new BorderLayout(0, 0));
		
		panel_5 = new JPanel();
		panelRelacion.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelCarreras = new JPanel();
		panelCarreras.setBorder(new EmptyBorder(10, 20, 10, 10));
		panel_5.add(panelCarreras);
		panelCarreras.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panelCarreras.add(panel, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("CARRERAS");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panelCarreras.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, BorderLayout.CENTER);
		
		listaContenidoCarrera = new JList<Carrera>();
		scrollPane_1.setViewportView(listaContenidoCarrera);
		
		panelPersonas = new JPanel();
		panelPersonas.setBorder(new EmptyBorder(10, 10, 10, 20));
		panel_5.add(panelPersonas);
		panelPersonas.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panelPersonas.add(panel_2, BorderLayout.NORTH);
		
		lblPersonas = new JLabel("PERSONAS");
		lblPersonas.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_2.add(lblPersonas);
		
		panel_4 = new JPanel();
		panelPersonas.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		panelListarContenidoPersonas = new JPanel();
		scrollPane_2.setViewportView(panelListarContenidoPersonas);
		panelListarContenidoPersonas.setLayout(new BoxLayout(panelListarContenidoPersonas, BoxLayout.Y_AXIS));
		
		panel_6 = new JPanel();
		panelRelacion.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		panelCopyRight_2 = new PanelCopyRight();
		panel_6.add(panelCopyRight_2);
		panelCopyRight_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}

}
