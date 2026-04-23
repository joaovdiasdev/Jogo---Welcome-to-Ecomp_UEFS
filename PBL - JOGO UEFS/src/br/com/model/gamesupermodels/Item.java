package br.com.model.gamesupermodels;

import java.io.Serializable;

//Superclasse dos objetos utilizáveis do jogo, possuindo um nome, uma quantidade e um preço como atributos;
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeItemString;
	private int quantidadeInt;
	private double precoDouble;
	
	//Construtor
	public Item(String nome, int quantidade, double preco){
		nomeItemString = nome;
		quantidadeInt = quantidade;
		precoDouble = preco;
	}

	//Getters e Setters
	public String getNomeItemString() {
		return nomeItemString;
	}

	public int getQuantidadeInt() {
		return quantidadeInt;
	}

	public double getPrecoDouble() {
		return precoDouble;
	}

	public void setNomeItemString(String nomeItemString) {
		this.nomeItemString = nomeItemString;
	}

	public void setQuantidadeInt(int quantidadeInt) {
		this.quantidadeInt = quantidadeInt;
	}

	public void setPrecoDouble(double precoDouble) {
		this.precoDouble = precoDouble;
	}
	
}
