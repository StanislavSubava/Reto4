package JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import TodoMenuAdmin.Reproducion;

class TestReproducion {

	@Test
    public void testReproducion() {
		Reproducion reproducion = new Reproducion();
		assertNotNull(reproducion);
		
		// Verificar los métodos setters y getters
		reproducion.setIDCliente(reproducion.getIDCliente());
		reproducion.setIDAudio(reproducion.getIDAudio());
		reproducion.setNombreA(reproducion.getNombreA());
		reproducion.setFechaReproduccion(reproducion.getFechaReproduccion());
		reproducion.setVecesReproducida(reproducion.getVecesReproducida());
		reproducion.setTipo(reproducion.getTipo());
	
		
		
	}

}
