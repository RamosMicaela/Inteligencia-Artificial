package model;

public class Diagnostico {
	
	public DiagnosticoPreliminar diagnosticoPreliminar;
	
	String diagnosticoFinal;
	
	public Diagnostico() {
		diagnosticoPreliminar = DiagnosticoPreliminar.NoDeterminado;
		
		diagnosticoFinal = diagnosticoPreliminar.toString();
	} 

	@Override
	public String toString() {
		return "Diagnóstico perro = [diagnosticoPreliminar=" + diagnosticoPreliminar + "]";
	}
	
	public String getDiagnosticoFinal() {
		
		if (this.diagnosticoPreliminar.isa(DiagnosticoPreliminar.NoDeterminado)) {
			return "Llevar a veterinario";
		}
		else {
			return this.diagnosticoPreliminar.toString();
		}
		
	}

	public DiagnosticoPreliminar getDiagnosticoPreliminar() {
		return diagnosticoPreliminar;
	}

	public void setDiagnosticoPreliminar(DiagnosticoPreliminar diagnosticoPreliminar) {
		this.diagnosticoPreliminar = diagnosticoPreliminar;
	}

	public void setDiagnosticoFinal(Diagnostico diagnostico) {
		this.diagnosticoFinal = diagnostico.toString();
	}
	
}
