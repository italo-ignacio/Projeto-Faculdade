package model;

public class Curso {

	private String codCurso;
	private String codInstituto;
	private String nomeCurso;
	private int cargaHoraria;
	private String tipoCurso;
	private String disciplinas;
	private String professores;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public String getCodInstituto() {
		return codInstituto;
	}

	public void setCodInstituto(String codInstituto) {
		this.codInstituto = codInstituto;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(String tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public String getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getProfessores() {
		return professores;
	}

	public void setProfessores(String professores) {
		this.professores = professores;
	}

}
