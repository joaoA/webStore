package models;

import javax.persistence.*;
import play.db.jpa.Model;

public class MaquinaAdulto extends Maquina {

	public String formVideo;
	public String fotoSeq;

	public String getFormVideo() {
		return formVideo;
	}
	public void setFormVideo(String formVideo) {
		this.formVideo = formVideo;
	}
	public String getFotoSeq() {
		return fotoSeq;
	}
	public void setFotoSeq(String fotoSeq) {
		this.fotoSeq = fotoSeq;
	}

}
