package br.com.model.placemodels;

import java.util.ArrayList;
import java.util.List;

import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;

public class Campus extends Places{
	private static List<Modulo> listaModulos;
	private static List<Restaurante> cantinas;
	
	public Campus(String nome, Pair posicaoPair, List<Events> eventos) {
		super(nome, posicaoPair, eventos);
		listaModulos = new ArrayList<Modulo>(7);
		cantinas = new ArrayList<Restaurante>(4);
		
	}
	
	public Modulo getModulo(Modulo modulo) {
		int index = listaModulos.indexOf(modulo);
		return listaModulos.get(index);
		
	}
	
	public List<Modulo> getModulos() {
		return listaModulos;
	}
	
	public List<Restaurante> getCantina(){
		return cantinas;
	}
}
