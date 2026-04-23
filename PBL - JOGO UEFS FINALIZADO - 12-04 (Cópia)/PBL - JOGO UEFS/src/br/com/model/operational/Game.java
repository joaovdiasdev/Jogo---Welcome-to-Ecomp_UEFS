package br.com.model.operational;
	
import java.util.ArrayList;
import java.util.List;

import br.com.model.gamesupermodels.Item;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.placemodels.Places;
import br.com.model.playermodels.Player;

public class Game {
	private List<Character> listaPersonagens;
	private Player jogador;
	private List<Places> listaLugares;
	private List<Subjects> listaMateria;
	private List<Item> listaItens;
	private Grid tabuleiro;
	
	public Game(String nome, int idade) {
		listaPersonagens = new ArrayList<Character>();
		jogador = new Player(nome, idade);
		listaLugares = new ArrayList<Places>();
		listaMateria = new ArrayList<Subjects>();
		tabuleiro = new Grid();
	}
	
	public Player getPlayer() {
		return jogador;
	}

	public List<Character> getListaPersonagens() {
		return listaPersonagens;
	}

	public Player getJogador() {
		return jogador;
	}

	public List<Places> getListaLugares() {
		return listaLugares;
	}

	public List<Subjects> getListaMateria() {
		return listaMateria;
	}

	public List<Item> getListaItens() {
		return listaItens;
	}

	public Grid getTabuleiro() {
		return tabuleiro;
	}
	
	
}
