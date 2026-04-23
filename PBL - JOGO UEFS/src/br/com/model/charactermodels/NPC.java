package br.com.model.charactermodels;

import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

//Classe concreta de personagens não jogáveis, com métodos genéricos para serem aplicados com polimorfismo
public class NPC extends Characters {
	
	private static final long serialVersionUID = 1L;

	public NPC(String nome, int idade, Pair posicao) {
		super(nome, idade, posicao);
	}
	
	public void dialogar() {
		System.out.println("Bom dia, no que posso tentar te ajudar hoje?");
	}

	public void motivar(Player jogador) {
		System.out.println("Vou ver se eu consigo te ajudar!");
	}

	public void desmotivar(Player jogador) {
		System.out.println("Sinto muito, não há nada que eu possa fazer, infelizmente.");
	}
	
}
