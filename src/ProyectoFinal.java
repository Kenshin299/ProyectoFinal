import javax.swing.JFrame;

public class ProyectoFinal {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatosCliente ventana = new DatosCliente();
			ventana.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}