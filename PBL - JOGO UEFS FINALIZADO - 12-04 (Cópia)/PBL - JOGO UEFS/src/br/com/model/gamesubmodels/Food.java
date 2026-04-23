package br.com.model.gamesubmodels;

import br.com.model.gamesupermodels.Item;

public class Food extends Item{
	private String tagString;

	public Food(String nome, int quantidade, double preco, String tag) {
		super(nome, quantidade, preco);
		tagString = tag;
	}
	
	public String getTagString() {
		return tagString;
	}
	
	public void setTagString(String tag) {
		this.tagString = tag;
	}
	
}