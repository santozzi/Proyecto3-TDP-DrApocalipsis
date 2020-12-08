package logica;

import javax.swing.ImageIcon;
/**
 *Imagenes
 *Representacion gráfica de la entidad 
 *
 */
public abstract class Imagenes {
/**
 * getImagen
 * Devuelve una imagen de tipo ImageIcon
 * @param clave, la claveImagen de la entidad
 * @return ImageIcon
 */
abstract public ImageIcon getImagen(String clave);

}