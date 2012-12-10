package materialFoto;

public class Maquina extends MaterialFoto{

	private String bateria;
	private String dimensao;
	private String dimensaoEcra;
	private String distFocal;
	private String interf;
	private String peso;
	private String resolucao;
	private String tipoMem;

	public Maquina(){}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public String getDimensao() {
		return dimensao;
	}

	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}

	public String getDimensaoEcra() {
		return dimensaoEcra;
	}

	public void setDimensaoEcra(String dimensaoEcra) {
		this.dimensaoEcra = dimensaoEcra;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getDistFocal() {
		return distFocal;
	}

	public void setDistFocal(String distFocal) {
		this.distFocal = distFocal;
	}

	public String getTipoMem() {
		return tipoMem;
	}

	public void setTipoMem(String tipoMem) {
		this.tipoMem = tipoMem;
	}

	public String getInterf() {
		return interf;
	}

	public void setInterf(String interf) {
		this.interf = interf;
	}

}
