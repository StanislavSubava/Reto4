package JUnit;


import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import TodoMenuAdmin.Cancion;

public class TestCancion {

	@Test
	public void testCancion() {
		Cancion cancion = new Cancion();
		assertNotNull(cancion);
		
		// Verificar los métodos setters y getters
		cancion.setId(cancion.getId());
		cancion.setNombre(cancion.getNombre());
		cancion.setDuracion(cancion.getDuracion());
		cancion.setTipo(cancion.getTipo());
	}

}
