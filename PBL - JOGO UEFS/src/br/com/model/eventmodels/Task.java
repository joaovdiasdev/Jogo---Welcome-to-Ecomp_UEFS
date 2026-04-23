package br.com.model.eventmodels;

import java.util.*;

import br.com.model.operational.TripletInt;
import br.com.model.playermodels.*;

//Classe de Eventos Obrigatórios, composta por um Map de String (chave) e uma "Tripleta" (trio de valores) do tipo int, além de um
//atributo booleano
public class Task extends Events{
	private static final long serialVersionUID = 1L;
	
	private Map<String, TripletInt> taskMap;
	private TripletInt trioInt;
	private boolean feito;
	
	//Construtor
	public Task(String nome, int gastoXp, int gastoMotivacao, int gastoEnergia){
		super(nome, gastoXp, gastoMotivacao, gastoEnergia);
		taskMap = new HashMap<String, TripletInt>();
		taskMap.put(nome, trioInt.makeTriplet(gastoXp, gastoEnergia, gastoMotivacao));
		this.feito = false;
	}
	
	//Métodos de guardar task para virar um map (de forma, teoricamente, a agrupar mais de uma task, se necessário), getters e um setter para
	//definir a tarefa como feita
	
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
		statusJogador.diffEnergia(getGastoNRG());
		statusJogador.diffMotivacao(getGastoAura());
		
	}
	
}
