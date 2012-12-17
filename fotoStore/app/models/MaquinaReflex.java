package models;

import javax.persistence.*;
import play.db.jpa.Model;

public class MaquinaReflex extends MaquinaAdulto{

	public String objetiva;
	public String nivelUser;

	public MaquinaReflex(){}

	public String getObjetiva() {
		return objetiva;
	}

	public void setObjetiva(String objetiva) {
		this.objetiva = objetiva;
	}

	public String getNivelUser() {
		return nivelUser;
	}

	public void setNivelUser(String nivelUser) {
		this.nivelUser = nivelUser;
	}

}
