package TodoMenuAdmin;

/**
 * Clase para los objetos de Reproducion, con sus atributos
 */

public class Reproducion {
	private String IDCliente;
	private String IDAudio;
	private String nombre;
	private String FechaReproduccion;
	private String VecesReproducida;
	private String Tipo;

	public Reproducion() {

	}

	public Reproducion(String iDCliente, String iDAudio, String nombre, String fechaReproduccion,
			String vecesReproducida, String tipo) {
		super();
		IDCliente = iDCliente;
		IDAudio = iDAudio;
		this.nombre = nombre;
		FechaReproduccion = fechaReproduccion;
		VecesReproducida = vecesReproducida;
		Tipo = tipo;
	}

	public String getIDCliente() {
		return IDCliente;
	}

	public void setIDCliente(String iDCliente) {
		IDCliente = iDCliente;
	}

	public String getIDAudio() {
		return IDAudio;
	}

	public void setIDAudio(String iDAudio) {
		IDAudio = iDAudio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaReproduccion() {
		return FechaReproduccion;
	}

	public void setFechaReproduccion(String fechaReproduccion) {
		FechaReproduccion = fechaReproduccion;
	}

	public String getVecesReproducida() {
		return VecesReproducida;
	}

	public void setVecesReproducida(String vecesReproducida) {
		VecesReproducida = vecesReproducida;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

}
