package br.com.model.gamesupermodels;

import java.util.ArrayList;

import java.util.List;

import br.com.model.charactermodels.Teacher;
import br.com.model.placemodels.Sala;

public class Subjects {
	private String nomeMateriaString;
	private Sala salaAula;
	private Teacher professor;
	private int numeroProvasInt;
	private int cargaHorariaInt;
	private List<Double> notasProvasList;
	
	public Subjects(String nomeMateria, Sala classroom, Teacher teacher, int numeroProvas, int cargaHoraria) {
		nomeMateriaString = nomeMateria;
		salaAula = classroom;
		professor = teacher;
		numeroProvasInt = numeroProvas;
		cargaHorariaInt = cargaHoraria;
		notasProvasList = new ArrayList<Double>(numeroProvas);
	}

	public String getNomeMateriaString() {
		return nomeMateriaString;
	}
	
	public Sala getSalaDeAula() {
		return salaAula;
	}
	
	public Teacher getProfessor() {
		return professor;
	}
	
	public int getNumeroProvasInt() {
		return numeroProvasInt;
	}

	public int getCargaHorariaInt() {
		return cargaHorariaInt;
	}

	public List<Double> getNotasProvasList() {
		return notasProvasList;
	}
	
	public double getMedia(Subjects materia) {
		List<Double> notasDouble = materia.getNotasProvasList();
		double soma = 0;
		for(Double nota: notasDouble) {
			soma = soma + nota;
		}
		double media = soma/materia.getNumeroProvasInt();
		return media;
	}
	
	
	
}
