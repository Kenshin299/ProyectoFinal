import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class DatosCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textfNombre;
	private JLabel lblNmero;
	private JTextField textfNumero;
	private JLabel lblDireccion;
	private JTextField textfDir;
	private Menu menu = new Menu();
	
	String url = "jdbc:mysql://127.0.0.1/restarantejava";
	String user = "root";
	
	

	/**
	 * Create the frame.
	 */
	public DatosCliente() {
		setResizable(false);
		setTitle("Datos - By Kemyl, Melwink, Cesar");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 387);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 17, 17));
		panel.setBounds(0, 0, 499, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 113, 61, 14);
		panel.add(lblNewLabel);
		
		textfNombre = new JTextField();
		textfNombre.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textfNombre.setBounds(135, 112, 303, 20);
		panel.add(textfNombre);
		textfNombre.setColumns(10);
		
		lblNmero = new JLabel("Número:");
		lblNmero.setForeground(Color.WHITE);
		lblNmero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNmero.setBackground(Color.WHITE);
		lblNmero.setBounds(64, 159, 61, 14);
		panel.add(lblNmero);
		
		textfNumero = new JTextField();
		textfNumero.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textfNumero.setColumns(10);
		textfNumero.setBounds(135, 158, 303, 20);
		panel.add(textfNumero);
		
		lblDireccion = new JLabel("Dirección:");
		lblDireccion.setForeground(Color.WHITE);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBackground(Color.WHITE);
		lblDireccion.setBounds(64, 206, 70, 14);
		panel.add(lblDireccion);
		
		textfDir = new JTextField();
		textfDir.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		textfDir.setColumns(10);
		textfDir.setBounds(145, 205, 293, 20);
		panel.add(textfDir);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textfNombre.getText().isBlank() && !textfNumero.getText().isBlank() && !textfDir.getText().isBlank()) {
					try {
						Connection conexion = DriverManager.getConnection (url, user, "");
						Class.forName("com.mysql.jdbc.Driver");
						System.out.println("Conexion a la Base de Datos exitosa");
						
						Statement statement = conexion.createStatement();
						statement.executeUpdate("INSERT INTO Cliente (Nombre, Telefono, Direccion)"
								+ "VALUES ('" + textfNombre.getText() + "', '" + textfNumero.getText() + "', '" + textfDir.getText()
								+ "')");
						conexion.close();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					menu.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(panel, "Complete todos los campos requeridos");
				}
			}
		});
		btnAcceder.setBackground(new Color(7, 132, 181));
		btnAcceder.setForeground(new Color(255, 255, 255));
		btnAcceder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAcceder.setBounds(184, 258, 131, 40);
		panel.add(btnAcceder);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(DatosCliente.class.getResource("/com/Icons/DatosCliente.jpg")));
		lblFondo.setBounds(0, 0, 500, 350);
		panel.add(lblFondo);
		
		lblFondo.setForeground(Color.WHITE);
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFondo.setBackground(Color.WHITE);
	}
}
