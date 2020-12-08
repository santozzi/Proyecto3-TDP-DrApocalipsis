package logica;

import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;

public class ListaDeInfectados {
	
	// Composite para mas adelante
	
	private List<Entidad> infectados;
	
	public ListaDeInfectados() {
		infectados = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getListaDeInfectados(){
		return this.infectados;
	}

}
