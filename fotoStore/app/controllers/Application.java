package controllers;

import java.io.*;
import play.*;
import play.data.binding.As;
import play.modules.paginate.ValuePaginator;
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

    public static void exampleBolsas(String marca) {

        ValuePaginator paginator=null;
        if(marca==null){
            List<Bolsa> bolsas = search.searchBolsa();
            paginator = new ValuePaginator(bolsas);
            paginator.setPageSize(5);

            int i=0;
            for(Bolsa b:bolsas){
                b.imagem="\\public\\images\\bolsas\\id"+b.id+".jpg";
                //b.id=i;
                i++;
            }


        }
        else{
            List<MaterialFoto> bolsas = search.search("Bolsas","marca",marca);
            paginator = new ValuePaginator(bolsas);
            paginator.setPageSize(5);

            int i=0;
            for(MaterialFoto b:bolsas){
                b.imagem="\\public\\images\\bolsas\\id"+b.id+".jpg";
                //b.id=i;
                i++;
            }

        }
        render(paginator);
    }



    public static void bolsaById(int id){

        List<MaterialFoto> materiais = search.search("Bolsas","Id",""+id);

        List<Bolsa> bolsas = new ArrayList<Bolsa>();
        for(MaterialFoto mat: materiais) {
            bolsas.add((Bolsa)mat);
        }

        String titulo = bolsas.get(0).getTitulo();
        String preco=bolsas.get(0).getPreco();

        String imagem ="\\public\\images\\bolsas\\id"+id+".jpg";



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

    public static void exampleObjectivas(String marca) {

        ValuePaginator paginator = null;
        if(marca == null){
            List<Objetiva> objetivas = search.searchObjetiva();
            paginator = new ValuePaginator(objetivas);
            paginator.setPageSize(5);


            for(Objetiva obj : objetivas){
                obj.imagem="\\public\\images\\objetivas\\id"+obj.id+".jpg";
            }
        }
        else{
            List<MaterialFoto> objetivas = search.search("Objetiva","marca",marca);
            paginator = new ValuePaginator(objetivas);
            paginator.setPageSize(5);

            for(MaterialFoto obj : objetivas){
                obj.imagem="\\public\\images\\objetivas\\id"+obj.id+".jpg";
            }
        }
        render(paginator);
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
        ValuePaginator paginator = new ValuePaginator(maqInf);
        paginator.setPageSize(5);

        int i=0;
        for(MaquinaInfantil maq : maqInf){
            maq.imagem="\\public\\images\\infantil\\id"+i+".jpg";
            maq.id=i;
            i++;
        }
		render(paginator);
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

	public static void exampleAventura(String marca) {
        ValuePaginator paginator=null;

        if(marca == null){
        List<MaquinaAventura> maqAv = search.searchAventura();
        paginator = new ValuePaginator(maqAv);
        paginator.setPageSize(5);



        for(MaquinaAventura maq : maqAv){
            maq.imagem="\\public\\images\\aventura\\id"+maq.id+".jpg";
        }

        }
        else{
            List<MaterialFoto> maqAv = search.search("Aventura","marca",marca);
            paginator = new ValuePaginator(maqAv);
            paginator.setPageSize(5);

            for(MaterialFoto maq : maqAv){
                maq.imagem="\\public\\images\\aventura\\id"+maq.id+".jpg";
            }
        }
		render(paginator);
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

	public static void exampleReflex(String marca) {
        ValuePaginator paginator=null;

        if(marca == null){
            List<MaquinaReflex> maqRf = search.searchReflex();
            paginator = new ValuePaginator(maqRf);
            paginator.setPageSize(5);


            for(MaquinaReflex maq : maqRf){
                maq.imagem="\\public\\images\\reflex\\id"+maq.id+".jpg";
            }
        }
        else{
            List<MaterialFoto> maqRf = search.search("Reflex","marca",marca);
            paginator = new ValuePaginator(maqRf);
            paginator.setPageSize(5);

            for(MaterialFoto maq : maqRf){
                maq.imagem="\\public\\images\\reflex\\id"+maq.id+".jpg";
            }
        }
		render(paginator);
	}

    public static void reflexById(int id){

        List<MaterialFoto> materiais = search.search("Reflex","Id",""+id);

        List<MaquinaReflex> maqReflex = new ArrayList<MaquinaReflex>();
        for(MaterialFoto mat: materiais) {
            maqReflex.add((MaquinaReflex)mat);
        }

        String titulo = maqReflex.get(0).getTitulo();
        String preco=maqReflex.get(0).getPreco();

        String imagem = "\\public\\images\\reflex\\id"+id+".jpg";



        /****************************************/
         /*            Recomendacao            */
        /****************************************/
        List<MaterialFoto> recomendacao = recommend.recommendReflex(maqReflex.get(0));

        // TODO:: tirar este PREGO!

        MaquinaReflex gandaPrego= new MaquinaReflex();
        gandaPrego.id=0;
        gandaPrego.titulo="nada";
        gandaPrego.preco="zero";
        while(recomendacao.size()<4)
            recomendacao.add(gandaPrego);

        recomendacao= recomendacao.subList(0,4);

        for (MaterialFoto mat : recomendacao){
            mat.imagem = "\\public\\images\\reflex\\id"+mat.id+".jpg";
            System.out.println(mat.titulo +"  "+mat.preco);
        }

        //TODO: melhorar recomendacao

        render(maqReflex,titulo,preco,imagem,recomendacao);
    }

/************************************************************************/

/*****************          Search Results            ******************/

    public static void searchResult(String search){

        // search e' a string que vem da search bar

        System.out.println(search);


        render(search);
    }


}