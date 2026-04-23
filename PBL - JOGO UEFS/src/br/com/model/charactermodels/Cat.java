package br.com.model.charactermodels;

import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

//Classe Cat, que herda de animal e aplica polimorfismo de NPC
public class Cat extends Animal{
	private static final long serialVersionUID = 1L;

	public Cat(String nome, int idade, Pair posicao) {
		super(nome, idade, posicao);
	}
	
	public void dialogar() {
		System.out.println("Miau miau");
	}
	
	public void motivar(Player jogador) {
		System.out.println("(Ronrona)");
		jogador.getStatusJogador().somaMotivacao(5);
	}
	
	public void desmotivar(Player jogador) {
		System.out.println("(Arranhada)");
		jogador.getStatusJogador().diffMotivacao(3);
		jogador.getStatusJogador().diffSaude(5);
	}
}
