package controllers;

import java.io.*;
import play.*;
import play.data.binding.As;
import play.mvc.*;

import java.util.*;
import java.lang.*;
import models.*;

public class Application extends Controller {

	private static Search search = new Search();
    private static Recommend recommend = new Recommend();

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


	public static void bolsaById(int id){

		List<MaterialFoto> materiais = search.search("Bolsas","Id",""+id);

		List<Bolsa> bolsas = new ArrayList<Bolsa>();
		for(MaterialFoto mat: materiais) {
			bolsas.add((Bolsa)mat);
		}

		String titulo = bolsas.get(0).getTitulo();
		String preco=bolsas.get(0).getPreco();

		String imagem = "\\public\\images\\bolsas\\id"+id+".jpg";



		/****************************************/
        /*         Recomendacao das bolsas      */
        /****************************************/
//        List<MaterialFoto> recomendacao = recommend.recommendBolsa(bolsas.get(0));


		render(bolsas,titulo,preco,imagem);
	}

	public static void exampleBolsas() {
		List<Bolsa> bolsas = search.searchBolsa();

        int i=0;
        for(Bolsa b:bolsas){
            b.imagem="\\public\\images\\bolsas\\id"+i+".jpg";
            b.id=i;
            i++;
        }


        //ValuePaginator paginator = new ValuePaginator(bolsas);
		render(bolsas);
	}

}