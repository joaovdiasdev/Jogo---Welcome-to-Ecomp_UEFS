package br.com.model.eventmodels;

import java.util.Random;

import br.com.model.playermodels.Player;

public class Achievements extends Events{
	Random random;

	public Achievements(String nome, int nivelXp, int gastoAura, int gastoNRG) {
		super(nome, nivelXp, gastoAura, gastoNRG);
		random = new Random();
	}

	private void conquistaBoa(Player jogador) {
		jogador.getStatusJogador().somaDinheiro(random.nextDouble(51));
		jogador.getStatusJogador().somaXp(random.nextInt(101));
		jogador.getStatusJogador().somaMotivacao(random.nextInt(26));
	}
	
	private void conquistaNeutra(Player jogador) {
		jogador.getStatusJogador().diffDinheiro(random.nextDouble(51));
		jogador.getStatusJogador().somaXp(random.nextInt(101));
		jogador.getStatusJogador().somaMotivacao(random.nextInt(26));
	}


	private void conquistaRuim(Player jogador) {
		jogador.getStatusJogador().diffDinheiro(random.nextDouble(51));
		jogador.getStatusJogador().somaXp(random.nextInt(101));
		jogador.getStatusJogador().diffMotivacao(random.nextInt(50));
		jogador.getStatusJogador().diffSaude(random.nextInt(26));
	}
	
	public void conquista(Player jogador) {
		int controle1 = jogador.getStatusJogador().getLucky();
		int controle2 = random.nextInt(1, 11);
		int controle3 = random.nextInt(1, 11);
		
		if(controle1 == controle2 && controle1 == controle3) {
			conquistaBoa(jogador);
		}
		
		else if((controle1 == controle2 && controle1 != controle3) || (controle1 == controle3 && controle1 != controle2)) {
			conquistaNeutra(jogador);
		}
		
		else {
			conquistaRuim(jogador);
		}
	}
}

