package br.com.model.operational;

import java.io.Serializable;
import java.util.HashMap;

import java.util.Map;
import br.com.model.playermodels.Player;

//Classe de usuário, que se relaciona apenas com jogo. Pode ter mais um jogo
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeUserString;
	private Map<String, Game> jogosMap;
	
	//Construtor
	public User(String nome) {
		nomeUserString = nome;
		jogosMap = new HashMap<String, Game>();
	}
	
	//Getters e CRUD para jogo
	public String getNomeUser() {
		return nomeUserString;
	}
	
	public void novoJogo(String nome, int idade) {
		Game jogo = new Game(nome, idade);
		Player jogador = jogo.getPlayer();
		jogosMap.put(jogador.getNomeString(), jogo);
		
	}
	
	public Map<String, Game> getJogos(){
		return jogosMap;
	}
	
	public Game getJogo(Player jogador) {
		return jogosMap.get(jogador.getNomeString());
	}
	
	public void deletarJogo(Player jogador) {
		jogosMap.remove(jogador.getNomeString());
	}
	
}
