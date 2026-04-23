package br.com.model.operational;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	private Pair origem;
	private List<Pair> posicoesGrid;
	
	public Grid() {
		origem = new Pair(0, 0);
		posicoesGrid = new ArrayList<Pair>();
		posicoesGrid.add(0, origem);
		
	}
	
	public Pair getPosicao(Pair posicaoPair) {
		return posicaoPair;
	}
	
	public void adicionarPosicao(Pair posicao) {
		posicoesGrid.add(posicao);
		
	}
}
