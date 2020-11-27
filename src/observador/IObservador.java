package observador;

import javax.swing.ImageIcon;

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
   public void quitarEntidad(Entidad entidad);
   public void updateEnergiaJugador();
   public void updateNivel(ImageIcon izq,ImageIcon fondo,ImageIcon der);
   
}
