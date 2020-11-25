package logica;

import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;

public class CompositeInfectado {
	
	private List<Entidad> infectados;
	
	public CompositeInfectado() {
		infectados = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getListaDeInfectados(){
		return this.infectados;
	}

}
