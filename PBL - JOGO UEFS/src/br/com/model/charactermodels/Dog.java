package br.com.model.charactermodels;

import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

//Classe Dog, que herda de animal e aplica polimorfismo dos métodos de NPC
public class Dog extends Animal{
	
	private static final long serialVersionUID = 1L;

	public Dog(String nome, int idade, Pair posicao) {
		super(nome, idade, posicao);
	}
	
	public void dialogar() {
		System.out.println("Au au!");
	}
	
	public void motivar(Player jogador) {
		System.out.println("(Lambida)");
		jogador.getStatusJogador().somaMotivacao(3);
	}
	
	public void desmotivar(Player jogador) {
		System.out.println("(Mordida)");
		jogador.getStatusJogador().diffMotivacao(3);
		jogador.getStatusJogador().diffSaude(5);
	}
}
