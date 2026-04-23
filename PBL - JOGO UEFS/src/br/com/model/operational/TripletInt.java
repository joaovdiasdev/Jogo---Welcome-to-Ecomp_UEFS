package br.com.model.operational;

//Classe operacional para guardar os valores de uma task
public class TripletInt {
	private int v1;
	private int v2;
	private int v3;
	
	public TripletInt(int x, int y, int z) {
		this.v1 = x;
		this.v2 = y;
		this.v3 = z;
	}
	
	public TripletInt makeTriplet(int a, int b, int c) {
		TripletInt trio = new TripletInt(a, b, c);
		return trio;
	}

	public int getV1() {
		return v1;
	}

	public int getV2() {
		return v2;
	}

	public int getV3() {
		return v3;
	}
	
	
}
