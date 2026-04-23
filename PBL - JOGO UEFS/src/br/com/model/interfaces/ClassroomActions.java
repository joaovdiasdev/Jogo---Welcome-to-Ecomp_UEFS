package br.com.model.interfaces;

import br.com.model.charactermodels.Characters;
import br.com.model.charactermodels.Teacher;
import br.com.model.placemodels.Places;
import br.com.model.placemodels.Sala;

//Unica interface do jogo, associada a uma sala de aula, para representar o que pode ser feito dentro dela
public interface ClassroomActions {
	
	void entrarSala(Characters personagem, Sala sala);

	void assistirAula(Characters personagem, Teacher professor);

	void interagirAula(Characters personagem, String texto);
	
	void sairSala(Characters personagem, Places lugar);

}