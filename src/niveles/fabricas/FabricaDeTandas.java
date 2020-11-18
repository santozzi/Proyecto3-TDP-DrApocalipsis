package niveles.fabricas;

import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import logica.Juego;

public abstract class FabricaDeTandas {
	
	protected Juego juego;
	protected int cantidadInfectados;
	protected LinkedList<Entidad> entidades;
	protected int anchoInfectado;
	protected int altoInfectado ;
	
	abstract public void primeraTanda();
	abstract public void segundaTanda();
	//abstract public void generar();
	abstract public List<Entidad> getEntidades();

}
