package br.com.model.charactermodels;

import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

public class NPC extends Characters {
	
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
