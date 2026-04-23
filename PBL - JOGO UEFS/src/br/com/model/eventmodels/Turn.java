package br.com.model.eventmodels;

import java.util.ArrayList;
import java.util.List;

import br.com.model.operational.TripletInt;

public class Turn {
	private List<Task> tarefasList;
	
	public Turn() {
		tarefasList = new ArrayList<Task>();
	}
	
	public void adicionarTask(Task task) {
		tarefasList.add(task);
	}
	
	public void removerTask(Task task) {
		tarefasList.remove(tarefasList.indexOf(task));
	}
	
	public List<Task> getTasks() {
		return tarefasList;
	}
	
	public Task getTask(int index) {
		return tarefasList.get(index);
	}
	
	public TripletInt getTaskValues(Task task) {
		return task.getTasks().get(task.getNomeString());	
	}
}