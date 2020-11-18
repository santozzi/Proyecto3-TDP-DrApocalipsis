package observador;

import entidades.Entidad;

public interface IObservador {
   /**
    * update
    * ------
    * Con este método el observador es notificado
    */
   public void update();
   public void updateEntidades(Entidad entidad);
   public void updateEntidad(Entidad entidad);
   
}
