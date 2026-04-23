package br.com.model.eventmodels;

import java.io.Serializable;

//Classe abstrata de Evento (por não ser um ambiente ou um objeto físico), que possui nome, nível de experiência que oferece ao jogador,
//gasto de motivação e de energia que o evento causa
public abstract class Events implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nomeString;
	private int nivelXp;
	private int gastoAura;
	private int gastoNRG;
	
	//Construtor da classe + getters;
	public Events(String nome, int nivelXp, int gastoAura, int gastoNRG) {
		this.nomeString = nome;
		this.nivelXp = nivelXp;
		this.gastoAura = gastoAura;
		this.gastoNRG = gastoNRG;
	}

	public String getNomeString() {
		return nomeString;
	}

	public int getNivelXp() {
		return nivelXp;
	}

	public int getGastoAura() {
		return gastoAura;
	}

	public int getGastoNRG() {
		return gastoNRG;
	}
	
}
