package logica.contabilidad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * Contabilidad
 * Encargada de la contar los puntos del score
 */
public class Contabilidad {
	protected Map<String,Item> items;
	protected int score;
	public Contabilidad() {
		items = new HashMap<String, Item>();
		this.score= 0;
	}

	/**
	 * agregarItem
	 * Agrega un item nuevo al mapeo de itemes o lo modifica de ya existir
	 * @param clave clave de imagen de la entidad
	 * @param score la cantidad de putos de la entidad
	 */
	public void agregarItem(String clave, int score) {
		Item valor = items.get(clave);
		if(valor==null) {
			items.put(clave, new Item(clave,score,1));
		}else {
			int puntos = valor.getScore();
			int cantidad = valor.getCantidad();
			valor.setScore(puntos+score);
			valor.setCantidad(cantidad+1);
			items.put(clave,valor);
		}
		this.score +=score;

	}
	public String toString() {
		String resultado = "";
		for(Item item:items.values()) {
			resultado += item+"\n";
		}
		return resultado;
	}
	/**
	 * getScore
	 * @return devuelve el total de los puntos sumados
	 */
	public int getScore() {
		return this.score;
	}
	/**
	 * listaDeItems
	 * Devuelve una colección iterable de los valores del mapeo
	 * @return lista de items de tipo Collecction
	 */
	public Collection<Item> listaDeItems(){
		return items.values();
	}
}
