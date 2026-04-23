package br.com.controller;

import br.com.model.operational.Game;
import br.com.model.operational.User;

public class MainController{
	private static final long serialVersionUID = 1L;
	
	private User usuario;
	private Game jogoGame;
	
	public User novoUsuario(String nomeUser) {
		usuario = new User(nomeUser);
		return usuario;
	}
	
	public Game novoJogo(String nomeJogador, int idadeJogador) {
		jogoGame = new Game(nomeJogador, idadeJogador);
		return jogoGame;
	}
	
}
