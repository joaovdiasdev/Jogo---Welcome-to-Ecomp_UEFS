package br.com.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameView {
	private String nomeJogador;
	private int idadeJogador;
	private Scanner scanner;
	
	public GameView(){
		scanner = new Scanner(System.in);
	}
	
	public String playerNome() {
		System.out.println("Escreva o nome do seu personagem: ");
		nomeJogador = scanner.nextLine();
		return nomeJogador;
		
	}
	public int playerIdade() {
		System.out.println("Digite a idade de entrada do seu personagem: ");
		idadeJogador = scanner.nextInt();
		return idadeJogador;
	}
}
