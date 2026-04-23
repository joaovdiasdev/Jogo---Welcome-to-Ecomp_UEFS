package br.com.model.placemodels;

import java.util.List;

import br.com.model.charactermodels.NPC;
import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

public class Colegiado extends Places{
	private static NPC maeli;
	
	public Colegiado(String nome, Pair posicao, List<Events> eventos) {
		super(nome, posicao, eventos);
		maeli = new NPC(nome, 35, getPosicaoLocalPair());
	}
	
	public void ajudarAluno(Player jogador) {
		maeli.dialogar();
	}
}
