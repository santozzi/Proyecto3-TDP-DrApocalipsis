package niveles;

import java.util.List;

import entidades.Entidad;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;

public abstract class Nivel {
	protected Juego juego;
	protected int cantidadInfectados;
	protected Nivel nivel;
	protected List<Entidad> entidades;
	protected FabricaDeTandas fabrica;
	
	abstract public List<Entidad> primeraTanda();
	abstract public List<Entidad> segundaTanda();
	abstract public void crearTanda();

}
