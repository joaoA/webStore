package controllers;

import java.util.ArrayList;
import java.util.List;

import models.MaquinaInfantil;
import models.Bolsa;
import models.Maquina;
import models.MaquinaAventura;
import models.MaquinaReflex;
import models.MaterialFoto;
import models.Objetiva;

public class Recommend {

	private Search search = new Search();

	public boolean priceFit(String preco, String preco2, int option) {
		double min = 0;
		double max = 0;

		if(option == 1) { //maq to maq
			min = Double.parseDouble(preco2.replace(",", ".")) * 0.8;
			max = Double.parseDouble(preco2.replace(",", ".")) * 1.2;
		}
		else if(option == 2) { //maq to bolsa
			min = Double.parseDouble(preco2.replace(",", ".")) * 0.08;
			max = Double.parseDouble(preco2.replace(",", ".")) * 0.15;
		}
		else if(option == 3) { //maq to obj
			min = Double.parseDouble(preco2.replace(",", ".")) * 0.3;
			max = Double.parseDouble(preco2.replace(",", ".")) * 0.6;
		}
		else if(option == 4) { //obj to maq
			min = Double.parseDouble(preco2.replace(",", ".")) * 1;
			max = Double.parseDouble(preco2.replace(",", ".")) * 3;
		}
		else if(option == 5) { //bolsa to maq
			min = Double.parseDouble(preco2.replace(",", ".")) * 8;
			max = Double.parseDouble(preco2.replace(",", ".")) * 12;
		}
		else if(option == 6) { //bolsa to bolsa
			min = Double.parseDouble(preco2.replace(",", ".")) * 0.8;
			max = Double.parseDouble(preco2.replace(",", ".")) * 1.2;
		}
		else { //obj to obj
			min = Double.parseDouble(preco2.replace(",", ".")) * 0.8;
			max = Double.parseDouble(preco2.replace(",", ".")) * 1.2;
		}

		double price = Double.parseDouble(preco.replace(",", "."));
		return min < price && price < max;
	}

	private boolean dimFit(String dimBolsa, String dimMaq) {
		return volume(dimBolsa) > volume(dimMaq);
	}

	private double volume(String dim) {

		double vol = 0;

		String[] ar = dim.replace(",",".").split(" ");
		int factor = 1;
		if(ar[5].equals("cm"))
			factor = 10;

		vol = Double.parseDouble(ar[0])*factor;
		vol *= Double.parseDouble(ar[2])*factor;
		vol *= Double.parseDouble(ar[4])*factor;

		return vol;
	}

	private boolean quality(String quality, String distFocal) {
		int dist = Integer.parseInt(distFocal.substring(0, distFocal.length()-2));

		if(quality.equals("amador") && dist <= 30) {
			return true;
		}
		else if(quality.equals("semi pro") && dist > 30 && dist <= 50) {
			return true;
		}
		else if(quality.equals("pro") && dist > 50) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<MaterialFoto> recommendReflex(MaquinaReflex maq) {
		List<MaterialFoto> materiais = new ArrayList<MaterialFoto>();
		List<MaterialFoto> temp;
		temp = search.search("Reflex","marca",maq.marca);
		for(MaterialFoto mat: temp) {
			if(mat.id != maq.id)
				materiais.add(mat);
		}

		temp = search.search("Reflex","!marca",maq.marca);
		for(MaterialFoto mat: temp) {
			if(priceFit(mat.getPreco(),maq.getPreco(),1))
				materiais.add(mat);
		}

		temp = search.search("Bolsas","all","");
		for(MaterialFoto mat: temp) {
			if(dimFit(((Bolsa)mat).getDimInterior(),maq.getDimensao()) && priceFit(mat.getPreco(),maq.getPreco(),2))
				materiais.add(mat);
		}
		temp = search.search("Objetiva","marcaObj",maq.marca);
		for(MaterialFoto mat: temp) {
			if(quality(((MaquinaReflex)maq).getNivelUser(), ((Objetiva)mat).getDistFoc()))
				materiais.add(mat);
		}

		System.out.println(materiais.size());

		return materiais;
	}

	public List<MaterialFoto> recommendAventura(MaquinaAventura maq) {
		List<MaterialFoto> materiais = new ArrayList<MaterialFoto>();
		List<MaterialFoto> temp;

		temp = search.search("Aventura","marca",maq.marca);
		for(MaterialFoto mat: temp) {
			if(mat.id != maq.id)
				materiais.add(mat);
		}

		temp = search.search("Aventura","!marca",maq.marca);
		for(MaterialFoto mat: temp) {
//			System.out.println(mat.titulo + " " + maq.preco + " " + mat.preco);
			if(priceFit(mat.getPreco(),maq.getPreco(),1))
				materiais.add(mat);
		}

		temp = search.search("Bolsas", "all", "");

		for(MaterialFoto mat: temp) {
			if(dimFit(((Bolsa)mat).getDimInterior(),maq.getDimensao()) && priceFit(mat.getPreco(),maq.getPreco(),2))
				materiais.add(mat);
		}

		System.out.println(materiais.size());

		return materiais;

	}

	public List<MaterialFoto> recommendInfantil(MaquinaInfantil infantil) {
		List<MaterialFoto> materiais = new ArrayList<MaterialFoto>();
		List<MaterialFoto> temp;
		temp = search.search("Infatil","all","");

		for(MaterialFoto mat: temp) {
			if(priceFit(mat.getPreco(),infantil.getPreco(),1) && mat.id != infantil.id)
				materiais.add(mat);
		}

		System.out.println(materiais.size());

		return materiais;
	}

	public List<MaterialFoto> recommendBolsa(Bolsa bolsa) {
		List<MaterialFoto> materiais = new ArrayList<MaterialFoto>();
		List<MaterialFoto> temp;
		temp = search.search("Bolsas","all","");
		for(MaterialFoto mat: temp) {
			if(priceFit(mat.getPreco(),bolsa.getPreco(),6) && mat.id != bolsa.id)
				materiais.add(mat);
		}
		temp = search.search("Reflex","all","");
		temp.addAll(search.search("Aventura", "all",""));
		for(MaterialFoto mat: temp) {
//			System.out.println(mat.getTitulo());
			if(dimFit(((Maquina)mat).getDimensao(),bolsa.getDimInterior()) && priceFit(mat.getPreco(),bolsa.getPreco(),5))
				materiais.add(mat);
		}

		System.out.println(materiais.size());

		return materiais;
	}

	public List<MaterialFoto> recommendObjetiva(Objetiva obj) {
		List<MaterialFoto> materiais = new ArrayList<MaterialFoto>();
		List<MaterialFoto> temp;

		String marca = chkMarcaObj(obj);
		System.out.println(marca);

		temp = search.search("Objetiva","marcaObj",marca);
		for(MaterialFoto mat: temp) {
			if(priceFit(mat.getPreco(),obj.getPreco(),7) && mat.id != obj.id)
				materiais.add(mat);
		}

		temp = search.search("Reflex","marca",marca);
		for(MaterialFoto mat: temp) {
			if(quality(((MaquinaReflex)mat).getNivelUser(), obj.getDistFoc()))
				materiais.add(mat);
		}

		System.out.println(materiais.size());

		return materiais;
	}

	private String chkMarcaObj(Objetiva obj) {

		String[] marcas = {"Canon","Nikon","Sony"};

		for(String s: marcas) {
			if(s.equals(obj.getMarca()))
				return s;
		}

		for(String s: marcas) {
			if(s.equals(obj.getTitulo().substring(obj.getTitulo().length()-5)))
				return s;
		}

		return "";
	}

}
