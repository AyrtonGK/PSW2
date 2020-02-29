package com.ayrton.psw2.util;

public interface FiguraGeometrica {
	public float area();
	public float perimetro();
	public float tamanhoHorizontal();
	public float tamanhoVertical();
	public double distancia(Ponto2D p);
	public Ponto2D centro();
	
	public int limiteHorizontalInferior();
	public int limiteHorizontalSuperior();
	public int limiteVerticalInferior();
	public int limiteVerticalSuperior();
	
}
