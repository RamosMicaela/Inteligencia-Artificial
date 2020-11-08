package model;

public enum DiagnosticoPreliminar {
	
	SinEnfermedad,
	NoDeterminado,
	Parvovirus,
	Mastitis,
	ParasitosIntestinales,
	GusanoDelCorazon,
	ArtritisYAtrosis;
	
	public Boolean isa(DiagnosticoPreliminar diagnostico) {
		
		return this.toString() == diagnostico.toString();
	}
}
