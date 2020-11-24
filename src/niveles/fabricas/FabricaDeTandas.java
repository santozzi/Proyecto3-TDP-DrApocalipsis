package niveles.fabricas;

import java.util.LinkedList;
import java.util.List;

import entidades.Entidad;
import logica.Juego;
import niveles.Nivel;

public abstract class FabricaDeTandas {
	
	protected Juego juego;
	protected int cantidadInfectados;
	protected int anchoInfectado;
	protected int altoInfectado ;
	protected Nivel nivel;
	
	abstract public void primeraTanda();
	abstract public void segundaTanda();
	//abstract public void generar();

}
