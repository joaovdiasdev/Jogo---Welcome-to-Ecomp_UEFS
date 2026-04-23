package br.com.model.charactermodels;

import br.com.model.operational.Pair;

public class Characters {
	private String nomeString;
	private Pair posicaoPair;
	private int idadeInt;
	
	public Characters(String nome, int idade, Pair posicao) {
		nomeString = nome;
		idadeInt = idade;
		posicaoPair = posicao;
	}

	public void andar(Pair posicaoGrid) {
		this.posicaoPair = posicaoGrid;
	}
	
	public void interagir(String texto) {
		System.out.println(texto);
	}

	public String getNomeString() {
		return nomeString;
	}

	public Pair getPosicaoGrid() {
		return posicaoPair;
	}

	public int getIdadeInt() {
		return idadeInt;
	}

	public void setNomeString(String nomeString) {
		this.nomeString = nomeString;
	}

	public void setIdadeInt(int idadeInt) {
		this.idadeInt = idadeInt;
	}
	
}
