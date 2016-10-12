package utility;

import model.Macchina;

public class Main {

	static GestioneServizio gs;
	
	public static void main(String[] args) {
		
		gs = new GestioneServizio(); 
		
		/// AGGIUNGI MACCHINA
		Macchina m1 = gs.aggiungiMacchina("Fiat", "TO643TO");
		System.out.println(m1);
		
		Macchina m2 = gs.aggiungiMacchina("Alfa", "UG209OG");
		System.out.println(m2);
		
		Macchina m3 = gs.aggiungiMacchina("Fiat", "TO643TO");
		System.out.println(m3);
	}
}
