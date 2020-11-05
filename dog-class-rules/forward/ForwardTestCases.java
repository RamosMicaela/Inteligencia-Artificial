package forward;

import static utils.TestCaseUtils.assertResults;
import static utils.TestCaseUtils.print;

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

import model.Arranque;
import model.Automovil;
import model.Bateria;
import model.Diagnostico;
import model.DiagnosticoMotor;
import model.DiagnosticoPreliminar;
import model.FuerzaMotor;
import model.Motor;
import model.TanqueCombustible;
import utils.KnowledgeSessionHelper;

public class ForwardTestCases {

	// Buscar archivo kmodule.xml. El nombre de la sesion debe ser igual al
	// configurado en ese archivo
	String K_SESSION_NAME = "kforward-chaining-session";

	KieSession sessionStatefull;
	static KieContainer kieContainer;

	FactHandle automovilDir;
	
	public ForwardTestCases() {
	}
		
	@BeforeClass
	public static void beforeallTestSetup() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	private void prepareKnowledgeSession() {
		
		
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
		// OutputDisplay outputDisplay = new OutputDisplay();
		//sessionStatefull.addEventListener(buildEventListener());
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
		print("Caso de prueba: No necesita reparacion");
		
		Motor motor = new Motor();
		
		motor.setArranque(Arranque.Gira);
		motor.setFuerzaMotor(FuerzaMotor.Normal);
		motor.setPresentaExplosiones(false);
		motor.setObservaFuncNormal(true);
		
		Bateria bateria = new Bateria();
		bateria.setTieneCarga(true);
		
		TanqueCombustible tanque = new TanqueCombustible();
		tanque.setTieneCombustible(true);
		
		Automovil automovil = new Automovil(motor, bateria, tanque);
		
		print(automovil);
		
		//FactHandle automovilDir = sessionStatefull.insert(automovil);
		sessionStatefull.insert(automovil);
		sessionStatefull.fireAllRules();
		//automovil = (Automovil) sessionStatefull.getObject(automovilDir);
		
		Diagnostico diagnostico = automovil.getDiagnostico();
		
		String valorEsperado = DiagnosticoPreliminar.NoNecesita.toString();
		
		assertResults(diagnostico, valorEsperado);
	}

	@Test
	public void cargarBateriaTest() {
		
		print("Caso de prueba: Cargar Bateria");
		
		Motor motor = new Motor();
		motor.setArranque(Arranque.NoGira);

		Bateria bateria = new Bateria();
		bateria.setTieneCarga(false);

		TanqueCombustible tanque = new TanqueCombustible();
		tanque.setTieneCombustible(true);
		
		Automovil automovil = new Automovil(motor, bateria, tanque);
		
		print(automovil);
		sessionStatefull.insert(automovil);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = automovil.getDiagnostico();
		
		String valorEsperado = DiagnosticoPreliminar.CargarBateria.toString();
		assertResults(diagnostico, valorEsperado);
	}

	@Test
	public void necesitaCombustibleTest() {
	
		print("Caso de prueba: Necesita Combustible");
		
		Motor motor = new Motor();
		motor.setArranque(Arranque.Gira);

		TanqueCombustible tanque = new TanqueCombustible();
		tanque.setTieneCombustible(false);

		Bateria bateria = new Bateria();
		bateria.setTieneCarga(true);
		
		Automovil automovil = new Automovil(motor, bateria, tanque);
		
		print(automovil);
		
		sessionStatefull.insert(automovil);
		sessionStatefull.fireAllRules();
		
		Diagnostico diagnostico = automovil.getDiagnostico();
		
		String valorEsperado = DiagnosticoPreliminar.CargarCombustible.toString();
		
		assertResults(diagnostico, valorEsperado);
	}

	
	  @Test public void limpiarTuberiasCombustibleTest() { 
		  
		  	print("Caso de prueba: Limpiar Tuberias de combustible");

			Motor motor = new Motor();
			motor.setArranque(Arranque.Gira);
			motor.setFuerzaMotor(FuerzaMotor.Debil);
			
			Bateria bateria = new Bateria();
			bateria.setTieneCarga(true);
			
			TanqueCombustible tanque = new TanqueCombustible();
			tanque.setTieneCombustible(true);

			Automovil automovil = new Automovil(motor, bateria, tanque);

			print(automovil);
			
			sessionStatefull.insert(automovil);
			sessionStatefull.fireAllRules();
			
			Diagnostico diagnostico = automovil.getDiagnostico();
			
			String valorEsperado = DiagnosticoMotor.LimpiarTuberiasCombustible.toString();
			assertResults(diagnostico, valorEsperado);
		}
	 

	@Test
	public void ajustarPuntosDeInjeccionTest() {
	
		print("Caso de prueba: Cargar Ajustar Puntos de Injeccion");

		Motor motor = new Motor();
		motor.setArranque(Arranque.Gira);
		motor.setPresentaExplosiones(true);
	
		Bateria bateria = new Bateria();
		bateria.setTieneCarga(true);

		TanqueCombustible tanque = new TanqueCombustible();
		tanque.setTieneCombustible(true);

		Automovil automovil = new Automovil(motor,bateria,tanque);

		print(automovil);
		
		sessionStatefull.insert(automovil);
		sessionStatefull.fireAllRules();
		
		Diagnostico diagnostico = automovil.getDiagnostico();
		
		String valorEsperado = DiagnosticoMotor.AjustarPuntosDeInyeccion.toString();
		assertResults(diagnostico, valorEsperado);
	}

	@Test
	public void ajustarTimingMotorTest() {
		
		print("Caso de prueba: Ajustar Timing del Motor");

		Motor motor = new Motor();
		motor.setArranque(Arranque.Gira);
		motor.setPresentaGolpes(true);

		Bateria bateria = new Bateria();
		bateria.setTieneCarga(true);

		TanqueCombustible tanque = new TanqueCombustible();
		tanque.setTieneCombustible(true);

		Automovil automovil = new Automovil(motor,bateria,tanque);

		print(automovil);
		
		sessionStatefull.insert(automovil);
		sessionStatefull.fireAllRules();
		
		Diagnostico diagnostico = automovil.getDiagnostico();
		
		String valorEsperado = DiagnosticoMotor.AjustarTimingMotor.toString();
		
		assertResults(diagnostico, valorEsperado);
	}

	@Test
	public void consultarExpertosTest() {
		
		print("Caso de prueba: Consultar Experto");

		Motor motor = new Motor();
		motor.setArranque(Arranque.Gira);
		motor.setFuerzaMotor(FuerzaMotor.Normal);
		motor.setPresentaExplosiones(false);
		motor.setPresentaGolpes(false);
		motor.setObservaFuncNormal(false);

		Bateria bateria = new Bateria();
		bateria.setTieneCarga(true);

		TanqueCombustible tanque = new TanqueCombustible();
		tanque.setTieneCombustible(true);

		Automovil automovil = new Automovil(motor,bateria,tanque);

		print(automovil);
		
		sessionStatefull.insert(automovil);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = automovil.getDiagnostico();
		
		String valorEsperado = DiagnosticoMotor.ConsultarExperto.toString();
		
		assertResults(diagnostico, valorEsperado);
	}
	
	
	
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
