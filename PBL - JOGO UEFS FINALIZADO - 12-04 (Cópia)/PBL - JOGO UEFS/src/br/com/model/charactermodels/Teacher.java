package br.com.model.charactermodels;

import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

public class Teacher extends NPC{
	private Map<String, Integer> conhecimento;
	private List<Subjects> materiaSubjects;
	
	public Teacher(String nome, int idade, Pair pos, Map<String, Integer> knowledge, List<Subjects> materias) {
		super(nome, idade, pos);
		conhecimento = knowledge;
		materiaSubjects = materias;
	}
	
	public void darAula(Characters jogador, String assunto) {
		Random random = new Random();
		((Player) jogador).getStatusJogador().somaXp(random.nextInt(conhecimento.get(assunto)+1)/100);
	}
	
	public Map<String, Integer> getFormacao() {
		return conhecimento;
	}
	
	public List<Subjects> getMateriasLecionadas(){
		return materiaSubjects;
	}
	
	public void interagir() {
		System.out.println("Olá turma, como vão?");
	}
	
	public void dialogar() {
		System.out.println("Se alguém estiver com dúvidas, pode perguntar");
	}

	public void motivar(Characters jogador) {
		jogador = (Player) new Characters(jogador.getNomeString(), jogador.getIdadeInt(), jogador.getPosicaoGrid());
		System.out.println("Você está indo muito bem, parabéns!");
		((Player) jogador).getStatusJogador().somaMotivacao(5);
	}

	public void desmotivar(Player jogador) {
		System.out.println("Esperava mais de você...");
		jogador.getStatusJogador().diffMotivacao(10);
	}
}
