package br.com.model.playermodels;

import br.com.model.eventmodels.Task;
import br.com.model.gamesupermodels.Subjects;

import java.util.*;

public class Calendar{
	private Task[][] calendarioTasks;
	
	public Calendar() {
		calendarioTasks = new Task[8][5];
	}
	
	private void distribuirTasks(Player jogador, List<Task> tasks) {
		List<Subjects> listaMaterias = jogador.getDisciplinas();
		Random random = new Random();
		int seedX, seedY;
		for(Subjects elemento: listaMaterias) {
			int nprovas = elemento.getNumeroProvasInt();
			for(int i = 1; i < nprovas+1; i++) {
				seedX = random.nextInt(8);
				seedY = random.nextInt(5);
				
				for(Task task: tasks) {
					calendarioTasks[seedX][seedY] = task;
				}
				
				}
			}
		}
	
	public void gerarCalendario(Player jogador, List<Task> tasks) {
		distribuirTasks(jogador, tasks);
	}
	
	public Task[][] getCalendario(){
		return calendarioTasks;
	}
	
	public Task[] getSemana(int semana) {
		Task[] semanaTasks = new Task[5];
		for(int i = 0; i < 5; i++) {
			calendarioTasks[semana-1][i] = semanaTasks[i];
		}
		return semanaTasks;
	}
	
	public Task getTask(int x, int y) {
		return calendarioTasks[x][y];
	}
	
}
