package models;

import javax.persistence.*;

import play.db.jpa.Model;

public class MaterialFoto extends Model {

	public String titulo;
	public String marca;
	public String preco;
    public String imagem;
    public String tipoMat;
    public int id;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getTipoMat() {
		return tipoMat;
	}
	public void setTipoMat(String tipoMat) {
		this.tipoMat = tipoMat;
	}

	@Override
	public String toString() {
		return "MaterialFoto [titulo=" + titulo + ", marca=" + marca
				+ ", preco=" + preco + ", imagem=" + imagem + ", tipoMat="
				+ tipoMat + ", id=" + id + "]";
	}


}
