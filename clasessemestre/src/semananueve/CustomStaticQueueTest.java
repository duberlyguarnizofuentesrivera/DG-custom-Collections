package semananueve;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStaticQueueTest {
	CustomStaticQueue<String> csq;
	CustomStaticQueue<Integer> csq2;

	@BeforeEach
	void prepararTest() {
		csq = new CustomStaticQueue(String.class, 4);
		csq2 = new CustomStaticQueue(Integer.class, 3);
	}

	@Test
	void testConstructor() {
		Assert.assertNotNull(csq);
		assertEquals(4, csq.lenght());
	}

	@Test
	void testAgregar() {
		try {
			csq.agregar("Hola");
			csq.agregar("Mundo");
		}
		catch (Exception e) {
			// pass
		}
		finally {
			assertEquals("Hola", csq.consultar(0));
			assertEquals("Mundo", csq.consultar(1));
			Assert.assertNull(csq.consultar(2));
		}

	}

	@Test
	void testSacar() {
		try {
			csq2.agregar(4);
			csq2.agregar(3);
			csq2.agregar(2);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			assertEquals(4, csq2.sacar());
			assertEquals(3, csq2.sacar());
			assertEquals(2, csq2.consultar(0));
		}

	}

	@Test
	void testAgregarCuandoNoHayMasEspacios() {
		try {
			csq.agregar("Uno");
			csq.agregar("dos");
			csq.agregar("tres");
			csq.agregar("cuatro");
			csq.agregar("cinco");
		}
		catch (Exception e) {
			assertTrue(e.getMessage().contains("Sin espacio en la cola"));
		}
	}

}
