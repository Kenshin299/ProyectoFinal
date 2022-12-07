public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatosCliente ventana = new DatosCliente();
			Look look = new Look();
			ventana.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}