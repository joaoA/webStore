package models;

import javax.persistence.*;
import play.db.jpa.Model;

public class MaquinaAventura extends MaquinaAdulto{

	public String zoom;
	public String abertura;
	public String iso;
	public String velocidade;

	public MaquinaAventura() {}

	public String getZoom() {
		return zoom;
	}
	public void setZoom(String zoom) {
		this.zoom = zoom;
	}
	public String getAbertura() {
		return abertura;
	}
	public void setAbertura(String abertura) {
		this.abertura = abertura;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(String velocidade) {
		this.velocidade = velocidade;
	}

}
