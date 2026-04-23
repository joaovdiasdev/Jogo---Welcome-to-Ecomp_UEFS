package br.com.model.gamesupermodels;

public class Item {
	private String nomeItemString;
	private int quantidadeInt;
	private double precoDouble;
	
	public Item(String nome, int quantidade, double preco){
		nomeItemString = nome;
		quantidadeInt = quantidade;
		precoDouble = preco;
	}

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
