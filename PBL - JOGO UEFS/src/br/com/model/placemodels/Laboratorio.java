package br.com.model.placemodels;

import java.util.List;	
import java.util.Random;

import br.com.model.charactermodels.Classmates;
import br.com.model.charactermodels.Teacher;
import br.com.model.eventmodels.Events;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

//Uma classe derivada de sala, pois todo laboratório é uma sala de aula
public class Laboratorio extends Sala{
	
	private static final long serialVersionUID = 1L;

	public Laboratorio(String nome, Pair pos, List<Events> eventos, Teacher professor, List<Classmates> alunos, Subjects materia) {
		super(nome, pos, eventos, professor, alunos, materia);
	}
	
	public void fazerExperimentos(Player jogador) {
		Random random = new Random();
		jogador.getStatusJogador().somaXp(random.nextInt(51));
		jogador.getStatusJogador().somaMotivacao(random.nextInt(51));
		
	}
	
	
}
