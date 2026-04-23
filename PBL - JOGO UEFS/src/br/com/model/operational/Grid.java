package br.com.model.operational;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Entrando nas classes operacionais, temos o tabueleiro, que possui uma origem (a casa do jogador) e um array qye guarda outras localizações

//Possui um construtor, um getter e uma função de adicionar posicao no array
public class Grid implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
