package br.com.model.placemodels;

import java.util.List;

import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

public class Home extends Places{
	public Home(String nome, Pair posicao, List<Events> eventos) {
		super(nome, posicao, eventos);
	}
	
	public void dormir(Player jogador) {
		jogador.getStatusJogador().somaEnergia(100 - jogador.getStatusJogador().getEnergiaInt());
		jogador.getStatusJogador().somaMotivacao(100 - jogador.getStatusJogador().getMotivacaoInt());
	}
	
	public void estudar(Player jogador) {
		jogador.getStatusJogador().somaXp(jogador.getStatusJogador().getXpInt() + 1);
		jogador.getStatusJogador().diffEnergia(jogador.getStatusJogador().getEnergiaInt() - 1);
	}
}
