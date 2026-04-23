package br.com.model.gamesupermodels;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import br.com.model.charactermodels.Teacher;
import br.com.model.placemodels.Sala;

//Classe que cria as matérias a serem cursadas. É utilizada para cálculo de média (para aprovação e reprovação), cálculo de
//desempenho acadêmico e distribuição das tasks do jogador. Está associada a um professor e a uma sala de aula, tendo os
//atributos de nome, numero de provas, notas de provas e carga horária;
public class Subjects implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeMateriaString;
	private Sala salaAula;
	private Teacher professor;
	private int numeroProvasInt;
	private int cargaHorariaInt;
	private List<Double> notasProvasList;
	
	//Construtor
	public Subjects(String nomeMateria, Sala classroom, Teacher teacher, int numeroProvas, int cargaHoraria) {
		nomeMateriaString = nomeMateria;
		salaAula = classroom;
		professor = teacher;
		numeroProvasInt = numeroProvas;
		cargaHorariaInt = cargaHoraria;
		notasProvasList = new ArrayList<Double>(numeroProvas);
	}
	
	//Getters
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
