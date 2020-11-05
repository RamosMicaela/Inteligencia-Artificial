package model;

public enum Sexo {
 
	Macho,
	Hembra;
	
	
	public Boolean isa(Sexo sexo) {
		
		return this.toString() == sexo.toString();
		
	}
	
}
