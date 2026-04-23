package br.com.model.playermodels;

import java.io.Serializable;

import br.com.model.gamesupermodels.*;

//Classe para guardar itens adquridos pelo usuário
public class Inventory implements Serializable{
	private static final long serialVersionUID = 1L;
	private Item[][] matriz;
	
	//Construtor
	public Inventory() {
		matriz = new Item[3][8];
	}
	
	//Métodos de CRUD no inventário
	public void adicionar(Item item) {
		if(matriz[2][7] != null) {
			for(int x = 0; x < 3; x++) {
				for(int y = 0; y < 8; y++) {
					if (matriz[x][y] == null) {
						matriz[x][y] = item;
					}
					else {
						;
					}
				}
			}
		}
	}
	public void deletar(Item item, int x, int y) {
		if(matriz[x][y] != null) {
			matriz[x][y] = null;
		}
		else {
			;
		}
	}
	public Item[][] getInventory() {
		return matriz;
	}
	
	public void usarItem(Item[][] matriz, Item item, int x, int y) {
		int qtd = matriz[x][y].getQuantidadeInt();
		qtd = qtd -1;
		if(qtd == 0) {
			matriz[x][y] = null;
		}
	}
	
	public Item getItem(Item item) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 8; j++) {
				if(matriz[i][j] == item) {
					return item;
				}
			}
		}
		return null;
	}
}
