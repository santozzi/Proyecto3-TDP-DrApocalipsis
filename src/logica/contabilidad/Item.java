package logica.contabilidad;

public class Item {
    protected String clave;
    protected int score;
    protected int cantidad;
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
    	return clave +" - "+score+" - "+cantidad;
    }
}
