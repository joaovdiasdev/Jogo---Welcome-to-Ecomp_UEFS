package br.com.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.com.model.playermodels.Player;

public class SavePlayer {
	Player jogadorPlayer;
	String arquivoJson;
	
	public SavePlayer(Player jogador, String arquivo) {
		this.jogadorPlayer = jogador;
		this.arquivoJson = arquivo;
		
	}
	
	public void savePlayer(String arquivo) throws FileNotFoundException, IOException {
		Saveable.saveElemento(jogadorPlayer, arquivo);
		
		Saveable.saveElemento(jogadorPlayer.getNomeString(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getIdadeInt(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getStatusJogador(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getPosicaoGrid(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getCalendario(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getDisciplinas(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getMochila(), arquivo);
		Saveable.saveElemento(jogadorPlayer.getHome(), arquivo);
		
	}
	public Player loadPlayer(Player player, String arquivo2) throws FileNotFoundException, IOException, ClassNotFoundException {
			Player playerSalvo = (Player) Saveable.loadElemento(player, arquivo2);
			
			Saveable.loadElemento(jogadorPlayer.getNomeString(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getIdadeInt(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getStatusJogador(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getPosicaoGrid(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getCalendario(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getDisciplinas(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getMochila(), arquivo2);
			Saveable.loadElemento(jogadorPlayer.getHome(), arquivo2);
			
			return playerSalvo;
	
	}
}
