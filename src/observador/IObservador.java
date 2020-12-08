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
   
   /**
    * updateEntidades
    * ---------------
    * Agrega la entidad pasada por parametro al observador
    * @param entidad a agregar
    */
   public void updateEntidades(Entidad entidad);
   
   /**
    * updateEntidad
    * -------------
    * Actualiza la entidad pasada por parametro al observador
    * @param entidad a actualizar
    */
   public void updateEntidad(Entidad entidad);
   
   /**
    * quitarEntidad
    * --------------
    * Elimina del observador la entidad pasada por parametro
    * @param entidad e quitar
    */
   public void quitarEntidad(Entidad entidad);
   
   /**
    * updateEnergiaJugador
    * --------------------
    * Actualiza la carga viral del jugador
    */
   public void updateEnergiaJugador();
   
   /**
    * updateNivel
    * -----------
    * Actualiza las imagenes de fondo del nivel
    * @param izq : imagen de fondo izquierda
    * @param fondo : imagen de fondo central
    * @param der : imagen de fondo derecha
    */
   public void updateNivel(ImageIcon izq,ImageIcon fondo,ImageIcon der);
   
   /**
    * updateScore
    * -----------
    * Actualiza el puntaje obtenido
    * @param score
    */
   public void updateScore(int score);
   
   /**
    * updateEstedistica
    * -----------------
    * Crea una estadistica del puntaje obtenido
    * @param datos
    */
   public void updateEstedistica(Collection<Item> datos);
   
   /**
    * iniciar
    * -------
    * Crea al observador
    */
   public void iniciar();
   
   /**
    * cerrar
    * ------
    * Elimina al observador
    */
   public void cerrar() ;
   
   
}
