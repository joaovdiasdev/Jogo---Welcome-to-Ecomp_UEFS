package br.com.model.charactermodels;

import br.com.model.operational.Pair;


//Construtor da classe animal herdando da classe NPC
public class Animal extends NPC{
	
	private static final long serialVersionUID = 1L;

	public Animal(String nome, int idade, Pair posicao) {
		super(nome, idade, posicao);
	}
}
