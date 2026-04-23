package br.com.model.playermodels;

import java.io.Serializable;
import java.util.ArrayList;		
import java.util.List;

import br.com.model.charactermodels.Characters;
import br.com.model.eventmodels.Task;
import br.com.model.gamesubmodels.*;
import br.com.model.gamesupermodels.Item;
import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.Pair;
import br.com.model.placemodels.Home;

//Classe do jogador e seus atributos
public class Player extends Characters implements Serializable{
	private static final long serialVersionUID = 1L;
	private PlayerStats statusJogador;
	private Inventory mochila;
	private List<Subjects> disciplinas;
	private Calendar calendario;
	private Home casaHome;
	
	//Construtor
	public Player(String nome, int idade) {
		super(nome, idade, new Pair(0, 0));
		statusJogador = new PlayerStats();
		disciplinas = new ArrayList<Subjects>(7);
		mochila = new Inventory();
		calendario = new Calendar();
		casaHome = new Home("Casa", new Pair(0, 0), null);
	}
	
	//Métodos inspirados na realidade (comer, dormir, estudar, etc) e os getters
	public void comer(Food comida) {
		if(comida.getTagString() == "Saudável") {
			statusJogador.somaSaude(3);
			statusJogador.somaEnergia(1);
			statusJogador.somaMotivacao(1);
		}
		else {
			statusJogador.diffSaude(3);
			statusJogador.somaEnergia(5);
			statusJogador.somaMotivacao(5);
		}	
	}
	
	public void dormir(Player jogador) {
		statusJogador.somaEnergia(100 - getStatusJogador().getEnergiaInt());
		statusJogador.somaMotivacao(100 - getStatusJogador().getMotivacaoInt());
	}
	
	public void fazerTask(Task task) {
		statusJogador.diffEnergia(getStatusJogador().getEnergiaInt() - task.getGastoNRG());
		statusJogador.diffMotivacao(getStatusJogador().getMotivacaoInt() - task.getGastoAura());
		statusJogador.somaXp(getStatusJogador().getXpInt() + task.getNivelXp());
		task.setFeitoTask(task);
	}
	
	public void estudar() {
		statusJogador.somaXp(getStatusJogador().getXpInt() + 1);
		statusJogador.diffEnergia(getStatusJogador().getEnergiaInt() - 1);
	}
	
	public void comprarItem(Item item) {
		statusJogador.diffDinheiro(item.getPrecoDouble());
		mochila.adicionar(item);
		item.setQuantidadeInt(item.getQuantidadeInt() + 1);
	}
	
	public void abrirMochila() {
		mochila.getInventory();
	}

	public PlayerStats getStatusJogador() {
		return statusJogador;
	}

	public Inventory getMochila() {
		return mochila;
	}

	public List<Subjects> getDisciplinas() {
		return disciplinas;
	}
	
	public Calendar getCalendario() {
		return calendario;
	}
	
	public Home getHome() {
		return casaHome;
	}
	
}
