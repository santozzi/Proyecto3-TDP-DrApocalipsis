package observador;

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


}
