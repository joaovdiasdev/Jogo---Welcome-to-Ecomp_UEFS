package br.com.model.operational;

import java.util.HashMap;

import java.util.Map;
import br.com.model.playermodels.Player;

public class User {
	
	private String nomeUserString;
	private Map<Player, Game> jogosMap;
	
	public User(String nome) {
		nomeUserString = nome;
		jogosMap = new HashMap<Player, Game>();
	}
	
	public String getNomeUser() {
		return nomeUserString;
	}
	
	public void novoJogo(String nome, int idade) {
		Game jogo = new Game(nome, idade);
		Player jogador = jogo.getPlayer();
		jogosMap.put(jogador, jogo);
		
	}
	
	public Map<Player, Game> getJogos(){
		return jogosMap;
	}
	
	public Game getJogo(Player jogador) {
		return jogosMap.get(jogador);
	}
	
	public void deletarJogo(Player jogador) {
		jogosMap.remove(jogador);
	}
	
}
