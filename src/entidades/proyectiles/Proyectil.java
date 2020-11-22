package entidades.proyectiles;

import entidades.Entidad;

public abstract class Proyectil extends Entidad {
	protected int letalidad;

	public int getLetalidad() {
		return this.letalidad;
	}
}
