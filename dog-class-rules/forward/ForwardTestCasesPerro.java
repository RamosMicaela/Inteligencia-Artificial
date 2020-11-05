package forward;

import static utils.TestCaseUtilsPerro.assertResults;
import static utils.TestCaseUtilsPerro.print;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import model.DiagnosticoFinalPerro;
import model.DiagnosticoPreliminarPerro;
import model.EstadoAnimico;
import model.EstadoFisico;
import model.EstadoGeneral;
import model.Perro;
import utils.KnowledgeSessionHelper;

public class ForwardTestCasesPerro {

	// Buscar archivo kmodule.xml. El nombre de la sesion debe ser igual al
	// configurado en ese archivo
	String K_SESSION_NAME = "kforward-chaining-session";

	KieSession sessionStatefull;
	static KieContainer kieContainer;

	FactHandle perroDir;

	public ForwardTestCasesPerro() {
	}

	@BeforeClass
	public static void beforeallTestSetup() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	private void prepareKnowledgeSession() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
	}

	@Before
	public void setUp() {
		print("----------Start----------");
		print();
		this.prepareKnowledgeSession(); // Inicializa una nueva base de hechos
	}

	@After
	public void tearDown() {
		print();
		print("----------End----------");
		print();
	}

	@Test
	public void noNecesitaReparacionTest() {
		print("Caso de prueba: Perro sin enfermedad");

		EstadoAnimico estadoAnimico = new EstadoAnimico();

		EstadoGeneral estadoGeneral = new EstadoGeneral();

		EstadoFisico estadoFisico = new EstadoFisico();

		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);

		print(perro);

		// FactHandle perroDir = sessionStatefull.insert(perro);
		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();
		// perro = (Perro) sessionStatefull.getObject(perroDir);

		DiagnosticoFinalPerro diagnostico = perro.getDiagnosticoFinalPerro();

		String valorEsperado = DiagnosticoPreliminarPerro.SinEnfermedad.toString();

		assertResults(diagnostico, valorEsperado);
	}

	/*
	 * 
	 * @Test public void cargarBateriaTest() {
	 * 
	 * print("Caso de prueba: Cargar Bateria");
	 * 
	 * Motor motor = new Motor(); motor.setArranque(Arranque.NoGira);
	 * 
	 * Bateria bateria = new Bateria(); bateria.setTieneCarga(false);
	 * 
	 * TanqueCombustible tanque = new TanqueCombustible();
	 * tanque.setTieneCombustible(true);
	 * 
	 * Automovil automovil = new Automovil(motor, bateria, tanque);
	 * 
	 * print(automovil); sessionStatefull.insert(automovil);
	 * sessionStatefull.fireAllRules();
	 * 
	 * Diagnostico diagnostico = automovil.getDiagnostico();
	 * 
	 * String valorEsperado = DiagnosticoPreliminar.CargarBateria.toString();
	 * assertResults(diagnostico, valorEsperado); }
	 * 
	 * @Test public void necesitaCombustibleTest() {
	 * 
	 * print("Caso de prueba: Necesita Combustible");
	 * 
	 * Motor motor = new Motor(); motor.setArranque(Arranque.Gira);
	 * 
	 * TanqueCombustible tanque = new TanqueCombustible();
	 * tanque.setTieneCombustible(false);
	 * 
	 * Bateria bateria = new Bateria(); bateria.setTieneCarga(true);
	 * 
	 * Automovil automovil = new Automovil(motor, bateria, tanque);
	 * 
	 * print(automovil);
	 * 
	 * sessionStatefull.insert(automovil); sessionStatefull.fireAllRules();
	 * 
	 * Diagnostico diagnostico = automovil.getDiagnostico();
	 * 
	 * String valorEsperado = DiagnosticoPreliminar.CargarCombustible.toString();
	 * 
	 * assertResults(diagnostico, valorEsperado); }
	 * 
	 * 
	 * @Test public void limpiarTuberiasCombustibleTest() {
	 * 
	 * print("Caso de prueba: Limpiar Tuberias de combustible");
	 * 
	 * Motor motor = new Motor(); motor.setArranque(Arranque.Gira);
	 * motor.setFuerzaMotor(FuerzaMotor.Debil);
	 * 
	 * Bateria bateria = new Bateria(); bateria.setTieneCarga(true);
	 * 
	 * TanqueCombustible tanque = new TanqueCombustible();
	 * tanque.setTieneCombustible(true);
	 * 
	 * Automovil automovil = new Automovil(motor, bateria, tanque);
	 * 
	 * print(automovil);
	 * 
	 * sessionStatefull.insert(automovil); sessionStatefull.fireAllRules();
	 * 
	 * Diagnostico diagnostico = automovil.getDiagnostico();
	 * 
	 * String valorEsperado =
	 * DiagnosticoMotor.LimpiarTuberiasCombustible.toString();
	 * assertResults(diagnostico, valorEsperado); }
	 * 
	 * 
	 * @Test public void ajustarPuntosDeInjeccionTest() {
	 * 
	 * print("Caso de prueba: Cargar Ajustar Puntos de Injeccion");
	 * 
	 * Motor motor = new Motor(); motor.setArranque(Arranque.Gira);
	 * motor.setPresentaExplosiones(true);
	 * 
	 * Bateria bateria = new Bateria(); bateria.setTieneCarga(true);
	 * 
	 * TanqueCombustible tanque = new TanqueCombustible();
	 * tanque.setTieneCombustible(true);
	 * 
	 * Automovil automovil = new Automovil(motor,bateria,tanque);
	 * 
	 * print(automovil);
	 * 
	 * sessionStatefull.insert(automovil); sessionStatefull.fireAllRules();
	 * 
	 * Diagnostico diagnostico = automovil.getDiagnostico();
	 * 
	 * String valorEsperado = DiagnosticoMotor.AjustarPuntosDeInyeccion.toString();
	 * assertResults(diagnostico, valorEsperado); }
	 * 
	 * @Test public void ajustarTimingMotorTest() {
	 * 
	 * print("Caso de prueba: Ajustar Timing del Motor");
	 * 
	 * Motor motor = new Motor(); motor.setArranque(Arranque.Gira);
	 * motor.setPresentaGolpes(true);
	 * 
	 * Bateria bateria = new Bateria(); bateria.setTieneCarga(true);
	 * 
	 * TanqueCombustible tanque = new TanqueCombustible();
	 * tanque.setTieneCombustible(true);
	 * 
	 * Automovil automovil = new Automovil(motor,bateria,tanque);
	 * 
	 * print(automovil);
	 * 
	 * sessionStatefull.insert(automovil); sessionStatefull.fireAllRules();
	 * 
	 * Diagnostico diagnostico = automovil.getDiagnostico();
	 * 
	 * String valorEsperado = DiagnosticoMotor.AjustarTimingMotor.toString();
	 * 
	 * assertResults(diagnostico, valorEsperado); }
	 * 
	 * @Test public void consultarExpertosTest() {
	 * 
	 * print("Caso de prueba: Consultar Experto");
	 * 
	 * Motor motor = new Motor(); motor.setArranque(Arranque.Gira);
	 * motor.setFuerzaMotor(FuerzaMotor.Normal);
	 * motor.setPresentaExplosiones(false); motor.setPresentaGolpes(false);
	 * motor.setObservaFuncNormal(false);
	 * 
	 * Bateria bateria = new Bateria(); bateria.setTieneCarga(true);
	 * 
	 * TanqueCombustible tanque = new TanqueCombustible();
	 * tanque.setTieneCombustible(true);
	 * 
	 * Automovil automovil = new Automovil(motor,bateria,tanque);
	 * 
	 * print(automovil);
	 * 
	 * sessionStatefull.insert(automovil); sessionStatefull.fireAllRules();
	 * 
	 * Diagnostico diagnostico = automovil.getDiagnostico();
	 * 
	 * String valorEsperado = DiagnosticoMotor.ConsultarExperto.toString();
	 * 
	 * assertResults(diagnostico, valorEsperado); }
	 * 
	 */

	private RuleRuntimeEventListener buildEventListener() {
		return new RuleRuntimeEventListener() {
			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {

				System.out.println("Object updated \n" + event.getObject().toString());
			}

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n" + event.getObject().toString());
			}

			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object deleted \n" + event.getOldObject().toString());
			}
		};
	}
}
