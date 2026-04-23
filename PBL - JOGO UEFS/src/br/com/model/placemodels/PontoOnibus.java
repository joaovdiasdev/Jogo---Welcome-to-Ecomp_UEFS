package br.com.model.placemodels;

import java.util.List;
import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

//Classe de ponto de ônibus, na qual os métodos só levam de casa->campus e campus->casa
public class PontoOnibus extends Places{
	
	private static final long serialVersionUID = 1L;

	public PontoOnibus(String nome, Pair posicao, List<Events> eventos) {
		super(nome, posicao, eventos);
	}
	
	public void goCasa(Player jogador, Home casa) {
		jogador.andar(casa.getPosicaoLocalPair());
	}
	
	public void goCampus(Player jogador, Campus faculdade) {
		jogador.andar(faculdade.getPosicaoLocalPair());
	}
}
