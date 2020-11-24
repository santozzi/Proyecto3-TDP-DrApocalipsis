package niveles;

import java.util.List;

import entidades.Entidad;
import logica.CompositeInfectado;
import logica.Juego;
import niveles.fabricas.FabricaDeTandas;

public abstract class Nivel {
	protected Juego juego;
	protected int cantidadInfectados;
	protected Nivel nivel;
	protected FabricaDeTandas fabrica;
	protected CompositeInfectado compInf;
	
	abstract public List<Entidad> primeraTanda();
	abstract public List<Entidad> segundaTanda();
	abstract public void crearTanda();
	public CompositeInfectado getColeccionDeInfectados() {
		return this.compInf;
	}

}
