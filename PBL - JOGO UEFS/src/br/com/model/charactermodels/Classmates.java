package br.com.model.charactermodels;

import br.com.model.operational.Pair;

//Classe classmates, que herda de NPC, para representar colegas de classe
public class Classmates extends NPC{
	
	private static final long serialVersionUID = 1L;

	public Classmates(String nome, int idade, Pair pos) {
		super(nome, idade, pos);
	}
}
