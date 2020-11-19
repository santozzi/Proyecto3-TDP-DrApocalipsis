package entidades.armas;
import entidades.proyectiles.*;
import entidades.Entidad;

public abstract class Arma extends Entidad{
	protected Proyectil proyectil;
/**
 * disparar
 * --------
 * Es el encargado de generar nuevos proyectiles	
 */
abstract public void disparar();

}
