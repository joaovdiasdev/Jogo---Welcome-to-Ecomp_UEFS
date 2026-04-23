package br.com.model.placemodels;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.model.eventmodels.Events;
import br.com.model.gamesubmodels.Food;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

public class Restaurante extends Places{
	private List<Mesa>mesasList;
	private List<Food> comidasList;
	
	public class Mesa{
		protected Map<Integer, Integer> mesa = Map.of(1, 4);
		protected boolean ocupado = false;
	}
	
	
	public Restaurante(String nome, Pair posicaoPair, List<Events> eventos, List<Food> listaFoods) {
		super(nome, posicaoPair, eventos);
		Mesa mesa = new Mesa();
		mesasList = new ArrayList<Mesa>(Collections.nCopies(10, mesa));
		comidasList = listaFoods;
		
		
	}
	
	public Mesa getMesa() {
		Random random = new Random();
		int pos = random.nextInt(10);
		Mesa mesaocupada = mesasList.get(pos);
		mesaocupada.ocupado = true;
		
		return mesaocupada;
	}
	
	public void outMesa(Mesa mesa) {
		mesa.ocupado = false;
	}
	
	public void fazerRefeição(Player jogador, Food comida) {
		jogador.comer(comida);
	}
	
	public void comprarComida(Player jogador, Food comida) {
		jogador.comprarItem(comida);
	}

	public List<Mesa> getMesasList() {
		return mesasList;
	}

	public List<Food> getComidasList() {
		return comidasList;
	}
}
