package br.com.tests.modeltests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

import br.com.model.charactermodels.Teacher;
import br.com.model.eventmodels.Task;
import br.com.model.eventmodels.Turn;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.Pair;
import br.com.model.placemodels.Sala;
import br.com.model.playermodels.*;
//Classe de testes dos objetos acadêmicos
class AcademicTest {
	private Player jogador = new Player("João Victor", 19);
	private Calendar calendario = new Calendar();
	private Turn turno = new Turn();
	private Task task = new Task("Prova", 20, 15, 25);
	private List<Task> listaTasks = new ArrayList<Task>(30);
	
	private Teacher professor = new Teacher("Cláudia", 50, null, null, null);
	private Sala salaAula = new Sala("Pat59", new Pair(25, -20), null, professor, null, null);
	private Subjects disciplina = new Subjects("Algoritmos", salaAula, professor, 3, 60);
	
	@Test
	public void testCalendar() { //Teste para gerar calendário e contar a quantidade de tasks presentes nele
		for(int i = 0; i < 30; i++) {
			listaTasks.add(task);
		}
		
		int soma = 0;
		calendario.gerarCalendario(jogador, listaTasks);
		assertNotNull(calendario);
		
		for(int i = 0; i < 8; i++) {
			Turn[] semana = calendario.getSemana(i+1);
			for(int j = 0; j<5; j++) {
				if(semana[j] instanceof Turn) {
					soma++;
				}
			}
		}
		
		assertEquals(30, soma); //Corrigir no próximo patch
	
	}
	
	@Test //Bateria de testes para saber se a média das provas está funcionando
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
	
	public void testAssistirAula() { //Bateria de testes para saber se o jogador consegue assistir a aula e se o professor consegue dar aula
		professor.getMateriasLecionadas().add(disciplina);
		assertEquals(disciplina, professor.getMateriasLecionadas());
		
		jogador.andar(salaAula.getPosicaoLocalPair());
		assertEquals(salaAula.getPosicaoLocalPair(), jogador.getPosicaoGrid());
		
		int xp = jogador.getStatusJogador().getXpInt();
		professor.darAula(jogador, disciplina.getNomeMateriaString());
		assertNotEquals(xp, jogador.getStatusJogador().getXpInt());
	}
	
	public void testConexao() {	//Bateria de testes para saber se os objetos estão conectados entre si
		assertEquals(professor, disciplina.getProfessor());
		assertEquals(salaAula, disciplina.getSalaDeAula());
		
		int index = professor.getMateriasLecionadas().indexOf(disciplina);
		assertEquals(disciplina, professor.getMateriasLecionadas().get(index));
		assertEquals(salaAula.getPosicaoLocalPair(), professor.getPosicaoGrid());
	}
	
	public void testTask() {	//Teste para saber se a task foi feita
		Random random = new Random(); 
		turno.adicionarTask(task);
		for(int i = 0; i < 30; i++) {
			listaTasks.add(task);
		}
		int x = random.nextInt(8);
		int y = random.nextInt(5);
		int z = random.nextInt(calendario.getArrayTasks(x, y).size());
		jogador.fazerTask(calendario.getArrayTasks(x, y).get(z));
		assertTrue(task.getFeitoTask());
	}
}
