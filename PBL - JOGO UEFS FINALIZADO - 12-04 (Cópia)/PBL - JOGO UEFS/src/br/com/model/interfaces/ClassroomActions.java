package br.com.model.interfaces;

import br.com.model.charactermodels.Characters;
import br.com.model.charactermodels.Teacher;
import br.com.model.placemodels.Places;
import br.com.model.placemodels.Sala;

public interface ClassroomActions {
	
	void entrarSala(Characters personagem, Sala sala);

	void assistirAula(Characters personagem, Teacher professor);

	void interagirAula(Characters personagem, String texto);
	
	void sairSala(Characters personagem, Places lugar);

}