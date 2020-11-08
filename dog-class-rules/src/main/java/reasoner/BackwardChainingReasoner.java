package reasoner;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.QueryResults;

import model.Diagnostico;
import model.DiagnosticoPreliminar;

public class BackwardChainingReasoner {
	KieSession sessionStatefull;
	
	public BackwardChainingReasoner(KieSession sessionStatefull) {
		this.sessionStatefull = sessionStatefull;
	}
	
	public FactHandle insert(Object obj) {
		return sessionStatefull.insert(obj);
	}
	
	public Diagnostico fireDiagnosis() {
		Diagnostico diagnostico = new Diagnostico();
		DiagnosticoPreliminar diagnosticoPreliminar = this.diagnosticoPreliminarPerro();
		diagnostico.setDiagnosticoPreliminar(diagnosticoPreliminar);

		return diagnostico;
	}
	
	public DiagnosticoPreliminar diagnosticoPreliminarPerro() {
		
		QueryResults result;
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro sin enfermedad");
		if (result.size() >= 1) {
			return DiagnosticoPreliminar.SinEnfermedad;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Parvovirus");
		if (result.size() >= 1) {
			return DiagnosticoPreliminar.Parvovirus;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Mastitis");
		if (result.size() >= 1) {
			return DiagnosticoPreliminar.Mastitis;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Parasitos Intestinales");
		if (result.size() >= 1) {
			return DiagnosticoPreliminar.ParasitosIntestinales;
		}
	
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Gusanos del Corazon");
		if (result.size() >= 1) {
			return DiagnosticoPreliminar.GusanoDelCorazon;
		}
		
		result = sessionStatefull.getQueryResults("Hipotesis: Perro con Artritis y Atrosis");
		if (result.size() >= 1) {
			return DiagnosticoPreliminar.ArtritisYAtrosis;
		}
		
		return DiagnosticoPreliminar.NoDeterminado;
	}
}
