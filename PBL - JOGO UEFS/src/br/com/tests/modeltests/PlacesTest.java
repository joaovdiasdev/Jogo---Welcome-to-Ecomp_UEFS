package br.com.tests.modeltests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import br.com.model.eventmodels.Achievements;
import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;
import br.com.model.placemodels.Campus;
import br.com.model.placemodels.Home;
import br.com.model.placemodels.Sala;
import br.com.model.playermodels.Player;

class PlacesTest {
	private Player jogadorPlayer = new Player("João Victor", 19);
	private Home casaHome = new Home("Casa", new Pair(0, 0), null);
	private Campus faculdade = new Campus("UEFS", new Pair(15, 30), null);
	private Achievements conquista = new Achievements("Primeira prova", 10, 2, 5, new Random());
	private List<Events> listaEvents = new ArrayList<Events>();
	private Sala sala = new Sala("Pat59", new Pair(30, 45), listaEvents, null, null, null);
	

	@Test
	public void testDeslocamento() { //Testagem de deslocamento do jogador
		int soma = 0;
		jogadorPlayer.andar(casaHome.getPosicaoLocalPair());
		soma += casaHome.getPosicaoLocalPair().getX() + casaHome.getPosicaoLocalPair().getY();
		jogadorPlayer.andar(faculdade.getPosicaoLocalPair());
		soma += faculdade.getPosicaoLocalPair().getX() + faculdade.getPosicaoLocalPair().getY();
		assertNotEquals(0, soma);
	}
	
	@Test
	public void testEventos() { //Testagem de eventos aleatórios do jogador
		listaEvents.add(conquista);
		jogadorPlayer.andar(faculdade.getPosicaoLocalPair());
		jogadorPlayer.andar(sala.getPosicaoLocalPair());
		int auraAtual = jogadorPlayer.getStatusJogador().getMotivacaoInt();
		Achievements evento = (Achievements) sala.getEvento(conquista);
		evento.conquista(jogadorPlayer);
		assertNotEquals(auraAtual, jogadorPlayer.getStatusJogador().getMotivacaoInt());
		
	}

}
