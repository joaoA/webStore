package models;

import javax.persistence.*;
import play.db.jpa.Model;

public class MaquinaInfantil extends Maquina{

	public String cor;

	public MaquinaInfantil() {}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
