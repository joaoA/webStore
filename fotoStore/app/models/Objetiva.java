package models;

import javax.persistence.*;
import play.db.jpa.Model;

public class Objetiva extends MaterialFoto{

	private String distFoc;
	private String abertura;
	private String dimensoes;
	private String peso;
	private String tipo;

	public Objetiva() {}

	public String getDistFoc() {
		return distFoc;
	}

	public void setDistFoc(String distFoc) {
		this.distFoc = distFoc;
	}

	public String getAbertura() {
		return abertura;
	}

	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Objetiva [distFoc=" + distFoc + ", abertura=" + abertura
				+ ", dimensoes=" + dimensoes + ", peso=" + peso + ", tipo="
				+ tipo + ", titulo=" + titulo + ", marca=" + marca + ", preco="
				+ preco + "]";
	}
}
