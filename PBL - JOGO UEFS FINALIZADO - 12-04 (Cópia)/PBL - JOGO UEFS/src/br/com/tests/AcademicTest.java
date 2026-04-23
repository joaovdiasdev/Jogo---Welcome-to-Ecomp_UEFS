package br.com.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import br.com.model.charactermodels.Teacher;
import br.com.model.eventmodels.Task;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.Pair;
import br.com.model.placemodels.Sala;
import br.com.model.playermodels.*;

class AcademicTest {
	private Player jogador = new Player("João Victor", 19);
	private Calendar calendario = new Calendar();
	private Task task = new Task("Prova", 20, 15, 25);
	private List<Task> listaTasks = new ArrayList<Task>(30);
	
	private Teacher professor = new Teacher("Cláudia", 50, null, null, null);
	private Sala salaAula = new Sala("Pat59", new Pair(25, -20), null, professor, null, null);
	private Subjects disciplina = new Subjects("Algoritmos", salaAula, professor, 3, 60);
	
	@Test
	public void testCalendar() {
		task.guardarTask(task);
		for(int i = 0; i < 30; i++) {
			listaTasks.add(task);
		}
		
		int soma = 0;
		calendario.gerarCalendario(jogador, listaTasks);
		assertNotNull(calendario);
		
		for(int i = 0; i < 8; i++) {
			Task[] semana = calendario.getSemana(i+1);
			for(int j = 0; j<5; j++) {
				if(semana[j] instanceof Task) {
					soma++;
				}
			}
		}
		
		assertEquals(30, soma);
	
	}
	
	@Test
	public void testMediaNotas() {
		disciplina.getNotasProvasList().add(0, 7.5);
		disciplina.getNotasProvasList().add(1, 8.7);
		disciplina.getNotasProvasList().add(2, 10.0);
		assertEquals(7.5, disciplina.getNotasProvasList().get(0));
		assertEquals(8.7, disciplina.getNotasProvasList().get(1));
		assertEquals(10.0, disciplina.getNotasProvasList().get(2));
		
		double media = disciplina.getMedia(disciplina);
		assertEquals(8.73, media);
	}
	
	public void testAssistirAula() {
		professor.getMateriasLecionadas().add(disciplina);
		assertEquals(disciplina, professor.getMateriasLecionadas());
		
		jogador.andar(salaAula.getPosicaoLocalPair());
		assertEquals(salaAula.getPosicaoLocalPair(), jogador.getPosicaoGrid());
		
		int xp = jogador.getStatusJogador().getXpInt();
		professor.darAula(jogador, disciplina.getNomeMateriaString());
		assertNotEquals(xp, jogador.getStatusJogador().getXpInt());
	}
	
	public void testConexao() {
		assertEquals(professor, disciplina.getProfessor());
		assertEquals(salaAula, disciplina.getSalaDeAula());
		
		int index = professor.getMateriasLecionadas().indexOf(disciplina);
		assertEquals(disciplina, professor.getMateriasLecionadas().get(index));
		assertEquals(salaAula.getPosicaoLocalPair(), professor.getPosicaoGrid());
	}
	
	public void testTask() {
		Random random = new Random();
		task.guardarTask(task);
		for(int i = 0; i < 30; i++) {
			listaTasks.add(task);
		}
		int x = random.nextInt(8);
		int y = random.nextInt(5);
		jogador.fazerTask(calendario.getTask(x, y));
		assertTrue(calendario.getTask(x, y).getFeitoTask());
	}
}
