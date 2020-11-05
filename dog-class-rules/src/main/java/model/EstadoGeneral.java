package model;

public class EstadoGeneral {
	Boolean presentaHecesConSangre;
	Boolean presentaVomitos;
	Boolean presentaDiarrea;
	Boolean presentaHecesBlandas;
	Boolean presentaTos;
	Boolean presentaDesmayos;
	Boolean presentaHemorragiasNasales;
	
	public EstadoGeneral() {
		this.presentaHecesConSangre = false;
		this.presentaVomitos = false;
		this.presentaDiarrea = false;
		this.presentaHecesBlandas = false;
		this.presentaTos = false;
		this.presentaDesmayos = false;
		this.presentaHemorragiasNasales = false;
	}

	@Override
	public String toString() {
		return  "Presenta heces con sangre: " 		+ this.presentaHecesConSangre + "\n" +
				"Presenta vomitos: " 				+ this.presentaVomitos + "\n" +
				"Presenta diarrea: " 				+ this.presentaDiarrea + "\n" +
				"Presenta heces blandas: " 			+ this.presentaHecesBlandas + "\n" +
				"Presenta tos: " 					+ this.presentaTos + "\n" +
				"Presenta desmayos: " 				+ this.presentaDesmayos + "\n" +
				"Presenta hemorragias nasales: " 	+ this.presentaHemorragiasNasales + "\n";
	}

	public Boolean getPresentaHecesConSangre() {
		return presentaHecesConSangre;
	}

	public void setPresentaHecesConSangre(Boolean presentaHecesConSangre) {
		this.presentaHecesConSangre = presentaHecesConSangre;
	}

	public Boolean getPresentaVomitos() {
		return presentaVomitos;
	}

	public void setPresentaVomitos(Boolean presentaVomitos) {
		this.presentaVomitos = presentaVomitos;
	}

	public Boolean getPresentaDiarrea() {
		return presentaDiarrea;
	}

	public void setPresentaDiarrea(Boolean presentaDiarrea) {
		this.presentaDiarrea = presentaDiarrea;
	}

	public Boolean getPresentaHecesBlandas() {
		return presentaHecesBlandas;
	}

	public void setPresentaHecesBlandas(Boolean presentaHecesBlandas) {
		this.presentaHecesBlandas = presentaHecesBlandas;
	}

	public Boolean getPresentaTos() {
		return presentaTos;
	}

	public void setPresentaTos(Boolean presentaTos) {
		this.presentaTos = presentaTos;
	}

	public Boolean getPresentaDesmayos() {
		return presentaDesmayos;
	}

	public void setPresentaDesmayos(Boolean presentaDesmayos) {
		this.presentaDesmayos = presentaDesmayos;
	}

	public Boolean getPresentaHemorragiasNasales() {
		return presentaHemorragiasNasales;
	}

	public void setPresentaHemorragiasNasales(Boolean presentaHemorragiasNasales) {
		this.presentaHemorragiasNasales = presentaHemorragiasNasales;
	}
}
