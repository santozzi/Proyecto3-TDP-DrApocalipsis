package observador;

import entidades.Entidad;

public interface IObservado {
	
/**
 * agregarObservador
 * -----------------
 * Agrega un observador en una coleccion de observadores
 * @param obs
 */
public void agregarObservador(IObservador obs);

/**
 * eliminarObservador
 * -------------------
 * Elimina un observador de la coleccion de observadores
 * @param obs
 */
public void eliminarObservador(IObservador obs);

/**
 * notificarObservadores
 * ---------------------
 * Notifica a todos los observadores de la coleccion
 */
public void notificarObservadores();

/**
 * notificarEntidad
 * ----------------
 * Notifica a la lista de observadores para que estos actualicen a las entidades, segun el estado de la entidad pasada por parametro
 * @param entidad a actualizar
 */
public void notificarEntidad(Entidad entidad);

/**
 * actualizarEntidad
 * ----------------
 * Notifica a la lista de observadores para que estos actualicen la entidad pasada por parametro
 * @param entidad a actualizar
 */
public void actualizarEntidad(Entidad entidad);

/**
 * notificarQuitarEntidad
 * ---------------------
 * Notifica a la lista de observadores para que estos eliminen la entidad pasada por parametro
 * @param entidad a eliminar
 */
public void notificarQuitarEntidad(Entidad entidad);

/**
 * notificarCargaViralDeJugador
 * ---------------------------
 * Notifica a la lista de observadores cuando se modifico la carga viral del jugador
 */
public void notificarCargaViralDeJugador();

/**
 * notificarNivel
 * ----------------
 * Notifica a la lista de observadores cuando se cambio de nivel
 */
public void notificarNivel();

/**
 * notificarScore
 * ----------------
 * Notifica a la lista de observadores cada vez que aumenta el puntaje
 */
public void notificarScore();

/**
 * notificarEstadistica
 * --------------------
 * Notifica a la lista de observadores la estadistica del puntaje obtenido
 */
public void notificarEstadistica();

}
