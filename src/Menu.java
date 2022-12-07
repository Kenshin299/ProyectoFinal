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
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 17, 17));
		panel.setBounds(0, 0, 518, 577);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrAsdasdAssad = new JTextArea();
		txtrAsdasdAssad.setText("Comida 1\r\nComida 2\r\nComida 3\r\n\r\nBebida 1\r\nBedida 2");
		txtrAsdasdAssad.setEditable(false);
		txtrAsdasdAssad.setBounds(97, 136, 159, 121);
		panel.add(txtrAsdasdAssad);
		
		JTextArea txtrComidaComida = new JTextArea();
		txtrComidaComida.setText("Comida 1\r\nComida 2\r\nComida 3\r\n\r\nBebida 1\r\nBedida 2");
		txtrComidaComida.setEditable(false);
		txtrComidaComida.setBounds(300, 136, 159, 121);
		panel.add(txtrComidaComida);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setText("Comida 1\r\nComida 2\r\nComida 3\r\n\r\nBebida 1\r\nBedida 2");
		textArea_1_1.setEditable(false);
		textArea_1_1.setBounds(179, 292, 159, 121);
		panel.add(textArea_1_1);
		
		JButton btnDesayuno = new JButton("Desayuno");
		btnDesayuno.setBackground(new Color(7, 132, 181));
		btnDesayuno.setForeground(Color.WHITE);
		btnDesayuno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDesayuno.setBounds(107, 98, 129, 27);
		panel.add(btnDesayuno);
		
		JButton btnAlmuerzo = new JButton("Almuerzo");
		btnAlmuerzo.setBackground(new Color(7, 132, 181));
		btnAlmuerzo.setForeground(Color.WHITE);
		btnAlmuerzo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAlmuerzo.setBounds(314, 98, 127, 27);
		panel.add(btnAlmuerzo);
		
		JButton btnCena = new JButton("Cena");
		btnCena.setBackground(new Color(7, 132, 181));
		btnCena.setForeground(Color.WHITE);
		btnCena.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCena.setBounds(207, 439, 103, 27);
		panel.add(btnCena);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/com/Icons/WhatsApp Image 2022-12-06 at 22.18.35.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 518, 576);
		panel.add(lblNewLabel_1);
	}
}
