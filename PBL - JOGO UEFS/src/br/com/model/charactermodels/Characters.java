package br.com.model.charactermodels;

import java.io.Serializable;

import br.com.model.operational.Pair;


//Super classe do pacote, com os atributos de nome, posicao e idade
public class Characters implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeString;
	private Pair posicaoPair;
	private int idadeInt;
	
	//Construtor por parâmetro
	public Characters(String nome, int idade, Pair posicao) {
		nomeString = nome;
		idadeInt = idade;
		posicaoPair = posicao;
	}
	//Métodos de andar, interagir, getters e setters necessários;
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
