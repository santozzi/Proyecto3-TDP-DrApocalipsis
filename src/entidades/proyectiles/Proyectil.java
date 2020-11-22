package entidades.proyectiles;

import entidades.Entidad;

public abstract class Proyectil extends Entidad {
  protected int velocidad;
  protected int letalidad;
  
  abstract public int getLetalidad();
}
