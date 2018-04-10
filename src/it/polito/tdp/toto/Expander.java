package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Expander {                   //classe che contiene algoritmo di espansione
	
	private List<Schedina> soluzione ; 

	public List<Schedina> expand(Pronostico p) {                  //restituisce schedina ricevendo come parametro un pronostico - FUNZIONE CHE CHIAMA LA RICORSIONE
		
		soluzione = new ArrayList<Schedina>() ;
		
		cerca(new Schedina(p.getN()), p, 0) ;
		
		return soluzione;
	}

	private void cerca(Schedina parziale, Pronostico p, int livello) {        //METODO RICORSIVO
		
		if(livello==p.getN()) {
			// caso terminale => ho una soluzione completa
			soluzione.add(new Schedina(parziale)) ;
			return ;
		}
		
		Previsione mosse = p.get(livello) ;
		for( Risultato mossa : mosse.getValori() ) {
			parziale.add(mossa); // prova la soluzione
			cerca(parziale, p, livello+1) ;                                  //ricorsione
			parziale.removeLast(); // backtrack
		}

	}
	
	/*
	Problema parziale: Schedina 1-X, livello 2
	Devo guardare pronostico p(2). Supponiamo sia X2
	Allora genererò le nuove soluzioni parziali 1-X-X, 1-X-2
	*/
}
