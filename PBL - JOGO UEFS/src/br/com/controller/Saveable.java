package br.com.controller;

import java.io.*;

public class Saveable implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static <E> void saveElemento(E elemento, String arquivoPersistencia) throws IOException, FileNotFoundException{
		File arquivo = new File(arquivoPersistencia);
		ObjectOutputStream escrever = new ObjectOutputStream(new FileOutputStream(arquivo));
		
		escrever.writeObject((Object) elemento);
		escrever.close();
	}
	
	public static <E> Object loadElemento(E e, String arquivoPersistencia2) throws IOException, FileNotFoundException, ClassNotFoundException{
		File arquivo2 = new File(arquivoPersistencia2);
		ObjectInputStream ler = new ObjectInputStream(new FileInputStream(arquivo2));
		
		Object e1 = ler.readObject();
		ler.close();
		return e1;
	}
}
