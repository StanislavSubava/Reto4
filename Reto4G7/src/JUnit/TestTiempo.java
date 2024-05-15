package JUnit;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

import TodoMenuAdmin.valorTiempo;

class TestTiempo {

	@Test
	public void testTiempo() {
		valorTiempo vt = new valorTiempo();
		assertNotNull(vt);
		
		vt.setFechaReproduccion(vt.getFechaReproduccion());
		
		
		
	}

}
