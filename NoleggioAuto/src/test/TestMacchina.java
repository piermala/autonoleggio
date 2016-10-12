package test;

import static org.junit.Assert.*;
import model.Macchina;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.MacchinaDao;

public class TestMacchina {

	static MacchinaDao mDao;
	
	@BeforeClass
	public static void setBeforeClass(){
		mDao = new MacchinaDao();
		assertNotNull(mDao);
	}
	
	
	@Test
	public void testMacchinaDao() {
		assertNotNull(mDao);
	}
	
	@Test
	public void testAggiungiMacchina() {
		Macchina m = mDao.aggiungiMacchina("Opel", "BG312BX");
		assertNotNull(m);
	}
	
	@Test
	public void testTrovaMacchina() {
		Macchina m = mDao.trovaMacchina("Audi", "BX112YT");
		assertNotNull(m);
	}
	
	@Test
	public void testModificaMacchina() {
		Macchina m = mDao.modificaMacchina("Audi", "BX112YT", "AudiA4", "BY112YT");
		assertNotNull(m);
	}
	
	@Test
	public void testEliminaMacchina() {
		boolean eliminata = mDao.eliminaMacchina("Alfa", "UG209OG");
		assertTrue(eliminata);
	}

}
