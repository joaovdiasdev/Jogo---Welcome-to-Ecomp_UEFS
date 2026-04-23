package br.com.model.gamesubmodels;

import br.com.model.gamesupermodels.Item;

//Classe de comida, que herda de item, que possui um atributo de "etiqueta", para definir se uma comida é saudável ou não, com
//o intuito de impactar o usuário na alimentação
public class Food extends Item{
	private static final long serialVersionUID = 1L;
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