package br.com.model.eventmodels;

public abstract class Events {
	protected String nomeString;
	protected int nivelXp;
	protected int gastoAura;
	protected int gastoNRG;
	
	
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
