import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class Orden extends JPanel implements CambiarPanel {
	
	String url = "jdbc:mysql://127.0.0.1/restarantejava";
	String user = "root";
	MenuDesayuno menu = new MenuDesayuno();
	double pagar = menu.getMonto();
	
	/**
	 * Create the panel.
	 */
	public Orden() {
		setBackground(new Color(17, 17, 17));
		setBounds(0, 0, 630, 700);
		setLayout(null);
		
		
		
		JLabel lbOrden = new JLabel("Confirmación de Factura");
		lbOrden.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbOrden.setForeground(new Color(255, 255, 255));
		lbOrden.setBounds(175, 38, 297, 54);
		add(lbOrden);
		
		JTextPane txtpnOrden = new JTextPane();
		txtpnOrden.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnOrden.setBounds(95, 127, 444, 446);
		add(txtpnOrden);
		String nombre = null;
		String telefono = null;
		String direccion = null;
		String monto = null;
		
		try {
			Connection conexion = DriverManager.getConnection (url,user,"");
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Conexion a la Base de Datos exitosa");
			
			Statement statement = conexion.createStatement(); 
			ResultSet rs = statement.executeQuery("SELECT * FROM Cliente ORDER BY IdCliente DESC LIMIT 1");
			while (rs.next()) {
				nombre = rs.getString("Nombre");
				telefono = rs.getString("Telefono");
				direccion = rs.getString("Direccion");
				monto = rs.getString("Monto");
			}
			ResultSet rs1 = statement.executeQuery("SELECT Monto FROM Cliente ORDER BY IdCliente DESC LIMIT 1");
			while (rs1.next()) {
				monto = rs1.getString("Monto");
			}
			System.out.print(monto);
			System.out.print(pagar);
			conexion.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		txtpnOrden.setText("************************************************" +
           "\n\t       Restaurante\t" +
           "\n************************************************" +
           "\n Nombre:- " + nombre +
           "\n Numero de telefono:- " + telefono +
           "\n Direccion:- " + direccion +
           "\n************************************************" +
           "\n  Total a Pagar: " + monto + pagar);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu();
				cambiarPanel(menu.panel);
			}
		});
		btnNewButton.setBackground(new Color(64, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(46, 621, 144, 48);
		add(btnNewButton);
		
		
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(txtpnOrden, "Orden, confirmada\n" + "Pedido Realizado");
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirmar.setBackground(new Color(64, 128, 128));
		btnConfirmar.setBounds(435, 621, 144, 48);
		add(btnConfirmar);
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
