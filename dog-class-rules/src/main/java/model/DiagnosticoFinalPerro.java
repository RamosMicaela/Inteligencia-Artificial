package model;

public class DiagnosticoFinalPerro {
	
	public DiagnosticoPreliminarPerro diagnosticoPreliminarPerro;
	
	String diagnosticoFinal;
	
	public DiagnosticoFinalPerro() {
		diagnosticoPreliminarPerro = DiagnosticoPreliminarPerro.NoDeterminado;
		
		diagnosticoFinal = diagnosticoPreliminarPerro.toString();
	} 

	@Override
	public String toString() {
		return "Diagnóstico perro = [diagnosticoPreliminar=" + diagnosticoPreliminarPerro + "]";
	}
	
	public String getDiagnosticoFinal() {
		
		if (this.diagnosticoPreliminarPerro.isa(DiagnosticoPreliminarPerro.NoDeterminado)) {
			return "Llevar a veterinario";
		}
		else {
			return this.diagnosticoPreliminarPerro.toString();
		}
		
	}

	public DiagnosticoPreliminarPerro getDiagnosticoPreliminarPerro() {
		return diagnosticoPreliminarPerro;
	}

	public void setDiagnosticoPreliminarPerro(DiagnosticoPreliminarPerro diagnosticoPreliminarPerro) {
		this.diagnosticoPreliminarPerro = diagnosticoPreliminarPerro;
	}

	public void setDiagnosticoFinalPerro(DiagnosticoFinalPerro diagnostico) {
		this.diagnosticoFinal = diagnostico.toString();
	}
	
}
