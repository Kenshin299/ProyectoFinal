import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MenuDesayuno extends JPanel implements CambiarPanel {
	String url = "jdbc:mysql://127.0.0.1/restarantejava";
	String user = "root";
	double total = 0;
	double total1 = 0;
	double total2 = 0;
	double total3 = 0;
	
	private double monto;

	/**
	 * Create the panel.
	 */
	public MenuDesayuno() {
		
		setBackground(new Color(17, 17, 17));
		setBounds(0, 0, 630, 700);
		setLayout(null);
		
		Menu menu = new Menu();
		
		String[] pPrincipales = {"Huevos Estrellados",
							"Huevos Benedict",
							"Huevos con Tocino",
							"Tostada de Aguacate",
							"Tostada Francesa"};
		
		String[] pSecundarios = {"Pan Cakes",
				"Mangu de Platano Verde",
				"Puré de Papas"};
		
		String[] pAñadidos = {"Salsa de Arandanos", 
				"Miel", 
				"Maple Syrup", 
				"Ketchup", 
				"Mayonesa"};
		
		String[] pBebidas = {"Jugo de Naranja", 
				"Café Negro", 
				"Café con Leche", 
				"Chocolate Caliente", 
				"Agua"};
		
		HashMap<String, Double> principalDesayuno = new HashMap<String, Double>(); 
		principalDesayuno.put(pPrincipales[0], 200.30);
		principalDesayuno.put(pPrincipales[1], 100.00);
		principalDesayuno.put(pPrincipales[2], 150.00);
		principalDesayuno.put(pPrincipales[3], 60.00);
		principalDesayuno.put(pPrincipales[4], 80.00);

		HashMap<String, Double> secundarioDesayuno = new HashMap<String, Double>(); 
		secundarioDesayuno.put(pSecundarios[0], 300.00);
		secundarioDesayuno.put(pSecundarios[1], 175.00);
		secundarioDesayuno.put(pSecundarios[2], 160.00);
		
		HashMap<String, Double> añadidosDesayuno = new HashMap<String, Double>(); 
		añadidosDesayuno.put(pAñadidos[0], 50.00);
		añadidosDesayuno.put(pAñadidos[1], 30.00);
		añadidosDesayuno.put(pAñadidos[2], 60.00);
		añadidosDesayuno.put(pAñadidos[3], 20.00);
		añadidosDesayuno.put(pAñadidos[4], 20.00);
		
		HashMap<String, Double> bebidasDesayuno = new HashMap<String, Double>(); 
		bebidasDesayuno.put(pBebidas[0], 80.00);
		bebidasDesayuno.put(pBebidas[1], 55.00);
		bebidasDesayuno.put(pBebidas[2], 70.00);
		bebidasDesayuno.put(pBebidas[3], 65.00);
		bebidasDesayuno.put(pBebidas[4], 35.00);
		
		double[] preciosPrincipales = {0, 200.30,
										100.00,
										150.00,
										60.00,
										80.00};
		double[] preciosSecundarios = {0, 300.00,
				175.00,
				160.00};
		
		double[] preciosAnadidos = {0, 50.00,
				 30.00,
				 60.00,
				 20.00,
				 20.00};
		
		double[] preciosBebidas = {0, 80.00,
				 55.00,
				 70.00,
				 65.00,
				 35.00};
		
		JTextField txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setToolTipText("Bebidas");
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTotal.setBounds(313, 474, 266, 44);
		add(txtTotal);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotal.setBounds(50, 475, 213, 54);
		add(lblTotal);
		
		JComboBox comboBoxPPrincipal = new JComboBox();
		comboBoxPPrincipal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				total = preciosPrincipales[comboBoxPPrincipal.getSelectedIndex()];
				txtTotal.setText(total + "");
			}
		});
		comboBoxPPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxPPrincipal.setToolTipText("Plato Principal");
		comboBoxPPrincipal.setModel(new DefaultComboBoxModel(new String[] {"",
				"Huevos Estrellados $" + principalDesayuno.get(pPrincipales[0]), 
				"Huevos Benedict $" + principalDesayuno.get(pPrincipales[1]), 
				"Huevos con Tocino $" + principalDesayuno.get(pPrincipales[2]), 
				"Tostada de Aguacate $" + principalDesayuno.get(pPrincipales[3]), 
				"Tostada Francesa $" + principalDesayuno.get(pPrincipales[4])}));
		comboBoxPPrincipal.setBounds(313, 177, 266, 44);
		add(comboBoxPPrincipal);
		
		JComboBox comboBoxPSecundario = new JComboBox();
		comboBoxPSecundario.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				total1 = preciosSecundarios[comboBoxPSecundario.getSelectedIndex()];
				txtTotal.setText(total + total1 + "");
			}
		});
		comboBoxPSecundario.setModel(new DefaultComboBoxModel(new String[] {"", 
				"Pan Cakes $" + secundarioDesayuno.get(pSecundarios[0]), 
				"Mangu de Platano Verde $" + secundarioDesayuno.get(pSecundarios[1]), 
				"Puré de Papas $" + secundarioDesayuno.get(pSecundarios[2])}));
		comboBoxPSecundario.setToolTipText("Plato Secundario");
		comboBoxPSecundario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxPSecundario.setBounds(313, 252, 266, 44);
		add(comboBoxPSecundario);
		
		JComboBox comboBoxAnadidos = new JComboBox();
		comboBoxAnadidos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				total2 = preciosAnadidos[comboBoxAnadidos.getSelectedIndex()];
				txtTotal.setText(total + total1 + total2 + "");
			}
		});
		comboBoxAnadidos.setToolTipText("Añadidos");
		comboBoxAnadidos.setModel(new DefaultComboBoxModel(new String[] {"", 
				"Salsa de Arandanos $" + añadidosDesayuno.get(pAñadidos[0]), 
				"Miel $" + añadidosDesayuno.get(pAñadidos[1]), 
				"Maple Syrup $" + añadidosDesayuno.get(pAñadidos[2]), 
				"Ketchup $" + añadidosDesayuno.get(pAñadidos[3]), 
				"Mayonesa $" + añadidosDesayuno.get(pAñadidos[4])}));
		comboBoxAnadidos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxAnadidos.setBounds(313, 334, 266, 44);
		add(comboBoxAnadidos);
		
		JComboBox comboBoxBebidas = new JComboBox();
		comboBoxBebidas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				total3 = preciosBebidas[comboBoxBebidas.getSelectedIndex()];
				txtTotal.setText(total + total1 + total2 + total3 + "");
			}
		});
		comboBoxBebidas.setModel(new DefaultComboBoxModel(new String[] {"", 
				"Jugo de Naranja $" + bebidasDesayuno.get(pBebidas[0]), 
				"Café Negro $" + bebidasDesayuno.get(pBebidas[1]), 
				"Café con Leche $" + bebidasDesayuno.get(pBebidas[2]), 
				"Chocolate Caliente $" + bebidasDesayuno.get(pBebidas[3]), 
				"Agua $"+ bebidasDesayuno.get(pBebidas[4])
				}));
		comboBoxBebidas.setToolTipText("Bebidas");
		comboBoxBebidas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBoxBebidas.setBounds(313, 410, 266, 44);
		add(comboBoxBebidas);
		
		JLabel lblSeleccioneLasComidas = new JLabel("Seleccione las comidas:");
		lblSeleccioneLasComidas.setForeground(Color.WHITE);
		lblSeleccioneLasComidas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSeleccioneLasComidas.setBounds(208, 103, 213, 54);
		add(lblSeleccioneLasComidas);
		
		JLabel lblPlatoPrincipal = new JLabel("Plato Principal:");
		lblPlatoPrincipal.setForeground(Color.WHITE);
		lblPlatoPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlatoPrincipal.setBounds(50, 172, 213, 54);
		add(lblPlatoPrincipal);
		
		JLabel lblPlatoPrincipal_1 = new JLabel("Plato Secundario:");
		lblPlatoPrincipal_1.setForeground(Color.WHITE);
		lblPlatoPrincipal_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlatoPrincipal_1.setBounds(50, 242, 213, 54);
		add(lblPlatoPrincipal_1);
		
		JLabel lblPlatoPrincipal_1_1 = new JLabel("Añadidos:");
		lblPlatoPrincipal_1_1.setForeground(Color.WHITE);
		lblPlatoPrincipal_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlatoPrincipal_1_1.setBounds(50, 324, 213, 54);
		add(lblPlatoPrincipal_1_1);
		
		JLabel lblPlatoPrincipal_1_2 = new JLabel("Bebidas:");
		lblPlatoPrincipal_1_2.setForeground(Color.WHITE);
		lblPlatoPrincipal_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlatoPrincipal_1_2.setBounds(50, 410, 213, 54);
		add(lblPlatoPrincipal_1_2);
		
		monto = total + total1 + total2 + total3;
		
		JButton btnNewButton = new JButton("<- Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(menu.panel);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(50, 601, 140, 54);
		add(btnNewButton);
		
		JButton btnContinuar = new JButton("Continuar ->");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orden orden = new Orden();
				try {
					Connection conexion = DriverManager.getConnection (url,user,"");
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Conexion a la Base de Datos exitosa");
					
					Statement statement = conexion.createStatement(); 
					statement.executeUpdate("UPDATE Cliente SET Monto = '" + monto + "' WHERE IdCliente = (SELECT MAX(IdCliente) FROM Cliente)");
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				cambiarPanel(orden);
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnContinuar.setBounds(418, 601, 161, 54);
		add(btnContinuar);
		
		JLabel imgFondo = new JLabel("");
		imgFondo.setIcon(new ImageIcon(MenuDesayuno.class.getResource("/com/Icons/MenuDesayuno.jpg")));
		imgFondo.setForeground(Color.WHITE);
		imgFondo.setFont(new Font("Tahoma", Font.BOLD, 18));
		imgFondo.setBounds(0, 0, 630, 700);
		add(imgFondo);
		
	

	}
	
	public double getMonto() {
		return monto;
	}

	@Override
	public void cambiarPanel(JPanel p) {
		// TODO Auto-generated method stub
		p.setLocation(0, 0);
		removeAll();
		repaint();
		revalidate();
		add(p);
	}

	
}
