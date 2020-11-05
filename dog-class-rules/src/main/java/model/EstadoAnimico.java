package model;

public class EstadoAnimico {
	Boolean presentaApatiaYTristeza;
	Boolean presentaPerdidaDeApetito;
	
	public EstadoAnimico() {
		this.presentaApatiaYTristeza = false;
		this.presentaPerdidaDeApetito = false;
	}

	@Override
	public String toString() {
		return  "Presenta apatia y tristeza: " 	+ this.presentaApatiaYTristeza  + "\n" +
				"Presenta perdida de apetito: " + this.presentaPerdidaDeApetito + "\n";
	}

	public Boolean getPresentaApatiaYTristeza() {
		return presentaApatiaYTristeza;
	}

	public void setPresentaApatiaYTristeza(Boolean presentaApatiaYTristeza) {
		this.presentaApatiaYTristeza = presentaApatiaYTristeza;
	}

	public Boolean getPresentaPerdidaDeApetito() {
		return presentaPerdidaDeApetito;
	}

	public void setPresentaPerdidaDeApetito(Boolean presentaPerdidaDeApetito) {
		this.presentaPerdidaDeApetito = presentaPerdidaDeApetito;
	}
}
