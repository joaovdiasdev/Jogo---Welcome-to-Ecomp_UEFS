package br.com.model.operational;

import java.io.Serializable;

//Classe auxiliar de Grid, ela compoe os pares ordenados do tabueleiro. Possui um construtor e dois getters
public class Pair implements Serializable{
	private static final long serialVersionUID = 1L;
	private double x;
	private double y;

	public Pair(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

}
