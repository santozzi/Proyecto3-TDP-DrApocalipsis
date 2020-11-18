package niveles.fabricas;

import java.util.List;

import entidades.Entidad;
import logica.Juego;

public abstract class FabricaDeTandas {
	protected Juego juego;
	protected int cantidadInfectados;
	protected int nivel;
	protected Entidad [] entidades;
	
	//abstract public void primeraTanda();
	//abstract public void segundaTanda();
	abstract public void generar();
	abstract public List<Entidad> getEntidades();

}
