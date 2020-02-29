package com.ayrton.psw2.util;

public class Retangulo implements FiguraGeometrica {
	private Ponto2D a;
	private Ponto2D b;

	public Retangulo() {
		a = new Ponto2D(0, 0);
		b = new Ponto2D(1, 1);
	}

	public Retangulo(Ponto2D p1, Ponto2D p2) {
		this.a = p1.clone();
		this.b = p2.clone();
	}

	public static Retangulo ParseRetangulo(String str) {
		str = str.trim();
		if (str.matches("\\{\\([0-9]+; [0-9]+\\)\\([0-9]+; [0-9]+\\)\\}")) {
			String p = str.substring(1, str.indexOf(')') + 1);
			Ponto2D p1 = Ponto2D.ParsePonto2D(p);
			p = str.substring(str.indexOf(')') + 1, str.length() - 1);
			Ponto2D p2 = Ponto2D.ParsePonto2D(p);

			return new Retangulo(p1, p2);
		} else
			return null;
	}

	public Ponto2D getA() {
		return a;
	}

	public void setA(Ponto2D a) {
		if (!a.equals(b))
			this.a = a.clone();

	}

	public Ponto2D getB() {
		return b;
	}

	public void setB(Ponto2D b) {
		if (!b.equals(a))
			this.b = b.clone();

	}

	protected Object clone() throws CloneNotSupportedException {
		return new Retangulo(a, b);
	}

	public String toString() {
		return String.format("{%s%s}", a, b);
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		if (this == obj)
			return true;
		if (centro().equals(((Retangulo) obj).centro()) && tamanhoHorizontal() == ((Retangulo) obj).tamanhoHorizontal()
				&& tamanhoVertical() == ((Retangulo) obj).tamanhoVertical())
			return true;
		return false;
	}

	@Override
	public float area() {
		return (float) (a.distanciaHorizontal(b) * a.distanciaVertical(b));
	}

	@Override
	public float perimetro() {
		return (float) (2 * (a.distanciaHorizontal(b) + a.distanciaVertical(b)));
	}

	@Override
	public float tamanhoHorizontal() {
		return (float) a.distanciaHorizontal(b);
	}

	@Override
	public float tamanhoVertical() {
		return (float) a.distanciaVertical(b);
	}

	@Override
	public double distancia(Ponto2D p) {
		return this.centro().distancia(p);
	}

	@Override
	public Ponto2D centro() {
		return new Ponto2D((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
	}

	public int limiteHorizontalInferior() {
		return a.getX() < b.getX() ? a.getX() : b.getX();
	}

	public int limiteHorizontalSuperior() {
		return a.getX() > b.getX() ? a.getX() : b.getX();
	}

	public int limiteVerticalInferior() {
		return a.getY() < b.getY() ? a.getY() : b.getY();
	}

	public int limiteVerticalSuperior() {
		return a.getY() > b.getY() ? a.getY() : b.getY();
	}
}
