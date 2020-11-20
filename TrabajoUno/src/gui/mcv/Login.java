package gui.mcv;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import gui.Modelo;
import util.Util;
/**
 * Clase Login, su funcionalidad es comprobar que el usuario y contraseña sean correctos para poder acceder al sistema de gestión de carreras
 * @author Susana
 *
 */
public class Login extends JFrame{
	/**
	 * Atributos de la clase Login
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JButton btnAcceder;

	/**
	 * Construyo el frame Login
	 */
	public Login() {
		
		initComponents();
		initHanderls();
	}
	
	/**
	 * Método que almacena todos los componentes gráficos del frame
	 */
	public void initComponents() {
		setTitle("Gesti\u00F3n de Atletismo 2020");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/corriendo.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 438, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(new EmptyBorder(45, 0, 0, 0));
		panel.add(panelTop, BorderLayout.NORTH);
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon(Login.class.getResource("/img/usuario (3).png")));
		panelTop.add(lblIcono);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(59, 30, 20, 30));
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_3.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Arial", Font.PLAIN, 13));
		panel_3.add(txtUser);
		txtUser.setColumns(12);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_4.add(lblNewLabel_1);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Arial", Font.PLAIN, 13));
		txtPass.setColumns(12);
		panel_4.add(txtPass);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(panel_2);
		
		btnAcceder = new JButton("Acceder");
		
		btnAcceder.setFont(new Font("Arial", Font.PLAIN, 14));
		panel_2.add(btnAcceder);
	}
	
	/**
	 * Método que almacena los eventos y los gestiona
	 */
	public void initHanderls() {
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=txtUser.getText();
				String pass = String.valueOf(txtPass.getPassword());
				if((user.equals( "admin" )&& pass.equals( "admin" )) || user.equals("susana") && pass.equals("susana") ) {
					
					Vista vista = new Vista();
					Modelo modelo = new Modelo();
					@SuppressWarnings("unused")
					Controlador controlador = new Controlador(modelo, vista);
					vista.setVisible(true);
					vista.setLocationRelativeTo(null);
					dispose(); 
				}else {
					JOptionPane.showMessageDialog(null,"Usuario / Contraseña incorrecta", "Login", JOptionPane.ERROR_MESSAGE);
					txtUser.setText("");
					txtPass.setText("");
				}
			}
			
		});
		
		this.addWindowListener(new WindowListener() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int opt = Util.mostrarDialogoSiNo("¿Desea cerrar la aplicación");
				if(opt == Util.ACEPTAR) {
					dispose();
				}
			}
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
