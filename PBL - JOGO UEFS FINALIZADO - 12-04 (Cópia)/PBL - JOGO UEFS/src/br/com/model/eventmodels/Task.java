package br.com.model.eventmodels;

import java.util.*;

import br.com.model.operational.TripletInt;
import br.com.model.playermodels.*;

public class Task extends Events{
	private Map<String, TripletInt> taskMap;
	private TripletInt trioInt;
	private boolean feito;
	
	public Task(String nome, int gastoXp, int gastoMotivacao, int gastoEnergia){
		super(nome, gastoXp, gastoMotivacao, gastoEnergia);
		taskMap = new HashMap<String, TripletInt>();
		this.feito = false;
	}
	
	public void guardarTask(Task task) {
		taskMap.put(task.nomeString, trioInt.makeTriplet(task.getNivelXp(), task.gastoAura, task.getGastoNRG()));
	}
	
	public Map<String, TripletInt> getTasks(){
		return taskMap;
	}
	
	public boolean getFeitoTask() {
		return feito;
	}
	
	public void setFeitoTask(Task task) {
		task.feito = true;
	}
	
	public void fazerTask(Player jogador) {
		PlayerStats statusJogador = jogador.getStatusJogador();
		statusJogador.diffEnergia(gastoNRG);
		statusJogador.diffMotivacao(gastoAura);
		
	}
	
}
