package reasoner;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;

import model.DiagnosticoFinalPerro;
import model.DiagnosticoPreliminarPerro;

public class BackwardChainingReasoner {
	KieSession sessionStatefull;
	
	public BackwardChainingReasoner(KieSession sessionStatefull) {
		this.sessionStatefull = sessionStatefull;
	}
	
	public FactHandle insert(Object obj) {
		return sessionStatefull.insert(obj);
	}
	
	public DiagnosticoFinalPerro fireDiagnosis() {
		DiagnosticoFinalPerro diagnostico = new DiagnosticoFinalPerro();
		DiagnosticoPreliminarPerro diagnosticoPreliminar = this.diagnosticoPreliminarPerro();
		diagnostico.setDiagnosticoPreliminarPerro(diagnosticoPreliminar);

		return diagnostico;
	}
	
	public DiagnosticoPreliminarPerro diagnosticoPreliminarPerro() {
		
		QueryResults result;
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro sin enfermedad");
		if (result.size() >= 1) {
			return DiagnosticoPreliminarPerro.SinEnfermedad;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Parvovirus");
		if (result.size() >= 1) {
			return DiagnosticoPreliminarPerro.Parvovirus;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Mastitis");
		if (result.size() >= 1) {
			return DiagnosticoPreliminarPerro.Mastitis;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Parasitos Intestinales");
		if (result.size() >= 1) {
			return DiagnosticoPreliminarPerro.ParasitosIntestinales;
		}
	
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Gusanos del Corazon");
		if (result.size() >= 1) {
			return DiagnosticoPreliminarPerro.GusanoDelCorazon;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Artritis y Atrosis");
		if (result.size() >= 1) {
			return DiagnosticoPreliminarPerro.ArtritisYAtrosis;
		}
		
		return DiagnosticoPreliminarPerro.NoDeterminado;
	}
}
