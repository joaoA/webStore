package models;

public class MaquinaReflex extends MaquinaAdulto{

	private String objetiva;
	private String nivelUser;

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
