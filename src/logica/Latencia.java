package logica;

import entidades.Entidad;

public class Latencia {
   protected int latencia;
   protected Entidad entidad;
   
public Latencia(Entidad entidad) {
	
	this.latencia = 1;
	this.entidad = entidad;
}
public int getLatencia() {
	return latencia;
}
public void setLatencia(int latencia) {
	this.latencia = latencia;
}
public Entidad getEntidad() {
	return entidad;
}
public void setEntidad(Entidad entidad) {
	this.entidad = entidad;
}
public void incrementarLatencia() {
	latencia++;
}
public void reiniciarLatencia() {
	latencia=1;
}

   
}
