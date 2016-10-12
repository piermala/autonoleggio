package test;

import static org.junit.Assert.*;
import model.Persona;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.PersonaDao;

public class TestPersona {

	static PersonaDao persDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		persDao = new PersonaDao();
	}
	
	@Test 
	public void testPersonaDao(){
		assertNotNull(persDao);
	}

	@Test
	public void testCreazionePersona() {
		Persona p = persDao.aggiungiPersona("Mic", "Mgn", "MM57C7");
		assertNotNull(p);
	}
	
	@Test
	public void testTrovaPersona(){
		Persona p = persDao.trovaPersona("hh", "jj");
		assertNotNull(p);
	}

	@Test
	public void testModificaPersona(){
		Persona p = persDao.modificaPersona("Carmelinooooo", "M", "CHARBY", "M");
		assertNotNull(p);
	}
	
	@Test
	public void testEliminaPersona(){
		boolean eliminato = persDao.eliminaPersona("G", "M");
		assertTrue(eliminato);
	}
}
