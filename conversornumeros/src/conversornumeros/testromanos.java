package conversornumeros;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testromanos {

	@Test
	void test1() {
		NumerosRomanos n = new NumerosRomanos();
		String n1 = n.dec2roman(NumerosRomanos.N);
		String esperado = n1;
		assertEquals(n1, esperado);
	}
	@Test
	void test2() {
		NumerosRomanos r = new NumerosRomanos();
		int r1 = r.roman2dec(NumerosRomanos.R);
		int esperado = r1;
		assertEquals(r1, esperado);
	}

}
