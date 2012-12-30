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
/*************************************************************************/

/*********************          BOLSA           *************************/

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
        List<MaterialFoto> recomendacao = recommend.recommendBolsa(bolsas.get(0));

        // TODO:: tirar este PREGO!

        Bolsa gandaPrego= new Bolsa();
        gandaPrego.id=0;
        gandaPrego.titulo="nada";
        gandaPrego.preco="zero";
        while(recomendacao.size()<4)
            recomendacao.add(gandaPrego);

        recomendacao= recomendacao.subList(0,4);

        for (MaterialFoto mat : recomendacao){
            mat.imagem = "\\public\\images\\bolsas\\id"+mat.id+".jpg";
            System.out.println(mat.titulo +"  "+mat.preco);
        }

        //TODO: para o caso das  bolsas mais caras, a recomendacao geral 1 bolsa,
        //TODO : temos que meter isto a gerar mais algumas, nem que seja aleatorio...depois explicamos ao prof o pq

        render(bolsas,titulo,preco,imagem,recomendacao);
    }


/****************************************************************************/

/*********************          Objectiva           *************************/

    public static void exampleObjectivas() {
        List<Objetiva> objetivas = search.searchObjetiva();

        int i=0;
        for(Objetiva obj : objetivas){
            obj.imagem="\\public\\images\\objetivas\\id"+i+".jpg";
            obj.id=i;
            i++;
        }

        render(objetivas);
    }


    public static void objectivaById(int id){

        List<MaterialFoto> materiais = search.search("Objetiva","Id",""+id);

        List<Objetiva> objectivas = new ArrayList<Objetiva>();
        for(MaterialFoto mat: materiais) {
            objectivas.add((Objetiva)mat);
        }

        String titulo = objectivas.get(0).getTitulo();
        String preco=objectivas.get(0).getPreco();

        String imagem = "\\public\\images\\objetivas\\id"+id+".jpg";



        /****************************************/
         /*            Recomendacao            */
        /****************************************/
        List<MaterialFoto> recomendacao = recommend.recommendObjetiva(objectivas.get(0));

        // TODO:: tirar este PREGO!

        Objetiva gandaPrego= new Objetiva();
        gandaPrego.id=0;
        gandaPrego.titulo="nada";
        gandaPrego.preco="zero";
        while(recomendacao.size()<4)
            recomendacao.add(gandaPrego);

        recomendacao= recomendacao.subList(0,4);

        for (MaterialFoto mat : recomendacao){
            mat.imagem = "\\public\\images\\objetivas\\id"+mat.id+".jpg";
            System.out.println(mat.titulo +"  "+mat.preco);
        }

        //TODO: melhorar recomendacao

        render(objectivas,titulo,preco,imagem,recomendacao);
    }



/************************************************************************/

/*****************          Maquinas Infantis           *****************/



	public static void exampleInfantis() {
        List<MaquinaInfantil> maqInf = search.searchInfantil();

        int i=0;
        for(MaquinaInfantil maq : maqInf){
            maq.imagem="\\public\\images\\infantil\\id"+i+".jpg";
            maq.id=i;
            i++;
        }
		render(maqInf);
	}

    public static void infantilById(int id){

        List<MaterialFoto> materiais = search.search("Infatil","Id",""+id);

        List<MaquinaInfantil> maqInfantil = new ArrayList<MaquinaInfantil>();
        for(MaterialFoto mat: materiais) {
            maqInfantil.add((MaquinaInfantil)mat);
        }

        String titulo = maqInfantil.get(0).getTitulo();
        String preco=maqInfantil.get(0).getPreco();

        String imagem = "\\public\\images\\infantil\\id"+id+".jpg";



        /****************************************/
         /*            Recomendacao            */
        /****************************************/
        List<MaterialFoto> recomendacao = recommend.recommendInfantil(maqInfantil.get(0));

        // TODO:: tirar este PREGO!

        MaquinaInfantil gandaPrego= new MaquinaInfantil();
        gandaPrego.id=0;
        gandaPrego.titulo="nada";
        gandaPrego.preco="zero";
        while(recomendacao.size()<4)
            recomendacao.add(gandaPrego);

        recomendacao= recomendacao.subList(0,4);

        for (MaterialFoto mat : recomendacao){
            mat.imagem = "\\public\\images\\infantil\\id"+mat.id+".jpg";
            System.out.println(mat.titulo +"  "+mat.preco);
        }

        //TODO: melhorar recomendacao

        render(maqInfantil,titulo,preco,imagem,recomendacao);
    }


/************************************************************************/

/*****************          Maquinas Aventura           *****************/

	public static void exampleAventura() {
        List<MaquinaAventura> maqAv = search.searchAventura();

        int i=0;
        for(MaquinaAventura maq : maqAv){
            maq.imagem="\\public\\images\\aventura\\id"+i+".jpg";
            maq.id=i;
            i++;
        }
		render(maqAv);
	}

    public static void aventuraById(int id){

        List<MaterialFoto> materiais = search.search("Aventura","Id",""+id);

        List<MaquinaAventura> maqAventura = new ArrayList<MaquinaAventura>();
        for(MaterialFoto mat: materiais) {
            maqAventura.add((MaquinaAventura)mat);
        }

        String titulo = maqAventura.get(0).getTitulo();
        String preco=maqAventura.get(0).getPreco();

        String imagem = "\\public\\images\\aventura\\id"+id+".jpg";



        /****************************************/
         /*            Recomendacao            */
        /****************************************/
        List<MaterialFoto> recomendacao = recommend.recommendAventura(maqAventura.get(0));

        // TODO:: tirar este PREGO!

        MaquinaAventura gandaPrego= new MaquinaAventura();
        gandaPrego.id=0;
        gandaPrego.titulo="nada";
        gandaPrego.preco="zero";
        while(recomendacao.size()<4)
            recomendacao.add(gandaPrego);

        recomendacao= recomendacao.subList(0,4);

        for (MaterialFoto mat : recomendacao){
            mat.imagem = "\\public\\images\\aventura\\id"+mat.id+".jpg";
            System.out.println(mat.titulo +"  "+mat.preco);
        }

        //TODO: melhorar recomendacao -> a 1º maquina nao recomenda nada

        render(maqAventura,titulo,preco,imagem,recomendacao);
    }


/************************************************************************/

/*****************          Maquinas Reflex            ******************/

	public static void exampleReflex() {
        List<MaquinaReflex> maqRf = search.searchReflex();

        int i=0;
        for(MaquinaReflex maq : maqRf){
            maq.imagem="\\public\\images\\reflex\\id"+i+".jpg";
            maq.id=i;
            i++;
        }
		render(maqRf);
	}






}