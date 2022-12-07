import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Menu() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 737);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 17, 17));
		panel.setBounds(0, 0, 630, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDesayuno = new JButton("Desayuno");
		btnDesayuno.setBackground(new Color(7, 132, 181));
		btnDesayuno.setForeground(Color.WHITE);
		btnDesayuno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDesayuno.setBounds(90, 317, 168, 61);
		panel.add(btnDesayuno);
		
		JButton btnAlmuerzo = new JButton("Almuerzo");
		btnAlmuerzo.setBackground(new Color(7, 132, 181));
		btnAlmuerzo.setForeground(Color.WHITE);
		btnAlmuerzo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAlmuerzo.setBounds(370, 317, 168, 61);
		panel.add(btnAlmuerzo);
		
		JButton btnCena = new JButton("Cena");
		btnCena.setBackground(new Color(7, 132, 181));
		btnCena.setForeground(Color.WHITE);
		btnCena.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCena.setBounds(226, 597, 168, 61);
		panel.add(btnCena);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/com/Icons/BienvMenu.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 630, 700);
		panel.add(lblNewLabel_1);
	}
}
