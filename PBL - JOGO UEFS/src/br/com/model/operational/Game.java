package br.com.model.operational;
	
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.model.gamesupermodels.Item;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.placemodels.Places;
import br.com.model.playermodels.Player;

//A classe onde acontece tudo dentro do jogo. Ela é o jogo, possuindo uma lista de personagens, um jogador, uma lista de lugares, uma lista de
//disciplinas, uma lista de itens e um tabuleiro, englobando todas as classes do jogo.

//Possui um construtor e getters
public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	
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
