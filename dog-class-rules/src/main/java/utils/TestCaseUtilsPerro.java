package utils;

import model.Perro;
import model.Sexo;
import model.Diagnostico;
import model.EstadoFisico;
import model.EstadoGeneral;
import model.EstadoAnimico;

public class TestCaseUtilsPerro {

	public static void print(String title) {
		System.out.println(title);
	}

	public static void print() {
		print("");
	}

	public static void print(Perro perro) {

		Sexo sexo = perro.getSexo();
		EstadoFisico estadoFisico = perro.getEstadoFisico();
		EstadoAnimico estadoAnimico = perro.getEstadoAnimico();
		EstadoGeneral estadoGeneral = perro.getEstadoGeneral();

		print();
		print("Perro");
		print("Sexo: " + sexo);
		print("Estado Fisico: \n" + estadoFisico);
		print("Estado Animico: \n" + estadoAnimico);
		print("Estado General: \n" + estadoGeneral);
		print();
	}

	public static void assertResults(Diagnostico diagnostico, String valorEsperado) {
		
		String diagnosticoFinal = diagnostico.getDiagnosticoFinal();

		printResults(diagnosticoFinal, valorEsperado);

		assert(diagnosticoFinal.equals(valorEsperado));
	}

	private static void printResults(String result,String expected) {
		print("Resultados");
		print("Esperaba: " + expected);
		print("Recibi: " + result);
		Boolean isOk = result.equals(expected);
		String condition = isOk ? "Ok" : "Fallo";
		print("Caso de prueba: "+ condition);
	}
}
