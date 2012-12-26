package models;

import javax.persistence.*;
import play.db.jpa.Model;


public class Bolsa extends MaterialFoto{

	public String dimInterior;
	public String dimExterior;


	public Bolsa() {
	}

	public String getDimInterior() {
		return dimInterior;
	}

	public void setDimInterior(String dimInterior) {
		this.dimInterior = dimInterior;
	}

	public String getDimExterior() {
		return dimExterior;
	}

	public void setDimExterior(String dimExterior) {
		this.dimExterior = dimExterior;
	}

}
