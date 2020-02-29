package com.ayrton.psw2.util;

public class Linha implements FiguraGeometrica {
	Ponto2D a;
	Ponto2D b;

	public Linha(Ponto2D a, Ponto2D b) {
		if (a != null && b != null) {
			if (!a.equals(b)) {
				this.a = a.clone();
				this.b = b.clone();
			} else {
				this.a = a.clone();
				this.b = new Ponto2D(0, 0);
				if (a.equals(b))
					b.setCoordenadas(1, 1);
			}
		}
	}

	public static Linha ParseLinha2D(String str) {
		str = str.trim();
		if (str.matches("\\[\\([0-9]+; [0-9]+\\)\\([0-9]+; [0-9]+\\)\\]")) {
			String p = str.substring(1, str.indexOf(')') + 1);
			Ponto2D p1 = Ponto2D.ParsePonto2D(p);
			p = str.substring(str.indexOf(')') + 1, str.length() - 1);
			Ponto2D p2 = Ponto2D.ParsePonto2D(p);

			return new Linha(p1, p2);
		} else
			return null;
	}

	public Linha() {
		this.a = new Ponto2D(0,0);
		this.b = new Ponto2D(1,1);
	}
	
	public Ponto2D getA() {
		return this.a;
	}
	public void setA(Ponto2D a) {
		if(!a.equals(b)) {
			this.a = a.clone();
		}
	}
	public Ponto2D getB() {
		return this.b;
	}
	public void setB(Ponto2D b) {
		if(!b.equals(a)) {
			this.b = b.clone();
		}
	}
	
	protected Linha clone() {
		return new Linha(this.a, this.b);
	}
	
	public String toString() {
		return String.format("[%s%s]", a, b);
	}
	
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		if(this == obj)
			return true;
		if(a.equals(((Linha)obj).a) && b.equals(((Linha)obj).a))
			return true;
		return false;
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
	public float tamanhoHorizontal() {
		return (float) a.distanciaHorizontal(b);
	}

	@Override
	public float tamanhoVertical() {
		return (float)a.distanciaVertical(b);
	}

	@Override
	public double distancia(Ponto2D p) {
		return this.centro().distancia(p.centro());
	}

	@Override
	public Ponto2D centro() {
		return new Ponto2D((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
	}

	@Override
	public int limiteHorizontalInferior() {
		return a.getX() < b.getX() ? a.getX() : b.getX();
	}

	@Override
	public int limiteHorizontalSuperior() {
		return a.getX() > b.getX() ? a.getX() : b.getX();
	}

	@Override
	public int limiteVerticalInferior() {
		return a.getY() < b.getY() ? a.getY() : b.getY();
	}

	@Override
	public int limiteVerticalSuperior() {
		return a.getY() > b.getY() ? a.getY() : b.getY();
	}

}
