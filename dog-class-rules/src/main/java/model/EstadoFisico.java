package model;

public class EstadoFisico {
	Boolean presentaDebilidad;
	Boolean presentaDeshidratacion;
	Boolean presentaOjosHundidos;
	Boolean presentaMucosasPalidas;
	Boolean presentaDolorEnPezones;
	Boolean presentaFiebre;
	Boolean presentaAumentoDelRitmoCardiaco;
	Boolean presentaAdelgazamiento;
	Boolean presentaObstruccionIntestinal;
	Boolean presentaAscitis;
	Boolean presentaDolorArticular;
	Boolean presentaRigidezYLimitacionEnMovimientos;
	Boolean presentaInflamacionEnArticulaciones;
	Boolean presentaCrujidosEnArticulaciones;
	
	public EstadoFisico() {
		this.presentaDebilidad = false;
		this.presentaDeshidratacion = false;
		this.presentaOjosHundidos = false;
		this.presentaMucosasPalidas = false;
		this.presentaDolorEnPezones = false;
		this.presentaFiebre = false;
		this.presentaAumentoDelRitmoCardiaco = false;
		this.presentaAdelgazamiento = false;
		this.presentaObstruccionIntestinal = false;
		this.presentaAscitis = false;
		this.presentaDolorArticular = false;
		this.presentaRigidezYLimitacionEnMovimientos = false;
		this.presentaInflamacionEnArticulaciones = false;
		this.presentaCrujidosEnArticulaciones = false;
	}

	@Override
	public String toString() {
		return  "Presenta debilidad: " + this.presentaDebilidad + "\n" +
				"Presenta deshidratación: "	+ this.presentaDeshidratacion + "\n" +
				"Presenta ojos hundidos: " + this.presentaOjosHundidos + "\n" +
				"Presenta mucosas pálidas: " + this.presentaMucosasPalidas + "\n" +
				"Presenta dolor en los pezones: " + this.presentaDolorEnPezones + "\n" +
				"Presenta fiebre: " + this.presentaFiebre + "\n" +
				"Presenta aumento del ritmo cardiaco: " + this.presentaAumentoDelRitmoCardiaco + "\n" +
				"Presenta adelgazamiento: " + this.presentaAdelgazamiento + "\n" +
				"Presenta obstrucción intestinal: " + this.presentaObstruccionIntestinal + "\n" +
				"Presenta ascitis: " + this.presentaAscitis + "\n" +
				"Presenta dolor articular: " + this.presentaDolorArticular + "\n" +
				"Presenta rigidez y limitacion en los movimientos: " + this.presentaRigidezYLimitacionEnMovimientos + "\n" +
				"Presenta inflamacion en las articulaciones: " + this.presentaInflamacionEnArticulaciones + "\n" +
				"Presenta crujidos en articulaciones: " + this.presentaCrujidosEnArticulaciones + "\n";
	}

	public Boolean getPresentaDebilidad() {
		return presentaDebilidad;
	}

	public void setPresentaDebilidad(Boolean presentaDebilidad) {
		this.presentaDebilidad = presentaDebilidad;
	}

	public Boolean getpresentaDeshidratacion() {
		return presentaDeshidratacion;
	}

	public void setpresentaDeshidratacion(Boolean presentaDeshidratacion) {
		this.presentaDeshidratacion = presentaDeshidratacion;
	}

	public Boolean getPresentaOjosHundidos() {
		return presentaOjosHundidos;
	}

	public void setPresentaOjosHundidos(Boolean presentaOjosHundidos) {
		this.presentaOjosHundidos = presentaOjosHundidos;
	}

	public Boolean getPresentaMucosasPalidas() {
		return presentaMucosasPalidas;
	}

	public void setPresentaMucosasPalidas(Boolean presentaMucosasPalidas) {
		this.presentaMucosasPalidas = presentaMucosasPalidas;
	}

	public Boolean getPresentaDolorEnPezones() {
		return presentaDolorEnPezones;
	}

	public void setPresentaDolorEnPezones(Boolean presentaDolorEnPezones) {
		this.presentaDolorEnPezones = presentaDolorEnPezones;
	}

	public Boolean getPresentaFiebre() {
		return presentaFiebre;
	}

	public void setPresentaFiebre(Boolean presentaFiebre) {
		this.presentaFiebre = presentaFiebre;
	}

	public Boolean getPresentaAumentoDelRitmoCardiaco() {
		return presentaAumentoDelRitmoCardiaco;
	}

	public void setPresentaAumentoDelRitmoCardiaco(Boolean presentaAumentoDelRitmoCardiaco) {
		this.presentaAumentoDelRitmoCardiaco = presentaAumentoDelRitmoCardiaco;
	}

	public Boolean getPresentaAdelgazamiento() {
		return presentaAdelgazamiento;
	}

	public void setPresentaAdelgazamiento(Boolean presentaAdelgazamiento) {
		this.presentaAdelgazamiento = presentaAdelgazamiento;
	}

	public Boolean getPresentaObstruccionIntestinal() {
		return presentaObstruccionIntestinal;
	}

	public void setPresentaObstruccionIntestinal(Boolean presentaObstruccionIntestinal) {
		this.presentaObstruccionIntestinal = presentaObstruccionIntestinal;
	}

	public Boolean getPresentaAscitis() {
		return presentaAscitis;
	}

	public void setPresentaAscitis(Boolean presentaAscitis) {
		this.presentaAscitis = presentaAscitis;
	}

	public Boolean getPresentaDolorArticular() {
		return presentaDolorArticular;
	}

	public void setPresentaDolorArticular(Boolean presentaDolorArticular) {
		this.presentaDolorArticular = presentaDolorArticular;
	}

	public Boolean getPresentaRigidezYLimitacionEnMovimientos() {
		return presentaRigidezYLimitacionEnMovimientos;
	}

	public void setPresentaRigidezYLimitacionEnMovimientos(Boolean presentaRigidezYLimitacionEnMovimientos) {
		this.presentaRigidezYLimitacionEnMovimientos = presentaRigidezYLimitacionEnMovimientos;
	}

	public Boolean getPresentaInflamacionEnArticulaciones() {
		return presentaInflamacionEnArticulaciones;
	}

	public void setPresentaInflamacionEnArticulaciones(Boolean presentaInflamacionEnArticulaciones) {
		this.presentaInflamacionEnArticulaciones = presentaInflamacionEnArticulaciones;
	}

	public Boolean getPresentaCrujidosEnArticulaciones() {
		return presentaCrujidosEnArticulaciones;
	}

	public void setPresentaCrujidosEnArticulaciones(Boolean presentaCrujidosEnArticulaciones) {
		this.presentaCrujidosEnArticulaciones = presentaCrujidosEnArticulaciones;
	}
	
}
