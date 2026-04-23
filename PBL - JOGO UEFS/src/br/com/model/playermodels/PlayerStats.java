package br.com.model.playermodels;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import br.com.model.gamesupermodels.Subjects;

//Classe específica de atributos do usuário solicitados no problema, com o intuito de modularizar e limpar o códiog
public class PlayerStats implements Serializable{
	private static final long serialVersionUID = 1L;
	private Random random = new Random();
	private int xpInt;
	private int levelInt;
	private int motivacaoInt;
	private int saudeInt;
	private int energiaInt;
	private double dinheiroDouble;
	private double scoreDouble;
	private int lucky;
	
	//Construtor
	public PlayerStats() {
		xpInt = 0;
		levelInt = 1;
		motivacaoInt = 100;
		saudeInt = 100;
		energiaInt= 100;
		dinheiroDouble = 400;
		scoreDouble = 0.0;
	}
	
	//Métodos de manipulação dos valores dos atributos (utilizado para tudo no jogo)
	public void somaXp(int valor) {
		xpInt = xpInt + valor;
	}
	public void somaLevel() {
		levelInt = levelInt + 1;
	}
	public void somaMotivacao(int valor) {
		motivacaoInt = motivacaoInt + valor;
	}
	public void somaSaude(int valor) {
		saudeInt = saudeInt + valor;
	}
	public void somaEnergia(int valor) {
		energiaInt = energiaInt + valor;
	}
	public void somaDinheiro(double valor) {
		dinheiroDouble = dinheiroDouble + valor;
	}
	
	private double calcularScore(Player jogador) {
		List<Subjects> materiaSubjects = jogador.getDisciplinas();
		double formula;
		double somaCargaHoraria = 0.0;
		double somaNotas = 0.0;
		double somaChNota = 0.0;

		
		for(Subjects element: materiaSubjects) {
			somaCargaHoraria = somaCargaHoraria + element.getCargaHorariaInt();
			for(double i: element.getNotasProvasList()) {
				somaNotas = somaNotas + i;
			}
			
			formula = (element.getCargaHorariaInt()*element.getCargaHorariaInt());
			somaChNota = somaChNota + formula;
		}
		scoreDouble = somaChNota / somaCargaHoraria;
		return scoreDouble;
		
	}
	public void diffMotivacao(int valor) {
		motivacaoInt = motivacaoInt - valor;
	}
	public void diffSaude(int valor) {
		saudeInt = saudeInt - valor;
	}
	public void diffEnergia(int valor) {
		energiaInt = energiaInt - valor;
	}
	public void diffDinheiro(double valor) {
		dinheiroDouble = dinheiroDouble - valor;
	}

	public int getXpInt() {
		return xpInt;
	}
	
	public int getLevelInt() {
		return levelInt;
	}

	public int getMotivacaoInt() {
		return motivacaoInt;
	}

	public int getSaudeInt() {
		return saudeInt;
	}

	public int getEnergiaInt() {
		return energiaInt;
	}

	public double getDinheiroDouble() {
		return dinheiroDouble;
	}

	public double getScoreDouble(Player jogador) {
		scoreDouble = calcularScore(jogador);	
		return scoreDouble;
	}
	
	public int getLucky() {
		lucky = random.nextInt(1, 11);
		return lucky;
	}
	
}
