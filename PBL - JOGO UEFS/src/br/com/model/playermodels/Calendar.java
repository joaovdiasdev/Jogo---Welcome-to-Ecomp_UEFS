package br.com.model.playermodels;

import br.com.model.eventmodels.Task;
import br.com.model.eventmodels.Turn;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.TripletInt;

import java.io.Serializable;
import java.util.*;

//Classe que guarda as tasks, servindo como um contador de tempo e de tarefas para o jogador
public class Calendar implements Serializable{
	private static final long serialVersionUID = 1L;
	private Turn[][] calendarioTasks;
	
	//Construtor
	public Calendar() {
		calendarioTasks = new Turn[8][5];
	}
	
	//Métodos para gerar o calendário aleatoriamente e os getters
	private void distribuirTasks(Player jogador, List<Task> tasks) {
		List<Subjects> listaMaterias = jogador.getDisciplinas();
		Random random = new Random();
		int seedX, seedY;
		for(Subjects elemento: listaMaterias) {
			int nprovas = elemento.getNumeroProvasInt();
			for(int i = 1; i < nprovas+1; i++) {
				seedX = random.nextInt(8);
				seedY = random.nextInt(5);
				calendarioTasks[seedX][seedY].adicionarTask(tasks.get(i));
			}
		}
	}
	
	public void gerarCalendario(Player jogador, List<Task> tasks) {
		distribuirTasks(jogador, tasks);
	}
	
	public Turn[][] getCalendario(){
		return calendarioTasks;
	}
	
	public Turn[] getSemana(int semana) {
		Turn[] semanaTasks = new Turn[5];
		for(int i = 0; i < 5; i++) {
			calendarioTasks[semana-1][i] = semanaTasks[i];
		}
		return semanaTasks;
	}
	
	public Task getTask(int pos, int pos2, int pos3) {
		Turn[] semana = getSemana(pos);
		List<Task> tasks = semana[pos2].getTasks();
		return tasks.get(pos3);
	}
	
	public TripletInt getTaskValues(int x, int y, Task task) {
		return calendarioTasks[x][y].getTaskValues(task);
	}
	
	public List<Task> getArrayTasks(int i, int j){
		return calendarioTasks[i][j].getTasks();
	}
	
}
