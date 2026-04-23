package br.com.model.placemodels;

import java.io.Serializable;
import java.util.List;

import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;

public class Places implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nomeLocalString;
	private Pair posicaoLocal;
	private List<Events> listaEventosEvents;
	
	public Places(String nome, Pair posicao, List<Events> eventos) {
		this.nomeLocalString = nome;
		this.posicaoLocal = posicao;
		this.listaEventosEvents = eventos;
	}
	
	public String getNomeLocalString() {
		return nomeLocalString;
	}

	public Pair getPosicaoLocalPair() {
		return posicaoLocal;
	}

	public List<Events> getListaEventosEvents() {
		return listaEventosEvents;
	}
	
	public Events getEvento(Events evento) {
		return listaEventosEvents.get(listaEventosEvents.indexOf(evento));
		 
	}
}
