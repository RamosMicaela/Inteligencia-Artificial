package model;

public enum DiagnosticoPreliminarPerro {
	
	SinEnfermedad,
	NoDeterminado,
	Parvovirus,
	Mastitis,
	ParasitosIntestinales,
	GusanoDelCorazon,
	ArtritisYAtrosis;
	
	public Boolean isa(DiagnosticoPreliminarPerro diagnostico) {
		
		return this.toString() == diagnostico.toString();
	}
}
