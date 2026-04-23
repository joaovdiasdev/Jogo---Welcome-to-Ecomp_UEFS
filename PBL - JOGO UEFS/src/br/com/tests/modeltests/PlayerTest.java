package br.com.tests.modeltests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.model.gamesubmodels.Food;
import br.com.model.gamesupermodels.Item;
import br.com.model.operational.Pair;
import br.com.model.placemodels.Home;
import br.com.model.placemodels.PontoOnibus;
import br.com.model.playermodels.Player;
import br.com.model.operational.Grid;

class PlayerTest {
	private Player jogador = new Player("João Victor", 17);
	private Item itemteste = new Item("Casaco", 1, 80.0);
	private Item itemteste2 = new Item("Celular", 1, 2500);
	private Food comidateste = new Food("Bolo", 1, 7.00, "Junk");
	private Food comidateste2 = new Food("Maça", 1, 2.10, "Saudável");
	private Grid tabuleiroGrid = new Grid();
	private Home casa = new Home("Casa", new Pair(1, 1), null);
	private PontoOnibus pontoOnibus = new PontoOnibus("Ponto1", new Pair(5, 3), null);
	
	@Test
	public void testStatus() { //Teste para saber se o método de comer funcionava
		int saude = jogador.getStatusJogador().getSaudeInt();
		int energia = jogador.getStatusJogador().getEnergiaInt();
		int motivacao = jogador.getStatusJogador().getMotivacaoInt();
		
		jogador.comer(comidateste2);
		assertNotEquals(saude, jogador.getStatusJogador().getSaudeInt());
		assertNotEquals(energia, jogador.getStatusJogador().getEnergiaInt());
		assertNotEquals(motivacao, jogador.getStatusJogador().getMotivacaoInt());
		
		int xp = jogador.getStatusJogador().getXpInt(); //Teste para saber se estudar modifica os status como deveria
		int nrg = jogador.getStatusJogador().getEnergiaInt();
		for(int i = 0; i < 5; i++) {
			jogador.estudar();
		}
		assertNotEquals(xp, jogador.getStatusJogador().getXpInt());
		assertNotEquals(nrg, jogador.getStatusJogador().getEnergiaInt());
		
		jogador.dormir(jogador); //Testagem de status ao limite, corrigir no próximo patch (não deixar ultrapassar 100 pontos)
		jogador.comer(comidateste);
		jogador.comer(comidateste2);
		jogador.comer(comidateste2);
		jogador.comer(comidateste2);
		
		if(jogador.getStatusJogador().getEnergiaInt() > 100) {
			fail("Energia do Jogador acima de 100%");
		}
		
		if(jogador.getStatusJogador().getSaudeInt() > 100) {
			fail("Saúde do Jogador acima de 100%");
		}
		
		
	}
	
	@Test
	public void testComida() {	//Testagem do dinheiro do usuário
		double dinheiro = jogador.getStatusJogador().getDinheiroDouble();
		jogador.comprarItem(comidateste);
		jogador.comprarItem(comidateste2);
		assertNotEquals(dinheiro, jogador.getStatusJogador().getDinheiroDouble());
		
		jogador.comer(comidateste);
		assertEquals(97, jogador.getStatusJogador().getSaudeInt());
		
		jogador.comer(comidateste2);
		assertEquals(100, jogador.getStatusJogador().getSaudeInt());
		
		//Testagem no limite, para saber se o usuário consegue comprar itens sem dinheiro (ele compra fiado, corrigir no próximo patch)
		jogador.getStatusJogador().diffDinheiro(jogador.getStatusJogador().getDinheiroDouble()); 
		jogador.comprarItem(comidateste);
		
		if(jogador.getStatusJogador().getDinheiroDouble() < 0) {
			fail("Jogador está comprando item sem dinheiro!");
		}
		
		
	}
	
	@Test
	public void testInventario() {
		jogador.comprarItem(itemteste);
		assertEquals(itemteste, jogador.getMochila().getItem(itemteste)); //Teste falha aqui, descobrir o porquê
		
		jogador.getMochila().usarItem(jogador.getMochila().getInventory(), itemteste, 0, 0);
		assertNull(jogador.getMochila().getItem(itemteste));
		
		for(int i = 0; i < 24; i++) {
			jogador.getMochila().adicionar(itemteste);
		}
		//Testagem no limite, para saber se o jogador consegue inserir um item em um inventário cheio
		jogador.getMochila().adicionar(itemteste2);
		jogador.getMochila().getItem(itemteste2);
		if(jogador.getMochila().getItem(itemteste2) == null) {
			fail("O item não foi inserido no array!");
		}
		
		
	}
	
	@Test
	public void testCasa() { //Bateria de testes para testar a casa do jogador
		tabuleiroGrid.adicionarPosicao(casa.getPosicaoLocalPair());
		tabuleiroGrid.adicionarPosicao(pontoOnibus.getPosicaoLocalPair());
		
		jogador.andar(pontoOnibus.getPosicaoLocalPair());
		assertEquals(jogador.getPosicaoGrid(), pontoOnibus.getPosicaoLocalPair());
		
		pontoOnibus.goCasa(jogador, casa);
		assertEquals(jogador.getPosicaoGrid(), casa.getPosicaoLocalPair());
		
		//Teste extremo: Jogador fora do mapa - Corrigir no próximo patch
		jogador.andar(null);
		if(jogador.getPosicaoGrid() == null) {
			fail("Jogador fora do mapa!");
		}
		
		int energia = jogador.getStatusJogador().getEnergiaInt();
		int motivacao = jogador.getStatusJogador().getMotivacaoInt(); 
		casa.dormir(jogador);
		assertNotEquals(energia, jogador.getStatusJogador().getEnergiaInt());
		assertNotEquals(motivacao, jogador.getStatusJogador().getMotivacaoInt());
		
		
	}
	
}
