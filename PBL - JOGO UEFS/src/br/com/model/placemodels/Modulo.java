package br.com.model.placemodels;

import java.util.List;
import br.com.model.eventmodels.Events;
import br.com.model.operational.Pair;

//Uma classe para agrupar um conjunto de salas de aula, um lugar do tipo restaurante e o colegiado;
public class Modulo extends Places{
	private static final long serialVersionUID = 1L;
	private List<Sala> salas;
	private List<Laboratorio> laboratorios;
	private Restaurante cantinaPlaces;
	private Colegiado colegiado;
	
	public Modulo(String nome, Pair posicao, List<Events> Eventos, List<Sala> salas, List<Laboratorio> laboratorios, Restaurante cantinaPlaces, Colegiado colegiado) {
		super(nome, posicao, Eventos);
		this.salas = salas;
		this.laboratorios = laboratorios;
		this.cantinaPlaces = cantinaPlaces;
		this.colegiado = colegiado;
	}

	public List<Sala> getSalas() {
		return salas;
	}
	
	public Sala getSala(Sala sala) {
		int index = salas.indexOf(sala);
		return salas.get(index);
	}
	
	

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public Restaurante getCantinaPlaces() {
		return cantinaPlaces;
	}
	
	public Colegiado getColegiado() {
		return colegiado;
	}
}
