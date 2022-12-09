import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class MenuCena extends JPanel implements CambiarPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url = "jdbc:mysql://127.0.0.1/restarantejava";
	String user = "root";
	double total = 0;
	double total1 = 0;
	double total2 = 0;
	double total3 = 0;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MenuCena() {
		setBackground(new Color(17, 17, 17));
		setBounds(0, 0, 630, 700);
		setLayout(null);
		
		Menu menu = new Menu();
		
		String[] pPrincipales = {"Churrasco",
				"Caldo de Pollo",
				"Salchicha a la parrilla",
				"Cheeseburguer con Tocino",
				"Spaghetti a la Bolognesa",
				"Fritos con salami"};

		String[] pSecundarios = {"Papas Fritas",
			"Tostones",
			"Croquetas de Pollo"};
		
		String[] pAñadidos = {"Ketchup", 
			"Mayonesa"};
		
		String[] pBebidas = {"Jugo de Naranja", 
			"Refresco de Frambuesa", 
			"Cerveza", 
			"Agua Saborizada", 
			"Agua"};
		
		HashMap<String, Double> principalAlmuerzo = new HashMap<String, Double>(); 
		principalAlmuerzo.put(pPrincipales[0], 800.30);
		principalAlmuerzo.put(pPrincipales[1], 270.00);
		principalAlmuerzo.put(pPrincipales[2], 450.00);
		principalAlmuerzo.put(pPrincipales[3], 560.00);
		principalAlmuerzo.put(pPrincipales[4], 375.00);
		principalAlmuerzo.put(pPrincipales[5], 325.00);
		
		HashMap<String, Double> secundarioAlmuerzo = new HashMap<String, Double>(); 
		secundarioAlmuerzo.put(pSecundarios[0], 100.00);
		secundarioAlmuerzo.put(pSecundarios[1], 100.00);
		secundarioAlmuerzo.put(pSecundarios[2], 80.00);
		
		HashMap<String, Double> añadidosAlmuerzo = new HashMap<String, Double>(); 
		añadidosAlmuerzo.put(pAñadidos[0], 40.00);
		añadidosAlmuerzo.put(pAñadidos[1], 40.00);
		
		HashMap<String, Double> bebidasAlmuerzo = new HashMap<String, Double>(); 
		bebidasAlmuerzo.put(pBebidas[0], 100.00);
		bebidasAlmuerzo.put(pBebidas[1], 50.00);
		bebidasAlmuerzo.put(pBebidas[2], 250.00);
		bebidasAlmuerzo.put(pBebidas[3], 65.00);
		bebidasAlmuerzo.put(pBebidas[4], 35.00);
		
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
				"Churrasco $" + principalAlmuerzo.get(pPrincipales[0]),
				"Caldo de Pollo $" + principalAlmuerzo.get(pPrincipales[1]),
				"Salchicha a la parrilla $" + principalAlmuerzo.get(pPrincipales[2]),
				"Cheeseburguer con Tocino $" + principalAlmuerzo.get(pPrincipales[3]),
				"Spaghetti a la Bolognesa $" + principalAlmuerzo.get(pPrincipales[4]),
				"Fritos con salami $" + principalAlmuerzo.get(pPrincipales[5])
				}));
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
			"Papas Fritas $" + secundarioAlmuerzo.get(pSecundarios[0]), 
			"Tostones $" + secundarioAlmuerzo.get(pSecundarios[1]), 
			"Croquetas de Pollo $" + secundarioAlmuerzo.get(pSecundarios[2])
			}));
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
			"Ketchup $" + añadidosAlmuerzo.get(pAñadidos[0]), 
			"Mayonesa $" + añadidosAlmuerzo.get(pAñadidos[1]), 
			}));
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
			"Jugo de Naranja $" + bebidasAlmuerzo.get(pBebidas[0]), 
			"Refresco de Frambuesa $" + bebidasAlmuerzo.get(pBebidas[1]), 
			"Cerveza $" + bebidasAlmuerzo.get(pBebidas[2]), 
			"Agua Saborizada $" + bebidasAlmuerzo.get(pBebidas[3]), 
			"Agua $"+ bebidasAlmuerzo.get(pBebidas[4])
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
				double monto = total + total1 + total2 + total3;
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
		imgFondo.setIcon(new ImageIcon(MenuCena.class.getResource("/com/Icons/MenuCena.jpg")));
		imgFondo.setForeground(Color.WHITE);
		imgFondo.setFont(new Font("Tahoma", Font.BOLD, 18));
		imgFondo.setBounds(0, 0, 630, 700);
		add(imgFondo);

	}

	@Override
	public void cambiarPanel(JPanel p) {
		// TODO Auto-generated method stub
		p.setLocation(0, 0);
		
		removeAll();
		add(p);
		revalidate();
		repaint();	
		
	}
}



