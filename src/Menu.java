import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements CambiarPanel{

	private JPanel contentPane;
	public JPanel panel;
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
		
		panel = new JPanel();
		panel.setBackground(new Color(17, 17, 17));
		panel.setBounds(0, 0, 630, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnDesayuno = new JButton("Desayuno");
		btnDesayuno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDesayuno panelD = new MenuDesayuno();
				cambiarPanel(panelD);
			}
		});
		btnDesayuno.setBackground(new Color(64, 128, 128));
		btnDesayuno.setForeground(new Color(255, 255, 255));
		btnDesayuno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDesayuno.setBounds(90, 317, 168, 61);
		panel.add(btnDesayuno);
		
		JButton btnAlmuerzo = new JButton("Almuerzo");
		btnAlmuerzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAlmuerzo panelA = new MenuAlmuerzo();
				cambiarPanel(panelA);
			}
		});
		btnAlmuerzo.setBackground(new Color(64, 128, 128));
		btnAlmuerzo.setForeground(new Color(255, 255, 255));
		btnAlmuerzo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAlmuerzo.setBounds(370, 317, 168, 61);
		panel.add(btnAlmuerzo);
		
		JButton btnCena = new JButton("Cena");
		btnCena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCena panelC = new MenuCena();
				cambiarPanel(panelC);
			}
		});
		btnCena.setBackground(new Color(64, 128, 128));
		btnCena.setForeground(new Color(255, 255, 255));
		btnCena.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCena.setBounds(226, 597, 168, 61);
		panel.add(btnCena);
		
		JLabel imgFondo = new JLabel("");
		imgFondo.setIcon(new ImageIcon(Menu.class.getResource("/com/Icons/BienvMenujpg.jpg")));
		imgFondo.setBounds(0, 0, 630, 700);
		panel.add(imgFondo);
	}
	@Override
	public void cambiarPanel(JPanel p) {
		p.setLocation(0, 0);
		
		panel.removeAll();
		panel.add(p);
		panel.revalidate();
		panel.repaint();
		
	}
}
