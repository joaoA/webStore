package controllers;

import java.io.*;
import play.*;
import play.mvc.*;

import java.util.*;
import java.lang.*;
import models.*;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void exampleObjectivas() {
		render();
	}

	public static void exampleInfantis() {
		render();
	}

	public static void exampleAventura() {
		render();
	}

	public static void exampleReflex() {
		render();
	}

	public static	void bolsaById(long id){
		List<Bolsa> bolsas = new ArrayList<Bolsa>();
		Bolsa bolsa = new Bolsa();

		String titulo = "bolsa muita fixe";
		String preco="192€";
		
		bolsa.titulo = "bolsa muita fixe";
		bolsa.marca = "bolsasMark";
		bolsa.dimExterior="10 x 20 x 40 mm";
		bolsa.dimInterior="7 x 15 x 35 mm";
		bolsa.preco = "192€";
		
		/****************************************/
		bolsas.add(bolsa);
		render(bolsas,titulo,preco);
	}
	
	public static void exampleBolsas() {
		List<Bolsa> bolsas = new ArrayList<Bolsa>();
		Bolsa bolsa = new Bolsa();

		bolsa.titulo = "bolsa muita fixe";
		bolsa.marca = "bolsasMark";
		bolsa.preco = "192€";
		bolsa.id = (long) 0;

		Bolsa bolsa2 = new Bolsa();

		bolsa2.titulo = "bolsa2";
		bolsa2.marca = "bolsasMark";
		bolsa2.preco = "50€";
		bolsa.id = (long) 1;

		/****************************************/

		bolsas.add(bolsa);
		bolsas.add(bolsa2);

		render(bolsas);
	}

}