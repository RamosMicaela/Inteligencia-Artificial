package forward;

import static utils.TestCaseUtilsPerro.assertResults;
import static utils.TestCaseUtilsPerro.print;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import model.Diagnostico;
import model.DiagnosticoPreliminar;
import model.EstadoAnimico;
import model.EstadoFisico;
import model.EstadoGeneral;
import model.Perro;
import model.Sexo;
import utils.KnowledgeSessionHelper;

public class ForwardTestCasesPerro {
	String K_SESSION_NAME = "kforward-chaining-session";

	KieSession sessionStatefull;
	static KieContainer kieContainer;

	FactHandle perroDir;

	public ForwardTestCasesPerro() {
	}

	@BeforeClass
	public static void beforeallTestSetup() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
		print("----------Forward Rules Tests----------");
		print();
	}

	private void prepareKnowledgeSession() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, K_SESSION_NAME);
	}

	@Before
	public void setUp() {
		print("----------Start----------");
		print();
		this.prepareKnowledgeSession();
	}

	@After
	public void tearDown() {
		print();
		print("----------End----------");
		print();
		this.sessionStatefull.dispose();
	}

	@Test
	public void perroSinEnfermedadTest() {
		print("Caso de prueba: Perro sin enfermedad");

		EstadoAnimico estadoAnimico = new EstadoAnimico();
		EstadoGeneral estadoGeneral = new EstadoGeneral();
		EstadoFisico estadoFisico = new EstadoFisico();

		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);

		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = DiagnosticoPreliminar.SinEnfermedad.toString();

		assertResults(diagnostico, valorEsperado);
	}

	@Test
	public void perroConParvovirusTest() {
		print("Caso de prueba: Perro con Parvovirus");

		EstadoAnimico estadoAnimico = new EstadoAnimico();
		estadoAnimico.setPresentaApatiaYTristeza(true);
		estadoAnimico.setPresentaPerdidaDeApetito(true);
		
		EstadoGeneral estadoGeneral = new EstadoGeneral();
		estadoGeneral.setPresentaHecesConSangre(true);
		estadoGeneral.setPresentaVomitos(true);
		estadoGeneral.setPresentaDiarrea(true);
		
		EstadoFisico estadoFisico = new EstadoFisico();
		estadoFisico.setPresentaDebilidad(true);
		estadoFisico.setpresentaDeshidratacion(true);
		estadoFisico.setPresentaOjosHundidos(true);
		estadoFisico.setPresentaMucosasPalidas(true);
		
		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);

		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = DiagnosticoPreliminar.Parvovirus.toString();

		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void perroConMastitisTest() {
		print("Caso de prueba: Perro con Mastiis");
		
		EstadoAnimico estadoAnimico = new EstadoAnimico();
		estadoAnimico.setPresentaApatiaYTristeza(true);
		estadoAnimico.setPresentaPerdidaDeApetito(true);
		
		EstadoGeneral estadoGeneral = new EstadoGeneral();
		estadoGeneral.setPresentaVomitos(true);
		estadoGeneral.setPresentaDiarrea(true);

		EstadoFisico estadoFisico = new EstadoFisico();
		estadoFisico.setPresentaAumentoDelRitmoCardiaco(true);
		estadoFisico.setPresentaDolorEnPezones(true);
		estadoFisico.setPresentaFiebre(true);

		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);
		perro.setSexo(Sexo.Hembra);
		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = DiagnosticoPreliminar.Mastitis.toString();

		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void perroConParasitosIntestinalesTest() {
		print("Caso de prueba: Perro con Parasitos Intestinales");
		
		EstadoAnimico estadoAnimico = new EstadoAnimico();
		estadoAnimico.setPresentaPerdidaDeApetito(true);
		
		EstadoGeneral estadoGeneral = new EstadoGeneral();
		estadoGeneral.setPresentaVomitos(true);
		estadoGeneral.setPresentaHecesBlandas(true);

		EstadoFisico estadoFisico = new EstadoFisico();
		estadoFisico.setPresentaAdelgazamiento(true);
		estadoFisico.setPresentaObstruccionIntestinal(true);
		
		
		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);
		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = DiagnosticoPreliminar.ParasitosIntestinales.toString();

		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void perroConGusanosDelCorazonTest() {
		print("Caso de prueba: Perro con Gusanos del Corazon");
		
		EstadoAnimico estadoAnimico = new EstadoAnimico();
		estadoAnimico.setPresentaPerdidaDeApetito(true);
		
		EstadoGeneral estadoGeneral = new EstadoGeneral();
		estadoGeneral.setPresentaTos(true);
		estadoGeneral.setPresentaDesmayos(true);
		estadoGeneral.setPresentaHemorragiasNasales(true);

		EstadoFisico estadoFisico = new EstadoFisico();
		estadoFisico.setPresentaAdelgazamiento(true);
		estadoFisico.setPresentaAscitis(true);
		
		
		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);
		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = DiagnosticoPreliminar.GusanoDelCorazon.toString();

		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void perroConArtritisYAtrosisTest() {
		print("Caso de prueba: Perro con Artritis y Atrosis");
		
		EstadoAnimico estadoAnimico = new EstadoAnimico();
		
		EstadoGeneral estadoGeneral = new EstadoGeneral();

		EstadoFisico estadoFisico = new EstadoFisico();
		estadoFisico.setPresentaCrujidosEnArticulaciones(true);
		estadoFisico.setPresentaDolorArticular(true);
		estadoFisico.setPresentaInflamacionEnArticulaciones(true);
		estadoFisico.setPresentaRigidezYLimitacionEnMovimientos(true);
		
		
		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);
		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = DiagnosticoPreliminar.ArtritisYAtrosis.toString();

		assertResults(diagnostico, valorEsperado);
	}
	
	@Test
	public void perroConEnfermedadSinDefinirTest() {
		print("Caso de prueba: Perro con Enfermedad sin definir");
		// Este caso debería darse siempre que el perro tenga algun sintoma de más o de menos
		// de los que están tenidos en cuenta en las reglas
		
		EstadoAnimico estadoAnimico = new EstadoAnimico();
		estadoAnimico.setPresentaApatiaYTristeza(true);
		
		EstadoGeneral estadoGeneral = new EstadoGeneral();

		EstadoFisico estadoFisico = new EstadoFisico();
		estadoFisico.setPresentaCrujidosEnArticulaciones(true);
		estadoFisico.setPresentaDolorArticular(true);
		estadoFisico.setPresentaInflamacionEnArticulaciones(true);
		estadoFisico.setPresentaRigidezYLimitacionEnMovimientos(true);
		
		
		Perro perro = new Perro(estadoGeneral, estadoFisico, estadoAnimico);
		print(perro);

		sessionStatefull.insert(perro);
		sessionStatefull.fireAllRules();

		Diagnostico diagnostico = perro.getDiagnosticoFinal();

		String valorEsperado = "Llevar a veterinario";

		assertResults(diagnostico, valorEsperado);
	}
}
