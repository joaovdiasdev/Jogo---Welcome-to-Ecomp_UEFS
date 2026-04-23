package br.com.model.charactermodels;

import java.util.List;
import java.util.Map;
import java.util.Random;

import br.com.model.gamesupermodels.Subjects;
import br.com.model.operational.Pair;
import br.com.model.playermodels.Player;

//Classe teacher, que representa um professor, com atributos de conhecimento (sendo <String, Integer> para representar o nível de formação
// do professor e a pontuação de conhecimento que essa formação representa) e uma lista de matérias;
public class Teacher extends NPC{
	private static final long serialVersionUID = 1L;
	
	private Map<String, Integer> conhecimento;
	private List<Subjects> materiaSubjects;
	
	//Construtor passado por parâmetro e encaminhado parcialmente para a superclasse (Teacher -> NPC -> Character)
	public Teacher(String nome, int idade, Pair pos, Map<String, Integer> knowledge, List<Subjects> materias) {
		super(nome, idade, pos);
		conhecimento = knowledge;
		materiaSubjects = materias;
	}
	
	//Métodos de dar aula, interagir (herdado e alterado de Character) e métodos herdados de NPC
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
