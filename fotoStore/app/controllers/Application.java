package controllers;

import java.io.*;
import play.*;
import play.mvc.*;

import java.util.*;
import java.lang.*;
import models.*;

public class Application extends Controller {

	private static Search search = new Search();

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

	public static void bolsaById(long id){
		List<MaterialFoto> materiais = search.search("Bolsas",
				"select ?element " +
						"where {" +
						"?element rdf:type xmlns:Bolsas . " +
						"?element xmlns:Id \"" + id +"\"" +
						"} ");

		List<Bolsa> bolsas = new ArrayList<Bolsa>();
		for(MaterialFoto mat: materiais) {
			bolsas.add((Bolsa)mat);
		}
		String cenas = ""+bolsas.size();

//		Bolsa bolsa = new Bolsa();

		String titulo = bolsas.get(0).getTitulo();
		String preco=bolsas.get(0).getPreco();

/*		bolsa.titulo = "bolsa muita fixe";
		bolsa.marca = "bolsasMark";
		bolsa.dimExterior="10 x 20 x 40 mm";
		bolsa.dimInterior="7 x 15 x 35 mm";
		bolsa.preco = "192€";
		bolsa.id=(long)0;
*/
		String imagem = "\\public\\images\\bolsas\\id"+id+".jpg";


		/****************************************/
//		bolsas.add(bolsa);
		render(bolsas,titulo,preco,imagem,cenas);
	}

	public static void exampleBolsas() {
		List<Bolsa> bolsas = search.searchBolsa();
/*		Bolsa bolsa = new Bolsa();

		bolsa.titulo = "bolsa muita fixe";
		bolsa.marca = "bolsasMark";
		bolsa.preco = "192€";
		bolsa.id = (long) 0;

		Bolsa bolsa2 = new Bolsa();

		bolsa2.titulo = "bolsa2";
		bolsa2.marca = "bolsasMark";
		bolsa2.preco = "50€";
		bolsa.id = (long) 1;

		*//****************************************//*

		bolsas.add(bolsa);
		bolsas.add(bolsa2);
*/
		render(bolsas);
	}

}