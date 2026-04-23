package br.com.model.placemodels;

import java.util.List;

import br.com.model.charactermodels.Characters;
import br.com.model.charactermodels.Classmates;
import br.com.model.charactermodels.Teacher;
import br.com.model.eventmodels.Events;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.interfaces.ClassroomActions;
import br.com.model.operational.Pair;

//Classe que representa uma unidade institucional (uma sala de aula) e implementa uma interface de ações de sala de aula
public class Sala extends Places implements ClassroomActions{
	private static final long serialVersionUID = 1L;
	private Teacher professor;
	private Subjects materiaSubjects;
	private List<Classmates> alunos;
	
	//Construtor
	public Sala(String nome, Pair pos, List<Events> eventos, Teacher professor, List<Classmates> alunos, Subjects materia){
		super(nome, pos, eventos);
		this.professor = professor;
		this.alunos = alunos;
		this.materiaSubjects = materia;
	}
	
	//Getters, Setters e métodos da interface
	public List<Classmates> getAlunos(){
		return alunos;
	}
	
	public Teacher getProfessor(){
		return professor;
	}
	
	public Subjects getMateria(){
		return materiaSubjects;
	}

	@Override
	public void entrarSala(Characters personagem, Sala sala) {
		personagem.andar(sala.getPosicaoLocalPair());
		
	}

	@Override
	public void assistirAula(Characters personagem, Teacher professor) {
		professor.darAula(personagem, materiaSubjects.getNomeMateriaString());
	}

	@Override
	public void interagirAula(Characters personagem, String texto) {
		professor.interagir();
		personagem.interagir(texto);
		
	}

	@Override
	public void sairSala(Characters personagem, Places lugar) {
		personagem.andar(lugar.getPosicaoLocalPair());
	}
}
