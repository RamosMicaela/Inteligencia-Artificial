package model;

public class Perro {

	Sexo sexo;
	EstadoGeneral estadoGeneral;
	EstadoFisico estadoFisico;
	EstadoAnimico estadoAnimico;
	public DiagnosticoFinalPerro diagnosticoFinalPerro;
	
	

	public Perro(EstadoGeneral estadoGeneral, EstadoFisico estadoFisico, EstadoAnimico estadoAnimico) {
		this.estadoGeneral = estadoGeneral;
		this.estadoFisico = estadoFisico;
		this.estadoAnimico = estadoAnimico;
		this.sexo = Sexo.Macho;
		this.diagnosticoFinalPerro = new DiagnosticoFinalPerro();
	}


	public void setDiagnosticoPreliminarPerro(DiagnosticoPreliminarPerro diagnostico) {
		this.diagnosticoFinalPerro.setDiagnosticoPreliminarPerro(diagnostico);
	}
	
	public void setDiagnosticoFinalPerro(DiagnosticoFinalPerro diagnostico) {
		this.diagnosticoFinalPerro.setDiagnosticoFinalPerro(diagnostico);
	}


	public Sexo getSexo() {
		return sexo;
	}


	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}


	public EstadoGeneral getEstadoGeneral() {
		return estadoGeneral;
	}


	public void setEstadoGeneral(EstadoGeneral estadoGeneral) {
		this.estadoGeneral = estadoGeneral;
	}


	public EstadoFisico getEstadoFisico() {
		return estadoFisico;
	}


	public void setEstadoFisico(EstadoFisico estadoFisico) {
		this.estadoFisico = estadoFisico;
	}


	public EstadoAnimico getEstadoAnimico() {
		return estadoAnimico;
	}


	public void setEstadoAnimico(EstadoAnimico estadoAnimico) {
		this.estadoAnimico = estadoAnimico;
	}
	
	public DiagnosticoFinalPerro getDiagnosticoFinalPerro() {
		return diagnosticoFinalPerro;
	}
}
