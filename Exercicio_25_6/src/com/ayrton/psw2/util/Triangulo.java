package com.ayrton.psw2.util;

public class Triangulo {
	private Ponto2D a;
	private Ponto2D b;
	private Ponto2D c;
	
	public Triangulo(){
		a = new Ponto2D(0,0);
		b = new Ponto2D(0,1);
		c = new Ponto2D(1,0);
	}
	
	public Triangulo(Ponto2D p1, Ponto2D p2, Ponto2D p3){
		this.setA(a);
		this.setB(b);
		this.setB(c);
	}
	
	public String toString() {
		return String.format("/%s,%s,%s\\",a,b,c);
	}
	
	public Ponto2D getA() {
		return a;
	}
	public void setA(Ponto2D a) {
		this.a = a.clone();
	}
	public Ponto2D getB() {
		return b;
	}
	public void setB(Ponto2D a) {
		this.b = b.clone();
	}
	public Ponto2D getC() {
		return c;
	}
	public void setC(Ponto2D a) {
		this.c = c.clone();
	}
}
