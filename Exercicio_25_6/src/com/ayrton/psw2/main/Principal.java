package com.ayrton.psw2.main;

import com.ayrton.psw2.util.Ponto2D;
import com.ayrton.psw2.util.Retangulo;
import com.ayrton.psw2.util.Triangulo;

public class Principal {
	public static void main(String[]args) {
		Ponto2D p= new Ponto2D();
		p.setCoordenadas(2, 2);
		Ponto2D p1 = new Ponto2D(p.getX(),p.getY());
		Triangulo t = new Triangulo();
		System.out.println(p);
		System.out.println(t);
		Retangulo r = new Retangulo();
		r.setB(p);
		System.out.println(r);
		System.out.println(r.perimetro());
	}
}
