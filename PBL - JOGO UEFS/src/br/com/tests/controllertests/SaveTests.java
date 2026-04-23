package br.com.tests.controllertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import br.com.controller.SavePlayer;
import br.com.model.playermodels.Player;

public class SaveTests {
	Player jogadorPlayer = new Player("João Victor", 17);
	String arquivoJson = "Teste.json";
	File arquivoFile = new File(arquivoJson);
	SavePlayer salvarPlayer = new SavePlayer(jogadorPlayer, arquivoFile.getName());
	
	@Test
	public void salvarPlayer() throws FileNotFoundException, IOException {
		salvarPlayer.savePlayer(arquivoFile.getName());
		assertTrue(arquivoFile.exists());
		assertTrue(arquivoFile.length() > 0);
	}
	
	@Test
	public void loadPlayer() throws FileNotFoundException, IOException, ClassNotFoundException {
		Player jogadorSalvoPlayer = salvarPlayer.loadPlayer(jogadorPlayer, arquivoFile.getName());
		assertNotNull(jogadorSalvoPlayer);
		assertEquals(jogadorPlayer, jogadorSalvoPlayer, "O objeto é o mesmo!");
		assertEquals("João Victor", jogadorSalvoPlayer.getNomeString());
		assertEquals(17, jogadorSalvoPlayer.getIdadeInt());
	}
	
	
	
}
