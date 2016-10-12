package utility;

import model.*;
import dao.*;

public class GestioneServizio {

	
	/// AGGIUNGI MACCHINA
	public Macchina aggiungiMacchina(String modello, String targa){
		
		Macchina m = null;
		MacchinaDao macchinaDao = new MacchinaDao();
		
		m = macchinaDao.aggiungiMacchina(modello, targa);				
				
		return m;		
	}
	
	
	/// AGGIUNGI PERSONA
	
}
