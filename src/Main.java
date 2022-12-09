public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatosCliente ventana = new DatosCliente();
			@SuppressWarnings("unused")
			Look look = new Look();
			ventana.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}