package TodoMenuAdmin;


/**
 * Clase para los objetos de canciones, con sus atributos
 */

public class Cancion {
	private int id;
    private String nombre;
    private String duracion;
    private String Tipo;
  	
    public Cancion() {
    	
    }
    
	public Cancion(int id, String nombre, String duracion, String Tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.duracion = duracion;
		this.Tipo= Tipo;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}
	
	
	
    
}
