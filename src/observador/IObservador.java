package observador;

import java.util.Collection;

import javax.swing.ImageIcon;

import entidades.Entidad;
import logica.contabilidad.Item;

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
   public void updateScore(int score);
   public void updateEstedistica(Collection<Item> datos);
   public void iniciar();
   public void cerrar() ;
   
   
}
