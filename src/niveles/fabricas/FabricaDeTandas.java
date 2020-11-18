package niveles.fabricas;

import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import logica.Juego;

public abstract class FabricaDeTandas {
	
	protected Juego juego;
	protected int cantidadInfectados;
	protected LinkedList<Entidad> entidades;
	public static final int ANCHO_INFECTADO = 40;
	public static final int ALTO_INFECTADO = 60;
	
	abstract public void primeraTanda();
	abstract public void segundaTanda();
	//abstract public void generar();
	abstract public List<Entidad> getEntidades();

}
