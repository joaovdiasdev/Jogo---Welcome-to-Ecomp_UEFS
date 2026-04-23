package br.com.view;

import java.util.Scanner;

public class UserMainView {
	private int entradaUser;
	private Scanner scanner;
	
	public UserMainView() {
		scanner = new Scanner(System.in);
	}
	
	public String firstInterface() {
		System.out.println("Olá, usuário, seja bem vindo ao BixoQuestUefs!\n");
		System.out.println("Crie um nome para você: ");
		String nomeUser = scanner.nextLine();
		return nomeUser;
	}
	
	public int mainInterface() {
		System.out.println("Escolha sua próxima ação: ");
		System.out.println("1- Criar um novo jogo: ");
		System.out.println("2- Jogar um jogo: ");
		System.out.println("3- Sair: ");
		entradaUser = scanner.nextInt();
		return entradaUser;
	}
}
