package com.ayrton.psw2.util;

public class Ponto2D implements FiguraGeometrica {
	private float coordenadas[] = new float[2];

	public Ponto2D() {
		this.setCoordenadas(0, 0);
	}

	public Ponto2D(int x, int y) {
		this.setCoordenadas(x, y);
	}

	public Ponto2D(Ponto2D p) {
		this.setCoordenadas(p.getX(), p.getY());
	}

	public static Ponto2D ParsePonto2D(String str) {
		str = str.trim();
		if (str.matches("\\([0-9]+; [0-9]+\\)")) {
			String n = str.substring(1, str.indexOf(';'));
			int x = Integer.parseInt(n);
			n = str.substring(str.indexOf(';') + 2, str.indexOf(')'));
			int y = Integer.parseInt(n);

			return new Ponto2D(x, y);
		} else
			return null;
	}

	public String toString() {
		return String.format("(%s;%s)", this.getX(), this.getY());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		if (this.getX() == ((Ponto2D) obj).getX() && this.getY() == ((Ponto2D) obj).getY())
			return true;
		return false;
	}

	public double distanciaVertical(Ponto2D p) {
		return Math.abs(this.getY() - p.getY());
	}

	public Ponto2D pontoMaximo(Ponto2D p) {
		return new Ponto2D(this.getX() > p.getX() ? this.getX() : p.getX(),
				this.getY() > p.getY() ? this.getY() : p.getY());
	}

	public double distanciaHorizontal(Ponto2D p) {
		return Math.abs(this.getX() - p.getX());
	}

	@Override
	public float area() {

		return 0;
	}

	@Override
	public float perimetro() {

		return 0;
	}

	@Override
	public double distancia(Ponto2D p) {
		return Math.sqrt(((this.getX() - p.getX()) * (this.getX() - p.getX()))
				+ ((this.getY() - p.getY()) * (this.getY() - p.getY())));
	}

	@Override
	public Ponto2D centro() {
		return this;
	}

	@Override
	public float tamanhoHorizontal() {
		return 0;
	}

	public float tamanhoVertical() {
		return 0;
	}

	public int getX() {
		return (int) coordenadas[0];
	}

	public void setX(float x) {
		this.coordenadas[0] = x;
	}

	public int getY() {
		return (int) coordenadas[1];
	}

	public void setY(float y) {
		this.coordenadas[1] = y;
	}

	@Override
	public Ponto2D clone() {
		return new Ponto2D(this.getX(), this.getY());
	}

	public void setCoordenadas(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public float[] getCoordenadas() {
		return this.coordenadas;
	}

	public int limiteHorizontalInferior() {
		return (int) coordenadas[0];
	}

	public int limiteHorizontalSuperior() {
		return (int) coordenadas[0];
	}

	public int limiteVerticalInferior() {
		return (int) coordenadas[1];
	}

	public int limiteVerticalSuperior() {
		return (int) coordenadas[1];
	}

}
