package model;

public class Disciplina {

	private String codNome;
	private int cargaHoraria;
	private int aulasSemanais;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodNome() {
		return codNome;
	}

	public void setCodNome(String codNome) {
		this.codNome = codNome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getAulasSemanais() {
		return aulasSemanais;
	}

	public void setAulasSemanais(int aulasSemanais) {
		this.aulasSemanais = aulasSemanais;
	}

}
