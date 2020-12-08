package logica.contabilidad;
/**
 * Item
 * Clase con tres atributos, clave (claveImagen), score(puntos) 
 * y cantidad( numero de entidades)
 */
public class Item {
    protected String clave;
    protected int score;
    protected int cantidad;
    /**
     * Item
     * @param clave
     * @param score
     * @param cantidad
     */
	public Item(String clave, int score, int cantidad) {
		this.clave = clave;
		this.score = score;
		this.cantidad = cantidad;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
    public String toString() {
    	return clave +" - "+cantidad+ " -  "+score;
    }
}
